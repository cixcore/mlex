package mlex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


public class UsuarioCommand
{		
	private final static int OPCAO_VOLTAR = 666;
	private static Repositorio repositorio = new Repositorio();
	private Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
	private Properties configuracoes = new Properties();
	private String usuario = "admin";
	private String senha = "admin";
	private String ordenacao = "n";
	Jogo jogoAtual;
=======
	Jogo jogoAtual;
	private PlataformaConfiguracao config;
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	private String nomeJogoPesquisado;
	private String nomeDaCategoria;
	private int idJogoPesquisado;
	
	public UsuarioCommand()
	{	
<<<<<<< HEAD
		if (new File("./.mlex.conf").exists() == false)
		{
			configuracoes.setProperty("usuario", "admin");
			configuracoes.setProperty("senha", "admin");
			configuracoes.setProperty("ordenado", "n");
			
			try
			{
				configuracoes.store(new FileOutputStream("./.mlex.conf"), null);
			}
			catch (IOException e) 
			{
				System.out.println("Problema escrevendo arquivo de configuracao default");
			}
		}
		else
		{
			try
			{
				configuracoes.load(new FileInputStream("./.mlex.conf"));
			}
			catch (IOException e)
			{
				System.out.println("Problema na leitura do arquivo de configuracao");
			}
			
			usuario = configuracoes.getProperty("usuario");
			senha = configuracoes.getProperty("senha");
			ordenacao = configuracoes.getProperty("ordenacao");	
		}
=======
		config = new PlataformaConfiguracao();

>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	}
	
	String getUsuario()
	{
<<<<<<< HEAD
		return this.usuario;
=======
		return config.getUsuario();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	}
	
	String getSenha()
	{
<<<<<<< HEAD
		return this.senha;
=======
		return config.getSenha();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	}
	
	String getOrdenacao()
	{
<<<<<<< HEAD
		return this.ordenacao;
=======
		return config.getOrdenacao();
	}
	
	String getEmailDoUsuario() 
	{
		return config.getEmailDoUsuario();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
	}
	
