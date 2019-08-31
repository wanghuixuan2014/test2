package com.cy.java.oop;
//-XX:+TraceClassLoading
class ClassAA{
	//static int[] array=new int[1024];
	static class Inner{
		//通过内部类实现延迟加载(Lazy)
		static int[] array=new int[1024];
	}
	public static void show() {}
	public static void addFirst(int a) {
		Inner.array[0]=a;
	}
}
public class TestClassObject06 {
   public static void main(String[] args) {
	 //  ClassAA.show();
	   ClassAA.addFirst(100);
   }
}
