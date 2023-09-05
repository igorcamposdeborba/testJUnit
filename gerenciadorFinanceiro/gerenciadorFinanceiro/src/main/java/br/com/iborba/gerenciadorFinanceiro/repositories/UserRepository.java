package br.com.iborba.gerenciadorFinanceiro.repositories;

import java.util.Optional;

import br.com.iborba.gerenciadorFinanceiro.domain.User;

// Esta é uma PORT (padrão Port and Adapters) para estabelecer a interface que rege os métodos a serem implementados nos Adapter para se conectar com o banco
public interface UserRepository {

	public User saveUser(User user);
	
	public Optional<User> getUserByEmail(String email); // Optional porque pode vir null/vazio (porque já existe usuário no banco de dados)
}
