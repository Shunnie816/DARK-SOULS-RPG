package stage;

import java.util.Scanner;

import character.Character;
import main.Setting;

public class Stage1 extends Stage {

	public Stage1() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName("城下不死教区");
	}

	@Override
	public void start(Character c) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner s = new Scanner(System.in);

		try {
			Thread.sleep(2000);
			this.open();
			Thread.sleep(2000);

			// 戦闘①
			Setting.openBattle(c, Setting.generateEnemy(4, "亡者"));
			Thread.sleep(2000);

			//	戦闘②
			Setting.openBattle(c, Setting.generateEnemy(3, "亡者兵士"));
			Thread.sleep(2000);

			// 篝火
			bonfireMenu(c);

			//	黒騎士戦闘
			Setting.openBattle(c, Setting.generateEnemy(1, "黒騎士"));
			Thread.sleep(2000);

			// 篝火
			bonfireMenu(c);

			// ボス戦①
			Thread.sleep(3000);
			Setting.openBossBattle(c, Setting.generateBoss(1, "牛頭のデーモン"));
			Thread.sleep(3000);

			// ボス戦②
			Thread.sleep(3000);
			Setting.openBossBattle(c, Setting.generateBoss(2, "ガーゴイル"));
			Thread.sleep(3000);

			System.out.println(c.getName() + "は一つ目の鐘を鳴らした。");
			Thread.sleep(3000);

			stageClear();
			//	クリア回数に+1する
			setClearCount(getClearCount() + 1);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		s.close();

	}

}
