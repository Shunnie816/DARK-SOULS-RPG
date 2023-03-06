package creature;

public class Dead extends Enemy {
	//亡者

	public Dead(char num, String name) {
		super(num, name);
		this.setHp(100);
		this.setMaxHp(this.getHp());
		this.setSoul((int) (this.getMaxHp() * 1.7));
		this.setDmg(20);
		this.setWeapon("折れた直剣");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.getName() + "は、守りの体制に入った！");
	}

}
