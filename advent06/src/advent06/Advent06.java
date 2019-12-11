package advent06;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Advent06 {

	private static Map<String, List<String>> orbitMap;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		orbitMap = new HashMap<String, List<String>>(); 
		Map<String, String> orbitreverseMap = new HashMap<String, String>();
		try {
			//String fileName = "C:/Users/Thijs/Desktop/inputadvent06TEST.txt";
			String fileName = "C:/Users/Thijs/Desktop/inputadvent06.txt";
			Path path = Paths.get(fileName);
			byte[] bytes = Files.readAllBytes(path);
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for (String line : allLines) {
				System.out.println(line);
				String key = line.split("\\)")[0];
				String val = line.split("\\)")[1];
				List<String> orb;
				if (orbitMap.containsKey(key)) {
					orb = orbitMap.get(key);
				} else {
					orb = new ArrayList<String>();
				}
				orb.add(val);
				orbitMap.put(key, orb);
				orbitreverseMap.put(val, key);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		int total = 0;
		for (Entry<String, List<String>> orbit : orbitMap.entrySet()) {
			total += orbitCount(orbit.getValue());
		}
		System.out.println("orbits:"+ total);
		*/
		
		int result = -1;
		int you = 0;
		String sYou = "YOU";
		while (result == -1) {
			int san = 0;
			String sSan = "SAN";
			if (orbitreverseMap.containsKey(sYou)) {
				sYou = orbitreverseMap.get(sYou);
				while (!sSan.equals(sYou)) {
					if (orbitreverseMap.containsKey(sSan)) {
						sSan = orbitreverseMap.get(sSan);
					} else {
						break;
					}
					san++;
				}
				if (sYou.equals(sSan)) {
					result = you + san - 1;
				}
			} else {
				break;
			}
			you++;
			
		}
		
		System.out.println("result:" + result);
		
	}
	
	private static int orbitCount(List<String> com) {
		int count = com.size();
		System.out.println("count:"+count);
		for (String orb : com) {
			if (orbitMap.containsKey(orb)) {
				count += orbitCount(orbitMap.get(orb));
			}
		}
		
		return count;
	}

}
