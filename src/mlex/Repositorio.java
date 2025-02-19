package mlex;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
=======
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Repositorio extends FileHandler
{
	private static List<Jogo> listaJogosObj = new ArrayList<Jogo>();
	private static Map<String, Integer> tabelaJogos = new HashMap<String, Integer>();
	private Indice indice =  new Indice();
	private Scanner scanner = new Scanner(System.in);

	private int idNovoJogo;
	private String nomeNovoJogo;
	private String lancamentoNovoJogo;
	private String desenvolvedorNovoJogo;
	private String versaoNovoJogo;

	public Repositorio()
	{
		Jogo jogoASerSalvo;
		File diretorioJogos = new File("./etc/jogos/");
		File[] jogosSalvos = diretorioJogos.listFiles();
		if (jogosSalvos != null)
		{
			for (File arquivoJogo : jogosSalvos)
			{
				jogoASerSalvo = (Jogo) this.leArquivo(arquivoJogo.getName(),  "./etc/jogos/");
				this.adicionaJogoPassaTeste(jogoASerSalvo, 0);
			}
		}
	}
	

	public boolean verificaId(String nomeJogo)
	{
		return tabelaJogos.keySet().contains(nomeJogo);
	}

	public void getInformacoesJogo()
	{
		System.out.println("Nome do jogo a ser adicionado: ");
		scanner.reset();
		this.nomeNovoJogo = scanner.nextLine();

		System.out.println("Data de lancamento do jogo a ser adicionado (DD/MM/AAAA): ");
		scanner.reset();
		this.lancamentoNovoJogo = scanner.nextLine();

		System.out.println("Desenvolvedor do jogo a ser adicionado: ");
		scanner.reset();
		this.desenvolvedorNovoJogo = scanner.nextLine();
	}

	public void criaJogo(Jogo jogo)
	{
		listaJogosObj.add(jogo);
		tabelaJogos.put(jogo.getNomeJogo(), jogo.getIdJogo());
	}

	public int adicionaJogo()
	{
		Jogo novoJogo = null;
		idNovoJogo = indice.getIdComNome(nomeNovoJogo);
		if (idNovoJogo == -1)
		{
			idNovoJogo = listaJogosObj.size();
		}
		String caminhoParaJogo = "./etc/jogos/" + Integer.toString(idNovoJogo);
<<<<<<< HEAD
		
		if (indice.getIdsDoIndice().contains(idNovoJogo))
		{
			System.out.println("tentativa de adicao de novo jogo falhou pois jogo ja existe");
		}
		else
		{
			novoJogo = new Jogo(this.idNovoJogo, this.nomeNovoJogo, this.lancamentoNovoJogo, this.desenvolvedorNovoJogo);
			
			criaJogo(novoJogo);

			try
			{
				indice.adicionaJogoNoIndice(novoJogo);
			}
			catch (Exception e)
			{
				System.out.println("falha ao adicionar novo jogo no indice");
			}

			indice.novoJogoSendoAdicionado(idNovoJogo); //funciona quando restaura jogo pq o indice restaura sobrescrevendo o mapa depois
		}

=======
		
		System.out.println("tamanho atual da lista de objetos jogo = " + listaJogosObj.size());
		System.out.println("id tentativa adicao = " + idNovoJogo);
		
		if (indice.getIdsDoIndice().contains(idNovoJogo))
		{
			System.out.println("tentativa de adicao de novo jogo falhou pois jogo ja existe");
		}
		else
		{
			novoJogo = new Jogo(this.idNovoJogo, this.nomeNovoJogo, this.lancamentoNovoJogo, this.desenvolvedorNovoJogo);
			
			criaJogo(novoJogo);

			try
			{
				indice.adicionaJogoNoIndice(novoJogo);
			}
			catch (Exception e)
			{
				System.out.println("falha ao adicionar novo jogo no indice");
			}

			indice.novoJogoSendoAdicionado(idNovoJogo); //funciona quando restaura jogo pq o indice restaura sobrescrevendo o mapa depois
		}
		
		
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		this.salvaObjetoEmArquivo(novoJogo, caminhoParaJogo);
		
		this.salvaRepositorio();
		
		return idNovoJogo;
	}

	public void removeJogo(int idJogo)
	{
		if (indice.getIdsDoIndice().contains(idJogo))
		{
			try
			{
				indice.removeJogoDoIndice(idJogo);
			}
			catch (Exception e)
			{
				System.out.println("Jogo nao existe no indice");
			}
			
<<<<<<< HEAD
			tabelaJogos.remove(listaJogosObj.get(idJogo).getNomeJogo());

			listaJogosObj.set(idJogo, null);
=======
			
			tabelaJogos.remove(listaJogosObj.get(idJogo).getNomeJogo());

			//listaJogosObj.set(idJogo, null);
			
			System.out.println("tamanho da lista de objetos agora = " + Integer.toString(listaJogosObj.size()));
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
			
			if (! new File("./etc/jogos/" + idJogo).delete())
			{
				System.out.println("arquivo jogo a ser deletado nao existe");
			}
		}
				
		this.salvaRepositorio();
	}

	public void adicionaJogoPassaTeste(Jogo novoJogo, int op)
	{
		try
		{
			indice.adicionaJogoNoIndice(novoJogo);
		}
		catch (Exception e)
		{
			System.out.println("Jogo ja existe no indice");
		}
		
		if (op == 1)
		{
			indice.novoJogoSendoAdicionado(novoJogo.getIdJogo());
		}
		
		this.criaJogo(novoJogo);
		
		this.salvaRepositorio();
	}
	
	public void adicionaJogoPassaTeste(Jogo novoJogo)
	{
		try
		{
			indice.adicionaJogoNoIndice(novoJogo);
		}
		catch (Exception e)
		{
			System.out.println("Jogo ja existe no indice");
		}

		indice.novoJogoSendoAdicionado(novoJogo.getIdJogo());
		
		this.criaJogo(novoJogo);
		
		this.salvaRepositorio();
	}

	public int getIdParaVerInfoDeJogo(String nomeJogoProcurado)
	{
		int id = -1;

		if(indice.getNumeroJogos() > 0)
		{
			id = indice.getIdComNome(nomeJogoProcurado);
		}

		return id;
	}

	public List<Integer> filtroPorAtributoDoJogo(String nomeOpcaoDeBusca, int opcaoDeBusca)
	{
		List<Integer> ids = new ArrayList<Integer>();

		switch(opcaoDeBusca)
		{
			case 1:
				//nome
				ids = indice.filtroPorAtributos(nomeOpcaoDeBusca, opcaoDeBusca);
				if(ids.size() > 0)
				{
					System.out.println("\nfiltro por jogos com nome '" + nomeOpcaoDeBusca + "': ");
					indice.imprimeAlgunsJogos(ids);
				}
				else
					System.out.println("\nNenhum jogo encontrado, verifique se o nome foi digitado corretamente");
				break;
			case 2:
				//lanc
				ids = indice.filtroPorAtributos(nomeOpcaoDeBusca, opcaoDeBusca);
				if(ids.size() > 0)
				{
					System.out.println("\nfiltro por jogos com data de lancamento '" + nomeOpcaoDeBusca + "': ");
					indice.imprimeAlgunsJogos(ids);
				}
				else
					System.out.println("\nNenhum jogo encontrado, verifique se a data foi digitada corretamente");
				break;
			case 3:
				//desenv
				ids = indice.filtroPorAtributos(nomeOpcaoDeBusca, opcaoDeBusca);
				if(ids.size() > 0)
				{
					System.out.println("\nfiltro por jogos do desenvolvedor '" + nomeOpcaoDeBusca + "': ");
					indice.imprimeAlgunsJogos(ids);
				}
				else
					System.out.println("\nNenhum jogo encontrado, verifique se o nome do desenvolvedor foi digitado corretamente");
				break;
			default:
				System.out.println("opcao invalida!");
		}

		return ids;
	}

	public int filtroDasCategorias(String nomeDeCategoria, int opcaoDeBuscaCateg)
	{
		List<Integer> ids = new ArrayList<Integer>();
		int resultados = -1;
		switch(opcaoDeBuscaCateg)
		{
			case 0:
				//sem subfiltro
				ids = indice.getIdsDoIndice();
				resultados = indice.filtroPorCategoria(nomeDeCategoria, ids);
				this.mostraResultadosDoFiltroDeCategorias(resultados, ids, nomeDeCategoria);
				break;
			case 1:
				//com subfiltro
				int opcaoDeSubfiltro = menuFiltro();
				System.out.println("\nDigite o parametro do subfiltro.");
<<<<<<< HEAD
				String nomeOpcaoDeSubfiltro = scanner.next();
=======
				String nomeOpcaoDeSubfiltro = scanner.nextLine();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				ids = indice.filtroPorAtributos(nomeOpcaoDeSubfiltro, opcaoDeSubfiltro);
				resultados = indice.filtroPorCategoria(nomeDeCategoria, ids);

				this.mostraResultadosDoFiltroDeCategorias(resultados, ids, nomeDeCategoria);
				break;
		}
		return resultados;
	}

	private int mostraResultadosDoFiltroDeCategorias(int nroDeResultados, List<Integer> idsValidos, String nomeDeCategoria)
	{
		if(nroDeResultados == -1)
		{
			System.out.println("\nNenhum jogo encontrado, verifique se o nome da colecao foi digitado corretamente.");
			return nroDeResultados;
		}
		if(nroDeResultados == 0)
		{
<<<<<<< HEAD
			System.out.println("Nao ha jogos na colecao selecionada.");
			return nroDeResultados;
		}
		System.out.println("\nResultados filtrados por colecao '" + nomeDeCategoria + "': ");
		indice.imprimeAlgunsJogos(idsValidos);
=======
			System.out.println("\nNao ha jogos na colecao selecionada.\n");
			return nroDeResultados;
		}
		//System.out.println("\nResultados filtrados por colecao '" + nomeDeCategoria + "': ");
		//indice.imprimeAlgunsJogos(idsValidos);
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		return nroDeResultados;
	}

	public void criaCateg(String nomeCateg)
	{
		indice.adicionaCategoriaAoIndice(nomeCateg);
		this.salvaRepositorio();
	}
	
	public void addJogoNaCateg(int idDoJogo, String nomeCateg)
	{
		try
		{
			indice.adicionaCategoriaAoJogo(idDoJogo, nomeCateg);
		}
		catch (Exception e)
		{
			System.out.println("falhou em adicionar jogo na categoria");
		}
		
		this.salvaRepositorio();
	}
	
	public void removeJogoDaCateg(int idDoJogo, String nomeCateg)
	{
		indice.removeCategoriaDoJogo(idDoJogo, nomeCateg);
		this.salvaRepositorio();
	}

	public int tamanho()
	{
		return listaJogosObj.size();
	}

	public void addComentarioEmJogo(int jogoId, String txt)
	{
		for (Jogo j: Repositorio.listaJogosObj) {
			if (j.getIdJogo() == jogoId){
				j.addComentario(txt);
				break;
			}
		}
	}
		
	public void addComentarioEmJogo(int jogoId, String txt, float nota)
	{	
		for (Jogo j: Repositorio.listaJogosObj) {
			if (j.getIdJogo() == jogoId){
				j.addComentario(txt, nota);
				break;
			}
		}
	}

	public void atualizaAtributo(int idJogo, int opcao, String atributoAtualizado)
	{
		switch (opcao)
		{
			case 1:
				this.nomeNovoJogo = atributoAtualizado;
				break;
			case 2:
				this.lancamentoNovoJogo = atributoAtualizado;
				break;
			case 3:
				this.desenvolvedorNovoJogo = atributoAtualizado;
				break;
			case 4:
				this.versaoNovoJogo = atributoAtualizado;
		}
		
		Jogo jogoModificado = listaJogosObj.get(idJogo).atualizaAtributos(opcao, atributoAtualizado);
		
<<<<<<< HEAD
=======
		String caminhoParaJogo = "./etc/jogos/" + Integer.toString(idJogo);
		
		this.salvaObjetoEmArquivo(jogoModificado, caminhoParaJogo);
		
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		listaJogosObj.set(idJogo, jogoModificado);
		
		try
		{
			indice.modificaJogoNoIndice(jogoModificado);
		}
		catch (Exception e)
		{
			System.out.println("tentativa de modificacao de jogo sobre jogo inexistente no indice");
		}
		
		this.salvaRepositorio();
	}
	
	private int menuFiltro()
	{
		System.out.println("\n1)Filtrar por nome do jogo;\n"
				+ "2)Filtrar data do lancamento do jogo;\n"
				+ "3)Filtrar por nome do desenvolvedor do jogo;\n"
				+ "4)Cancela;\n");

		int opcaoDeFiltro = scanner.nextInt();
<<<<<<< HEAD

=======
		scanner.nextLine();
		
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		return opcaoDeFiltro;
	}
	
	public void removeComentariosDeJogo(int jogoId)
	{
		for (Jogo j: Repositorio.listaJogosObj) {
			if (j.getIdJogo() == jogoId){
				j.removeComentarios();
				break;
			}
		}
	}

	public void exibeInformacoesJogo(int idJogoPesquisado)
	{
<<<<<<< HEAD
		System.out.println((listaJogosObj.get(idJogoPesquisado)));
=======
		if (idJogoPesquisado == -1)
		{
			System.out.println("Este jogo foi removido");
		}
		else
		{		
			System.out.println((Repositorio.listaJogosObj.get(idJogoPesquisado)));
		}
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	}

	public void exibeComentariosDeJogo(int jogoId) 
	{
		for (Jogo j: Repositorio.listaJogosObj) {
			if (j.getIdJogo() == jogoId){
				j.exibeComentarios();
				break;
			}
		}	
	}
	
	public void setInfoJogo(Jogo j) 
	{
		this.idNovoJogo = j.getIdJogo();
		this.nomeNovoJogo = j.getNomeJogo();
		this.lancamentoNovoJogo = j.getLancamentoJogo();
		this.desenvolvedorNovoJogo = j.getDesenvolvedorJogo();
	}
	
	public void verificaIntegridade() 
	{
		BufferedReader r;
		try 
		{
			r = new BufferedReader(new FileReader("./etc/versoes.txt"));
			String ln = r.readLine();
			while(ln != null) 
			{
				String[] parsedLine = ln.split(",");
				
				int i = 0;
				for(Jogo j: Repositorio.listaJogosObj) 
				{
					if(j.getNomeJogo().equals(parsedLine[0])) 
					{

						if(!(Repositorio.listaJogosObj.get(i).getVersao().equals(parsedLine[1]))) 
						{
							String velhaVersao = Repositorio.listaJogosObj.get(i).getVersao().substring(1);
							String novaVersao = parsedLine[1].substring(1);
							double novo = Double.parseDouble(novaVersao);
							double velho = Double.parseDouble(velhaVersao);
<<<<<<< HEAD

							if (novo > velho) 
							{
								j.setVersao(parsedLine[1]);
								Repositorio.listaJogosObj.set(i, j);
								System.out.println(j.getNomeJogo() + " foi atualizado com sucesso para a vers�o " + parsedLine[1] +".");
							}
						}
					}
					i++;
				}
				ln = r.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Nao foi possivel verificar versao");
		}
	}
	
	
	public void atualizaVersaoJogo(int jogoId, String novaVersao) 
	{
		int i = 0;
		for (Jogo j: Repositorio.listaJogosObj) 
		{
			if (j.getIdJogo() == jogoId)
			{	
				j.setVersao(novaVersao);

=======

							if (novo > velho) 
							{
								j.setVersao(parsedLine[1]);
								Repositorio.listaJogosObj.set(i, j);
								System.out.println(j.getNomeJogo() + " foi atualizado com sucesso para a vers�o " + parsedLine[1] +".");
							}
						}
					}
					i++;
				}
				ln = r.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Nao foi possivel verificar versao");
		}
	}
	
	
	public void atualizaVersaoJogo(int jogoId, String novaVersao) 
	{
		int i = 0;
		for (Jogo j: Repositorio.listaJogosObj) 
		{
			if (j.getIdJogo() == jogoId)
			{	
				j.setVersao(novaVersao);

>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				Repositorio.listaJogosObj.set(i, j);
			}
			i++;
		}
	}
	
	public String getVersaoJogo(int jogoId) 
	{
		int i = 0;
		for (Jogo j : Repositorio.listaJogosObj)
		{
			if (jogoId == Repositorio.listaJogosObj.get(i).getIdJogo())
			{
				return Repositorio.listaJogosObj.get(i).getVersao();
			}
			i++;
		}
		return null;
	}
	
