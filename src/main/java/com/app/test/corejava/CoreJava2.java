package com.app.test.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr2= {1,2,3,4,5,7,8,45,34};
		
		for(int i = 0; i < arr2.length; i++)
		{
			if(arr2[i] % 2 == 0)
			{
		// System.out.println(arr2[i]);
		// break;
			}
			else {
		// System.out.println(arr2[i]+" "+"is not multiple of 2");
			}
		}
		
		List<String> a = new ArrayList<String>();
		a.add("ajaaj");
		a.add("ahmad");
		a.add("shaikh");
		a.add("infinito");
		// System.out.println(a.get(2));
		// create object of the class - object.method
		
		for(int i = 0; i < a.size(); i++)
				{
		// System.out.println(a.get(i));
				}
		for (String val:a)
		{
			System.out.println(val);
		}
		// item is present in ArrayList
		
		System.out.println(a.contains("ajaaj1"));
		
		String[] name = {"ajaaj", "ahmad", "shaikh"};
		List<String> nameArrayList = Arrays.asList(name);
		
		System.out.println(nameArrayList.contains("ahmad"));
		
		
		
		

	}

}
