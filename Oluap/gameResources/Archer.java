package gameResources;

import java.util.Random;

public class Archer extends Build {

	public Archer(String name, int str, int dex, int inte, int con, int potion) {
		super(name, str, dex, inte, con, potion);
	}

	@Override
	public int attack() {
		Random rand = new Random();
		System.out.println("Você atira uma flecha no inimigo.");
		if (rand.nextInt(10) <= 5) {
			return getStr();
		} else if (rand.nextInt(10) <= 2) {
			System.out.println("Você demonstra uma destreza notável e consegue atacar ainda mais duas vezes.");
			return getStr()*3;
		} else {
			System.out.println("Graças a suas habilidades, você ataca mais uma vez.");
			return getStr()*3;
		}
	}

	@Override
	public void heal() {
		if (getPotion() > 0) {
			System.out.println("A poção é de um vermelho vívido. (Vida totalmente curada)");
			setPotion(getPotion()-1);
		} else {
			System.out.println("Você não possui mais poções.");
		}
	}

	@Override
	public int useSkill() {
		return rainOfArrows();
	}
	
	public int rainOfArrows () {
		Random rand = new Random();
		String[] rainOfArrowsQuotes = {"Você aponta seu arco para o céu e atira uma quantidade de flechas que facilmente se confundiriam com as atiradas por 100 homens.",
				                 "Seu inimigo olha para o céu e o Sol não é visível, sua chuva de flechas é tudo que ele enxerga."};
		System.out.println(rainOfArrowsQuotes[rand.nextInt(rainOfArrowsQuotes.length)]);
		return getDex()*4;
	}

}
