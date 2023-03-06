package creature;

import character.Character;

public abstract class Creature {
	private String name;
	private char number; // 複数のモブを設置する時のカウント用
	private int hp;
	private int maxHp;
	private int dmg;
	private int soul;
	private String weapon;
	private boolean dead = false;

	//	コンストラクタ
	public Creature() {
	}

	// フィールドのゲッターとセッター
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDmg() {
		return this.dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public String getWeapon() {
		return this.weapon;
	}

	public void setWeapon(String w) {
		this.weapon = w;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(char number) {
		this.number = number;
	}

	public int getSoul() {
		return this.soul;
	}

	public void setSoul(int s) {
		this.soul = s;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	//	敵の基本メソッド
	public abstract void defence();

	public void attack(Character c) {
		//		ダメージ計算 (攻撃力 x (1 - カット率));
		int dmg = (int) (this.getDmg() * (1 - c.getArmor().getCut()));

		System.out.println(this.getName() + "は、" + c.getName() + "に" + this.getWeapon() + "で攻撃した！");
		System.out.println(c.getName() + "に" + dmg + "のダメージ！");
		c.setHp(c.getHp() - dmg);

		if (c.getHp() <= 0) {
			c.die();
		} else {
			System.out.println(c.getName() + "のHPは" + c.getHp() + "だ");
		}
	}

	public void checkStatus() {
		System.out.println(this.getName() + "のステータス");
		System.out.println("HP: " + this.getHp());
	}

	public void die() {
		if (this.getHp() <= 0) {
			System.out.println(this.getName() + "は、倒れた");
			this.setDead(true);
		}

	}
}
