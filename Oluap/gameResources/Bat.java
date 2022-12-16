package gameResources;

import java.util.Random;

public class Bat extends Creature {

	public Bat(String name, int dmg, int maxHp) {
		super(name, dmg, maxHp);
	}

	@Override
	public int attack() {
		Random rand = new Random();
		String[] batAttackQuotes = {"O morcego te morde, o dano não é tão alto mas suas vacinas estão em dia?",
				                    "O morcego bate com as asas no seu rosto."};
		System.out.println(batAttackQuotes[rand.nextInt(batAttackQuotes.length)]);
		return getDmg();
	}

	@Override
	public void heal() {
		System.out.println("O morcego come uma fruta qualquer e está curado. Simples, não?");
		setHp(getMaxHp());
	}
	
	@Override
	public int skill() {
		System.out.println("O morcego chupa seu sangue e recupera a própria vida. Não deveria ser um vampiro então? Bem... Já está no jogo como um morcego.");
		setHp(getMaxHp());
		return getDmg();
	}

}
