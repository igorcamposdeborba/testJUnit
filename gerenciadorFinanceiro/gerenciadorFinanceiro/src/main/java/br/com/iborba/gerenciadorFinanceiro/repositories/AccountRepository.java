package br.com.iborba.gerenciadorFinanceiro.repositories;

import java.util.Optional;

import br.com.iborba.gerenciadorFinanceiro.domain.Account;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

public interface AccountRepository {

	public Account saveAccount(Account account) throws ValidationException;
	
	public Optional<Account> getAccountByName(String accountName);
}
