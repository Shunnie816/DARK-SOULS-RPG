package item;

public abstract class Armor extends Item {

	private double cut; //カット率
	private int defence; // 防御力はHPにそのまま加算する

	//	コンストラクタ
	public Armor(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// フィールドのゲッターとセッター
	public double getCut() {
		return this.cut;
	}

	public void setCut(double cut) {
		this.cut = cut;
	}

	public int getDefence() {
		return this.defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

}
