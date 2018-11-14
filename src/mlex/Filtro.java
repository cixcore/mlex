package mlex;

public class Filtro {
	
	public int filtraJogoCompleto(String nomeDoJogo, Indice indice) {
		int id = indice.getIdPorNome(nomeDoJogo);
		return id;
	}
	
}
