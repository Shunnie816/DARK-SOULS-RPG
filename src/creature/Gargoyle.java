package creature;

import character.Character;

public class Gargoyle extends Boss {

	public Gargoyle() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName("ガーゴイル");
		this.setHp(10000);
		this.setSoul(5000);
		this.setDmg(70);
		this.setWeapon("ガーゴイルの槍");
	}

	@Override
	public void strongAttack(Character c) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mutate() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
