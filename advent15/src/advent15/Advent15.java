package advent15;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Advent15 {


	private static int x = 0;
	private static int y = 0;
	private static Point topLeft = new Point(0,0);
	private static Point bottomRight = new Point(0,0);
	private static long direction = 0;
	private static List<Long> inputs = new ArrayList<Long>();
	private static Map<String, Integer> shipPath = new HashMap<String, Integer>();
	private static Random r = new Random();
	private static long discovered = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		shipPath.put("0:0", 0);
		direction = 1;
		inputs.add(direction); //North
		x++;
		recalcGrid();

		testcomp();

	}

	private static void recalcGrid() {
		if (x > 0 && x > topLeft.x) {
			topLeft.x = x;
		}
		if (x < 0 && x < bottomRight.x) {
			bottomRight.x = x;
		}
		if (y > 0 && y > bottomRight.y) {
			bottomRight.y = y;
		}
		if (y < 0 && y < topLeft.y) {
			topLeft.y = y;
		}
	}

	private static void draw() {
		System.out.println("discovered:"+discovered);
		for (int j=topLeft.y; j<=bottomRight.y; j++) {
			for (int i = topLeft.x;i>=bottomRight.x; i--) {

				if (x==i && y==j) {
					System.out.print("D");
				} else if (i==0 && j==0) {
					System.out.print("S");
				} else if (shipPath.containsKey(""+i+":"+j)) {
					int val = shipPath.get(""+i+":"+j);
					if (val == 0) {
						System.out.print("#");
					} else if (val == 1) {
						System.out.print(".");
					} else if (val == 2) {
						System.out.print("O");
					} 

				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void output(long val) {
		if (!shipPath.containsKey(""+x+":"+y)) {
			draw();
			discovered++;
			shipPath.put(""+x+":"+y, (int) val);
		}

		if (val==0) {
			//hit wall
			x = direction==1?x-1:direction==2?x+1:x;
			y = direction==3?y+1:direction==4?y-1:y;
			if (!shipPath.containsKey(""+(x+1)+":"+y)) {
				//System.out.println(""+(x+1)+":"+y);
				//System.out.println("x+1");
				
				direction = 1;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if(!shipPath.containsKey(""+(x-1)+":"+y)) {
				//System.out.println(""+(x-1)+":"+y);
				//System.out.println("x-1");
				
				direction = 2;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if (!shipPath.containsKey(""+x+":"+(y+1))) {
				//System.out.println(""+x+":"+(y+1));
				//System.out.println("y+1");
				
				direction = 4;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if (!shipPath.containsKey(""+x+":"+(y-1))) {
				//System.out.println(""+x+":"+(y-1));
				//System.out.println("y-1");
				
				direction = 3;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else {
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
				do {
					x = direction==1?x-1:direction==2?x+1:x;
					y = direction==3?y+1:direction==4?y-1:y;
					direction = 1+ r.nextInt(4);
					x = direction==1?x+1:direction==2?x-1:x;
					y = direction==3?y-1:direction==4?y+1:y;
				} while(shipPath.containsKey(""+x+":"+y) && shipPath.get(""+x+":"+y)==0 );
			}
			//direction--;
			//direction = direction==0?4:direction;
			inputs.add(direction);


		} else if (val == 1) {
			if (!shipPath.containsKey(""+(x+1)+":"+y)) {
				//System.out.println(""+(x+1)+":"+y);
				//System.out.println("x+1");
				
				direction = 1;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if(!shipPath.containsKey(""+(x-1)+":"+y)) {
				//System.out.println(""+(x-1)+":"+y);
				//System.out.println("x-1");
				
				direction = 2;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if (!shipPath.containsKey(""+x+":"+(y+1))) {
				//System.out.println(""+x+":"+(y+1));
				//System.out.println("y+1");
				
				direction = 4;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if (!shipPath.containsKey(""+x+":"+(y-1))) {
				//System.out.println(""+x+":"+(y-1));
				//System.out.println("y-1");
				
				direction = 3;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else {
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
				do {
					x = direction==1?x-1:direction==2?x+1:x;
					y = direction==3?y+1:direction==4?y-1:y;
					direction = 1+ r.nextInt(4);
					x = direction==1?x+1:direction==2?x-1:x;
					y = direction==3?y-1:direction==4?y+1:y;
				} while(shipPath.containsKey(""+x+":"+y) && shipPath.get(""+x+":"+y)==0 );
			}
			inputs.add(direction);
			//requested direction
		} else if (val == 2) {
			//oxygen system
			if (!shipPath.containsKey(""+(x+1)+":"+y)) {
				//System.out.println(""+(x+1)+":"+y);
				//System.out.println("x+1");
				
				direction = 1;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if(!shipPath.containsKey(""+(x-1)+":"+y)) {
				//System.out.println(""+(x-1)+":"+y);
				//System.out.println("x-1");
				
				direction = 2;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if (!shipPath.containsKey(""+x+":"+(y+1))) {
				//System.out.println(""+x+":"+(y+1));
				//System.out.println("y+1");
				
				direction = 4;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else if (!shipPath.containsKey(""+x+":"+(y-1))) {
				//System.out.println(""+x+":"+(y-1));
				//System.out.println("y-1");
				
				direction = 3;
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
			} else {
				x = direction==1?x+1:direction==2?x-1:x;
				y = direction==3?y-1:direction==4?y+1:y;
				do {
					x = direction==1?x-1:direction==2?x+1:x;
					y = direction==3?y+1:direction==4?y-1:y;
					direction = 1+ r.nextInt(4);
					x = direction==1?x+1:direction==2?x-1:x;
					y = direction==3?y-1:direction==4?y+1:y;
				} while(shipPath.containsKey(""+x+":"+y) && shipPath.get(""+x+":"+y)==0 );
			}
			inputs.add(direction);
		}
		recalcGrid();
		


	}

	private static long testcomp() {
		boolean print = false;
		boolean output = false;
		String inputString = "3,1033,1008,1033,1,1032,1005,1032,31,1008,1033,2,1032,1005,1032,58,1008,1033,3,1032,1005,1032,81,1008,1033,4,1032,1005,1032,104,99,102,1,1034,1039,1001,1036,0,1041,1001,1035,-1,1040,1008,1038,0,1043,102,-1,1043,1032,1,1037,1032,1042,1105,1,124,102,1,1034,1039,102,1,1036,1041,1001,1035,1,1040,1008,1038,0,1043,1,1037,1038,1042,1105,1,124,1001,1034,-1,1039,1008,1036,0,1041,101,0,1035,1040,1002,1038,1,1043,1001,1037,0,1042,1105,1,124,1001,1034,1,1039,1008,1036,0,1041,102,1,1035,1040,1002,1038,1,1043,102,1,1037,1042,1006,1039,217,1006,1040,217,1008,1039,40,1032,1005,1032,217,1008,1040,40,1032,1005,1032,217,1008,1039,5,1032,1006,1032,165,1008,1040,1,1032,1006,1032,165,1101,0,2,1044,1105,1,224,2,1041,1043,1032,1006,1032,179,1102,1,1,1044,1105,1,224,1,1041,1043,1032,1006,1032,217,1,1042,1043,1032,1001,1032,-1,1032,1002,1032,39,1032,1,1032,1039,1032,101,-1,1032,1032,101,252,1032,211,1007,0,56,1044,1105,1,224,1102,0,1,1044,1106,0,224,1006,1044,247,102,1,1039,1034,1001,1040,0,1035,101,0,1041,1036,102,1,1043,1038,102,1,1042,1037,4,1044,1106,0,0,40,31,67,22,98,81,11,5,82,25,86,22,69,15,21,97,6,6,62,50,91,14,90,37,26,50,98,4,55,61,39,20,93,19,70,47,50,8,85,97,24,91,12,79,38,62,13,99,4,63,48,75,93,2,4,62,72,51,63,23,12,8,80,87,54,13,99,85,2,66,45,93,13,2,87,86,14,25,27,12,87,49,58,51,77,25,5,97,13,35,48,64,63,11,76,32,18,79,37,88,12,85,85,4,69,71,29,27,66,33,7,66,72,51,74,87,13,48,42,34,67,26,13,96,25,65,83,46,72,99,25,62,3,50,72,99,65,37,75,39,68,39,11,75,27,70,90,39,62,69,31,17,57,43,27,28,54,87,7,97,72,25,93,30,59,20,74,59,7,8,94,96,36,86,9,35,81,74,21,73,15,59,6,80,42,5,67,34,55,95,96,31,98,70,50,17,64,36,79,34,31,20,58,60,9,4,55,39,94,49,17,95,81,85,31,26,62,80,4,71,80,17,37,80,97,9,16,25,89,6,46,76,50,99,20,62,73,6,79,66,96,2,42,72,45,96,30,94,73,42,38,63,12,36,68,70,50,54,26,74,49,92,26,33,38,66,65,79,90,55,37,71,48,66,5,57,86,17,42,89,5,97,81,46,99,74,19,69,13,86,60,93,7,16,86,42,81,26,95,91,93,14,94,76,91,33,44,42,58,87,26,41,9,22,63,1,82,63,20,49,50,71,75,5,32,73,14,45,98,50,91,54,69,61,27,60,40,88,16,34,18,64,18,50,81,67,67,28,95,7,89,80,37,26,97,25,29,58,77,60,22,22,43,64,15,66,69,33,20,50,84,70,53,11,64,80,16,80,74,15,90,67,33,12,57,8,52,78,10,18,25,40,82,63,93,93,28,18,51,68,58,6,60,58,14,54,72,68,91,41,70,67,3,74,18,3,27,65,71,11,11,99,49,88,21,42,7,78,35,4,78,2,2,82,26,65,97,67,46,63,1,68,55,85,94,16,1,22,41,67,86,35,10,83,64,11,95,50,46,86,74,5,68,81,62,22,75,68,26,58,40,62,44,38,65,22,69,20,90,5,10,42,99,96,51,63,64,7,64,36,92,89,54,4,68,63,85,9,38,95,89,51,50,75,86,5,41,40,59,31,82,99,8,95,5,43,45,60,60,29,84,15,5,96,64,55,97,44,35,7,93,96,43,22,50,20,70,81,39,8,90,50,66,49,31,29,34,97,90,1,59,3,5,82,85,85,47,29,6,65,31,70,76,33,35,82,43,98,62,29,44,76,70,59,89,30,25,97,83,75,79,43,98,93,40,59,36,55,64,29,31,98,65,47,33,91,75,62,71,68,38,33,81,10,73,83,6,13,88,92,45,94,15,1,88,59,22,7,36,89,59,36,12,80,3,80,78,29,85,75,28,7,15,82,41,1,81,26,7,72,46,85,71,16,40,73,11,81,7,24,10,87,75,9,87,35,40,86,5,16,69,98,45,43,8,68,20,83,73,47,86,77,35,89,71,1,37,62,62,65,44,26,83,52,87,89,40,62,61,97,7,42,79,9,1,64,99,86,5,86,51,23,25,32,71,28,91,26,87,64,47,17,2,90,64,42,10,85,36,31,79,75,79,21,59,5,9,88,12,36,74,59,72,6,82,34,80,10,78,81,33,91,22,94,18,88,10,63,23,87,58,65,20,66,74,65,18,96,22,98,13,86,48,67,14,96,58,73,14,67,2,65,48,92,42,93,18,96,32,81,0,0,21,21,1,10,1,0,0,0,0,0,0";
		Map<Long, Long> inputMap = new HashMap<Long, Long>();
		for (String s : inputString.split(",")) {
			//System.out.println("S:"+ s);
			inputMap.put((long) inputMap.size(), Long.valueOf(s));
		}
		//inputMap.put(0l, 2l);
		//Long[] input = new Long[]{3l,8l,1005l,8l,324l,1106l,0l,11l,0l,0l,0l,104l,1l,104l,0l,3l,8l,1002l,8l,-1l,10l,1001l,10l,1l,10l,4l,10l,1008l,8l,1l,10l,4l,10l,1001l,8l,0l,29l,1l,1107l,14l,10l,1006l,0l,63l,1006l,0l,71l,3l,8l,1002l,8l,-1l,10l,101l,1l,10l,10l,4l,10l,1008l,8l,1l,10l,4l,10l,1002l,8l,1l,61l,1l,103l,18l,10l,1006l,0l,14l,1l,105l,7l,10l,3l,8l,1002l,8l,-1l,10l,101l,1l,10l,10l,4l,10l,1008l,8l,1l,10l,4l,10l,101l,0l,8l,94l,1006l,0l,37l,1006l,0l,55l,2l,1101l,15l,10l,3l,8l,1002l,8l,-1l,10l,1001l,10l,1l,10l,4l,10l,1008l,8l,0l,10l,4l,10l,101l,0l,8l,126l,2l,1006l,12l,10l,3l,8l,102l,-1l,8l,10l,101l,1l,10l,10l,4l,10l,1008l,8l,1l,10l,4l,10l,1001l,8l,0l,152l,3l,8l,102l,-1l,8l,10l,1001l,10l,1l,10l,4l,10l,108l,0l,8l,10l,4l,10l,101l,0l,8l,173l,1006l,0l,51l,1006l,0l,26l,3l,8l,102l,-1l,8l,10l,101l,1l,10l,10l,4l,10l,1008l,8l,0l,10l,4l,10l,1001l,8l,0l,202l,2l,8l,18l,10l,1l,103l,19l,10l,1l,1102l,1l,10l,1006l,0l,85l,3l,8l,102l,-1l,8l,10l,1001l,10l,1l,10l,4l,10l,108l,0l,8l,10l,4l,10l,1001l,8l,0l,238l,2l,1002l,8l,10l,1006l,0l,41l,3l,8l,102l,-1l,8l,10,1001l,10l,1l,10l,4l,10l,108l,0l,8l,10l,4l,10l,101l,0l,8l,267l,2l,1108l,17,10l,2l,105l,11l,10l,1006l,0l,59,1006l,0l,90l,3l,8,1002l,8l,-1l,10l,1001l,10l,1l,10l,4l,10l,1008l,8l,1l,10l,4l,10l,1001l,8l,0l,304l,101l,1l,9l,9l,1007l,9l,993l,10l,1005l,10l,15l,99l,109l,646l,104l,0l,104l,1l,21102l,936735777688l,1l,1l,21101l,341l,0l,0l,1105l,1l,445l,21101l,0l,937264173716l,1l,21101l,352l,0l,0l,1106l,0l,445l,3l,10l,104l,0l,104l,1l,3l,10l,104l,0l,104l,0l,3l,10l,104l,0l,104l,1l,3l,10l,104l,0l,104l,1l,3l,10l,104l,0l,104l,0l,3l,10l,104l,0l,104l,1l,21101l,3245513819l,0l,1l,21102l,1l,399l,0l,1105l,1l,445l,21102l,1l,29086470235l,1l,21102l,410l,1l,0l,1105l,1l,445l,3l,10l,104l,0l,104l,0l,3l,10l,104l,0l,104l,0l,21101l,825544712960l,0l,1l,21102l,1l,433l,0l,1106l,0l,445l,21102,825460826472,1,1,21101,0,444,0,1106,0,445,99,109,2,22102,1,-1,1,21101,0,40,2,21101,0,476,3,21102,466,1,0,1105,1,509,109,-2,2105,1,0,0,1,0,0,1,109,2,3,10,204,-1,1001,471,472,487,4,0,1001,471,1,471,108,4,471,10,1006,10,503,1101,0,0,471,109,-2,2106,0,0,0,109,4,2101,0,-1,508,1207,-3,0,10,1006,10,526,21101,0,0,-3,21202,-3,1,1,21201,-2,0,2,21101,0,1,3,21101,0,545,0,1105,1,550,109,-4,2105,1,0,109,5,1207,-3,1,10,1006,10,573,2207,-4,-2,10,1006,10,573,21202,-4,1,-4,1106,0,641,21202,-4,1,1,21201,-3,-1,2,21202,-2,2,3,21101,0,592,0,1105,1,550,22101,0,1,-4,21101,1,0,-1,2207,-4,-2,10,1006,10,611,21102,1,0,-1,22202,-2,-1,-2,2107,0,-3,10,1006,10,633,22101,0,-1,1,21102,633,1,0,105,1,508,21202,-2,-1,-2,22201,-4,-2,-4,109,-5,2105,1,0};
		//Long[] input = new Long[] {104l,1125899906842624l,99l};
		//Integer[] input = new Integer[] {3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10};
		//List<Integer> inputlist = new ArrayList<Integer>();
		//inputlist = Arrays.asList(input);

		/*
		for (int i = 0; i<input.length;i++) {
			inputMap.put((long) i, (long) input[i]);
		}
		 */
		//1202 program alarm
		//input[1] = noun;//12;
		//input[2] = verb;//2;
		/*
				List<Integer> inputs = new ArrayList<Integer>();
				inputs = Arrays.asList(inputArr);
		 */
		//List<Long> inputs = new ArrayList<Long>();
		Scanner s = new Scanner(System.in);

		long pointer = 0;
		int inputsPointer = 0;
		long offset = 0;
		//int result = 0;


		//System.out.println("result" + Arrays.toString(input));
		while (pointer >= 0) {
			//System.out.println("atpointer: " + inputlist.get(pointer));
			long opcode = inputMap.get(pointer) % 100;
			if (print) {System.out.println("pointer: " + pointer);}
			if (print) {System.out.println("opcode: " + opcode);}
			if (print) {System.out.println("offset: " + offset);}
			if (opcode == 1) { 

				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}


				long b = (inputMap.get(pointer) / 1000) % 10;
				try {
					b = b==1?inputMap.get(pointer+2):inputMap.get(inputMap.get(pointer+2)+(b==2?offset:0));
				} catch(NullPointerException ne) {
					b = 0;
				}

				long c = (inputMap.get(pointer) / 10000) % 10;
				inputMap.put(inputMap.get(pointer+3)+(c==2?offset:0), a+b);
				pointer += 4;
			} else if (opcode == 2) {
				long a = (inputMap.get(pointer) / 100) % 10;
				//System.out.println(a);
				//System.out.println(inputlist.get(pointer+1));
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}

				long b = (inputMap.get(pointer) / 1000) % 10;
				//System.out.println(b);
				try {
					b = b==1?inputMap.get(pointer+2):inputMap.get(inputMap.get(pointer+2)+(b==2?offset:0));
				} catch(NullPointerException ne) {
					b = 0;
				}


				long c = (inputMap.get(pointer) / 10000) % 10;
				inputMap.put(inputMap.get(pointer+3)+(c==2?offset:0), a*b);
				pointer += 4;
			} else if (opcode == 3) {
				//System.out.println("input?");
				//long in = s.nextLong();
				/*
				while (inputs.size() == inputsPointer) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				 */
				if (print) {System.out.printf("inputspointer:%d/%d%n", inputsPointer, inputs.size() );}
				if (inputsPointer != inputs.size()-1) {
					System.out.println("something went wrong");
				}

				//long a = inputs.get(inputsPointer);
				long a = inputs.get(inputs.size()-1);

				inputsPointer++;
				//long a = (inputMap.get(pointer) / 100) % 10;
				inputMap.put(inputMap.get(pointer+1)+(a==2?offset:0), a);
				pointer += 2;
			} else if (opcode == 4) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}

				if (print || output) {System.out.println("output: "+ a);}
				output(a);
				//inputs.add(a);
				pointer += 2;




			} else if (opcode == 5) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}

				if (a != 0) {
					long b = (inputMap.get(pointer) / 1000) % 10;
					try {
						b = b==1?inputMap.get(pointer+2):inputMap.get(inputMap.get(pointer+2)+(b==2?offset:0));
					} catch(NullPointerException ne) {
						b = 0;
					}

					pointer = (int) b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 6) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}

				if (a == 0) {
					long b = (inputMap.get(pointer) / 1000) % 10;
					try {
						b = b==1?inputMap.get(pointer+2):inputMap.get(inputMap.get(pointer+2)+(b==2?offset:0));
					} catch(NullPointerException ne) {
						b = 0;
					}

					pointer = (int) b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 7) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}

				long b = (inputMap.get(pointer) / 1000) % 10;
				try {
					b = b==1?inputMap.get(pointer+2):inputMap.get(inputMap.get(pointer+2)+(b==2?offset:0));
				} catch(NullPointerException ne) {
					b = 0;
				}

				long c = (inputMap.get(pointer) / 10000) % 10;
				if (a < b) {
					inputMap.put(inputMap.get(pointer+3)+(c==2?offset:0), 1l);
				} else {
					inputMap.put(inputMap.get(pointer+3)+(c==2?offset:0), 0l);
				}
				pointer += 4;
			} else if (opcode == 8) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}

				long b = (inputMap.get(pointer) / 1000) % 10;
				try {
					b = b==1?inputMap.get(pointer+2):inputMap.get(inputMap.get(pointer+2)+(b==2?offset:0));
				} catch(NullPointerException ne) {
					b = 0;
				}

				long c = (inputMap.get(pointer) / 10000) % 10;
				if (a == b) {
					inputMap.put(inputMap.get(pointer+3)+(c==2?offset:0), 1l);
				} else {
					inputMap.put(inputMap.get(pointer+3)+(c==2?offset:0), 0l);
				}
				pointer += 4;
			} else if (opcode == 9) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					offset += a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					offset += 0;
				}
				pointer+=2;
			} else if (opcode == 99) {
				if (print) {System.out.println("halted");}
				break;
			} else {
				System.out.println("error:" + inputMap.get(pointer));
				break;
			}
			//System.out.println("result" + Arrays.toString(input));

		}
		return inputMap.get(0l);
	}
}
