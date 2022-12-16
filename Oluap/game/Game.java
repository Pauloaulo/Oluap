package game;

import java.util.Scanner;
import java.util.Random;
import gameResources.*;

public class Game {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("      ___           ___       ___           ___           ___                    \n" +
				           "     /\\  \\         /\\__\\     /\\__\\         /\\  \\         /\\  \\         \n" +
				           "    /::\\  \\       /:/  /    /:/  /        /::\\  \\       /::\\  \\            \n" +
				           "   /:/\\:\\  \\     /:/  /    /:/  /        /:/\\:\\  \\     /:/\\:\\  \\        \n" +
				           "  /:/  \\:\\  \\   /:/  /    /:/  /  ___   /::\\~\\:\\  \\   /::\\~\\:\\  \\     \n" +
				           " /:/__/ \\:\\__\\ /:/__/    /:/__/  /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n" +
				           " \\:\\  \\ /:/  / \\:\\  \\    \\:\\  \\ /:/  / \\/__\\:\\/:/  / \\/__\\:\\/:/  /\n" +
				           "  \\:\\  /:/  /   \\:\\  \\    \\:\\  /:/  /       \\::/  /       \\::/  /       \n" +
				           "   \\:\\/:/  /     \\:\\  \\    \\:\\/:/  /        /:/  /         \\/__/         \n" +
				           "    \\::/  /       \\:\\__\\    \\::/  /        /:/  /                           \n" +
				           "     \\/__/         \\/__/     \\/__/         \\/__/                               " );
		
		System.out.println("\n1. Novo jogo \n" +
		                   "2. Como Jogar  \n" +
				           "3. Sair          ");
		
		int selection = sc.nextInt();
		
