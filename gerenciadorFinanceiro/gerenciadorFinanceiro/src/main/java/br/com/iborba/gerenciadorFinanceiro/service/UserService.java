package br.com.iborba.gerenciadorFinanceiro.service;

import java.util.Optional;

import br.com.iborba.gerenciadorFinanceiro.domain.User;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;
import br.com.iborba.gerenciadorFinanceiro.repositories.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User user) throws ValidationException {
		// Conectar com o banco
		// Consulta MySQL
		// Executar consulta
		// Obter o usuário salvo no banco de dados
		Optional<User> userDataBase = userRepository.getUserByEmail(user.getEmail());
		if (!userDataBase.isEmpty()) {
			throw new ValidationException(String.format("Usuario %s ja cadastrado", userDataBase.get().getEmail()));
		}
		
		return userRepository.saveUser(user);
	}
}
