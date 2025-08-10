package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RemSubFolder {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();

        for(String f:folder){
            if(list.isEmpty() || !f.startsWith(list.get(list.size()-1)+"/")){
                list.add(f);
            }
        }
        return list;
    }
    public static void main(String[] args) {
		String[] arr = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
		RemSubFolder sl3  = new RemSubFolder();
		System.out.println(sl3.removeSubfolders(arr));
	}
}