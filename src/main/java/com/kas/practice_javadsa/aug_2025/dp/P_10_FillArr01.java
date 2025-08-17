package com.kas.practice_javadsa.aug_2025.dp;
// no. of ways to fill arrays with 0 and 1 wo consecutives 1s

class P_10_FillArr01{
	//int ans;
	int fillArr01(int index,int n, boolean prevOne){
		int ans=0;
		if(index == n)
		{
			ans = ans+1;
			return ans;
		}
		//prevOne false
		if(prevOne==false){
		ans+= fillArr01(index+1,n, true);
		ans +=fillArr01(index+1,n,false);
		}
		
		//prevOne true
		if(prevOne==true)
			ans +=fillArr01(index+1,n,false);


		return ans;
	}

	public static void main(String[] args) {
		//int n=1;

		for(int n=1;n<=10;n++){
			int ans=0;
		ans =new P_10_FillArr01().fillArr01(0,n,false);
		//new P_10_FillArr01().fillArr01(0,3,true);
		System.out.println(ans);}
	}
}
//