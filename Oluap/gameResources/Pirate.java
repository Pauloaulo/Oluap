package gameResources;

import java.util.Random;

public class Pirate extends Creature {

	public Pirate(String name, int dmg, int maxHp) {
		super(name, dmg, maxHp);
	}

	@Override
	public int attack() {
		Random rand = new Random();
		String[] pirateAttackQuotes = {"O pirata te ataca com sua espada.",
				                       "Usando uma revólver a pólvora, bem antigo, o pirata atira em sua direção."};
		System.out.println(pirateAttackQuotes[rand.nextInt(pirateAttackQuotes.length)]);
		return getDmg();
	}

	@Override
	public void heal() {
		System.out.println("Uma garrafa de rum e 15 minutos assistindo Piratas do Caribe e o pirata está curado.");
		setHp(getMaxHp());
	}

	@Override
	public int skill() {
		System.out.println("O pirata ordena que todos os canhões do navio atirem em você. Com certeza doeu.");
		return getDmg()*2;
	}
}
