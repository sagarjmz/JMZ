package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

public class FileOperation {
static int i=0;
	static List list = new LinkedList();
	static int mark = 0;
	static String aNs;
	static String result = null;
	static int count = 0;
	static Questions q;
static String s1 [] = new String[5];
static int range = 0;
static String fileName ;
static String filePath ;
	public static void mainEntry() {
		
		for (int z = 0; z < range; z++) {
			try {
				randomLine();
				System.out.print("randomLine");
				count++;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			 randomLineone();
		}
		display();
	}

	public static void display() {
		System.out.println("Questions");
		ListIterator i = list.listIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

	public static void randomLine() throws FileNotFoundException 
	{
		String fn = null;
		
		if(fileName.equals("Java"))
		{
			filePath="/Users/prabhakardixit/anandSir/OnlineEntranceExam/"+fileName+".txt";
			System.out.println("filePath"+"   Java");
		}
		else if(fileName.equals("Html"))
		{
			filePath="/Users/prabhakardixit/anandSir/OnlineEntranceExam/"+fileName+".txt";
			System.out.println("filePath"+"     Html");
		}
		else
		{
			filePath="/Users/prabhakardixit/anandSir/OnlineEntranceExam/xyz.txt";
		}
	
		File f = new File(filePath);

		Random rand = new Random();
		int n = 0;
		Scanner sc = null;
		sc = new Scanner(f);
		while (sc.hasNext()) {
			++n;
			String line = sc.nextLine();
			if (rand.nextInt(n) == 0)
				result = line;

		}

		String[] s = result.split("@");
		// String qsn, String oOne, String oTwo, String oThree, String oFour, String ans
		System.out.println(list.size());
		
		if (list.size() < range) {
			q = new Questions(s[0], s[1], s[2], s[3], s[4], s[5]);
			list.add(new Gson().toJson(q));

			
		}

	}



}
