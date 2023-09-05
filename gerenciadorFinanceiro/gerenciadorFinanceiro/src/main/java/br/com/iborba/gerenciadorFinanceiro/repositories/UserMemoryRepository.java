package br.com.iborba.gerenciadorFinanceiro.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.iborba.gerenciadorFinanceiro.domain.User;
import br.com.iborba.gerenciadorFinanceiro.domain.exceptions.ValidationException;

public class UserMemoryRepository implements UserRepository {

	private List<User> users;
	private Long currentId;
	
	public UserMemoryRepository() throws ValidationException {
		currentId = 0L;
		users = new ArrayList<User>();
		saveUser(new User(null, "Admin", "adm@hotmail.com", "123456"));
	}
	
	@Override
	public User saveUser(User user) {
		User newUser = null;
		try {
			newUser = new User(nextId(), user.getName(), user.getEmail(), user.getPassword());
			users.add(newUser);
		} catch (ValidationException  e) {
			e.printStackTrace();
		}
		return newUser;
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return users.stream()
				.filter(userObject -> userObject.getEmail().equalsIgnoreCase(email))
				.findFirst();
	}

	private Long nextId() {
		return ++currentId;
	}
	
	public void printUsers() {
		System.out.println(users);
	}
	
	public static void main(String[] args) throws ValidationException {
		UserMemoryRepository repo = new UserMemoryRepository();
		repo.saveUser(new User(null, "Igor Borba", "igor@hotmail.com", "123456"));
		repo.printUsers();
	}
}
