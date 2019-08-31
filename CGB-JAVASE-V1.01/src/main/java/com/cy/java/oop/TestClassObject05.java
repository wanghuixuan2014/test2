package com.cy.java.oop;
/**
 * 隐式类加载触发的时机?
 * 1)访问类中没有使用final修饰的类成员时
 * 2)访问类中的使用了final修饰的非string和非8种基本数据类型
 * 检测:-XX:+TraceClassLoading
 */
class ClassB{
	//static final 修饰的String以及8种基本类型在编译时有优化
	//通过类名直接方法时不会触发类的加载
	static final String LOCK="LOCK"; 
	static final int ORDER=Integer.MAX_VALUE;
	static final Integer NUMBER=100;
	static int count=100;
	public static void show() {}
}
public class TestClassObject05 {
	public static void main(String[] args) {
		ClassB c1;//不会触发类加载
		//触发类加载
		//int count=ClassB.count;
		//ClassB.show();
		//new ClassB();
		
		//String s1=ClassB.LOCK;
		//int order=ClassB.ORDER;
		Integer number=ClassB.NUMBER;
	}
}
