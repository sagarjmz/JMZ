package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

public class FileOperation {

	static List<String> list = new LinkedList();
	static LinkedList listFinal ;
	static String aNs;
	static String result = null;
	static Questions q;
	static int range = 0;
	static String fileName;
	static String filePath;
	static HashMap map = new HashMap();
	static File f;

	public static void mainEntry(int examId) throws FileNotFoundException 
	{
		listFinal = new LinkedList();
		list.clear();
		listFinal.clear();
		if (fileName.equals("Java")) {
			filePath = "/Users/prabhakardixit/anandSir/OnlineEntranceExam/Java.txt";

		} else if (fileName.equals("Html")) {

			filePath = "/Users/prabhakardixit/anandSir/OnlineEntranceExam/Html.txt";
		} else {
			filePath = "/Users/prabhakardixit/anandSir/OnlineEntranceExam/Java.txt";

		}
		f = new File(filePath);
		System.out.println("in FileOperation");
		for (int z = 0; z < range; z++) {
			try {
				randomLine();
			} catch (FileNotFoundException e) {
				System.out.println("exception in mainEntry() of FileOperation2suhel");
			}

		}
		map.put(examId, listFinal);
//		display();

	}

	public static void display() {
		System.out.println("Questions");
		ListIterator i = listFinal.listIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

	public static void randomLine() throws FileNotFoundException {
		System.out.println("in RandomeLine()");

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
		sc.close();

		String[] s = result.split("@");
		if (list.contains(s[0])) {
			System.out.println("incresed by 1");
			range++;
		} else {
			q = new Questions(s[0], s[1], s[2], s[3], s[4], s[5]);
			list.add(q.getQsn());

			listFinal.add(new Gson().toJson(q));
		}

	}

}
