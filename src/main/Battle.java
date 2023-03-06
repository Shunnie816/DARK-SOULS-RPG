package main;

import java.util.ArrayList;
import java.util.Scanner;

import character.Character;
import creature.Creature;

public class Battle {
	//	戦闘の状態を保持するクラス
	Character c;
	ArrayList<Creature> e = new ArrayList<>();
	private boolean myTurn = true;
	private boolean battle = true;

	public Battle() {
	};

	public Battle(Character c, ArrayList<Creature> e) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.c = c;
		this.e.addAll(e);
		System.out.println("戦闘が始まります。");
	}

	public boolean isMyTurn() {
		return myTurn;
	}

	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

	public boolean isBattle() {
		return battle;
	}

	public void setBattle(boolean battle) {
		this.battle = battle;
	}

	public void start() {

		try {
			while (this.isBattle() == true) {
				System.out.println("----------------------------------------------------------");
				Thread.sleep(1000);
				if (this.isMyTurn() == true) {
					this.myTurn();
					this.start();
				} else {
					this.enemyTurn();
					this.start();
				}
			}
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	} // start()

	@SuppressWarnings("resource")
	public void myTurn() {

		// Scannerの初期化
		Scanner s = new Scanner(System.in);

		if (this.e.isEmpty()) {
			this.end();
		} else {
			System.out.print("どうする？:  1. 戦う 2. 守る 3. エスト瓶で回復 4. 逃げる 5. ステータス確認 ");
			int selected = s.nextInt();
			switch (selected) {
			case 1:
				//			if (e.length > 0) {
				//				System.out.print("誰を攻撃しますか？：" );
				//				int attacked = s.nextInt();
				//			}
				this.c.attack(e.get(0)); //とりあえずデフォルトでは一人目から順に攻撃

				if (this.e.get(0).isDead()) {
					//	敵が死んだ状態の場合、敵を格納した配列から敵を取り除く
					this.e.remove(0);
					if (this.e.isEmpty()) {
						//	敵がいない場合、戦闘を終了する
						this.end();
					}
				} else {
					this.setMyTurn(false);
				}
				break;
			case 2:
				System.out.println("しかし何も起こらなかった！");
				this.setMyTurn(false);
				break;
			case 3:
				this.c.estHeal();
				this.setMyTurn(false);
				break;
			case 4:
				if (this.c.escape()) {
					this.end();
				} else {
					this.setMyTurn(false);
				}
				break;
			case 5:
				this.c.checkBattleStatus();
				System.out.println("----------------------------------------------------------");
				for (int i = 0; i < this.e.size(); i++) {
					this.e.get(i).checkStatus();
					System.out.println("------");
				}
				this.start();
				break;
			default:
				System.out.println("それはできない！");
				System.out.println("----------------------------------------------------------");
				this.myTurn();
			}
		}

	} // myTurn

	public void enemyTurn() {
		if (this.e.isEmpty()) {
			this.end();
		} else {
			this.e.get(0).attack(c);
			if (this.c.isDead()) {
				this.end();
			} else {
				this.setMyTurn(true);
				this.start();
			}
		}
	} //enemyTurn

	public boolean end() {
		System.out.println("戦闘が終了しました。");
		System.out.println("----------------------------------------------------------");
		return battle = false;
	}

	public void repeat(Battle battle, ArrayList<Creature> enemy) {
		// 死んだときにステータスリセットしてもう一度戦闘が始まる
		while (this.c.getHp() <= 0) {
			this.c.reset();
			battle = new Battle(c, enemy);
			battle.start();
		}
	}

}
