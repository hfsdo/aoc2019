package advent01;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Advent01 {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//File file = new File("C:/Users/Thijs/Desktop/inputadvent01.txt");
			String fileName = "C:/Users/Thijs/Desktop/inputadvent01.txt";
			Path path = Paths.get(fileName);
			byte[] bytes = Files.readAllBytes(path);
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			int total = 0;
			for (String line : allLines) {
				System.out.println(line);
				long val = Integer.parseInt(line);
				
				do {
					val = (long) Math.floor((double) val/3)-2;
					System.out.println("test:"+val);
					if (val > 0) {
						total+=val;
						System.out.println("subresult: "+ total);
					}
				} while (val > 0);
				
				
				
			}
			System.out.println("result: "+ total);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
