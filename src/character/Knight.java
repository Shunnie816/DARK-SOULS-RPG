package character;

import creature.Creature;
import item.KnightArmor;
import item.Sword;

public class Knight extends Character {

	//	コンストラクタ
	public Knight(String name) {
		super(name);
		this.setLevel(5);
		this.setMinHp(50);
		this.setPower(40);
		this.setWeapon(new Sword("ロングソード")); //初期装備
		this.setArmor(new KnightArmor("騎士の鎧")); //初期装備
		this.setHp(this.getMinHp() + this.getArmor().getDefence());
		this.setMaxHp(this.getHp());
	}

	@Override
	public void attack(Creature c) {
		//		呼び出しの簡略化
		String weaponName = this.getWeapon().getName();
		int dmg = (int) (this.getPower() * this.getWeapon().getDmg());

		System.out.println(this.getName() + "は、" + c.getName() + "に" + weaponName + "で攻撃した！");
		System.out.println(c.getName() + "に" + dmg + "のダメージ！");
		c.setHp(c.getHp() - dmg);

		if (c.getHp() <= 0) {
			c.die();
			System.out.println(this.getName() + "は、" + c.getSoul() + "ソウルを手に入れた");
			this.setSoul(getSoul() + c.getSoul());
		} else {
			System.out.println(c.getName() + "のHPは" + c.getHp() + "だ");
		}
	}

	@Override
	public void defence() {
		System.out.println(this.getName() + "は、守りの体制に入った！");
	}

}
