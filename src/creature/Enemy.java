package creature;

public abstract class Enemy extends Creature {

	public Enemy(char num, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName(name);
		this.setNumber(num);
		this.setName(this.getName() + this.getNumber());
		System.out.println(this.getName() + "が現れた！");
	}

	@Override
	public void defence() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
