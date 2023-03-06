package item;

public abstract class Weapon extends Item {

	private double dmg; // キャラクターの攻撃力の補正値を設定する

	//	コンストラクタ
	public Weapon(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// フィールドのゲッターとセッター
	public double getDmg() {
		return this.dmg;
	}

	public void setDmg(double d) {
		this.dmg = d;
	}

}
