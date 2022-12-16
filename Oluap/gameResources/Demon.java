package gameResources;

public class Demon extends Creature {

	public Demon(String name, int dmg, int maxHp) {
		super(name, dmg, maxHp);
	}

	@Override
	public int attack() {
		System.out.println("Você não compreende nada do que vê, o estado de sua sanidade é questionável.");
		return getDmg();
	}

	@Override
	public void heal() {
		System.out.println("Em escárnio, o demônio simula o mesmo que outros inimgos chamariam de 'cura', não faz nenhuma diferença.");
	}

}
