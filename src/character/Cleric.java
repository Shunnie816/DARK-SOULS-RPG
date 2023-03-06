package character;

import creature.Creature;
import item.ClericRobe;
import item.Talisman;

public class Cleric extends Character {

	public Cleric(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
		this.setLevel(6);
		this.setMinHp(50);
		this.setPower(30);
		this.setMagicPower(90);
		this.setWeapon(new Talisman("タリスマン"));
		this.setArmor(new ClericRobe("祈禱師のローブ"));
		this.setHp(this.getMinHp() + this.getArmor().getDefence());
		this.setMaxHp(this.getHp());
	}

	@Override
	public void attack(Creature c) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
