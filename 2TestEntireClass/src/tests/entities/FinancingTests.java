package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {
	// Padrão de nomeclatura de TESTE: <AÇÃO> Should <EFEITO> [When Cenário]
	@Test
	public void constructorShouldCreateFinancingObjectWhenValidInputs() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
				
		// 2) ACT
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);
		
		// 3) ASSERT
		Assertions.assertNotNull(installments);
	}
	
	@Test
	public void constructorShoulThrowExceptionWhenInvalidInputs() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 20;
		
		
		// 2) ACT and ASSERT
		IllegalArgumentException error = Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
			FinancingFactory.createFinancing(totalAmount, income, months);
		}, "A parcela nao pode ser maior que a metade da renda");
		
		Assertions.assertEquals("A parcela nao pode ser maior que a metade da renda", error.getMessage());
	}
	
	@Test
	public void setTotalAmountShouldUpdateAmountWhenValidData() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Double expectedTotalAmount = 50000.0;
		
		// 2) ACT
		installments.setTotalAmount(expectedTotalAmount);
		
		// 3) ASSERT
		Assertions.assertEquals(expectedTotalAmount, installments.getTotalAmount());
		
	}
}
