package com.kas.designpat.Factory2;
public class PC extends Computer {

	
	
	public PC(String ram, String hdd, String cpu){
		super.ram=ram;
		super.hdd=hdd;
		super.cpu=cpu;
	}
	@Override
	public String getRAM() {
		return super.ram;
	}

	@Override
	public String getHDD() {
		return super.hdd;
	}

	@Override
	public String getCPU() {
		return super.cpu;
	}

}