	public int menuInicial(int opcaoMenu)
	{
		switch(opcaoMenu)
		{
			case -1:
				break;
			case 0:
				repositorio.exibeJogosNoRepositorio();
				//ver tds jogos
				break;
			case 1:
				//ve um jogo e pode:
				//remove-lo, modifica-lo, adicionar comentario, verificar integridade, enviar por email
				limpaTela();
<<<<<<< HEAD
				System.out.println("Digite o nome do jogo a ser pesquisado (Digite 5 para voltar): ");
				nomeJogoPesquisado = scanner.nextLine();
				
				if (repositorio.verificaId(nomeJogoPesquisado))
				{
					int opcaoJogo = -1;
					do
					{
						this.menuJogo(opcaoJogo);
						opcaoJogo = scanner.nextInt();
					} while (opcaoJogo != OPCAO_VOLTAR);
				}
				else
				{
=======
				System.out.println("Digite o nome do jogo a ser pesquisado: ");
				
				nomeJogoPesquisado = scanner.nextLine();
				
				if (repositorio.verificaId(nomeJogoPesquisado))
				{
					int opcaoJogo = -1;
					int temp;
					do
					{
						temp = this.menuJogo(opcaoJogo);
						opcaoJogo = scanner.nextInt();
						scanner.nextLine();
					} while (opcaoJogo != OPCAO_VOLTAR && temp != -2);
				}
				else
				{
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
					System.out.println("Jogo pesquisado nao existe, voltando para menu");
				}
				break;
			case 2:
				//add um jogo
				repositorio.getInformacoesJogo();				
				repositorio.adicionaJogo();
				break;
			case 3:
				//opcoes da colecoes
				int opcaoCategoria = -1;
			do
				{
					this.menuCategorias(opcaoCategoria);
					opcaoCategoria = scanner.nextInt();
					scanner.nextLine();
				} while (opcaoCategoria != OPCAO_VOLTAR);
				break;
			case 4:
				//filtroo
<<<<<<< HEAD

				int filt = this.menuFiltro();
				String nomefilt = scanner.nextLine();
				repositorio.filtroPorAtributoDoJogo(nomefilt, filt);
=======
				int filt = this.menuFiltro();
				scanner.reset();
				if (filt != 4)
				{
					System.out.println("Digite o filtro:");
					String nomefilt = scanner.nextLine();
					repositorio.filtroPorAtributoDoJogo(nomefilt, filt);
				}
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				break;
			case 5:
				System.out.println("\nConfiguracoes de usuario;\n"
						+ "0)Alterar nome;\n"
						+ "1)Alterar senha\n"
						+ "2)Alterar email\n"
						+ "3)Alterar ordenacao");
				int opcaoConfiguracao = scanner.nextInt();
				switch(opcaoConfiguracao)
				{
				case 0:
					if(config.validacaoUsuario()) 
					{
						System.out.println("Digite o novo nome: ");
						scanner.nextLine();
						String novoNome = scanner.nextLine();
						config.setUsuario(novoNome);
						System.out.println("Nome atualizado com sucesso.");
					}
					else
					{
						System.out.println("Senha invalida.");
					}
						

					break;
				case 1:
					if(config.validacaoUsuario()) 
					{
						System.out.println("Digite a nova senha: ");
						scanner.nextLine();
						String novaSenha = scanner.nextLine();
						config.setUsuario(novaSenha);	
						System.out.println("Senha atualizada com sucesso.");
					}
					else
					{
						System.out.println("Senha invalida.");
					}

					break;
				case 2:
					if(config.validacaoUsuario())
					{
						System.out.println("Digite o novo email: ");
						scanner.nextLine();
						String novoEmail = scanner.nextLine();
						config.setUsuario(novoEmail);
						System.out.println("Email atualizado com sucesso.");
					}
					else
					{
						System.out.println("Senha invalida.");
					}

					break;
				case 3:
					if(config.validacaoUsuario())
					{
						System.out.println("Digite a nova ordenacao: ");
						scanner.nextLine();
						String novaOrdenacao = scanner.nextLine();
						config.setUsuario(novaOrdenacao);
						System.out.println("Ordenacao atualizada com sucesso.");
					}
					else
					{
						System.out.println("Senha invalida.");
					}

					break;
				default:
					break;
				}

				break;
			case 666:
				//encerra o programa
				repositorio.salvaRepositorio();
				break;
			default: 
				System.out.println("Nao eras, meu bruxo!");
		}
		
		limpaTela();
		System.out.println("\n0)Mostrar os jogos do repositorio;\n"
				+ "1)Selecionar jogo;\n"
				+ "2)Adicionar um jogo ao repositorio;\n"
				+ "3)Acessar colecoes;\n"
				+ "4)Filtrar jogos;\n"
				+ "5)Configuracoes do usuario;\n"
				+ "666)Sair;\n"
				+ "Escolha a acao que deseja realizar: ");
		
		return opcaoMenu;
	}
	
	public int menuCategorias(int opcaoDeCategoria)
	{
		//exibe todas colecoes --- CICA FAZ ISSO AQUI				
		switch(opcaoDeCategoria)
		{
			case -1:
				break;
			case 0:
				repositorio.exibeColecoesNoIndice();
				break;
			case 1:
				//exibe jogos em x colecao
				System.out.println("\nDigite o nome da colecao a ser pesquisada:");
<<<<<<< HEAD
				nomeDaCategoria = scanner.next();
=======
				scanner.reset();
				nomeDaCategoria = scanner.nextLine();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				repositorio.filtroDasCategorias(nomeDaCategoria, 0);
				break;
			case 2:
				//cria nova colecao
				System.out.println("Digite o nome da colecao a ser criada:");
<<<<<<< HEAD
				nomeDaCategoria = scanner.next();
=======
				scanner.reset();
				nomeDaCategoria = scanner.nextLine();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				repositorio.criaCateg(nomeDaCategoria);
				break;
			case 3:
				//adiciona um jogo a uma colecao
				System.out.println("Digite o nome da colecao:");
				nomeDaCategoria = scanner.next();
				System.out.println("Digite o nome do jogo:");
				nomeJogoPesquisado = scanner.next();
				idJogoPesquisado = repositorio.getIdParaVerInfoDeJogo(nomeJogoPesquisado);
				repositorio.addJogoNaCateg(idJogoPesquisado, nomeDaCategoria);
				break;
			case 4:
				//remove um jogo de uma colecao
				System.out.println("Digite o nome da colecao:");
				nomeDaCategoria = scanner.next();
				System.out.println("Digite o nome do jogo:");
				nomeJogoPesquisado = scanner.next();
				idJogoPesquisado = repositorio.getIdParaVerInfoDeJogo(nomeJogoPesquisado);
				repositorio.removeJogoDaCateg(idJogoPesquisado, nomeDaCategoria);
				break;
			case 5:
				//filtra jogos dentro de uma colecao
<<<<<<< HEAD
=======
				System.out.println("Digite o nome da colecao:");
				scanner.reset();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				nomeDaCategoria = scanner.nextLine();
				repositorio.filtroDasCategorias(nomeDaCategoria, 1);
				break;
			case 666:
				break;
			default: 
				System.out.println("Nao eras, meu bruxo!");
		}
		
		limpaTela();
		System.out.println("0)Mostrar todas colecoes\n"
				+ "1)Buscar jogos da colecao;\n"
				+ "2)Criar colecao;\n"
				+ "3)Adicionar um jogo a colecao;\n"
				+ "4)Remover jogo de colecao;\n"
				+ "5)Filtrar colecoes;\n"
				+ "666)Voltar;\n"
				+ "Escolha a acao que deseja realizar: ");
		
		
		return opcaoDeCategoria;
	}
	
	public int menuJogo(int opcaoDeJogo)
	{		
		int idJogoPesquisado = repositorio.getIdParaVerInfoDeJogo(nomeJogoPesquisado);
		
<<<<<<< HEAD
		repositorio.exibeInformacoesJogo(idJogoPesquisado);
		
=======
		System.out.println("id do jogo que acabou de ser pesquisado = " + idJogoPesquisado);
		System.out.println("jogos no indice atualmente na ordem = + ");
		
		
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		if (idJogoPesquisado == -1)
		{
			System.out.println("Jogo com esse nome nao existe no repositorio");
		}
		else
		{
<<<<<<< HEAD
=======
			repositorio.exibeInformacoesJogo(idJogoPesquisado);
			
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
			switch(opcaoDeJogo)
			{
				case -1:
					break;
				case 0:
					limpaTela();
					System.out.println("Digite o que deseja modificar\n");
					System.out.println("1 - nomeJogo\n"
									+ "2 - lancamento\n"
									+ "3 - desenvolvedor\n"
									+ "4 - versao\n"
									+ "5 - genero\n");
					int opcao = scanner.nextInt();
<<<<<<< HEAD
=======
					scanner.nextLine();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
					String atributoAtualizado = new String();
					switch (opcao)
					{
						case 1:
							System.out.println("Digite o nome atualizado do jogo:");
							atributoAtualizado = scanner.nextLine();
							repositorio.atualizaAtributo(idJogoPesquisado, 1, atributoAtualizado);
							break;
						case 2:
							System.out.println("Digite a data atualizada de lancamento do jogo (DD/MM/AAAA):");
							atributoAtualizado = scanner.next();
							repositorio.atualizaAtributo(idJogoPesquisado, 2, atributoAtualizado);
							break;
						case 3:
							System.out.println("Digite o nome atualizado do desenvolvedor do jogo:");
							atributoAtualizado = scanner.next();
							repositorio.atualizaAtributo(idJogoPesquisado, 3, atributoAtualizado);
							break;
						case 4:
							System.out.println("Digite a versao atualizada  do jogo:");
							atributoAtualizado = scanner.next();
							repositorio.atualizaAtributo(idJogoPesquisado, 4, atributoAtualizado);
							break;
						case 5:
							System.out.println("Digite o genero atualizado do jogo:");
							atributoAtualizado = scanner.next();
							repositorio.atualizaAtributo(idJogoPesquisado, 5, atributoAtualizado);
							break;
						default:
							break;
					}
					break;
				case 1:
					repositorio.removeJogo(idJogoPesquisado);
<<<<<<< HEAD
=======
					idJogoPesquisado = -1;
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
					limpaTela();
					System.out.println("\n0)Mostrar os jogos do repositorio;\n"
							+ "1)Selecionar jogo;\n"
							+ "2)Adicionar um jogo ao repositorio;\n"
							+ "3)Acessar colecoes;\n"
							+ "4)Filtrar jogos;\n"
							+ "5)Configuracoes do usuario;\n"
							+ "666)Sair;\n"
							+ "Escolha a acao que deseja realizar: ");
<<<<<<< HEAD
					return -1;
=======
					return -2;
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				case 2:
					//adicionar comentario
					System.out.println("Comentarios:");
					System.out.println("1 - Adicionar comentario com Nota\n"
									+ "2 - Adicionar comentario sem Nota\n"
									+ "3 - Exibir todos os comentarios do jogo\n"
									+ "4 - Remover todos os comentarios do jogo\n"
<<<<<<< HEAD
									+ "5 - Voltar\n");
					int opcaoComentario = scanner.nextInt();
=======
									+ "5 - Voltar");
					int opcaoComentario = scanner.nextInt();
					scanner.nextLine();
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
					switch(opcaoComentario)
					{
						case 1:
							System.out.println("Digite o seu comentario:");
							scanner.next();
							String comentarioComNota = scanner.nextLine();
							System.out.println("Digite a nota:");
							double nota = Double.parseDouble(scanner.nextLine());
							float notaFloat = (float)nota;
							repositorio.addComentarioEmJogo(idJogoPesquisado, comentarioComNota, notaFloat);
							System.out.println("Comentario adicionado com sucesso.");
							break;
						case 2:
							System.out.println("Digite o seu comentario:");
							scanner.nextLine();
							String comentarioSemNota = scanner.nextLine();
							repositorio.addComentarioEmJogo(idJogoPesquisado, comentarioSemNota);
							System.out.println("Comentario adicionado com sucesso.");
							break;
						case 3:
							repositorio.exibeComentariosDeJogo(idJogoPesquisado);
<<<<<<< HEAD
							System.out.println("Aperte (ENTER) para voltar");
=======
							System.out.println("Digite ENTER para voltar");
							scanner.nextLine();
							scanner.nextLine();

>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
							break;
						case 4:
							repositorio.removeComentariosDeJogo(idJogoPesquisado);
							break;
						case 5:
							break;
						default:
							break;
					}
					break;
				case 3:
					repositorio.verificaIntegridade();
					break;
				case 4:
					//enviar por email -- fazer depois que comentarios e toString integrados
<<<<<<< HEAD
=======
					System.out.println("Digite email do destinatario: \n");
					scanner.nextLine();
					String emailTO = scanner.nextLine();
					repositorio.enviaEmail(emailTO, config.getEmailDoUsuario(), idJogoPesquisado);
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
					break;
				case 5:
					//volta
					break;
				default: 
					System.out.println("Nao eras, meu bruxo!");
			}
			
			limpaTela();
			System.out.println("\n0)Modificar informacoes;\n"
					+ "1)Remover do repositorio;\n"
					+ "2)Comentarios;\n"
					+ "3)Verificar integridade;\n"
					+ "4)Recomendar para um amigo;\n"
<<<<<<< HEAD
					+ "5)Voltar;\n"
=======
					+ "666)Voltar;\n"
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
					+ "Escolha a acao que deseja realizar: ");
		
			return opcaoDeJogo;
		}
		return -1;
	}
	
	public int menuFiltro()
	{
		limpaTela();
		System.out.println("\n1)Filtrar por nome do jogo;\n"
				+ "2)Filtrar data do lancamento do jogo;\n"
				+ "3)Filtrar por nome do desenvolvedor do jogo;\n"
				+ "4)Cancela;\n");
		
		scanner.reset();
		int opcaoDeFiltro = scanner.nextInt();
		scanner.nextLine();
		
		return opcaoDeFiltro;
	}
	
	public void limpaTela()
	{
		try
		{
			Runtime.getRuntime().exec("clear");
		}
		catch (IOException e)
		{
			System.out.println("Erro ao limpar a tela");
		}
	}

}
