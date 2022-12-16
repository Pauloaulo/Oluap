package gameResources;

import java.util.Random;

public class Dragon extends Creature {

	public Dragon(String name, int dmg, int maxHp) {
		super(name, dmg, maxHp);
	}

	@Override
	public int attack() {
		Random rand = new Random();
		String[] dragonAttackQuotes = {"O dragão usa suas garras e te atinge.", 
				                       "Ele balança e, com um giro, te acerta com a cauda."};
		System.out.println(dragonAttackQuotes[rand.nextInt(dragonAttackQuotes.length)]);
		return getDmg();
	}

	@Override
	public void heal() {
		System.out.println("A pele com escamas e sua natureza reptiliana curam o dragão conforme ele se concetra.");
		setHp(getMaxHp());
	}

	@Override
	public int skill() {
		System.out.println("O dragão sopra uma grande rajada de fogo que incinera tudo em seu caminho.");
		return getDmg()*3;
	}
}