<<<<<<< HEAD
=======
	public void enviaEmail(String emailTO, String emailFROM, int idJogo)
	{
		if (tabelaJogos.values().contains(idJogo))
		{
			
			String fpath = "./etc/" + idJogo + "email.txt";
			String commentsPath = "./etc/" + idJogo + "comentario.txt";
			File f = new File(fpath);
			File f2 = new File(commentsPath);
			
			if(!(f.exists()))
			{
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("N�o foi poss�vel criar arquivo de email");
				}
			}
			try
			{
				Jogo jogoPorEmail = Repositorio.listaJogosObj.get(idJogo);
				FileWriter fw = new FileWriter (f.getPath());
				BufferedWriter bw = new BufferedWriter(fw);

				String nomeDoJogo = Repositorio.listaJogosObj.get(idJogo).getNomeJogo();

				bw.write("Email sobre o jogo "+ nomeDoJogo);
				bw.newLine();
				bw.write("From: "+emailFROM);
				bw.newLine();
				bw.write("To: "+emailTO);
				bw.newLine();
				bw.newLine();
				
				this.escreveInfoEmEmail(jogoPorEmail.getIdJogo(), bw);
				bw.newLine();
				
				if(f2.exists())
				{
					bw.write("Comentarios:");
					bw.newLine();
					
					BufferedReader br = new BufferedReader( new FileReader(commentsPath));
					
					String ln = br.readLine();
					while (ln != null)
					{
						bw.write(ln);
						bw.newLine();

						ln = br.readLine();
					}
					br.close();
				}

				bw.close();
				
				System.out.println("Email enviado com sucesso. \n");

			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Nao foi possivel criar email. Jogo nao existe no repositorio.");
		}

	 }
	
	public void escreveInfoEmEmail(int idJogo, BufferedWriter bw)
	{
		try {
			bw.write("Nome do jogo: " + Repositorio.listaJogosObj.get(idJogo).getNomeJogo());
			bw.newLine();
			bw.write("Data de lancamento: " + Repositorio.listaJogosObj.get(idJogo).getLancamentoJogo());
			bw.newLine();
			bw.write("Desenvolvedor: " +Repositorio.listaJogosObj.get(idJogo).getDesenvolvedorJogo());
			bw.newLine();
			bw.write("Versao do jogo: " +Repositorio.listaJogosObj.get(idJogo).getVersao());
			bw.newLine();
			bw.write("Genero: " +Repositorio.listaJogosObj.get(idJogo).getGeneroJogo());
			bw.newLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Nao foi possivel escrever dados do jogo em arquivo de email");
		}
	}
	
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	public void exibeJogosNoRepositorio()
	{
		if (tabelaJogos.size() == 0)
		{
<<<<<<< HEAD
			System.out.println("Nao existem jogos a serem exibidos");
		}
		else
		{
			for (String nomeJogo : tabelaJogos.keySet())
			{
				System.out.println(" - " + nomeJogo);
=======
			System.out.println("\nNao existem jogos a serem exibidos\n");
		}
		else
		{
			System.out.println("\nJogos armazenados no repositorio:");
			for (String nomeJogo : tabelaJogos.keySet())
			{
				System.out.println(" - " + nomeJogo);
				System.out.println("id dentro do indice = " + indice.getIdComNome(nomeJogo));
				System.out.println("id dentro da tabela de jogos = " + tabelaJogos.get(nomeJogo));
				System.out.println("id dentro da lista de objetos = ");
				for (Jogo j : listaJogosObj)
				{
					if (j.getNomeJogo().equals(nomeJogo))
						System.out.println(j.getIdJogo());
				}
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
			}
		}
	}
	
	public void exibeColecoesNoIndice()
	{
		List <String> colecoes = indice.getListaCategorias();
		
		if (colecoes.size() == 0)
		{
			System.out.println("Nao existem colecoes a serem exibidas\n");
		}
		else
		{
			for (int i=0; i< colecoes.size(); i++)
			{
				System.out.println(" - " + colecoes.get(i));
			}
		}
	}
	
	public void salvaRepositorio()
	{
		indice.salvaObjetoIndice();
		indice.salvaMapaJogoCategorias();
		indice.salvaListaCategorias();
	}
	
}
