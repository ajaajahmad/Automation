package com.app.test.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CoreJavaPractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int[] arr2 = {1,2,3,5,7,8,0,23,22,12,444,566,788};
		
		for(int i = 0; i<arr2.length; i++)
		{
			if(arr2[i] % 2 == 0)
			{
				System.out.println(arr2[i]);
				break;
			}
			else {
				System.out.println(arr2[i]+" "+"is not multiple of 2.");
			}
		}
		
		ArrayList<String> a = new ArrayList<String>();
		// create object of the class - object.method
		
		a.add("ajaaj");
		a.add("ahmad");
		a.add("acedamy");
		a.add("selenium");
		System.out.println(a.get(3));
		
		for(int i = 0; i<a.size(); i++)
		{
			System.out.println(a.get(i));
		}
		System.out.println("===================");
		for(String sr :a)
		{
			System.out.println((sr));
		}
		// is item present in ArrayList
		System.out.println(a.contains("ajaaj"));
		
		//convert simple array into list
		
		String[] name = {"ajaaj", "ahmad", "shaikh"};
		List<String> nameArrayList = Arrays.asList(name);
		System.out.println(nameArrayList.contains("shaikh"));
		
		

	}

}
