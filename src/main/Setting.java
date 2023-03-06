package main;

import java.util.ArrayList;
import java.util.Scanner;

import character.Character;
import character.Cleric;
import character.Knight;
import character.Thief;
import character.Wizard;
import creature.BlackKnight;
import creature.Bone;
import creature.Boss;
import creature.CowHeadDemon;
import creature.Creature;
import creature.Dead;
import creature.DeadKnight;
import creature.Demon;
import creature.Dragon;
import creature.Enemy_NPC;
import creature.Gargoyle;
import creature.Golem;
import stage.Stage0;
import stage.Stage1;

public abstract class Setting {
	// ゲームのシステムに関わるメソッドの定義用クラス

	public Setting() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static Character selectCharacter(int num, String name) {
		// 最初のキャラ選択用
		Character c = null;

		switch (num) {
		case 1:
			c = new Knight(name);
			break;
		case 2:
			c = new Thief(name);
			break;
		case 3:
			c = new Wizard(name);
			break;
		case 4:
			c = new Cleric(name);
			break;
		default:
			System.out.println("キャラクターが正常に作成されませんでした。最初からやり直してください");
			break;
		}

		return c;
	};

	public static void selectStage(Character c) {

		// Scannerの初期化
		Scanner s = new Scanner(System.in);
		System.out.print("ステージを選択してください (1. 北の不死院、2. 城下不死教区、3. 病村、 4. アノールロンド) : ");
		int stage = s.nextInt();

		switch (stage) {
		case 1:
			Stage0 stage0 = new Stage0();
			stage0.start(c);
			break;
		case 2:
			Stage1 stage1 = new Stage1();
			stage1.start(c);
			break;
		case 3:
			System.out.println("このステージは追加予定です。");
			selectStage(c);
			break;
		case 4:
			System.out.println("このステージは追加予定です。");
			selectStage(c);
			break;
		default:
			System.out.println("もう一度やり直してください。");
			selectStage(c);
		}

		s.close();
	}

	public static ArrayList<Creature> generateEnemy(int num, String who) {
		ArrayList<Creature> e = new ArrayList<>();
		// ボス以外を出現させる

		switch (who) {
		case "亡者":
			for (int i = 1; i <= num; i++) {
				e.add(new Dead((char) i, who));
			}
			break;
		case "亡者兵士":
			for (int i = 1; i <= num; i++) {
				e.add(new DeadKnight((char) i, who));
			}
			break;
		case "骸骨兵士":
			for (int i = 1; i <= num; i++) {
				e.add(new Bone((char) i, who));
			}
			break;
		case "黒騎士":
			for (int i = 1; i <= num; i++) {
				e.add(new BlackKnight((char) i, who));
			}
			break;
		case "石のゴーレム":
			for (int i = 1; i <= num; i++) {
				e.add(new Golem((char) i, who));
			}
			break;
		default:
			// 第二引数が上記以外の場合は亡者が出現する
			for (int i = 1; i <= num; i++) {
				e.add(new Dead((char) i, "亡者"));
			}
		}
		return e;
	}

	public static ArrayList<Boss> generateBoss(int num, String who) {
		ArrayList<Boss> e = new ArrayList<>();
		// ボスを出現させる

		switch (who) {
		case "不死院のデーモン":
			for (int i = 1; i <= num; i++) {
				e.add(new Demon());
			}
			break;
		case "牛頭のデーモン":
			for (int i = 1; i <= num; i++) {
				e.add(new CowHeadDemon());
			}
			break;
		case "ガーゴイル":
			for (int i = 1; i <= num; i++) {
				e.add(new Gargoyle());
			}
			break;
		case "ドラゴン":
			for (int i = 1; i <= num; i++) {
				e.add(new Dragon());
			}
			break;
		case "人喰いミルドレット":
			for (int i = 1; i <= num; i++) {
				e.add(new Enemy_NPC("人喰いミルドレット", "肉断ち包丁"));
			}
			break;
		default:
			// 第二引数が上記以外の場合は亡者が出現する
			System.out.println("generateBoss()の引数が間違えています");

		}
		return e;
	}

	public static void openBattle(Character c, ArrayList<Creature> enemy) {
		// 通常バトル(死んだらキャラクターのHPなどをリセットして再戦する)
		Battle battle = new Battle(c, enemy);
		try {
			battle.start();
			Thread.sleep(5000);
			battle.repeat(battle, enemy);
			c.checkStatus(); //戦闘後のステータスの確認
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void openBossBattle(Character c, ArrayList<Boss> boss) {
		// ボス戦(死んだらキャラクターのHPなどをリセットして再戦する)
		BossBattle battle = new BossBattle(c, boss);
		try {
			battle.start();
			Thread.sleep(5000);
			battle.repeat(battle, boss);
			c.checkStatus(); //戦闘後のステータスの確認
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
