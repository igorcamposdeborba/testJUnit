package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	// Padrão de nomeclatura de TESTE: <AÇÃO> Should <EFEITO> [When Cenário]
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		// 1) ARRANGE: preparar os dados e instanciar
		double amount = 200.00;
		double expectedValue = 196.00;
		
		Account acc = new Account(1L, 0.0);
		
		// 2) ACT: executar as ações
		acc.deposit(amount);
		
		// 3) ASSERT: resultado esperado
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	// Teste com Exception
	@Test
	public void depositShouldNothingWhenNegativeAmount() {
		// Data
		double amount = -1.0;
		double expectedValue = 100.0;
		Account acc = new Account(1L, expectedValue);
				
		// Do and Result
		IllegalArgumentException error = Assertions.assertThrowsExactly(IllegalArgumentException.class, 
				() -> { acc.deposit(amount); }, 
				"The amount need be greather than zero");
		Assertions.assertEquals("The amount need be greather than zero", error.getMessage());
		
	}
}
