package stage;

import java.util.Scanner;

import character.Character;
import main.Setting;

public class Stage0 extends Stage {

	public Stage0() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName("北の不死院");
	}

	@Override
	public void start(Character c) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner s = new Scanner(System.in);

		try {
			Thread.sleep(2000); //2秒の遅延
			this.open();
			Thread.sleep(2000); //2秒の遅延

			// デーモン初戦(死にイベ)
			System.out.println("大きな扉を抜けた先に巨大なデーモンがいた！");
			Thread.sleep(1000); // 遅延

			System.out.print("どうする？： 1. 攻撃　2. 逃げる");
			int selected = s.nextInt();

			switch (selected) {
			case 1:
				System.out.println(c.getName() + "は攻撃した！");
				Thread.sleep(500); // 遅延
				System.out.println("しかし全くダメージが入らない！");
				break;
			case 2:
				System.out.println(c.getName() + "は逃げだした！");
				Thread.sleep(2000);
				System.out.println("しかしデーモンの方が速かった！");
				break;
			default:
				System.out.println(c.getName() + "は逃げだした！");
				Thread.sleep(2000);
				System.out.println("しかしデーモンの方が速かった！");
				break;
			}

			System.out.println("デーモンは大きな槌を振りかざした！");
			System.out.println(c.getName() + "に大ダメージ！");
			System.out.println(c.getName() + "は倒れた！");
			Thread.sleep(3000);

			System.out.print("またデーモンに挑戦しますか？： 1. はい　2. いいえ");
			int num = s.nextInt();

			switch (num) {
			case 1:
				Thread.sleep(500); // 遅延
				break;
			case 2:
				Thread.sleep(2000);
				System.out.println("あなたにはこのゲームはまだ早かったようだ…");
				System.out.println("===================================");
				System.out.println("---------------------GAME OVER-----------------------");
				System.out.println("===================================");
				System.exit(0);
				break;
			default:
				Thread.sleep(500); // 遅延
				break;
			}

			// オープニング的な
			System.out.println("");
			System.out.println("亡者よ、北の不死院を抜け、二つの鐘を鳴らして新たなる使命を授かるがよい");
			System.out.println("");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// 戦闘①
		Setting.openBattle(c, Setting.generateEnemy(3, "亡者"));

		// 初めての篝火
		bonfireMenu(c);

		// デーモン戦
		try {
			Thread.sleep(2000);
			System.out.println("再びデーモンが現れた！");
			Thread.sleep(2000);
			Setting.openBossBattle(c, Setting.generateBoss(1, "不死院のデーモン"));
			Thread.sleep(2000);
			System.out.println(c.getName() + "は無事に北の不死院を抜け出すことができた。");
			stageClear();
			//	クリア回数に+1する
			setClearCount(getClearCount() + 1);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		s.close();

	} //start()

}