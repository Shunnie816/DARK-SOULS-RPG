package character;

import java.util.Random;

import creature.Creature;
import item.Dagger;
import item.ThiefCloth;

public class Thief extends Character {

	public Thief(String name) {
		super(name);
		this.setLevel(4);
		this.setMinHp(40);
		this.setPower(30);
		this.setWeapon(new Dagger("ダガー"));
		this.setArmor(new ThiefCloth("盗人の服"));
		this.setHp(this.getMinHp() + this.getArmor().getDefence());
		this.setMaxHp(this.getHp());
	}

	@Override
	public void attack(Creature c) {
		// 盗人の攻撃はダガーの振り回しで1～3回のランダムヒット
		String weaponName = this.getWeapon().getName();
		Random r = new Random();
		int random = r.nextInt(2) + 1;
		int dmg = (int) (this.getPower() * this.getWeapon().getDmg() * (random));

		System.out.println(this.getName() + "は、" + c.getName() + "に" + weaponName + "で攻撃した！");
		System.out.println(c.getName() + "に" + random + "回ヒットし、" + dmg + "のダメージ！");
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
