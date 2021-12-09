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
	public static void mainEntry() {

		for (int z = 0; z < 5; z++) {
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

	public static void randomLine() throws FileNotFoundException {
		File f = new File("/Users/prabhakardixit/anandSir/OnlineEntranceExam/xyz.txt");

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
		System.out.println(s[1]);
		System.out.println(s[2]);
		// String qsn, String oOne, String oTwo, String oThree, String oFour, String ans
		System.out.println(list.size());
		
		if (list.size() < 5) {
			q = new Questions(s[0], s[1], s[2], s[3], s[4], s[5]);
			list.add(q);
			s1[i] = new Gson().toJson(q);
			i++;
			System.out.println(s1[0]+": in FileOperation");
			System.out.println(s1[1]+": in FileOperation");
			System.out.println(s1[2]+": in FileOperation");
			System.out.println(s1[3]+": in FileOperation");
			System.out.println(s1[4]+": in FileOperation");
			
		}

	}

//	public static void randomLineone() {
//
//		String[] a = result.split("@");
//
//		Questions q = new Questions(a[0], a[1], a[2], a[3], a[4], a[5]);
//		System.out.println("Questions:");
//		System.out.println("Q - " + a[0]);
//		System.out.println("");
//		System.out.println("A- " + a[1]);
//		System.out.println("B- " + a[2]);
//		System.out.println("C- " + a[3]);
//		System.out.println("D- " + a[4]);
//		System.out.println("");
//		if (a[5].equals(a[1])) {
//			aNs = "a";
//		} else if (a[5].equals(a[2])) {
//			aNs = "b";
//		} else if (a[5].equals(a[3])) {
//			aNs = "c";
//		} else {
//			aNs = "d";
//		}
//		System.out.print("answer : ");
//		Scanner sc = new Scanner(System.in);
//		String s = sc.next();
//		if (s.equalsIgnoreCase(aNs)) {
//			mark++;
//			System.out.println("Correct Answer");
//		} else {
//			System.out.println("Wrong answer,moving to next Question ");
//		}
//		System.out.println("Score: " + mark + "/2");
//
//	}

}
