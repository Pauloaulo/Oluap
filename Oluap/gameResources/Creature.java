package gameResources;

public abstract class Creature implements Actions {
	
	private String name;
	
	private int dmg;
	private int maxHp;
	private int hp;

	public Creature(String name, int dmg, int maxHp) {
		this.name = name;
		this.dmg = dmg;
		this.maxHp = maxHp;
		this.hp = maxHp;
	}

	@Override
	public abstract int attack();
	@Override
	public abstract void heal();
	public int skill() {
		return 0;
	}

	public String getName() {
		return name;
	}
	public int getDmg() {
		return dmg;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int newHp) {
		hp = newHp;
	}
	
	@Override
	public boolean isAlive() {
		boolean x = (hp > 0) ? true : false;
		return x;
	}
	
}
