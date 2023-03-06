package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.Character;
import creature.Boss;

public class BossBattle extends Battle {

	ArrayList<Boss> e = new ArrayList<>();

	public BossBattle(Character c, ArrayList<Boss> b) {
		this.c = c;
		this.e.addAll(b);
		System.out.println(this.c.getName() + "は" + this.e.get(0).getName() + "に勝負を挑んだ！");
	}

	// Scannerの初期化
	Scanner s = new Scanner(System.in);

	public void myTurn() {

		if (this.e.isEmpty()) {
			this.end();
		} else {
			System.out.print("どうする？:  1. 戦う 2. 守る 3. エスト瓶で回復 4. 逃げる 5. ステータス確認 ");
			int selected = s.nextInt();
			switch (selected) {
			case 1:
				this.c.attack(e.get(0));

				if (this.e.get(0).isDead()) {
					this.e.remove(0);
					if (this.e.isEmpty()) {
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
				System.out.println("ボスから逃げることはできない！");
				this.setMyTurn(false);
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

	@Override
	public void enemyTurn() {

		Random r = new Random();
		int attackOps = r.nextInt(2);

		if (this.e.isEmpty()) {
			this.end();
		} else {
			switch (attackOps) {
			case 0:
				this.e.get(0).attack(c);
				break;
			case 1:
				this.e.get(0).strongAttack(c);
				break;
			}

			if (this.c.isDead()) {
				this.end();
			} else {
				this.setMyTurn(true);
				this.start();
			}
		}
	} //enemyTurn

	public void repeat(BossBattle battle, ArrayList<Boss> enemy) {
		// 死んだときにステータスリセットしてもう一度戦闘が始まる
		while (this.c.getHp() <= 0) {
			this.c.reset();
			battle = new BossBattle(c, enemy);
			battle.start();
		}
	}

}
