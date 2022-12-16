package gameResources;

import java.util.Random;

public class Skeleton extends Creature {

	public Skeleton(String name, int dmg, int maxHp) {
		super(name, dmg, maxHp);
	}

	@Override
	public int attack() {
		System.out.println("O esqueleto arranca um braço de si próprio e te bate com ele.");
		return getDmg();
	}

	@Override
	public void heal() {
		Random rand = new Random();
		String[] skeletonHealQuotes = {"O esqueleto puxa um item do... bolso? Ele toma seu Calcitran B3 e recupera toda sua vida.",
				                       "Nada que um copo de leite não resolva, o esqueleto se cura completamente."};
		System.out.println(skeletonHealQuotes[rand.nextInt(skeletonHealQuotes.length)]);
		setHp(getMaxHp());
	}

}
