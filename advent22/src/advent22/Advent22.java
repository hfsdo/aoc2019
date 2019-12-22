package advent22;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Advent22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> cardList = new ArrayList<Integer>();
		for (int i = 0; i < 10007; i++) {
			cardList.add(i);
		}
		String fileName = "C:/Users/Thijs/Desktop/inputadvent22TEST.txt";
		Path path = Paths.get(fileName);
		
		try {
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for (String line : allLines) {
				if (line.contains("deal with increment")) {
					int n = Integer.parseInt(line.substring(line.lastIndexOf(' ')).trim());
					cardList = inc(cardList, n);
				} else if (line.contains("deal into new stack")) {
					cardList = dealNewStack(cardList);
				} else if (line.contains("cut")) {
					int n = Integer.parseInt(line.substring(line.lastIndexOf(' ')).trim());
					cardList = cut(cardList, n);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
		//cardList = dealNewStack(cardList);
		//cardList = cut(cardList, -4);
		//cardList = inc(cardList, 3);
		

		System.out.println("2019:"+cardList.indexOf(2019));

	}

	private static void outputDeck (List<Integer> cardList) {
		System.out.print("deck:");
		for (Integer card : cardList) {
			System.out.printf("%d ", card);
		}
		System.out.println();
	}

	private static List<Integer> dealNewStack(List<Integer> cardList) {
		List<Integer> resultList = new ArrayList<Integer>();

		for (int i = cardList.size()-1; i >=0;i--) {
			resultList.add((int) cardList.get(i));
		}

		return resultList;

	}

	private static List<Integer> cut(List<Integer> cardList, int n) {
		List<Integer> resultList = new ArrayList<Integer>();

		if (n < 0) {
			n = cardList.size() + n;
		}


		for (int i = n; i<cardList.size();i++) {
			resultList.add(cardList.get(i));
		}
		for (int i = 0; i<n;i++) {
			resultList.add(cardList.get(i));
		}


		return resultList;

	}

	private static List<Integer> inc(List<Integer> cardList, int n) {
		List<Integer> resultList = new ArrayList<Integer>();
		SortedMap<Integer, Integer> cardMap = new TreeMap<Integer, Integer>();

		int position = 0;
		for (int i = 0; i<cardList.size(); i++) {
			cardMap.put(position, cardList.get(i));
			position += n;
			if (position > cardList.size()) {
				position -= cardList.size();
			}
		}

		for (Integer card : cardMap.values()) {
			resultList.add(card);
		}

		return resultList;
	}

}
