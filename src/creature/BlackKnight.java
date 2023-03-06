package creature;

public class BlackKnight extends Enemy {
	// 黒騎士

	public BlackKnight(char num, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(num, name);
		this.setHp(500);
		this.setMaxHp(this.getHp());
		this.setSoul((int) (this.getMaxHp() * 1.7));
		this.setDmg(80);
		this.setWeapon("黒騎士の剣");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
