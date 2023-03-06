package main;

import java.util.Scanner;

import character.Character;

public class Main {

	public static void main(String[] args) {

		// Scannerの初期化
		Scanner s = new Scanner(System.in);

		//		キャラクターの生成
		//		System.out.print("キャラクター番号を選択してください (1. 騎士、2. 盗賊、3. 魔法使い、 4. 祈禱師) : ");
		//		int num = s.nextInt();
		//		System.out.print("キャラクターの名前を入力してください: ");
		//		String name = s.next();
		//		Character c = Setting.selectCharacter(num, name);
		//
		//		if (c == null) {
		//			System.out.println("キャラクターが正常に作成されませんでした。");
		//			System.exit(0);
		//		} else {
		//			System.out.println(
		//					c.getName() + "さん、あなたの装備は" + c.getWeapon().getName() + "と" + c.getArmor().getName() + "です。");
		//		}

		//		キャラクターサンプル
		Character c = Setting.selectCharacter(1, "Shun");

		//		Tutorial.start(c);

		//		ステージ選択
		Setting.selectStage(c);

		// Scannerのインスタンスを閉じる
		s.close();
	}

}
