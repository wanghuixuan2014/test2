package com.cy.java.oop;
class ClassA{
	static {
		System.out.println("ClassA.static{}");
	}
}
//-XX:+TraceClassLoading
public class TestClassObject03 {
	public static void main(String[] args)throws Exception {
	  //需求:使用ClassLoader加载ClassA
	  //loadClass01();
	  //loadClass02();
	  //loadClass03();
	  //new ClassA();
	}
	private static void loadClass03()throws Exception {
		Class.forName("com.cy.java.oop.ClassA",
				      true,//initialize 为true时会执行静态代码块
				      ClassLoader.getSystemClassLoader());//loader
	}
	private static void loadClass02()throws Exception {
		Class.forName("com.cy.java.oop.ClassA");
	}
	//alt+shift+m
	private static void loadClass01() throws ClassNotFoundException {
		//1.获取类的加载器对象
		ClassLoader loader=
		ClassLoader.getSystemClassLoader();
		//System.out.println(loader.getClass());
		//2.加载类(将类读到内存中)
		loader.loadClass("com.cy.java.oop.ClassA");
      //如何证明如上类被加载了?(使用-XX:+TraceClassLoading参数)
	}
}
