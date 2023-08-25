package br.ce.wcaquino.servicos;

import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Test
	public void test() throws LocadoraException, FilmeSemEstoqueException {
		// Arrange
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Igor");
		Filme filme = new Filme("Harry Potter", 2, 2.50);
		
		// Act
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		// Assert
		assertThat(locacao.getValor(), is(2.50));
		assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
	// Should When Then
	@Test
	public void filmWithoutStock_ShouldThrowsException_WhenFilmStorageIsZero_ThenMustApproveThisTest() throws LocadoraException {
		// Arrange
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		// Filme filme = new Filme("Filme 2", 2, 4.0); // Forçando rodar no teste porque o teste é verificar se a exception de sem estoque funciona. Mas estou instanciando com estoque.
		Filme filme = new Filme("Filme 2", 0, 4.0); 
		
		// Act and Assert
		try {
			service.alugarFilme(usuario, filme); // O caminho correto dessa exception é rodar dentro da classe que tem a exception e pular para o catch que verifica se a mensagem está correta
			Assert.fail("Deveria ter lancado uma excecao"); // Sempre colocar um Assert.fail porque se não cair na exception da classe, vai cair nessa assertion de erro
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Filme sem estoque")); // Verifica se a mensagem está correta
		}
	}

}
