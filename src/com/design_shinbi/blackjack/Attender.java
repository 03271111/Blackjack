package com.design_shinbi.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Attender {
	protected List<Card> cards;
	protected String name;
	
	public Attender(String name) {
		this.name = name;
		initialize();
	}
	
	public void initialize() {
		this.cards = new ArrayList<Card>();
	}
	
	public void start(Stock stock) {
		this.cards.clear();
		for(int i = 0; i < 2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void hit(Stock stock) {
		Card card = stock.pickCard();
		this.cards.add(card);
	}
	
    public static int calculateStrengthFromList(List<Card> list) {
    	int strength = 0; //強さ
    	int aceCount = 0; //エースの枚数
    	
    	for(Card card : list) {
    		int number = card.getNumber();
    		if(number >= 11) {
    			strength += 10; //11より小さい時は10を足す
    		} 
    		else {
    			strength += number; //それ以外の時はそのままの数字
    		}
    		if(number == 1) {
    			aceCount += 1; //エースを持っていたら
    	    }
    }
    	
    if(aceCount > 0 && strength <= 11) {
    	strength += 10; //エースが存在し、なおかつ11より小さいとき
    }
    
    if(strength > 21) {
    	strength = 0; //21以上だと0になる
    }
    
    return strength;
    
    }
    
    public int calculateStrength() {
    	int strength = calculateStrengthFromList(this.cards);
    	return strength;
    }
    
    public String toString() {
    	String string = name + ":";
    	for(int i = 0; i < this.cards.size(); i++) {
    		Card card = this.cards.get(i);
    		string = string + card.toString();
    	}
    	return string;
    }
    
    public void display() {
    	System.out.println(this.toString());
    }
    
    public abstract void play(Stock stock);
   	

}
