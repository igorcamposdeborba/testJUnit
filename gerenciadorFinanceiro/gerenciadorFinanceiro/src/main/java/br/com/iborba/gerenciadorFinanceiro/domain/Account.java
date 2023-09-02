package br.com.iborba.gerenciadorFinanceiro.domain;

import java.util.Objects;

import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

public class Account {
	private Long id = 0L;
	private String name = "Checking account";
	private User user;
	
	public Account(Long id, String name, User user) throws ValidationException {
		if (Objects.isNull(name) || name.equals("")) { throw new ValidationException("Name of account is required"); }
			
		this.id = id;
		this.name = name;
		this.user = user;
	}
	
	// Access methods
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public User getUser() {
		return user;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
