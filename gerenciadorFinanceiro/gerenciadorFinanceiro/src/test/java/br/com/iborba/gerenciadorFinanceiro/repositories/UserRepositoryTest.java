package br.com.iborba.gerenciadorFinanceiro.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.iborba.gerenciadorFinanceiro.domain.User;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;
import br.com.iborba.gerenciadorFinanceiro.service.UserService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest  {

	
	@Test
	@Order(0) // Ordem de teste
	void userValid_ShouldSaveUser_WhenUserServiceIsConstructed() throws ValidationException {
		// Arrange
		UserService userService = new UserService(new UserMemoryRepository());
		
		// Act
		User user = userService.saveUser(new User(null, "Igor Borba", "igor_campos5@hotmail.com", "123456"));
		
		// Assert
		Assertions.assertNotNull(user.getId());
		Assertions.assertEquals(2L, user.getId());
	}
	
	@Test
	@Order(1)
	void userDuplicated_ShouldThrowsException_WhenUserServiceIsConstructed() throws ValidationException {
		// Arrange
		UserService userService = new UserService(new UserMemoryRepository());
		
		// Assert		
		Assertions.assertThrows(ValidationException.class, () -> {
			userService.saveUser(new User(null, "Igor Borba", "igor_campos5@hotmail.com", "123456"));
		}, "Usuario igor_campos5@hotmail.com ja cadastrado");
	}
	
	
}