		switch(selection) {
			case 1: {
				Build player = characterGenerator();
				inicio(player);
				break;
			}
			case 2: {
			System.out.println("------------------------------COMO JOGAR------------------------------\n" +
		                       "   Os eventos possuirão múltiplas escolhas, selecione a que desejar   \n" +
					           "                 informando o número correspondente.                  \n" +
		                       "-------------------------------CLASSES--------------------------------\n" +
					           "Cada uma das classes possui características, atributos e habilidades  \n" +
		                       "específicas, o sucesso de alguns eventos dependerão de seus pontos em \n" +
					           "alguns atributos.                                                     \n" +
					           "                                                                      \n" +
		                       "GUERREIRO: Classe mais básica, alto valor de força e constituição,    \n" +
					           "sua habilidade especial o faz atacar em frenesi, aplicando grande     \n" +
		                       "dano baseado em sua força.                                            \n" +
					           "                                                                      \n" +
					           "MAGO: Alto valor de inteligência, única classe a possuir duas habili- \n" +
		                       "dades, pode lançar uma bola de fogo e causar um grande dano baseado em\n" +
					           "inteligência ou se curar sem o uso de poções.                         \n" +
		                       "                                                                      \n" +
		                       "ARQUEIRO: Classe mais equilibrada e com foco em destreza, tem 50% de  \n" +
					           "chances de aplicar dois ataques consecutivos em seu ataque básico, e  \n" +
		                       "10% de chance de atacar 3 vezes. Sua habilidade o faz atirar uma chuva\n" +
					           "de flechas que dão dano baseado em sua destreza.                      \n" +
		                       "                                                                      \n" +
					           "Todos os atributos variam entre 1 e 20 pontos, tenha isso em mente ao \n" +
		                       "considerar os pontos fortes e fraquezas do seu personagem.            \n" +
		                       "----------------------------------------------------------------------\n" +
					           "\n1. Voltar                                                           \n");
			
			int retorno = sc.nextInt();
			if(retorno == 1) menu();
			
			break;
			}
			case 3: {
				System.exit(0);
			}
			default: {
				System.out.println("Selecione uma opção válida.");
				menu();
			}
		}
	}
	
	public static Build characterGenerator() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println(" Como se chama seu(a) héroi(na)?");
		String name = sc.nextLine();
		
		System.out.println("\nSelecione sua classe: \n\n" +
		                   "1. Guerreiro              \n" +
				           "2. Mago                   \n" +
		                   "3. Arqueiro                 " );
		int selection = sc.nextInt();
		
		switch(selection) {
			case 1: {
				Warrior character = new Warrior(name, rand.nextInt(16, 20), rand.nextInt(8, 12), rand.nextInt(4, 10), rand.nextInt(14, 20), 4);
				return character;
			}
			case 2: {
				Mage character = new Mage(name, rand.nextInt(4, 10), rand.nextInt(6, 10), rand.nextInt(16, 20), rand.nextInt(8, 12), 1);
				return character;
			}
			case 3: {
				Archer character = new Archer(name, rand.nextInt(8, 12), rand.nextInt(16, 20), rand.nextInt(6, 10), rand.nextInt(8, 12), 3);
				return character;
			}
			default: {
				System.out.println("Selecione uma opção válida.");
				characterGenerator();
			}
		}
		return null;
	}

	public static void infoTab(Build character) {
		System.out.println("\n-----" + character.getName() +     "-----\n" +
	                       "HP: " + character.getHp() +               "\n" +
				           "Força: " + character.getStr() +           "\n" +
	                       "Destreza: " + character.getDex() +        "\n" +
				           "Inteligência: " + character.getInte() +   "\n" +
	                       "Constituição: " + character.getCon() +    "\n" +
				           "Poções: " + character.getPotion() +       "\n" +
	                       "----------\n                                 ");
	}
	
	public static void creatureInfoTab(Creature enemy) {
		System.out.println("\n-----" + enemy.getName() + "-----\n" +
                           "HP: " + enemy.getHp() +          "\n");
	}
	
	public static void combat(Build character, Creature enemy) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		creatureInfoTab(enemy);
		
		do {
			System.out.println("1. Atacar       \n" +
	                           "2. Curar        \n" +
			                   "3. Usar Habilidade");
			int selection = sc.nextInt();
	
			switch(selection) {
				case 1: {
					enemy.setHp(enemy.getHp()-character.attack());
					break;
		}
				case 2: {
					character.heal();
					break;
		}
				case 3: {
					enemy.setHp(enemy.getHp()-character.useSkill());
					break;
		}
				default: {
					System.out.println("Slecione uma opção válida.");
					combat(character, enemy);
				}
			}
			
			creatureInfoTab(enemy);
			if(enemy.isAlive() != true) break;
			
			int enemyTurn = rand.nextInt(1, 10);
			if((enemy instanceof Bat == true) || (enemy instanceof Pirate == true) || (enemy instanceof Dragon == true)) {
				if(enemyTurn <= 6) {
					character.setHp(character.getHp()-enemy.attack());
				} else if ((enemyTurn > 6) && (enemyTurn <= 8)) {
					enemy.heal();
				} else {
					character.setHp(character.getHp()-enemy.skill());
				}
			} else  if (enemyTurn <= 8){
				enemy.attack();
			} else {
				enemy.heal();
			}
			
			infoTab(character);
			if(character.isAlive() != true) {
				gameOver();
				break;
			}
			
		} while (true);
	}

	public static void inicio(Build character) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		infoTab(character);
		
		System.out.println("Bem... Você estava na taverna local, escuta alguns murmúrios sobre um dragão ter sido avistado               \n" +
		                   "mas não dá muita bola, não é como se importasse muito. Mesmo não demonstrando interesse nos rumores,         \n" +
				           "você percebe o taverneiro se aproximando de sua mesa, ele puxa uma cadeira, senta em sua frente e:           \n" +
		                   "- Pela forma como você está vestido, acredito que seja um aventureiro. Deve saber dos rumores sobre o dragão.\n" +
				           "Veja bem, minha filha está doente e é dito que ingerir o sangue de um dragão pode curar qualquer doença      \n" +
				           "                    (INSIRA AQUI UM LONGO E EMOCIONANTE DIÁLOGO SOBRE AMOR PATERNO)                          \n" +
				           "- Vá e derrote o dragão, coloque o sangue dele e coloque neste frasco *entrega frasco* e o traga para mim,   \n" +
				           "não possuo muito mas posso te oferecer a mão da minha filha e alguns anos de economias que tenho guardadas.\n\n" +
				           "Se o herói recusasse a oferta não teríamos história, então, iniciando sua busca, surgem duas opções, ir em   \n" +
				           "direção ao centro da cidade e procurar por informações sobre o ninho do dragão ou sair da cidade e procurar  \n" +
				           "pistas enquanto já se dirige ao norte.                                                                     \n\n" +
				           "1. Ir para o centro da cidade                                                                                \n" +
				           "2. Seguir rumo ao norte                                                                                      \n");
		
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				townCenter(character);
				break;
			}
			case 2: {
				cityOutskirts(character);
				break;
			}
			default: {
				System.out.println("Insira uma opção válida.");
				inicio(character);
			}
		}
	}
	
	public static void gameOver() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("      ___           ___           ___           ___                    ___           ___           ___           ___                                     \n" +
				           "     /\\  \\         /\\  \\         /\\__\\         /\\  \\                  /\\  \\         /\\__\\         /\\  \\         /\\  \\                    \n" +
				           "    /::\\  \\       /::\\  \\       /::|  |       /::\\  \\                /::\\  \\       /:/  /        /::\\  \\       /::\\  \\                       \n" +
				           "   /:/\\:\\  \\     /:/\\:\\  \\     /:|:|  |      /:/\\:\\  \\              /:/\\:\\  \\     /:/  /        /:/\\:\\  \\     /:/\\:\\  \\                \n" +
				           "  /:/  \\:\\  \\   /::\\~\\:\\  \\   /:/|:|__|__   /::\\~\\:\\  \\            /:/  \\:\\  \\   /:/__/  ___   /::\\~\\:\\  \\   /::\\~\\:\\  \\           \n" +
				           " /:/__/_\\:\\__\\ /:/\\:\\ \\:\\__\\ /:/ |::::\\__\\ /:/\\:\\ \\:\\__\\          /:/__/ \\:\\__\\  |:|  | /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\  \n" +
				           " \\:\\  /\\ \\/__/ \\/__\\:\\/:/  / \\/__/~~/:/  / \\:\\~\\:\\ \\/__/          \\:\\  \\ /:/  /  |:|  |/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /         \n" +
				           "  \\:\\ \\:\\__\\        \\::/  /        /:/  /   \\:\\ \\:\\__\\             \\:\\  /:/  /   |:|__/:/  /   \\:\\ \\:\\__\\      |:|::/  /               \n" +
				           "   \\:\\/:/  /        /:/  /        /:/  /     \\:\\ \\/__/              \\:\\/:/  /     \\::::/__/     \\:\\ \\/__/      |:|\\/__/                      \n" +
				           "    \\::/  /        /:/  /        /:/  /       \\:\\__\\                 \\::/  /       ~~~~          \\:\\__\\        |:|  |                            \n" +
				           "     \\/__/         \\/__/         \\/__/         \\/__/                  \\/__/                       \\/__/         \\|__|                             \n");
		
		System.out.println("1. Jogar Novamente\n" +
		                   "2. Sair             ");
		
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				menu();
				break;
			}
			case 2: {
				System.exit(0);
			}
		}
	}
	
	public static void townCenter(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		infoTab(character);
		
		System.out.println("Chegando ao centro da cidade você se dirige a um conhecido vendedor,      \n" +
		                   "famoso por sempre ter informações acerca dos mais variados temas no reino.\n" +
				           "Ele diz possuir a informação que você procura, mas pra compartilha-lá     \n" +
		                   "você deve passar por um teste de conhecimentos gerais feito pelo vendedor,\n" +
				           "aparentemente ele é um homem bem excêntrico.                            \n\n" +
		                   "1. Tentar o teste (Inteligência)                                          \n" +
				           "2. Recusar Educadamente                                                     ");
		
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				if (rand.nextInt(character.getInte()-5, character.getInte()) >= 12) {
					System.out.println("(SUCESSO)O vendedor se demonstra impressionado por suas capacidades e te entrega a informação que procura:\n" +
				                       "- Ao sair pela cidade, siga a esquerda, você encontrará uma caverna, ao atravessa-lá, você chegará        \n" +
							           "em uma ponte, quando a alcançar, siga a estrada e ela te levará ao vulcão inativo 'Terra Escaldada',      \n" +
				                       "é lá onde o dragão faz seu ninho.                                                                         \n" +
							           "Seguindo as orientações do mercador, você saí da cidade e segue rumo a caverna.                           \n");
					cave(character);
					break;
				} else {
					System.out.println("(FALHA)Aparentemente não foi uma boa idéia matar aquelas aulas no instituto do reino, você terá de encon-\n" +
				                       "trar seu caminho de outra forma. Você acaba seguindo o plano original, e saindo da cidade rumo ao        \n" +
							           "norte.                                                                                                   \n");
					cityOutskirts(character);
					break;
				}
			}
			case 2: {
				System.out.println("Assim que se afasta do mercador para seguir sua busca você ouve um grito de socorro, você não consegue\n" +
			                       "ignorar um pedido de ajuda e segue em direção ao grito. Chegando ao local, um beco escuro que leva    \n" +
						           "para fora do mercado central, você se depara com uma mulher sendo atacada por um pirata que aparentava\n" +
			                       "querer levá-la para seu navio que estava atracado na cidade.                                          \n"+
						           "Você não poderia só fingir que não viu.                                                               \n");
				
				Pirate pirate = new Pirate("Barba Rosa", 20, 80);
				
				combat(character, pirate);
				
				System.out.println("Após derrotar o pirata, a mulher que estava sendo atacada se mostra muito grata, sabendo da sua busca    \n" +
				                   "pelo ninho do dragão, a mulher te indica seguir uma caverna que fica próxima a cidade e te levará ao vul-\n" +
						           "cão 'Terra Escaldada', onde se acredita ser o lar da fera.                                               \n" +
				                   "Você ouve a orientação e segue rumo a tal caverna.                                                       \n");
				cave(character);
			}
		}
	}
	
	public static void cityOutskirts(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Você saiu da cidade e está na estrada que leva a maior cidade do norte do reino,       \n" +
		                   "tal estrada passa por uma floresta muito conhecida por ataques a viajantes desavisados.\n" +
				           "E depois dessa frase, era de se esperar um ataque. Um goblin saí dos arbustos na beira \n" +
		                   "da estrada e te ataca, mal sabe ele que não criamos valores monetários para esse jogo. \n");
		
		Goblin goblin = new Goblin("Jared", 10, 40);
		
		combat(character, goblin);
		
		System.out.println("Depois de derrotar o goblin você encontra um cogumelo roxo em sua bolsa.\n" +
		                   "1. Comer (Constituição)\n" +
				           "2. Deixar o cogumelo     ");
		
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				Random rand = new Random();
				if(rand.nextInt(character.getCon()-5, character.getCon()) < 12) {
					character.setHp(character.getMaxHp()/2);
					creaturesLair(character);
					break;
				} else {
					System.out.println("(SUCESSO)Mesmo tendo um gosto horrível o cogumelo não gera mais do quê uma careta em você,\n" +
				                       "hora de seguir rumo a Snowville, cidade vizinha a nosso destino.                          \n");
					snowville(character);
					break;
				}
			}
			case 2:
				System.out.println("Precaução nunca foi demais, você deixa o cogumelo no chão e segue rumo a snowville.\n");
				snowville(character);
				break;
		}
	}
	
	public static void cave(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Você adentra a caverna com uma lanterna em mãos, a caverna é bem escura e úmida, suas paredes de pedra \n" +
		                   "estão cobertas de musgo. Enquanto caminha você considera um parada para comer algumas frutas que trouxe\n" +
				           "em sua bolsa.                                                                                          \n" +
		                   "1. Parar e comer                                                                                        \n" +
				           "2. Seguir em frente");
		
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				System.out.println("Não surpeendentemente, morcegos que vivem na caverna identificam o cheiro das frutas e te atacam.\n");
				
				Bat bats = new Bat("Colónia de Morcegos", 30, 160);
				combat(character, bats);
				
				System.out.println("Após acabar com a ameaça dos morcegos, você segue sua viagem pela caverna sem mais interrupções e\n" +
				                   "chega a uma estrada ao fim da caverna.\n                                                           ");
				volcanoRoad(character);
				break;
			}
			case 2: {
				Random rand = new Random();
				System.out.println("Você segue em frente mas a má iluminação dentro da caverna dificulta muito sua movimentação, é\n" +
			                       "difícil de dizer aonde se está pisando.                                                       \n");
				if(rand.nextInt(character.getDex()-5, character.getDex()) <= 12) {
					System.out.println("Você não percebe o buraco no chão e acaba tropeçando e caindo nele, até consegue sair mas \n" +
				                       "não sem se machucar. (-20Hp)");
					character.setHp(character.getHp()-20);
				} else {
					System.out.println("Por conta da escuridão você não nota um buraco na sua frente enquanto caminha, por pouco  \n" +
				                       "você não caí, a destreza de conseguir se equilibrar no último instante, te salvou.        \n");
				}
				volcanoRoad(character);
			}
		}
	}
	
	public static void creaturesLair(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("(FALHA)Você não lembra muita coisa do quê aconteceu depois de comer aquele cogumelo, mas não parece \n" +
		                   "ter sido uma boa idéia. Você acorda amarrado a um poste, o ambiente onde você está lembra o interior\n" +
				           "de uma cabana de madeira.                                                                           \n" +
		                   "1. Tentar forçar as cordas (Força)                                                                  \n" +
				           "2. Conjurar um feitiço de fogo para queimar as cordas (Inteligência)                                \n" +
		                   "3. Tentar alcançar a faca em sua cintura e cortar as cordas (Destreza)                              \n");
		
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				if(rand.nextInt(1, 20) + (int) character.getStr()/2 >= 16) {
					System.out.println("(SUCESSO)As cordas se rompem com sua força, você está livre e vai em direção à saída da \n" +
				                       "cabana. Ao abrir a porta você logo percebe onde está, no meio de uma tribo de goblins, e\n" +
							           "na sua frente, o rei goblin.                                                            \n");
					Goblin king = new Goblin("Rei Goblin", 50, 250);
					combat(character, king);
					break;
				} else {
					System.out.println("(FALHA)Acho que você precisa tomar suas vitaminas, a corda nem se mexe. Depois de um tempo\n" +
				                       "você descobre que está em um viarejo goblin, e agora, você é o prato principal.           \n");
					gameOver();
					break;
				}
			} case 2: {
				if(rand.nextInt(1, 20) + (int) character.getInte()/2 >= 16) {
					System.out.println("(SUCESSO)As cordas queimam o suficiente para te libertarem, você está livre e vai em dire-\n" +
				                       "ção à saída da cabana. Ao abrir a porta você logo percebe onde está, no meio de uma tribo \n" +
							           "de goblins, e na sua frente, o rei goblin.                                                \n");
					Goblin king = new Goblin("Rei Goblin", 50, 250);
					combat(character, king);
					break;
				} else {
					System.out.println("(FALHA)Você quase coloca a si mesmo em chamas, a corda nem se mexe. Depois de um tempo\n" +
		                       "você descobre que está em um viarejo goblin, e agora, você é o prato principal.               \n");
					gameOver();
					break;
				}
			}
			case 3: {
				if(rand.nextInt(1, 20) + (int) character.getDex()/2 >= 16) {
					System.out.println("(SUCESSO)Você consegue cortar as cordas, você está livre e vai em direção à saída da \n" +
		                       "cabana. Ao abrir a porta você logo percebe onde está, no meio de uma tribo de goblins, e     \n" +
					           "na sua frente, o rei goblin.                                                                 \n");
					Goblin king = new Goblin("Rei Goblin", 50, 250);
					combat(character, king);
					break;
				} else {
					System.out.println("(FALHA)Você só consegue um corte no dedo e bastante dor. Depois de um tempo    \n" +
		                       		   "você descobre que está em um viarejo goblin, e agora, você é o prato principal.\n");
					gameOver();
					break;
				}
			}
		}
		System.out.println("Depois de resolver seus problemas com os goblins você pega o quê acha pela tribo. (+2 poções)\n" +
                           "Você percebe que não está tão distante de Snowville, sua próxima parada.                     \n");
		character.setPotion(character.getPotion()+2);
		snowville(character);
	}
	
	public static void snowville(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Você está na entrada da cidade mas antes que pudesse entrar é abordado por uma criatura diferente,\n" +
		                   "ele tira o capuz que cobre seu rosto e você percebe que é um esqueleto, nada usual...             \n" +
				           "- HeHeHeHe. Meu nome é Papyrus, e é osso entrar nessa cidade. Para passar você precisa responder  \n" +
		                   "alguns de meus enigmas, é bem simples.                                                            \n" +
				           "                                                                                                  \n" +
		                   "Primeira pergunta: Qual o instrumento preferido de um esqueleto?                                  \n" +
				           "1. Saxofone\n" +
		                   "2. Flauta  \n" +
				           "3. Trombone\n" +
		                   "4. Violão    ");
		int selection = sc.nextInt();
		switch(selection) {
			case 3: {
				System.out.println("- Isso mesmo, isso mesmo, tromBONE, entendeu? Entendeu? RAJRAJRAJRAJ.\n" +
			                       "Toma aqui. (+1 poção)                                                \n");
				character.setPotion(character.getPotion()+1);
				infoTab(character);
				break;
			}
			default: {
				System.out.println("- Como você conseguiu errar essa? *lança um osso na sua direção*\n");
				character.setHp(character.getHp()-20);
				infoTab(character);
				if(character.isAlive() != true) gameOver();
			}
		}
		
		System.out.println("Segunda pergunta: Qual o doce preferido de um esqueleto?\n" +
		                   "1. Churros        \n" +
				           "2. Doce de leite  \n" +
		                   "3. Balinha de café\n" +
				           "4. Sorvete          ");
		selection = sc.nextInt();
		switch(selection) {
			case 4: {
				System.out.println("- Isso mesmo, OSSOrvete RAJRAJRAJRAJ.\n" +
			                       "Pega. (+1 poção)                     \n");
				character.setPotion(character.getPotion()+1);
				infoTab(character);
				break;
			}
			default: {
				System.out.println("- Acho que precisamos verificar se você é que nem eu, só osso, sem cérebro.\n");
				character.setHp(character.getHp()-20);
				infoTab(character);
				if(character.isAlive() != true) gameOver();
			}
		}
		
		System.out.println("Terceira pergunta: Qual parte do corpo mais conquista um esqueleto?\n" +
		                   "1. Sorriso\n" +
				           "2. Cabelo \n" +
		                   "3. Lábios \n" +
				           "4. Olhos    ");
		selection = sc.nextInt();
		switch(selection) {
			case 1: {
				System.out.println("- Eu não sei você, mas eu sou caio para OSSOrriso. RARARARARARA\n" +
	                      	       "Você merece. (+1 poção)                                        \n");
				character.setPotion(character.getPotion()+1);
				infoTab(character);
				break;
			}
			default: {
				System.out.println("- Você não deve ter nenhuma sorte no amor.\n");
				character.setHp(character.getHp()-20);
				infoTab(character);
				if(character.isAlive() != true) gameOver();
			}
		}
		
		System.out.println("- Independente de você conseguir passar pelos meus enigmas ou não, preciso testar sua força,\n" +
		                   "já vou logo avisando, eu sou osso duro de roer. RAJRAJRAJRAJRAJ                            \n");
		Skeleton papyrus = new Skeleton("Papyrus", 30, 180);
		combat(character, papyrus);
		
		System.out.println("- Eu já imaginava que você fosse bom mesmo, mas era de se esperar, você também tem um esqueleto dentro de si. RAJRAJRAJRAJRAJ\n" +
		                   "Vai lá e não esquece das doses diárias de cálcio.                                                                          \n\n" +
				           "Você adentra a cidade, mas sua passagem é prevista para ser curta, seu objetivo está logo a frente, o lar do dragão.         \n" +
		                   "Você prepara seus equipamentos e segue rumo ao confronto final.                                                              \n");
		dragonHunt(character);
 	}
	
	public static void volcanoRoad(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Após sair da caverna você se encontra na estrada que leva diretamente ao vulcão e lar do seu objetivo.\n" +
		                   "E logo no início da estrada você observa um problema, uma carroça tombada impede sua passagem, o dono \n" +
				           "não parece estar perto.                                                                               \n" +
		                   "1. Tentar tirar a carroça da estrada (FORÇA)                                                          \n" +
				           "2. Pular por cima da carroça (DESTREZA)                                                               \n" +
		                   "3. Pular no corrego que percorre os dois lados da estrada e atravessar o bloqueio a nado                ");
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				if(rand.nextInt(1, 20) + (int) character.getStr()/2 >= 18) {
					System.out.println("(SUCESSO)Você consegue erguer a carroça e tirá-lá do caminho sem infortúnios, no processo,\n" +
				                       "você ainda encontra algumas poções, agora resta seguir para o seu objetivo.               \n");
					character.setPotion(character.getPotion()+2);
					dragonHunt(character);
					break;
				} else {
					System.out.println("(FALHA)Você aparentemente não está tão forte assim, só conseguiu se machucar no processo\n" +
				                       "e terá de nadar mesmo. (-15 Hp)                                                         \n");
					character.setHp(character.getHp()-15);
					infoTab(character);
					if(character.isAlive() != true) gameOver();
					
					System.out.println("A correnteza é bastante forte, você consegue passar mas perdeu uma poção no processo e vai\n" +
					                   "enfrentar seu objetivo estando mais debilitado.                                           \n");
					character.setPotion(character.getPotion()-1);
					dragonHunt(character);
				}
			}
			case 2: {
				if(rand.nextInt(1, 20) + (int) character.getDex()/2 >= 18) {
					System.out.println("(SUCESSO)Você consegue pular por cima carroça e agora segue rumo ao objetivo.\n");
					dragonHunt(character);
					break;
				} else {
					System.out.println("(FALHA)Você aparentemente es´ta enferrujado, só conseguiu se machucar no processo\n" +
		                               "e terá de nadar mesmo. (-15 Hp)                                                          \n");
					character.setHp(character.getHp()-15);
					infoTab(character);
					if(character.isAlive() != true) gameOver();
			
					System.out.println("A correnteza é bastante forte, você consegue passar mas perdeu uma poção no processo e vai\n" +
			                           "enfrentar seu objetivo estando mais debilitado.                                           \n");
					character.setPotion(character.getPotion()-1);
					dragonHunt(character);
				}
			}
			default: {
				System.out.println("A correnteza é bastante forte, você consegue passar mas perdeu uma poção no processo e vai\n" +
                                   "enfrentar seu objetivo estando mais debilitado.                                           \n");
				character.setPotion(character.getPotion()-1);
				dragonHunt(character);
			}
		}
	}
	
	public static void dragonHunt(Build character) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Você finalmente chega ao vulcão, logo a sua frente está a entrada para o lar do dragão, mesmo na entrada,\n" +
		                   "você consegue sentir o ar quente que é expelido de lá, só não sabe se é o vulcão ou o seu inimigo.       \n" +
				           "Antes de entrar você aproveita para usar um tomo mágico que trouxe consigo dentro da bolsa, o feitiço    \n" +
		                   "nele contido cura sua vida completamente.                                                                \n");
		character.setHp(character.getMaxHp());
		
		System.out.println("Dentro do vulcão as paredes são claramente feitas de magma resfriado, o ar é quente e quanto mais se apro-\n" +
		                   "funda maior fica a presença do dragão.\n" +
				           "Após 20 minutos andando você chega em um grande espaço aberto dentro do vulcão, e na sua frente estão pi-     \n" +
		                   "lhas e mais pilhas de tesouros, ouro, jóias e todo tipo de riquezas, provavelmente o dragão as vem coletan    \n" +
				           "do das cidades as quais ataca. E logo após esse pensamento passar por sua cabeça, você só consegue se jogar   \n" +
		                   "para o lado para desviar de uma baforada de fogo, o dragão está na sua frente. Vermelho e maior que os maiores\n" +
				           "prédios que você já viu na vida, sua batalha final inicia agora.                                              \n");
		Dragon dragon = new Dragon("Shen-Long", 30, 300);
		combat(character, dragon);
		
		System.out.println("O corpo chamuscado e dolorido, você se ergue vitorioso, o dragão, majestosamente abatido ao seu lado, foi uma \n" +
		                   "dura batalha. Você pega sua adaga e o frasco entregue pelo taverneiro, encontrando uma brecha entre as duras  \n" +
				           "escamas, você consegue coletar o sangue da fera.                                                            \n\n" +
		                   "E agora? Você me pergunta. Os tesouros da caverna estão ao seu dispor. 'Mas e o taverneiro e sua filha?', essa\n" +
				           "história já está bem longa, o personagem é você, o quê você fez com o sangue coletado?                        \n" +
		                   "                                                                                                              \n" +
				           "---------------------------------------------------FIM--------------------------------------------------------\n" +
		                   "Parabéns por concluir a história.\n" +
				           "1. Voltar para o menu.           \n" +
		                   "2. Sair"                            );
		int selection = sc.nextInt();
		switch(selection) {
			case 1: {
				menu();
				break;
			}
			default: {
				System.exit(0);
			}
		}
	}
}
