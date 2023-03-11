package stage;

import java.util.Scanner;

import character.Character;

public abstract class Stage {
	private String name;
	private int clearCount = 0;

	Scanner s = new Scanner(System.in);

	public Stage() {
	}

	//	フィールドのゲッターとセッター
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClearCount() {
		return clearCount;
	}

	public void setClearCount(int clearCount) {
		this.clearCount = clearCount;
	}

	// 共通のメソッド
	public abstract void start(Character c);

	public void open() {
		System.out.println("===================================");
		System.out.println("          --------------" + this.getName() + "-----------");
		System.out.println("===================================");
	}

	public void stageClear() {
		try {
			Thread.sleep(2000);
			System.out.println("===================================");
			System.out.println("---------------------STAGE CLEAR----------------------");
			System.out.println("===================================");
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void bonfireMenu(Character c) {

		try {
			Thread.sleep(2000);
			System.out.println("少し歩いたところで篝火を見つけた");
			Thread.sleep(500);
			System.out.print("篝火に火を灯しますか？： 1. はい　2. いいえ");
			int num = s.nextInt();

			switch (num) {
			case 1:
				Thread.sleep(500);
				Bonfire.find();
				Thread.sleep(500);
				System.out.println("篝火に触れると、体力の回復やレベルアップを行うことができます。");
				Thread.sleep(500);
				Bonfire.heal(c);
				break;
			case 2:
				Thread.sleep(500);
				System.out.println("篝火に触れると、体力の回復やレベルアップを行うことができます。");
				Thread.sleep(500);
				break;
			default:
				Thread.sleep(500);
				System.out.println("篝火に触れると、体力の回復やレベルアップを行うことができます。");
				Thread.sleep(500);
				break;
			}
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}