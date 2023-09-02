package br.com.iborba.gerenciadorFinanceiro.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

public class AccountTest {
		// Testar
		// - Classe com cenário válido
		// - Exception null e empty ""
	 	
	

	@Test
	public void createAccount_ShouldInstantiateNewAccount_WhenConstructorIsCalled() throws ValidationException {
		// Arrange
		Long idAccount = 0L;
		String nameAccount = "Checking account";
		Long idUser = 1L;
		String nameUser = "Igor Borba";
		String emailUser = "igor@hotmail.com";
		String passwordUser = "123456";
		
		// Act
		User user = new User(idUser, nameUser, emailUser, passwordUser);
		Account account = new Account(idAccount, nameAccount, user);
		
		// Assert
		Assertions.assertAll(
				() -> Assertions.assertNotNull(account.getUser()),
				() -> Assertions.assertEquals(0L ,account.getId()),
				() -> Assertions.assertEquals("Checking account" ,account.getName())
				);
	}
	
	@Test
	public void nullFieldsAccount_ShouldThrowsValidationException_WhenParametersAreNull_ThenDisplayMessage() throws ValidationException {
		// Arrange
		Long idAccount = 0L;
		String nameAccountNull = null;
		Long idUser = 1L;
		String nameUser = "Igor Borba";
		String emailUser = "igor@hotmail.com";
		String passwordUser = "123456";
		
		// Act
		User user = new User(idUser, nameUser, emailUser, passwordUser);
		
		Assertions.assertAll(
				() -> Assertions.assertThrows(ValidationException.class, () -> new Account(idAccount, nameAccountNull, user), 
						"Name of account is required")
				);
	}
	
	@Test
	public void emptyFieldsAccount_ShouldThrowsValidationException_WhenParametersAreEmpty_ThenDisplayMessage() throws ValidationException {
		// Arrange
		Long idAccount = 0L;
		String nameAccountEmpty = "";
		Long idUser = 1L;
		String nameUser = "Igor Borba";
		String emailUser = "igor@hotmail.com";
		String passwordUser = "123456";
		
		// Act
		User user = new User(idUser, nameUser, emailUser, passwordUser);
		
		Assertions.assertAll(
				() -> Assertions.assertThrows(ValidationException.class, () -> new Account(idAccount, nameAccountEmpty, user), 
						"Name of account is required")
				);
	}
}
