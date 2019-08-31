package com.cy.java.oop;
import java.util.Date;
class ObjectFactory{
	public static Object newInstance(
			Class<?> cls) {
		try {
		return cls.newInstance();
		}catch(Exception e) {
		e.printStackTrace();
		return null;
		}
	}
}
public class TestClassObject01 {
	public static void main(String[] args) {
		//1.基于ObjectFactory的newInstance方法
		//为Object类型创建一个实例对象
		Object obj=
		ObjectFactory.newInstance(Date.class);
	}
}
