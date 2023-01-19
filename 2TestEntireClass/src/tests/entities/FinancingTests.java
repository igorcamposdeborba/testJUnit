package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {
	// Padrão de nomeclatura de TESTE: <AÇÃO> Should <EFEITO> [When Cenário]
	// Construtor Deve criar o objeto com os dados corretos quando os dados forem válidos

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
	
	// Construtor Deve lançar IllegalArgumentException quando os dados não forem válidos
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
	
	// setTotalAmount Deve atualizar o valor quando os dados forem válidos
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
	
	// setTotalAmount Deve lançar IllegalArgumentException quando os dados não forem válidos
	@Test
	public void setTotalAmountShouldThrowExceptionAmountWhenInvalidData() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Double expectedTotalAmount = 200000.0;
		
		// 2) ACT and ASSERT
		IllegalArgumentException error = Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
			installments.setTotalAmount(expectedTotalAmount);
			// installments.getTotalAmount();
		}, "A parcela nao pode ser maior que a metade da renda");
		
		Assertions.assertEquals("A parcela nao pode ser maior que a metade da renda", error.getMessage());
		
	}
	
	// setIncome Deve atualizar o valor quando os dados forem válidos
	@Test
	public void setIncomeShouldUpdateWhenDataIsValid() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Double expectedIncome = 4000.0;
		
		// 2) ACT
		installments.setIncome(expectedIncome);
		
		// 3) ASSERT
		Assertions.assertEquals(expectedIncome, installments.getIncome());
		
	}
	
	// setIncome Deve lançar IllegalArgumentException quando os dados não forem válidos
	@Test
	public void setIncomeShouldThrowExceptionWhenInvalidData() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Double expectedIncome = 1000.0;
		
		// 2) ACT and ASSERT
		IllegalArgumentException error = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			installments.setIncome(expectedIncome);
		}, "A parcela nao pode ser maior que a metade da renda");
		
		Assertions.assertEquals("A parcela nao pode ser maior que a metade da renda", error.getMessage());
		
	}
	
	// setMonths Deve atualizar o valor quando os dados forem válidos
	@Test
	public void setMonthsShouldUpdateWhenDataIsValid() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);

		Integer expectedMonths = 90;
		
		// 2) ACT
		installments.setMonths(expectedMonths);
		
		// 3) ASSERT
		Assertions.assertEquals(expectedMonths, installments.getMonths());
	}
	
	// setMonths Deve lançar IllegalArgumentException quando os dados não forem válidos
	@Test
	public void setMonthsShouldThrowExceptionWhenDataInvalid() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);

		Integer expectedMonths = 40;	
		
		// 2) ACT and ASSERT
		IllegalArgumentException error = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			installments.setMonths(expectedMonths);	
		}, "A parcela nao pode ser maior que a metade da renda");
		
		Assertions.assertEquals("A parcela nao pode ser maior que a metade da renda", error.getMessage());
	}
	
	// entry Deve calcular corretamente o valor da entrada
	@Test
	public void entryShouldCalculateInput() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);
		
		double ExpectedTotalAmount = 20000.0;
		
		// 2) ACT
		double result = installments.entry();
		
		// 3) ASSERT
		Assertions.assertEquals(ExpectedTotalAmount, result);
	}
	
	// quota Deve calcular corretamente o valor da prestação
	@Test
	public void quotaShouldCalculateInstallment() {
		// 1) ARRANGE
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Financing installments = FinancingFactory.createFinancing(totalAmount, income, months);

		double ExpectedQuotaInstallment = 1000.0;
		
		// 2) ACT
		double result = installments.quota();
				
		// 3) ASSERT
		Assertions.assertTrue(result == ExpectedQuotaInstallment);
	}
	
}
