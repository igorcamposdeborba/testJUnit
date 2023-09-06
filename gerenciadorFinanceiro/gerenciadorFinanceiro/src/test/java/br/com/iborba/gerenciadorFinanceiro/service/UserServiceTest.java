package br.com.iborba.gerenciadorFinanceiro.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.iborba.gerenciadorFinanceiro.domain.User;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;
import br.com.iborba.gerenciadorFinanceiro.repositories.UserRepository;

public class UserServiceTest {

	@Test
	void emailInDatabase_ShouldReturnUserByEmail_WhenUserServiceMethodGetUserByEmailIsCalled() throws ValidationException {
		// Arrange
		UserRepository userRepository = Mockito.mock(UserRepository.class); // Criar objeto da classe UserRepository mockado com Mockito
		UserService userService = new UserService(userRepository);
		
		// Act
		Optional<User> user = userService.getUserByEmail("email@email.com");
		
		// Assert
		Assertions.assertTrue(user.isEmpty());
	}
	
	@Test // Teste básico com Mockito
	void emailNoExistsInDatabase_ShouldReturnUserEmpty_WhenUserServiceMethodGetUserByEmailIsCalled() throws ValidationException {
		// Arrange
		UserRepository userRepository = Mockito.mock(UserRepository.class); // Criar objeto da classe UserRepository mockado com Mockito
		UserService userService = new UserService(userRepository);
		
		// Treinamento do mock (cadastro de valores que o Mock consegue responder)
		Mockito.when(userRepository.getUserByEmail("email@email.com"))
								   .thenReturn(Optional.empty()); // comportamento que eu pré-defini
		
		// Act
		Optional<User> user = userService.getUserByEmail("email@email.com");
		
		// Assert
		Assertions.assertTrue(user.isEmpty());
	}
	
	@Test // Teste básico com Mockito e validando o número de vezes que o mock é chamado
	void emailExistsInDatabase_ShouldReturnUser_WhenUserServiceMethodGetUserByEmailIsCalled() throws ValidationException {
		// Arrange
		UserRepository userRepository = Mockito.mock(UserRepository.class); // Criar objeto da classe UserRepository mockado com Mockito
		UserService userService = new UserService(userRepository);
		
		// Treinamento do mock (cadastro de valores que o Mock consegue responder)
		Mockito.when(userRepository.getUserByEmail("igor@hotmail.com"))
								   			.thenReturn(Optional.of(new User(null, "Igor Borba", "igor@hotmail.com", "123456"))); // comportamento que eu pré-defini
		
		// Act
		Optional<User> user = userService.getUserByEmail("igor@hotmail.com");
		
		// Assert
		Assertions.assertTrue(user.isPresent());
		Mockito.verify(userRepository).getUserByEmail("igor@hotmail.com"); // validar valor do mock processado
		Mockito.verify(userRepository, Mockito.times(1)).getUserByEmail("igor@hotmail.com"); // validar o número de vezes que o mock foi chamado (1 vez)
	}
	
	@Test // Testar dois métodos
	void userValid_ShouldSaveUserSuccessfully_WhenUserServiceMethodsaveUserIsCalled() throws ValidationException {
		// Arrange
		UserRepository userRepository = Mockito.mock(UserRepository.class); // Criar objeto da classe UserRepository mockado com Mockito
		UserService userService = new UserService(userRepository);
		User user = new User(null, "Andressa Silva", "andressa@hotmail.com", "789456");
		
		// Treinamento do mock (cadastro de valores que o Mock consegue responder)
		Mockito.when(userRepository.getUserByEmail(user.getEmail()))
		   									.thenReturn(Optional.empty()); // comportamento que eu pré-defini
		
		Mockito.when(userRepository.saveUser(user))
											.thenReturn(user);
		
		// Act
		User userSaved = userService.saveUser(user);
		
		// Assert
		Assertions.assertNotNull(user);
		Mockito.verify(userRepository).getUserByEmail("andressa@hotmail.com"); // validar valor do mock processado
		Mockito.verify(userRepository).saveUser(user);
	}
	
	@Test // Testar exception
	void emailInDatabase_ShouldThrowValidationException_WhenUserServiceMethodSaveUserIsCalled() throws ValidationException {
		// Arrange
		UserRepository userRepository = Mockito.mock(UserRepository.class); // Criar objeto da classe UserRepository mockado com Mockito
		UserService userService = new UserService(userRepository);
		User user = new User(null, "Igor Borba", "igor@hotmail.com", "123456");
		
		// Act and Assert
		Mockito.when(userRepository.getUserByEmail(user.getEmail()))
										.thenReturn(Optional.of(user));

		Assertions.assertThrows(ValidationException.class, () -> userService.saveUser(user), "Usuario igor@hotmail.com ja cadastrado");
	}
}
