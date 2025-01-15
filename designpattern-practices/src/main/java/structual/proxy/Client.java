package structual.proxy;

import structual.proxy.context.Proxy;
import structual.proxy.i.Subject;

public class Client {
	public static void main(String[] args) {
		//Context ctx = new Context();
		// Subject subject = ctx.getSubject();	
		
		Subject subject = new Proxy();
		subject.doAction();
	}
}
