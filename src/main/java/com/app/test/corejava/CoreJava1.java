package com.app.test.corejava;

public class CoreJava1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum = 5;
		String website = "vfirst.com";
		char letter = 'L';
		double dec = 6.79;
		boolean myCard = true;
		
//		System.out.println(myNum+" "+"is the value stored in myNum variable");
//		System.out.println(website);
		//Arrays
		
		int[] arr= new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		int[] arr2= {1,2,3,4,5,7,8,45,34};
		
		//For Loop
		
//		for (int i = 0; i< arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}
		
//		for (int i = 0; i< arr2.length; i++)
//		{
//			System.out.println(arr2[i]);
//		}
		
		String[] name = {"ajaaj", "ahmad", "shaikh"};
//		for(int i = 0; i < name.length; i++)
//		{
//			System.out.println(name[i]);
//		}
			
			for(String s: name)
			{
				System.out.println(s);
			}
		
	}

}
