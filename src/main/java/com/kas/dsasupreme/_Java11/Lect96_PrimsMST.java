
package com.kas.dsasupreme._Java11;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lect96_PrimsMST {

	public static void main(String args[]) throws Exception {
		String path = "C:\\Users\\Krishna\\Documents\\abc.txt";
		List<String> ls = new ArrayList<String>();
		ls.add("krishna");
		ls.add("karishna");
		ls.add("krishn@");
		
		//convert list to array
		String[] arrJava11 =  ls.stream().toArray(elem -> new String[elem]);
		String[] arrjava11fnc = ls.stream().toArray(String[] :: new);
		System.out.println(Arrays.toString(arrjava11fnc));
		System.out.println(Arrays.toString(arrJava11));
		
		//read , write using java11
		
		String strjava11 = Files.readString(Paths.get(path));
		System.out.println(strjava11);
		
		Files.writeString(Paths.get(path), "kasnjsjre", StandardOpenOption.APPEND);
		
		String updatedJava11Data = Files.readString(Paths.get(path));
		System.out.println(updatedJava11Data);
		
		String uri = "https://postman-echo.com/post";
		HttpRequest httpReq = HttpRequest.newBuilder()
								.uri(URI.create(uri))
								.GET().version(Version.HTTP_2)
								.build();
		
		HttpClient client = HttpClient.newBuilder()
							.build();

		HttpResponse<String> resp = client.send(httpReq, BodyHandlers.ofString());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		
		//java11 var keyword
		var x ="asd";
		var y = 23456;
		
		FuncInter func = (var a,var b) -> a+b;
		System.out.println(func.op(5, 3));
		
		//java11 ----->  Optional.isEmpty()
		Optional o = Optional.of("as");
		//o = o.empty();
		System.out.println(o.isEmpty());
		
		//direct run java file without .class file in jdk11
		//java abc.java
		
		String a = "  ";
		System.out.println(a.isBlank());
		System.out.println(a.isEmpty());
		
		String mltLines = "affa"
				+ " dfs\n"
				+" adf";
		
		mltLines.lines().forEach(System.out :: println);
	}
}

interface FuncInter{
	int op(int a, int b);
}
/*
 
u v wt

/*
5
6
0 1 2
0 3 6
1 3 8
1 4 5
1 2 3
2 4 7
0

o/p:
Minimum spannig Tree:
0 - 1 : 2
1 - 2 : 3
0 - 3 : 6
1 - 4 : 5
 */
