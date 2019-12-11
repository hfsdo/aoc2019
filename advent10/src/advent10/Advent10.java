package advent10;

import java.awt.Point;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Advent10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Point> lstAsteroids = new HashMap<String, Point>();
		Map<String, Integer> mapAsteroids = new HashMap<String, Integer>();

		SortedMap<Double, SortedMap<Double, Point>> mapDist = new TreeMap<Double, SortedMap<Double,Point>>();
		

		
		int highest = 0;
		Point pHighest = new Point(-1,-1);

		try {
			String fileName = "C:/Users/Thijs/Desktop/inputadvent10TEST.txt";
			Path path = Paths.get(fileName);
			//byte[] bytes = Files.readAllBytes(path);
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			int y = 0;
			for (String line : allLines) {

				char[] c = line.toCharArray();
				for (int x = 0; x < c.length; x++) {
					char pos = c[x];
					if (pos=='#') {
						lstAsteroids.put(""+x+":"+y, new Point(x, y));
					}
				}
				y++;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		Point newBase = lstAsteroids.get("20:18");



		SortedMap<Double, Point> angleMap = new TreeMap<Double, Point>();
		//System.out.println("point:"+possible.toString());
		int count = 0;
		for (Point asteroid : lstAsteroids.values()) {
			double x = newBase.x-asteroid.x;
			double y = newBase.y-asteroid.y;
			//System.out.println("x:"+String.valueOf(possible.x-asteroid.x));
			//System.out.println("y:"+String.valueOf(possible.y-asteroid.y));
			double angle;
			if (x == 0 && y!=0) {
				angle = y<0?180:0;
			} else if (y==0 && x!=0) {
				angle = x<0?90:270;
			} else if (x!=0 && y!=0) {
				double tan =  Math.abs(x) / Math.abs(y);
				//System.out.println("tan: " + tan);
				angle = Math.atan(tan);
				angle = (angle/(2*Math.PI))*360;
				if (x > 0 && y < 0) {//Linksonder
					angle = 180 + angle;
				} else if (x < 0 && y < 0) {//rechtsonder
					angle = 180 - angle;
				} else if (x < 0 && y > 0) {
					//angle = angle;
				} else if (x > 0 && y > 0) {
					angle = 360 - angle;
				}

				//System.out.println("angle: " + angle);
			} else {
				continue;
			}
			double dist;
			if (x == 0) {
				dist = y;
			} else if (y == 0) {
				dist = x;
			} else {
				dist = Math.sqrt((x*x) + (y*y));
			}
			
			if (mapDist.containsKey(angle)) {
				mapDist.get(angle).put(dist, asteroid);
			} else {
				SortedMap map = new TreeMap<Integer, Point>();
				map.put(dist, asteroid);
				mapDist.put(angle, map);
				
			}
			
			
			
			if (!angleMap.containsKey(angle)) {
				angleMap.put(angle, asteroid);
				count++;
			}

		}

		int amountShot = 0;
		
		
		for (Entry<Double, SortedMap<Double, Point>> angleKey: mapDist.entrySet()) {
			double distKey = angleKey.getValue().firstKey();
			System.out.println("destroy:"+ angleKey.getKey() + ":" + amountShot + ":" + angleKey.getValue().get(distKey));
			System.out.println("size:"+angleKey.getValue().size());
			
			amountShot++;
		}
		
		
		/*
		mapAsteroids.put(String.valueOf(newBase.x) + ":" + String.valueOf(newBase.y), count);
		if (highest < count) {
			highest = count;
			pHighest.x = possible.x;
			pHighest.y = possible.y;
			System.out.println(String.valueOf(possible.x) + ":" + String.valueOf(possible.y));
		}
		*/

		System.out.println("result:" + highest);

	}

}
