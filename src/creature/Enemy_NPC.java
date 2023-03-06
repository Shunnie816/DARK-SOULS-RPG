package creature;

public class Enemy_NPC extends Boss {

	public Enemy_NPC(String name, String weapon) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName(name);
		this.setHp(5000);
		this.setSoul(5000);
		this.setDmg(100);
		this.setWeapon(weapon);
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
