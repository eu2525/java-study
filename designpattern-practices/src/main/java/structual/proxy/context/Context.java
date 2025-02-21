package structual.proxy.context;

import structual.proxy.i.Subject;

class Context {
	private Subject realSubject;
	
	Context() {
		this(() -> {System.out.println("Subject.doAction in Context done");});
	}
	
	private Context(Subject subject) {
		realSubject = subject;
	}

	Subject getSubject() {
		return realSubject;
	}
}
