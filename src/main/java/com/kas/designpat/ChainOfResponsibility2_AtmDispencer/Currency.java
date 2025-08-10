package com.kas.designpat.ChainOfResponsibility2_AtmDispencer;
public class Currency {

	private int amount;
	
	public Currency(int amt){
		this.amount=amt;
	}
	
	public int getAmount(){
		return this.amount;
	}
}