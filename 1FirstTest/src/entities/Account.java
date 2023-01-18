package entities;

public class Account {
	
	public static double DEPOSIT_FEE_PERCENTAGE = 0.02;
	
	private Long id;
	private Double balance;
	
	public Account() {}
	
	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	// Access methods
	public Long getId() {
		return id;
	}
	public Double getBalance() {
		return balance;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	// Logic methods
	public void deposit(Double amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("The amount need be greather than zero");
		}
		amount = amount - amount * DEPOSIT_FEE_PERCENTAGE;
		balance += amount;
	}
	
	public void withdraw(double amount) throws IllegalArgumentException {
		if (amount > balance) { 
			throw new IllegalArgumentException("You don't permit withdraw a amount greather than your balance");
		}
		balance -= amount;
	}
	
	public double fullWithdraw() {
		if (balance <= 0) { 
			throw new IllegalArgumentException("You don't have positive balance");
		}
		double varBalance = balance;
		balance = 0.0;
		return varBalance;
	}
}
