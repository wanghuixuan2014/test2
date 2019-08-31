package com.cy.java.oop.features;
interface MailService{
	void send(String content);
}
final class DefaultMailService implements MailService{
	@Override
	public void send(String content) {
		System.out.println("send content ...");
	}
}
class LogMailService{
	//组合:ref(has a)
	private MailService mailService;
	public LogMailService(MailService mailService) {
		this.mailService=mailService;
	}
	public void send(String content) {
		System.out.println("start:"+System.currentTimeMillis());
		this.mailService.send(content);
		System.out.println("end:"+System.currentTimeMillis());
	}
}
public class TestCompose01 {
	public static void main(String[] args) {
		LogMailService logSerivce=
		new LogMailService(new DefaultMailService());
	    logSerivce.send("恭喜cgb1904全部高薪就业");
	}
}










