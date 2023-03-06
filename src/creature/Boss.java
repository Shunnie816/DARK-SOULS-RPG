package creature;

import character.Character;

public abstract class Boss extends Creature {

	public Boss() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void strongAttack(Character c) {
		// 通常攻撃の2倍のダメージ
		//		ダメージ計算 (攻撃力 x (1 - カット率));
		int dmg = (int) (this.getDmg() * (1 - c.getArmor().getCut()));

		System.out.println(this.getName() + "は、" + c.getName() + "に" + this.getWeapon() + "で強攻撃を仕掛けてきた！");
		System.out.println(c.getName() + "に" + dmg * 2 + "のダメージ！");
		c.setHp(c.getHp() - dmg * 2);

		if (c.getHp() <= 0) {
			c.die();
		} else {
			System.out.println(c.getName() + "のHPは" + c.getHp() + "だ");
		}
	}

	public abstract void mutate(); //第二形態に変化、または2本目のゲージ

}
