package com.app.test.corejava;
public class CoreJava3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// string is an object  //String literal.
		
		//String s1 = "Ajaaj Ahmad Shaikh";
		//String s2 = "Ajaaj Ahmad Shaikh";
		
		String s5 = "Hello";
		
		//new
		
		//String s2 = new String("welcome");
		//String s3 = new String("welcome");
		
		String s = "Ajaaj Ahmad Shaikh";
		String[] SplitArray = s.split("Ahmad");
		System.out.println(SplitArray[0]);
		System.out.println(SplitArray[1]);
		System.out.println(SplitArray[1].trim());
		for(int i=s.length()-1; i>0; i--)
		{
			System.out.println(s.charAt(i));
		}

	}

}
