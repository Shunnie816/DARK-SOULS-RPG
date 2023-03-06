package character;

import creature.Creature;
import item.MagicianRobe;
import item.Wand;

public class Wizard extends Character {

	public Wizard(String name) {
		super(name);
		this.setLevel(6);
		this.setMinHp(40);
		this.setPower(10);
		this.setMagicPower(90);
		this.setWeapon(new Wand("杖"));
		this.setArmor(new MagicianRobe("魔法使いのローブ"));
		this.setHp(this.getMinHp() + this.getArmor().getDefence());
		this.setMaxHp(this.getHp());
	}

	@Override
	public void attack(Creature c) {
		// TODO 自動生成されたメソッド・スタブ
		//		呼び出しの簡略化
		String weaponName = this.getWeapon().getName();
		int dmg = (int) (this.getMagicPower() * this.getWeapon().getDmg());

		System.out.println(this.getName() + "は、" + c.getName() + "に" + weaponName + "でソウルの矢を放った！");
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
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.getName() + "は、守りの体制に入った！");
	}

}
