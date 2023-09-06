package br.com.iborba.gerenciadorFinanceiro.service;

import java.util.Optional;

import br.com.iborba.gerenciadorFinanceiro.domain.Account;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;
import br.com.iborba.gerenciadorFinanceiro.repositories.AccountRepository;

public class AccountService implements AccountRepository {

	private AccountRepository accountRepository;
	
	public AccountService (AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public Account saveAccount(Account account) throws ValidationException {
		// Conectar com o banco
		// Preparar consulta MySQL
		// Executar consulta MySQL
		// Obter conta salva no banco de dados
		Optional<Account> accountDataBase = accountRepository.getAccountByName(account.getName());
		if ( !accountDataBase.isEmpty()) {
			throw new ValidationException("Nao pode ter duas contas com o mesmo nome: " + accountDataBase.get().getName());
		}
		return accountRepository.saveAccount(account);
	}

	@Override
	public Optional<Account> getAccountByName(String accountName) {
		return accountRepository.getAccountByName(accountName);
	}

}
