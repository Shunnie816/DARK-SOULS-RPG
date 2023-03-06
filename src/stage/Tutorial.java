package stage;

import character.Character;
import main.Battle;
import main.Setting;

public abstract class Tutorial {

	public Tutorial() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void start(Character c) {

		System.out.println("----------------------------------------------------------");
		System.out.println("試しに敵を倒してみましょう。");
		Battle battle = new Battle(c, Setting.generateEnemy(1, "亡者"));
		battle.start();

		while (c.getHp() <= 0) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			System.out.println("敵にやられてしまうと所持していたソウルをすべて失います。");
			System.out.println("もう一度挑戦してみましょう。");
			c.reset();
			battle = new Battle(c, Setting.generateEnemy(1, "亡者"));
			battle.start();
		}

		if (c.getSoul() > 0) {
			System.out.println("敵を倒すとソウルが手に入ります");
		} else {
			System.out.println("敵から逃げて戦闘を終わらせることもできますが、失敗して敵に先回りされてしまうことがあります。");
		}

		System.out.println("----------------------------------------------------------");
		c.checkStatus();
		System.out.println("----------------------------------------------------------");
		System.out.println("チュートリアルはこれで終了です。");

	}

}
