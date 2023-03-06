package character;

import java.util.Random;

import creature.Creature;
import item.Armor;
import item.Weapon;

public abstract class Character {
	private String name;
	private int hp;
	private int minHp; //基礎HP
	private int maxHp;
	private int level;
	private int soul;
	private int power; //攻撃力 
	private int est = 60; //エスト瓶の回復量
	private int estCount = 10; //エスト瓶の残量
	int magicPower;
	private boolean dead = false;
	Weapon weapon;
	Armor armor;

	//	コンストラクタ
	public Character(String name) {
		this.setName(name);
		this.setSoul(0);
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

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Weapon w) {
		this.weapon = w;
	}

	public Armor getArmor() {
		return this.armor;
	}

	public void setArmor(Armor a) {
		this.armor = a;
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

	public void setMaxHp(int mx) {
		this.maxHp = mx;
	}

	public int getMinHp() {
		return this.minHp;
	}

	public void setMinHp(int min) {
		this.minHp = min;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getEst() {
		return est;
	}

	public void setEst(int est) {
		this.est = est;
	}

	public int getEstCount() {
		return estCount;
	}

	public void setEstCount(int estCount) {
		this.estCount = estCount;
	}

	public int getMagicPower() {
		return this.magicPower;
	}

	public void setMagicPower(int mp) {
		this.magicPower = mp;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	//	キャラクターの基本メソッド
	public abstract void attack(Creature c);

	public abstract void defence();

	public boolean escape() {
		Random r = new Random();
		int trial = r.nextInt(2);
		if (trial == 0) {
			System.out.println(this.getName() + "は逃げ出した！");
			return true;
		} else {
			System.out.println(this.getName() + "敵に回り込まれて逃げられなかった！");
			return false;
		}
	};

	public void checkBattleStatus() {
		System.out.println("----------------------------------------------------------");
		System.out.println(this.getName() + "のステータスを確認します。");
		System.out.println("HP: " + this.getHp());
		System.out.println("エスト瓶: " + this.getEstCount() + "本");
		System.out.println("MP: " + this.getMagicPower());
		System.out.println("----------------------------------------------------------");
	};

	public void checkStatus() {
		System.out.println("----------------------------------------------------------");
		System.out.println(this.getName() + "のステータスを確認します。");
		System.out.println("HP: " + this.getHp());
		System.out.println("エスト瓶: " + this.getEstCount() + "本");
		System.out.println("MP: " + this.getMagicPower());
		System.out.println("ソウル: " + this.getSoul());
		System.out.println("----------------------------------------------------------");
	};

	public void estHeal() {
		if (this.getHp() > 0 && this.getEstCount() > 0) {
			System.out.println(this.getName() + "はエスト瓶を使用した");
			if (this.getHp() + this.getEst() >= this.getMaxHp()) {
				this.setHp(this.getMaxHp());
			} else {
				this.setHp(this.getHp() + this.getEst());
			}
			this.setEstCount(this.getEstCount() - 1);
		}
		System.out.println(this.getName() + "のHPが" + this.getHp() + "まで回復した");
		System.out.println("エスト瓶は残り" + this.getEstCount() + "個だ");
	}

	public void die() {
		if (this.getHp() <= 0) {
			System.out.println(this.getName() + "は、倒れた");
			System.out.println("===================================");
			System.out.println("---------------------YOU DIED-------------------------");
			System.out.println("===================================");
			System.out.println(this.getSoul() + "ソウルを失った！");
			this.setSoul(0);
			this.setDead(true);
		}
	}

	public void reset() {
		this.setHp(this.getMaxHp());
		this.setEstCount(10);
	}
}
