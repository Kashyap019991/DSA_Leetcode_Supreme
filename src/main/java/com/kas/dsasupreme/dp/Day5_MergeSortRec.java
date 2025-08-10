package com.kas.dsasupreme.dp;

class Day5_MergeSortRec {
	static int[] a = { 44, 23, 11, 25 };

	static void merge(int s, int e){
		int mid= s + (e-s)/2;
		//0 3 --> 1 
		int lfp = mid-s+1;
		int lsc = e- mid;
		//copy left and right part element in new array
		int[] fp = new int[lfp];
		int[] sc = new int[lsc];
		int k =s;
		for(int i=0;i< lfp;i++){
			fp[i] = a[k++];
		}
		for(int i=0;i< lsc;i++){
			sc[i] = a[k++];
		}
		//merge 2 sorted array
		k=s;
		
		int i1 = 0;
		int i2= 0;
		
		while(i1<lfp && i2 < lsc){
		if(fp[i1]<sc[i2])
		{
			a[k++] = fp[i1++];
		}
		else
		{
			a[k++] = sc[i2++];
		}
		}
		
		while(i1<lfp){
			a[k++] = fp[i1++];
		}
		
		while(i2<lsc){
			a[k++] = sc[i2++];
		}
		
		
	}

	static void mergeSrt(int s, int e) {

		if (s >= e)
			return;
		int mid = s + (e - s) / 2;

		// leftpart
		mergeSrt(s, mid);

		// right part
		mergeSrt(mid + 1, e);

		merge(s, e);

	}

	public static void main(String[] args) {

		mergeSrt(0, a.length - 1);
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}