package br.com.iborba.gerenciadorFinanceiro.domain.builders;
import br.com.iborba.gerenciadorFinanceiro.domain.User;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

// Builder para centralizar os atributos do parâmetro para o teste. Objetivo: evitar que tenha que alterar cada campo do teste se o mock mudar.

public class UserBuilder {
	private long id;
	private String name,
	 			   email,
	               password;
	
	private UserBuilder() {}
	
	
	public static UserBuilder build() { // static
		UserBuilder userBuilder = new UserBuilder(); // instanciar Builder
		userBuilder.id = 0L;
		userBuilder.name = "Igor Borba";
		userBuilder.email = "igor@hotmail.com";
		userBuilder.password = "123456";
		
		return userBuilder;
	}
	
	public UserBuilder withId(Long id) {
		this.id = id;
		return this; // retornar este objeto desta classe
	}
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	public User user() throws ValidationException { // concreto: retorna Usuário porque eu só posso acessar esse método depois de instanciado o build() que seta os atributos
		return new User(id, name, email, password);
	}
}
