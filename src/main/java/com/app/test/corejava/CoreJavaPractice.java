package com.app.test.corejava;

import java.util.Iterator;

public class CoreJavaPractice {

	public static void main(String[] args) {
		int num = 90909090;
		String alph = "Hello World";
		String capp = alph.toUpperCase();
		double dec = 2.00;
		boolean cond = true;	
		System.out.println(capp+" "+"is my first output");
		
		//ARRAY
		
		int[] arr = new int[5];
		arr[0] = 2;
		arr[1] = 9;
		arr[2] = 6;
		arr[3] = 7;
		arr[4] = 5;
		
		int[] arr2 = {2,3,5,7,8,0,23,22,12,444,566,788};
		
		//for loop
		
		for(int i = 0; i< arr.length; i++)
		{
		System.out.println(arr[i]);	
		}
				for(int i = 0; i<arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}
		
		String[] name = {"ajaaj", "ahmad", "shaikh"};
		
		for(int i = 0; i<name.length; i++)
			
		{
			System.out.println(name[i]);
		}
		
		for(String s: name)
		{
			System.out.println(s);
		}
		
		int[] arr3 = {1,2,3,5,7,8,0,23,22,12,444,566,788};
		
		for(int i = 0; i<arr3.length; i++)
		{
			if(arr3[i] % 2 == 0)
			{
				System.out.println(arr3[i]);
				break;
			}
			else {
				System.out.println(arr3[i]+" "+"is not multiple of 2.");
			}
		}
			
}
}	