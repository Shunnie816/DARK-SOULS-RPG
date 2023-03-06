package creature;

public class Bone extends Enemy {
	// 骸骨兵士

	public Bone(char num, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(num, name);
		this.setHp(120);
		this.setMaxHp(this.getHp());
		this.setSoul((int) (this.getMaxHp() * 1.7));
		this.setDmg(30);
		this.setWeapon("ショートソード");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println(this.getName() + "は、守りの体制に入った！");

	}

}
