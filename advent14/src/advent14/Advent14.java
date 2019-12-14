package advent14;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Advent14 {

	private static Map<String, Map<String, Long>> materialMap = new HashMap<String, Map<String,Long>>();
	private static Map<String, Long> materialCountMap = new HashMap<String, Long>();
	private static Map<String, Long> materialUsedMap = new HashMap<String, Long>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalOre = 0;
		
		String fileName = "C:/Users/Thijs/Desktop/inputadvent14TEST.txt";
		Path path = Paths.get(fileName);

		try {
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for (String line : allLines) {
				String result = line.split("=>")[1].trim();
				String material = line.split("=>")[0].trim();
				
				materialCountMap.put(result.split(" ")[1], Long.parseLong(result.split(" ")[0]));
				materialUsedMap.put(result.split(" ")[1], 0l);
				
				Map<String, Long> matMap = new HashMap<String, Long>();
				
				for (String mat:material.split(",")) {
					matMap.put(mat.trim().split(" ")[1], Long.parseLong(mat.trim().split(" ")[0]));
				}
				materialMap.put(result.split(" ")[1], matMap);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		
		
		for (String material : materialMap.keySet()) {
			System.out.printf("material:%s:%d%n", material, materialCountMap.get(material));
			for (String sub:materialMap.get(material).keySet()) {
				System.out.printf("sub:%s:%d%n", sub, materialMap.get(material).get(sub));
			}
		}
		
		for (String sub:materialCountMap.keySet()) {
			System.out.printf("count:%s:%d%n", sub, materialCountMap.get(sub));
		}
		
		getfuelcomponent("FUEL", 1);
		
		for (Entry<String, Long> matUsed:materialUsedMap.entrySet()) {
			System.out.printf("matCheck:%s:%d%n", matUsed.getKey(), matUsed.getValue());
		}
		
		
		for (Entry<String, Long> matUsed:materialUsedMap.entrySet()) {
			System.out.printf("mat:%s:%d%n", matUsed.getKey(), matUsed.getValue());
			
			
			
			
			
			for (Entry<String, Long> matEntry: materialMap.get(matUsed.getKey()).entrySet()) {
				long matCount = matUsed.getValue();
				while (matCount % materialCountMap.get(matUsed.getKey()) != 0) {
					matCount++;
				}
				System.out.printf("matcor:%s:%d%n", matUsed.getKey(), matCount);
				
				if (matEntry.getKey().equals("ORE")) {
					totalOre += (matCount / materialCountMap.get(matUsed.getKey())) * matEntry.getValue();
					System.out.println("totOre:"+totalOre);
				}
			}
		}
		System.out.println("total:"+totalOre);
	}
	
	private static int getfuelcomponent(String material, long amount) {
		
		int total = 0;
		
		for (Entry<String, Long> matEntry: materialMap.get(material).entrySet()) {
			if (matEntry.getKey().equals("ORE")) {
				//total += matEntry.getValue();
				
			} else {
				
				
				
				long result = 0;
				
				
				
				//total += amount * getfuelcomponent(matEntry.getKey(), matEntry.getValue());
				//materialUsedMap.put(matEntry.getKey(), materialUsedMap.get(matEntry.getKey()) + (matEntry.getValue() * amount));
				
				System.out.println("mat:"+material+",amount:"+amount);
				System.out.printf("%s:amount:%d:creat:%d:this:%d%n", matEntry.getKey(), amount, materialCountMap.get(material), matEntry.getValue());
				System.out.printf("result:%d%n", (long) ((matEntry.getValue()*Math.ceil((double) amount/materialCountMap.get(material)))));
				
				long top = materialUsedMap.get(matEntry.getKey()) + matEntry.getValue();
				long bottom = (long) Math.ceil((double) amount/materialCountMap.get(material));
				System.out.printf("(%d+%d)*(%d/%d)%n", materialUsedMap.get(matEntry.getKey()), matEntry.getValue(), amount, materialCountMap.get(material));
				//materialUsedMap.put(matEntry.getKey(), materialUsedMap.get(matEntry.getKey()) + (long) ((matEntry.getValue()*Math.ceil((double) amount/materialCountMap.get(material)))));
				materialUsedMap.put(matEntry.getKey(), (long) ((matEntry.getValue()*Math.ceil((double) amount/materialCountMap.get(material)))));
				
				
				
				//getfuelcomponent(matEntry.getKey(), matEntry.getValue());
				getfuelcomponent(matEntry.getKey(), materialUsedMap.get(matEntry.getKey()));
				
				
				
				
			}
		}
		
		//materialUsedMap.put(material, total);
		
		return total;
	}

}
