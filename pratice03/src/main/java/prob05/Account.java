package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String account) {
		this.accountNo = account;
		this.balance = 0;
		
		System.out.println(this.accountNo + " 계좌가 개설 되었습니다.");
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public int getBalance() {
		return this.balance;
	}

	public void save(int money) {
		this.balance += money;
		System.out.println(this.accountNo + " 계좌에 " + money + "만원이 입금 되었습니다.");
	}

	public void deposit(int money) {
		this.balance -= money;
		System.out.println(this.accountNo + " 계좌에 " + money + "만원이 출금 되었습니다.");
	}
}
