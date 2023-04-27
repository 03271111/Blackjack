package com.design_shinbi.blackjack;

import java.util.Collections;
import java.util.List;

/**
 * 山札の管理クラス
 */
public class Stock {
	private List<Card> cards;
	/**
	 * 山札の初期化
	 */
	public Stock() {
		initialize();
	}
	/**
	 * 山札をシャッフルして持たせる
	 */
	public void initialize() {
		List<Card> list = Card.getAllCards();
		Collections.shuffle(list);
		this.cards = list;
    }
	/**
	 * カードの数字を取得
	 * @return 
	 */
	public int getNumberOfCards() {
		return this.cards.size();
	}
	/**
	 * カードが引かれたら山札から削除する
	 * @return　残りのカード
	 */
	public Card pickCard() {
		Card card = this.cards.get(0);
		this.cards.remove(0);
		return card;
	}
}
