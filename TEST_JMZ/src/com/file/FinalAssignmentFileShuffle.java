package com.file;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

public class FinalAssignmentFileShuffle {
	// SHOW LIST OF QUESTIONS--------------------FROM FILE AT A TIME
	static int mark = 0;
	static String aNs;
	static String result = null;
	static int range = 0;
	static List<Object> list = new ArrayList<Object>();
	static List<Object> listFinal = new ArrayList<Object>();
	static Scanner sc = null;
	static int i = 0;
	static String fileName;
	static String filePath;

	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Enter the number of questions you want :- ");
		range = Integer.parseInt(sc1.next());
		for (int z = 0; z < range; z++) {
			randomLine();
		}
		for (int m = 0; m < listFinal.size(); m++) {
			System.out.println(listFinal.get(m));
		}
		sc.close();

		System.out.println("total Question : " + listFinal.size());
	}

	public static void randomLine() throws FileNotFoundException {
		File f = new File("/Users/prabhakardixit/anandSir/OnlineEntranceExam/Java.txt");
		Random rand = new Random();
		int n = 0;
		sc = new Scanner(f);
		while (sc.hasNext()) {
			++n;
			String line = sc.nextLine();
			if (rand.nextInt(n) == 0)
				result = line;
		}

		String[] a = result.split("@");
		if (list.contains(a[0])) {
			System.out.println("incresed by 1");
			range++;
		} else {
			Questions q = new Questions(a[0], a[1], a[2], a[3], a[4], a[5]);
			list.add(q.getQsn());
			listFinal.add(new Gson().toJson(q));
		}
	}
}