package creature;

public class Golem extends Enemy {
	// 石のゴーレム

	public Golem(char num, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(num, name);
		this.setHp(1000);
		this.setMaxHp(this.getHp());
		this.setSoul((int) (this.getMaxHp() * 1.7));
		this.setDmg(90);
		this.setWeapon("ゴーレムの大剣");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
