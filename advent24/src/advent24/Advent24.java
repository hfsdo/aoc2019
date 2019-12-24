package advent24;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean repetition = false;
		List<String> eris = new ArrayList<String>();
		String bioDiversity = "";
		String input = "";
		String fileName = "C:/Users/Thijs/Desktop/inputadvent24TEST.txt";
		Path path = Paths.get(fileName);
		try {
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for (String line : allLines) {
				input += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		eris.add(input);
		
		draw(input);
		
		while (!repetition) {
			Map<String, Boolean> erisMap = new HashMap<String, Boolean>();
			String current = eris.get(eris.size()-1);
			String nextiter = "";
			for (int i = 0; i < current.length(); i++) {
				String c = current.substring(i, i+1);
				erisMap.put(""+(i%5)+":"+(i/5), c.equals("#"));
			}
			
			for (int j = 0; j<5; j++) {
				for (int i = 0; i<5; i++) {
					int nearCount = 0;
					if (erisMap.containsKey(""+(i-1)+":"+j) && erisMap.get(""+(i-1)+":"+j)) {
						nearCount++;
					}
					if (erisMap.containsKey(""+(i+1)+":"+j) && erisMap.get(""+(i+1)+":"+j)) {
						nearCount++;
					}
					if (erisMap.containsKey(""+i+":"+(j+1)) && erisMap.get(""+i+":"+(j+1))) {
						nearCount++;
					}
					if (erisMap.containsKey(""+i+":"+(j-1)) && erisMap.get(""+i+":"+(j-1))) {
						nearCount++;
					}
					if (nearCount != 1 && erisMap.get(""+i+":"+j)) {
						nextiter += ".";
					} else if ((nearCount == 1 || nearCount == 2) && !erisMap.get(""+i+":"+j)) {
						nextiter += "#";
					} else {
						nextiter += erisMap.get(""+i+":"+j)?"#":".";
					}
				}
			}
			
			draw(nextiter);
			if (eris.contains(nextiter)) {
				repetition = true;
				bioDiversity = nextiter;
			} else {
				eris.add(nextiter);
			}
			
		}
		
		int total = 0;
		for (int i = 0; i < bioDiversity.length(); i++) {
			String c = bioDiversity.substring(i, i+1);
			int pow2 = (int) Math.pow(2, i);
			if (c.equals("#")) {
				total += pow2;
			}
			
		}
		System.out.println("Biodiversity:"+total);
		
	}
	
	private static void draw(String out) {
		System.out.println("iter:");
		for (int i = 0; i < out.length(); i += 5) {
			System.out.println(out.substring(i, i+5));
		}
	}

}
