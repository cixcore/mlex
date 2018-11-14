package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mlex.Filtro;
import mlex.Indice;
import mlex.Jogo;

public class TestFiltro {
	Filtro filtroTeste;
	Indice indiceTeste;
	Jogo jogoTeste1;
	Jogo jogoTeste2;

	@Before
	public void setUp() throws Exception {
		filtroTeste = new Filtro();
		indiceTeste = new Indice();
		jogoTeste1 = new Jogo(0, "Jogo Legal", "01/09/94", "Klei");
		jogoTeste2 = new Jogo(666, "Jogo Chato", "31/02/94", "Despacito");
//		indiceTeste.novoJogoSendoAdicionado(666);
//		indiceTeste.novoJogoSendoAdicionado(0);
	}

	@Test
	public void testFiltraJogoEspecificoEmIndiceVazio() {
		assertTrue(filtroTeste.filtraJogoCompleto(jogoTeste1.getNomeJogo(), indiceTeste) == jogoTeste1.getIdJogo());
	}

}
