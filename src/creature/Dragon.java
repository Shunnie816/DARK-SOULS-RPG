package creature;

import character.Character;

public class Dragon extends Boss {

	public Dragon() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName("砦のドラゴン");
		this.setHp(100000);
		this.setSoul(100000);
		this.setDmg(60);
		this.setWeapon("ドラゴンの爪");
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
