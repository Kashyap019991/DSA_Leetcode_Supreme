package com.kas.designpat.ChainOfResponsibility2_AtmDispencer;
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}