package item;

public abstract class Item {
	private String name;
	private int price;

	//	コンストラクタ
	public Item(String name) {
		this.setName(name);
	}

	// フィールドのゲッターとセッター
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
