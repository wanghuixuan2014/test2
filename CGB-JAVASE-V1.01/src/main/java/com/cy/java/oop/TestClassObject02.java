package com.cy.java.oop;

public class TestClassObject02 {
	public static void main(String[] args)
	throws Exception{
		Class<Object> c1=Object.class;
		Class<?> c2=
		Class.forName("java.lang.Object");
		Object obj=new Object();
		Class<?> c3=obj.getClass();
		System.out.println(c1==c2);//true
		System.out.println(c2==c3);//true
	}
}
