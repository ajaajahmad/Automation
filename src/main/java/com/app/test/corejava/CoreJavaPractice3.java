package com.app.test.corejava;

public class CoreJavaPractice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//string in an object   //string literal
		
		@SuppressWarnings("unused")
		String s1 = "Welcome";
		@SuppressWarnings("unused")
		String s2 = "Welcome";
		@SuppressWarnings("unused")
		String s0 = "hello";
		
		@SuppressWarnings("unused")
		String s3 = new String ("Ajaaj Ahmad Shaikh");
		String s = "Ajaaj Ahmad Shaikh";
		
		
		String[] splittedString = s.split("Ahmad");
		
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[1].trim());
		System.out.println("===================");
		//for(int i = 0; i<s.length(); i++)
		for(int i = s.length()-1;i>=0;i--)
		{
			System.out.println(s.charAt(i));
		}
		

	}

}
