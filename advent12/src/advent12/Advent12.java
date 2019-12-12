package advent12;

import java.awt.print.Printable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Point3D> posMap = new HashMap<Integer, Point3D>();
		Map<Integer, Point3D> velMap = new HashMap<Integer, Point3D>();
		Map<Integer, Point3D> oriposMap = new HashMap<Integer, Point3D>();
		Map<Integer, Point3D> orivelMap = new HashMap<Integer, Point3D>();
		Map<Integer, Point3D> maxMap = new HashMap<Integer, Point3D>();
		//Map<Integer, Point3D> minMap = new HashMap<Integer, Point3D>();
		String fileName = "C:/Users/Thijs/Desktop/inputadvent12TEST.txt";
		Path path = Paths.get(fileName);
		//byte[] bytes = Files.readAllBytes(path);
		try {
			int i = 0;
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for (String line : allLines) {
				line = line.replace("<", "");
				line = line.replace(">", "");
				String[] coord = line.split(",");
				posMap.put(i, new Point3D(Integer.parseInt(coord[0].split("=")[1]), Integer.parseInt(coord[1].split("=")[1]), Integer.parseInt(coord[2].split("=")[1])));
				velMap.put(i, new Point3D(0, 0, 0));

				oriposMap.put(i, new Point3D(Integer.parseInt(coord[0].split("=")[1]), Integer.parseInt(coord[1].split("=")[1]), Integer.parseInt(coord[2].split("=")[1])));
				orivelMap.put(i, new Point3D(0, 0, 0));

				maxMap.put(i, new Point3D(0, 0, 0));
				//minMap.put(i, new Point3D(0, 0, 0));

				i++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}



		printall(0, posMap, velMap);
		long steps = 1;
		while (steps > 0) {

			for (int i = 0; i < posMap.size(); i++) {
				for (int j = i; j < posMap.size(); j++) {
					if (i!=j) { 

						Point3D pi = posMap.get(i);
						Point3D pj = posMap.get(j);

						Point3D vi = velMap.get(i);
						Point3D vj = velMap.get(j);

						if (pi.x() < pj.x()) {vi.x(vi.x()+1); vj.x(vj.x()-1);}
						else if (pi.x() > pj.x()) {vi.x(vi.x()-1); vj.x(vj.x()+1);}

						if (pi.y() < pj.y()) {vi.y(vi.y()+1); vj.y(vj.y()-1);}
						else if (pi.y() > pj.y()) {vi.y(vi.y()-1); vj.y(vj.y()+1);}

						if (pi.z() < pj.z()) {vi.z(vi.z()+1); vj.z(vj.z()-1);}
						else if (pi.z() > pj.z()) {vi.z(vi.z()-1); vj.z(vj.z()+1);}




						//velMap.put(i, vi);
						//velMap.put(j, vj);
					}
				}
			}

			for (int i = 0; i < posMap.size(); i++) {
				Point3D pi = posMap.get(i);
				Point3D vi = velMap.get(i);
				Point3D ovi = orivelMap.get(i);
				Point3D opi = oriposMap.get(i);
				Point3D max = maxMap.get(i);


				pi.x(pi.x()+vi.x());
				pi.y(pi.y()+vi.y());
				pi.z(pi.z()+vi.z());

				if (steps != 0) {
					if (vi.x() == 0 && pi.x() == opi.x() && max.x() ==0) {
						max.x(steps);
					}
					if (vi.y() == 0 && pi.y() == opi.y() && max.y() == 0) {
						max.y(steps);
					}
					if (vi.z() == 0 && pi.z() == opi.z() && max.z() ==0) {
						max.z(steps);
					}
				}




			}

			if (steps % 6000 == 0) {
				printall(steps, posMap, velMap);
				printall(-1, orivelMap, maxMap);

				
				
				long xlcm = lcm(maxMap.get(0).x(),maxMap.get(1).x(),maxMap.get(2).x(), maxMap.get(3).x());
				System.out.println("x:"+xlcm);
				long ylcm = lcm(maxMap.get(0).y(),maxMap.get(1).y(),maxMap.get(2).y(), maxMap.get(3).y());
				System.out.println("y:"+ylcm);
				long zlcm = lcm(maxMap.get(0).z(),maxMap.get(1).z(),maxMap.get(2).z(), maxMap.get(3).z());
				System.out.println("z:"+zlcm);
				long maxlcm = lcm(xlcm, ylcm,zlcm);
				/*
				System.out.printf("lcm:%d, %d, %d%n", xlcm, ylcm, zlcm);
				System.out.printf("lcm total: %d%n", maxlcm);
				*/
				
			}



			if (orivelMap.get(0).getCompareValue().equals(velMap.get(0).getCompareValue())) {
				if (orivelMap.get(1).getCompareValue().equals(velMap.get(1).getCompareValue())) {
					if (orivelMap.get(2).getCompareValue().equals(velMap.get(2).getCompareValue())) {
						if (orivelMap.get(3).getCompareValue().equals(velMap.get(3).getCompareValue())) {
							if (oriposMap.get(0).getCompareValue().equals(posMap.get(0).getCompareValue())) {
								if (oriposMap.get(1).getCompareValue().equals(posMap.get(1).getCompareValue())) {
									if (oriposMap.get(2).getCompareValue().equals(posMap.get(2).getCompareValue())) {
										if (oriposMap.get(3).getCompareValue().equals(posMap.get(3).getCompareValue())) {
											System.out.println("same: " + steps);
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			steps++;
		}

		int totalenergy = 0;
		for (int i = 0; i < posMap.size(); i++) {
			Point3D pi = posMap.get(i);
			Point3D vi = velMap.get(i);

			totalenergy += (Math.abs(pi.x()) + Math.abs(pi.y()) + Math.abs(pi.z())) * (Math.abs(vi.x()) + Math.abs(vi.y()) + Math.abs(vi.z()));
		}
		System.out.println("totalenergy: " + totalenergy);
	}

	private static void printall(long iter, Map<Integer, Point3D> posMap, Map<Integer, Point3D> velMap) {
		for (Integer id : posMap.keySet()) {
			System.out.printf("%,d:", iter);
			posMap.get(id).printPoint3D("pos");
			System.out.print(", ");
			velMap.get(id).printPoint3D("vel");
			System.out.println();
		}
	}

	public static long lcm(long... a) {
		for (long m = 1;; m++) {
			int n = a.length;
			for (long i : a) {
				if (m % i != 0) {
					break;
				}
				if (--n == 0) {
					return m;
				}
			}
		}
	}



}
