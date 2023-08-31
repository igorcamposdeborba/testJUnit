package br.com.iborba.gerenciadorFinanceiro.domain;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

class UserTest {

	// ! Como pegar uma lista de Exceptions ao invés de descobrir uma por uma a cada execução do teste: com assertAll
	@Test
	void createUser_ShouldInstantiateClass_WhenParametersAreFilled() throws ValidationException {
		// Arrange
		long id = 0L;
		String name = "Igor Borba";
		String email = "igor@hotmail.com";
		String password = "123456";
		
		// Act
		User user1 = new User(id, name, email, password);
		
		// Assert
		Assertions.assertAll(
				() -> Assertions.assertEquals(0L, user1.getId()),
				() -> Assertions.assertEquals("Igor Borba", user1.getName()),
				() -> Assertions.assertEquals("igor@hotmail.com", user1.getEmail()),
				() -> Assertions.assertEquals("123456", user1.getPassword())
				);
	}
	
	// ! Como validar vários campos com a mesma exception, mas mudando a mensagem.
	@Test
	void nullFields_ShouldThrowsValidationException_WhenParameterAreNull_ThenDisplaysMessage() throws ValidationException {
		// Arrange
		Long idNull = null,
			   idFilled = 0L;
		String nameNull = null, 
			   emailNull = null, 
			   passwordNull = null,
			   nameFilled = "Igor Borba",
			   emailFilled = "igor@hotmail.com",
			   passwordFilled = "123465";
		
		
		// Assert
		ValidationException nameException = Assertions.assertThrows(ValidationException.class, () -> new User(idNull, nameNull, emailFilled, passwordFilled), 
				"Review parameters and class's processing because should throw a Exception");
		ValidationException emailException = Assertions.assertThrows(ValidationException.class, () -> new User(idFilled, nameFilled, emailNull, passwordFilled),
				"Review parameters and class's processing because should throw a Exception");
		ValidationException passwordException = Assertions.assertThrows(ValidationException.class, () -> new User(idFilled, nameFilled, emailFilled, passwordNull),
				"Review parameters and class's processing because should throw a Exception");
		
		Assertions.assertEquals("name is required", nameException.getMessage());
		Assertions.assertEquals("email is required", emailException.getMessage());
		Assertions.assertEquals("password is required", passwordException.getMessage());
	}
	
	// Como fazer assertAll com assertThrows para validar uma ou várias exceptions
	@Test
	void EmptyFields_ShouldThrowsValidationException_WhenParameterAreEmpty_ThenDisplaysMessage() throws ValidationException {
		// Arrange
		Long id = null;
		String name = "", 
			   email = "", 
			   password = "";
		
		// Assert
		Assertions.assertAll(
				() -> Assertions.assertThrows(ValidationException.class, () -> new User(id, name, email, password), "Review parameters and class's processing because should throw a Exception)"));
	}
	
}
