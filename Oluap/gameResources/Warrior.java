package gameResources;

import java.util.Random;

public class Warrior extends Build {
	
	public Warrior(String name, int str, int dex, int inte, int con, int potion) {
		super(name, str, dex, inte, con, potion);
	}

	public int attack() {
		Random rand = new Random();
		String[] attackQuotes = {"Você ergue sua arma e golpeia de cima para baixo.", 
				                 "Você desfere uma estocada", 
				                 "Sua arma se move horizontalmente buscando acertar qualquer coisa a sua frente.", 
				                 "Você corre em direção ao inimigo e o atinge com o peso de seu corpo"};
		System.out.println(attackQuotes[rand.nextInt(attackQuotes.length)]);
		return getStr()*2;
	}

	public void heal() {
		if (getPotion() > 0) {
			System.out.println("Você quebra o frasco de poção no seu peito. (Vida totalmente curada)");
			setPotion(getPotion()-1);
			setHp(getMaxHp());
		} else {
			System.out.println("Você não possui mais poções.");
		}
	}
	
	@Override
	public int useSkill() {
		return modoBeserk();
	}
	
	private int modoBeserk() {
		System.out.println("Sua visão fica turva, você sente o gosto metálico de sangue na boca, seus músculos ficam rígidos. "
		         + "Por alguns instantes você não consegue pensar em mais nada além do inimigo em sua frente. "
		         + "Com sua arma em punho você avança, atacando em frenesi.");
		return getStr()*4;
	}


}
