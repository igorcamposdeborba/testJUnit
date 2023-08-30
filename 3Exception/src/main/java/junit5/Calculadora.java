package junit5;

public class Calculadora {
	public int soma(int a, int b) {
		return a + b;
	}
	
	public float dividir(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Nao pode dividir por zero");
		}
		return (float) a / b;
	}
}
