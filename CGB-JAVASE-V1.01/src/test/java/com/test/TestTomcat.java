package com.test;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;
public class TestTomcat {
	@Test
	public void testTomcat() throws Exception{
		String tName=Thread.currentThread().getName();
		System.out.println(tName);
		//1.构建一个Tomat对象
		Tomcat t=new Tomcat();
		//2.构建Connector对象
		Connector c=new Connector("org.apache.coyote.http11.Http11NioProtocol");
		c.setURIEncoding("utf-8");
		c.setAsyncTimeout(20000);
		c.setRedirectPort(8443);
		c.setPort(8080);
		//3.设置Connector对象
		t.getService().addConnector(c);
		//4.启动tomcat
		t.start();
		//5.阻塞当前线程
		t.getServer().await();
	}
}
