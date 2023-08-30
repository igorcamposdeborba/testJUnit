package junit5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	// Should When Then
	@Test
	public void aAndB_Shouldsum_WhenMethodSumisCalled_ThenReturn5() {
		// Arrange
		Calculadora calc = new Calculadora();
		int a = 3;
		int b = 2;

		// Act
		int result1 = calc.soma(a, b);

		// Assert
		Assertions.assertEquals(5, result1);
	}

	@Test
	public void assertives() {
		// Arrange
		Calculadora calc = new Calculadora();
		int a = 3;
		int b = 4;
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();

		// Act
		int result1 = calc.soma(a, b);

		// Assert
		Assertions.assertEquals(new ArrayList<>(), s1);
		Assertions.assertNotEquals(1, result1);
		Assertions.assertTrue("casa".equalsIgnoreCase("CASA")); // assertTrue: permite usar lógica dos métodos
		Assertions.assertTrue("Casa".startsWith("Ca"));

		// Assertions.assertSame(s1, s2); // assertSame: compara ENDEREÇOS de memória
		Assertions.assertEquals(s1, s2); // assertEquals: compara VALORES dentro da lista
		// Assertions.assertNull(s2);
		Assertions.assertNotNull(s2);
	}

	@Test
	public void ADividedB_ShouldDivide_WhenMethodDivideisCalled_ThenReturn2() {
		// Arrange
		Calculadora calc = new Calculadora();

		// Act
		int a = 4;
		int b = 2;
		float result = calc.dividir(a, b);

		// Assert
		Assertions.assertEquals(2.0, result);
	}

	@Test
	public void ADividedB_ShouldNegativeNumber_WhenMethodDivideisCalled_ThenReturn_negative2() {
		// Arrange
		Calculadora calc = new Calculadora();

		// Act
		int a = 6;
		int b = -2;
		float result = calc.dividir(a, b);

		// Assert
		Assertions.assertEquals(-3.0, result);
	}

	@Test
	public void ADividedB_ShouldReturnDecimalNumber_WhenMethodDivideisCalled_ThenReturn_negative3_5() {
		// Arrange
		Calculadora calc = new Calculadora();

		// Act
		int a = 10;
		int b = 3;
		float result = calc.dividir(a, b);

		// Assert
		Assertions.assertEquals(3.33, result, 0.01); // Delta (margem de erro) de 1 casa decimal com 0.01
	}

	// Forma manual de tratar exception
	@Test
	public void ADividedBByZero_ShouldThrowsException_WhenMethodDivideisCalled_JUnit4() {
		// Arrange
		Calculadora calc = new Calculadora(); 		
		
		// Act
		int a = 10;
		int b = 2;
		// Assert
		try {
			calc.dividir(a, b);
			Assertions.fail("Review parameters and class's processing because should throw a Exception");
		} catch (ArithmeticException e) {
			Assertions.assertEquals("Nao pode dividir por zero", e.getMessage());
		}
		
	}
	
	// Forma automática de tratar exception
	@Test
	public void ADividedBByZero_ShouldThrowsException_WhenMethodDivideisCalled_JUnit5() {
		// Arrange
		Calculadora calc = new Calculadora();
		
		// Act
		int a = 10;
		int b = 2;
		
		// Assert
		Assertions.assertThrows(ArithmeticException.class, () -> calc.dividir(a, b), "Review parameters and class's processing because should throw a Exception");
	}
}
