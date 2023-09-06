package br.com.iborba.gerenciadorFinanceiro.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.iborba.gerenciadorFinanceiro.domain.Account;
import br.com.iborba.gerenciadorFinanceiro.domain.User;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;
import br.com.iborba.gerenciadorFinanceiro.repositories.AccountRepository;

public class AccountServiceTest {

	@Test
	void accountValid_ShouldSaveAccountSuccessfully_WhenUserServiceMethodSaveAccountIsCalled() throws ValidationException {
		// Arrange
		AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
		AccountService accountService = new AccountService(accountRepository);
		User user = new User(null, "Igor Borba", "igor@hotmail.com", "123456");
		Account account = new Account(null, "Abc123NomeDaConta", user);
		
		// Define behaviors of Mockito
		Mockito.when(accountRepository.getAccountByName(account.getName()))
		.thenReturn(Optional.empty());
		
		Mockito.when(accountRepository.saveAccount(account))
		.thenReturn(account);

		// Act
		Account accountSaved = accountService.saveAccount(account);
				
		// Assert
		Assertions.assertNotNull(account);
		Mockito.verify(accountRepository).getAccountByName("Abc123NomeDaConta");
		Mockito.verify(accountRepository).saveAccount(accountSaved);		
	}
}
