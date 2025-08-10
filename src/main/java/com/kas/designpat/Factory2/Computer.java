package com.kas.designpat.Factory2;
public abstract class Computer {
	
	protected String ram;
	protected String hdd;
	protected String cpu;
	
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	@Override
	public String toString(){
		return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
	}
}