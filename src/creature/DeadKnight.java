package creature;

public class DeadKnight extends Enemy {
	// 亡者兵士

	public DeadKnight(char num, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(num, name);
		this.setHp(150);
		this.setMaxHp(this.getHp());
		this.setSoul((int) (this.getMaxHp() * 1.7));
		this.setDmg(40);
		this.setWeapon("ロングソード");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
