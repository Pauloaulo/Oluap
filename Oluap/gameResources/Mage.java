package gameResources;

import java.util.Scanner;
import java.util.Random;

public class Mage extends Build {
	
	public Mage(String name, int str, int dex, int inte, int con, int potion) {
		super(name, str, dex, inte, con, potion);
	}

	@Override
	public int attack() {
		Random rand = new Random();
		String[] attackQuotes = {"Você bate com seu cajado na cabeça do inimigo... Não é muito efetivo.", 
				                 "Você profere palavras de baixo calão e dá alguns socos... Não é muito sua área."};
		System.out.println(attackQuotes[rand.nextInt(attackQuotes.length)]);
		return getStr();
	}

	@Override
	public void heal() {
		if (getPotion() > 0) {
			System.out.println("Não é o quê se espera de um mago, mas você remove a rolha e bebe a poção. (Vida totalmente curada)");
			setPotion(getPotion()-1);
			setHp(getMaxHp());
		} else {
			System.out.println("Você não possui mais poções.");
		}
	}

	@Override
	public int useSkill() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("---------------%n"
				        + "1) Bola de Fogo%n"
				        + "2) Restauração%n"
				        + "--------------%n");
		
		int selection = sc.nextInt();
		
		switch(selection) {
			case 1: {
				return fireball();
			}
			case 2: {
				restoration();
				return 0;
			}
			default: {
				System.out.println("Selecione uma opção válida. ");
				useSkill();
			}
		}
		return 0;
		
	}

	private int fireball() {
		Random rand = new Random();
		String[] fireballQuotes = {"Uma grande esfera de calor se forma em suas maõs e você lança a mesma na direção do inimigo.", 
				                   "O ambiente ao seu redor fica distorcido pelo calor, a grande fonte de calor que você segura é lançada em direção ao inimigo.",
				                   "O calor é tão grande que evapora a umidade do ar ao seu redor."};
		System.out.println(fireballQuotes[rand.nextInt(fireballQuotes.length)]);
		return getInte()*4;
	}
	
	private void restoration() {
		System.out.println("Uma aura clara surge ao seu redor. (Vida completamente curada.");
		setHp(getMaxHp());
	}
	
}
