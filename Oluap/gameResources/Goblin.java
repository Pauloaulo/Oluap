package gameResources;

import java.util.Random;

public class Goblin extends Creature {

	public Goblin(String name, int dmg, int maxHp) {
		super(name, dmg, maxHp);
	}

	@Override
	public int attack() {
		Random rand = new Random();
		String[] goblinAttackQuotes = {"O goblin corre em sua direção e te ataca com uma faca.",
				                       "O goblin usa sua pequena lança pra dar uma estocada.",
				                       "O goblin lança uma pedra em sua direção."};
		System.out.println(goblinAttackQuotes[rand.nextInt(goblinAttackQuotes.length)]);
;		return getDmg();
	}
	
	@Override
	public void heal() {
		System.out.println("O goblin tira uma poção de uma pequena sacola que carrega, provavelmete a poção foi roubada. Ele bebe a poção e se cura completamente.");
		setHp(getMaxHp());
	}

}
