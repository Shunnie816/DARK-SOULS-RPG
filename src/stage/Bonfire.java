package stage;

import character.Character;

public abstract class Bonfire {

	private String name;

	public Bonfire() {
		this.setName("篝火");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void find() {
		System.out.println("===================================");
		System.out.println("--------------------BONFIRE LIT-------------------------");
		System.out.println("===================================");
	}

	public static void heal(Character c) {
		System.out.println(c.getName() + "は、篝火で休んだ！");
		c.reset();
	}

	public static void levelUp(Character c) {
		c.setLevel(c.getLevel() + 1);
		System.out.println(c.getName() + "のレベルが" + c.getLevel() + "になった！");
		c.setMinHp((int) (c.getMinHp() * 1.05)); //基礎HPの強化
		c.setPower(c.getPower() + 3); //攻撃力の強化
	}

}