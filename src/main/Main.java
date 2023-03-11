package main;

import java.util.Scanner;

import character.Character;
import stage.Tutorial;

public class Main {

	public static void main(String[] args) {

		// Scannerの初期化
		Scanner s = new Scanner(System.in);

		//		キャラクターの生成
		System.out.print("キャラクター番号を選択してください (1. 騎士、2. 盗賊、3. 魔法使い、 4. 祈禱師) : ");
		int num = s.nextInt();
		System.out.print("キャラクターの名前を入力してください: ");
		String name = s.next();
		Character c = Setting.selectCharacter(num, name);

		if (c == null) {
			System.out.println("キャラクターが正常に作成されませんでした。");
			System.exit(0);
		} else {
			System.out.println(
					c.getName() + "さん、あなたの装備は" + c.getWeapon().getName() + "と" + c.getArmor().getName() + "です。");
		}

		//		キャラクターサンプル
		//		Character c = Setting.selectCharacter(1, "Shun");

		//	チュートリアル
		Tutorial.start(c);

		//		ステージ選択
		boolean game = true;

		while (game) {
			Scanner s2 = new Scanner(System.in);
			Setting.selectStage(c);
			System.out.print("ステージ選択を続けますか？： 1. はい　2. いいえ");
			int ans = s2.nextInt();
			// 1以外を選択するとゲームが終了する。
			if (ans == 1) {
				// なにもしない
			} else {
				game = false;
				s2.close();
				System.out.println("ゲームが終了しました。");
			}
		}

		// Scannerのインスタンスを閉じる
		s.close();

	}

}
