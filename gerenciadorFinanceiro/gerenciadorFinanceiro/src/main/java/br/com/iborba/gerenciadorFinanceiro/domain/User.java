package br.com.iborba.gerenciadorFinanceiro.domain;

import java.util.Objects;

import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

public class User {
	private final Long id;
	private final String name;
	private String email;
	private String password;
				   
	
	public User(Long id, String name, String email, String password) throws ValidationException {
		if (Objects.isNull(name) || name.equals("") ) { throw new ValidationException("name is required"); }
		if (Objects.isNull(email) || email.equals("")) { throw new ValidationException("email is required"); }
		if (Objects.isNull(password) || password.equals("")) { throw new ValidationException("password is required"); }
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}


}