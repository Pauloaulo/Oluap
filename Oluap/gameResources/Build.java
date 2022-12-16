package gameResources;

public abstract class Build implements Actions {

	private String name;

	private int str;
	private int dex;
	private int inte;
	private int con;
	private int maxHp;
	private int hp;
	private int potion;

	public Build(String name, int str, int dex, int inte, int con, int potion) {
		this.name = name;
		this.str = str;
		this.dex = dex;
		this.inte = inte;
		this.con = con;
		this.maxHp = con*10;
		this.hp = maxHp;
		this.potion = potion;
	}
	
	@Override
	public abstract int attack();
	@Override
	public abstract void heal();
	public abstract int useSkill();
	
	public String getName() {
		return name;
	}
	public int getStr() {
		return str;
	}
	public int getDex() {
		return dex;
	}
	public int getInte() {
		return inte;
	}
	public int getCon() {
		return con;
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
	
	public int getPotion() {
		return potion;
	}
	public void setPotion(int newPotion) {
		potion = newPotion;
	}
	
	public boolean isAlive () {
		boolean x = (hp > 0) ? true : false;
		return x;
	}
	
}
