package advent13;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Advent13 {
	private static List<Long> inputs = new ArrayList<Long>();
	private static int outType = 0;
	private static int x = 0;
	private static int y = 0;
	private static Map<String, Integer> gameMap = new HashMap<String, Integer>();
	private static Point topLeft = new Point(0,0);
	private static Point bottomRight = new Point(0,0);
	private static Point paddle = new Point(0,0);
	private static Point ball = new Point(0,0);
	private static int blockCount = 0;
	private static int score = -1;

	public static void main(String[] args) {
		//inputs.add(0l);

		testcomp();

		System.out.println("blocks:"+blockCount);
		System.out.println("score:"+score);

	}

	private static void draw() {
		for (int j=topLeft.y; j<=bottomRight.y; j++) {
			for (int i = topLeft.x;i>=bottomRight.x; i--) {


				if (gameMap.containsKey(""+i+":"+j)) {
					int val = gameMap.get(""+i+":"+j);
					if (val == 0) {
						System.out.print(" ");
					} else if (val == 1) {
						System.out.print("|");
					} else if (val == 2) {
						System.out.print("#");
					} else if (val == 3) {
						System.out.print("_");
					} else if (val == 4) {
						System.out.print("0");
					}

				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void output(long val) {



		if (outType == 0) {
			//X
			x = (int) val;
			outType = 1;
		} else if (outType == 1) {
			//Y
			y = (int) val;
			outType = 2;
		} else if (outType == 2) {
			//ID

			if (x==-1 && y==0) {
				score = (int) val;
				System.out.println("score:" + score);

				//draw();



			} else {
				gameMap.put(""+x+":"+y, (int) val);
				if (val == 2) {
					blockCount++;
				} else if  (val == 3) {
					paddle.x = x;
					paddle.y = y;
				} else if (val == 4) {
					ball.x = x;
					ball.y = y;
				}

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

				x=0;
				y=0;

			}
			
			if (score >= 0 && paddle.x != 0) {
				if (ball.x < paddle.x) {
					inputs.add(-1l);
					System.out.println("-1");
					/*
					gameMap.put(""+paddle.x+":"+paddle.y, 0);
					paddle.x -= 1;
					gameMap.put(""+paddle.x+":"+paddle.y, 3);
					*/
				} else if (ball.x > paddle.x) {
					inputs.add(1l);
					System.out.println("1");
					/*
					gameMap.put(""+paddle.x+":"+paddle.y, 0);
					paddle.x += 1;
					gameMap.put(""+paddle.x+":"+paddle.y, 3);
					*/
				} else {
					inputs.add(0l);
					System.out.println("0");
				}
			} else {
				//inputs.add(0l);
				System.out.println("N:0");
			}
			
			draw();
			outType = 0;
		}



	}

	private static long testcomp() {
		boolean print = false;
		boolean output = false;
		String inputString = "1,380,379,385,1008,2151,549350,381,1005,381,12,99,109,2152,1102,1,0,383,1101,0,0,382,21002,382,1,1,21001,383,0,2,21101,37,0,0,1106,0,578,4,382,4,383,204,1,1001,382,1,382,1007,382,36,381,1005,381,22,1001,383,1,383,1007,383,21,381,1005,381,18,1006,385,69,99,104,-1,104,0,4,386,3,384,1007,384,0,381,1005,381,94,107,0,384,381,1005,381,108,1105,1,161,107,1,392,381,1006,381,161,1101,-1,0,384,1106,0,119,1007,392,34,381,1006,381,161,1102,1,1,384,20101,0,392,1,21102,19,1,2,21102,1,0,3,21101,0,138,0,1106,0,549,1,392,384,392,21002,392,1,1,21101,19,0,2,21102,3,1,3,21102,161,1,0,1106,0,549,1102,0,1,384,20001,388,390,1,21002,389,1,2,21101,0,180,0,1105,1,578,1206,1,213,1208,1,2,381,1006,381,205,20001,388,390,1,20102,1,389,2,21101,205,0,0,1105,1,393,1002,390,-1,390,1102,1,1,384,21002,388,1,1,20001,389,391,2,21102,1,228,0,1106,0,578,1206,1,261,1208,1,2,381,1006,381,253,21001,388,0,1,20001,389,391,2,21102,253,1,0,1106,0,393,1002,391,-1,391,1102,1,1,384,1005,384,161,20001,388,390,1,20001,389,391,2,21102,1,279,0,1105,1,578,1206,1,316,1208,1,2,381,1006,381,304,20001,388,390,1,20001,389,391,2,21101,0,304,0,1106,0,393,1002,390,-1,390,1002,391,-1,391,1101,1,0,384,1005,384,161,21001,388,0,1,21001,389,0,2,21102,1,0,3,21102,1,338,0,1106,0,549,1,388,390,388,1,389,391,389,20102,1,388,1,20101,0,389,2,21102,4,1,3,21101,365,0,0,1106,0,549,1007,389,20,381,1005,381,75,104,-1,104,0,104,0,99,0,1,0,0,0,0,0,0,236,16,16,1,1,18,109,3,22101,0,-2,1,22102,1,-1,2,21101,0,0,3,21102,1,414,0,1106,0,549,21202,-2,1,1,22102,1,-1,2,21102,429,1,0,1105,1,601,1202,1,1,435,1,386,0,386,104,-1,104,0,4,386,1001,387,-1,387,1005,387,451,99,109,-3,2105,1,0,109,8,22202,-7,-6,-3,22201,-3,-5,-3,21202,-4,64,-2,2207,-3,-2,381,1005,381,492,21202,-2,-1,-1,22201,-3,-1,-3,2207,-3,-2,381,1006,381,481,21202,-4,8,-2,2207,-3,-2,381,1005,381,518,21202,-2,-1,-1,22201,-3,-1,-3,2207,-3,-2,381,1006,381,507,2207,-3,-4,381,1005,381,540,21202,-4,-1,-1,22201,-3,-1,-3,2207,-3,-4,381,1006,381,529,22102,1,-3,-7,109,-8,2106,0,0,109,4,1202,-2,36,566,201,-3,566,566,101,639,566,566,1202,-1,1,0,204,-3,204,-2,204,-1,109,-4,2105,1,0,109,3,1202,-1,36,594,201,-2,594,594,101,639,594,594,20101,0,0,-2,109,-3,2105,1,0,109,3,22102,21,-2,1,22201,1,-1,1,21101,0,383,2,21102,1,195,3,21102,1,756,4,21101,0,630,0,1106,0,456,21201,1,1395,-2,109,-3,2105,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,2,2,0,2,0,0,0,0,2,2,0,2,2,2,0,2,2,2,2,0,0,2,0,2,0,0,0,2,2,2,2,2,0,1,1,0,2,0,0,2,2,2,0,0,2,0,0,2,0,2,0,0,2,2,0,0,2,0,0,2,2,2,0,2,0,2,2,2,0,1,1,0,2,2,0,2,2,0,2,0,0,0,2,0,2,0,0,2,0,2,0,0,2,2,2,2,0,2,2,2,0,0,0,2,0,1,1,0,0,0,0,2,0,0,2,2,0,0,2,2,0,2,0,2,2,0,2,2,2,0,0,0,2,2,2,2,0,2,2,2,0,1,1,0,2,0,0,0,0,0,0,0,2,2,2,2,0,2,2,2,2,2,0,2,2,0,2,0,0,0,2,2,2,0,2,0,0,1,1,0,2,0,2,2,2,2,2,0,0,2,0,0,0,2,0,2,2,0,0,2,0,2,2,2,2,0,2,0,0,0,0,0,0,1,1,0,2,2,0,0,0,2,0,0,0,2,2,0,2,2,2,0,2,2,2,0,2,2,2,2,2,2,2,0,2,2,2,2,0,1,1,0,0,2,0,2,2,2,2,0,0,2,2,0,0,2,0,0,2,0,0,2,2,0,0,2,0,2,2,0,0,2,0,2,0,1,1,0,2,2,2,2,0,2,0,2,2,0,2,2,2,2,0,0,0,0,0,0,0,2,2,2,2,2,0,2,0,0,0,2,0,1,1,0,2,0,0,0,2,0,0,2,0,0,2,0,0,0,2,2,2,2,2,0,2,0,2,0,2,0,2,0,0,2,2,0,0,1,1,0,0,2,0,2,0,0,2,0,2,0,2,2,2,0,2,0,2,2,2,2,2,0,0,2,2,2,2,0,2,2,2,0,0,1,1,0,2,2,2,2,0,0,2,2,0,0,2,0,0,0,2,0,0,2,2,0,0,2,2,0,2,2,0,2,2,2,2,2,0,1,1,0,2,2,2,0,0,2,2,0,2,2,0,0,2,2,0,0,0,2,2,0,2,2,2,0,2,2,2,2,2,2,2,2,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,41,18,64,4,35,69,87,3,61,92,57,18,62,5,79,85,93,19,49,29,82,55,89,89,54,81,9,18,83,31,88,84,91,60,30,80,76,17,43,67,53,1,87,74,50,67,38,2,13,58,18,4,4,46,61,32,48,76,53,56,73,93,20,24,80,69,13,67,19,15,13,29,16,92,21,20,22,82,83,21,51,54,13,97,7,78,96,6,9,63,21,66,62,6,57,2,83,63,26,49,13,8,72,52,67,51,17,52,34,89,37,76,10,62,28,41,79,62,28,48,29,85,52,35,45,25,66,25,84,34,12,34,64,34,54,13,53,82,51,89,14,15,7,32,58,64,26,21,70,38,5,73,91,9,95,62,69,5,41,66,89,17,65,88,18,15,82,53,86,59,12,70,26,75,31,54,44,86,36,89,97,94,4,4,46,84,49,7,38,40,93,28,20,18,6,37,35,68,51,71,12,26,47,30,98,76,14,82,36,5,7,90,20,71,20,69,83,70,37,53,37,68,74,50,49,85,83,34,35,43,54,43,41,23,29,75,85,70,52,83,74,72,49,75,64,61,28,69,15,74,20,38,96,96,22,64,23,91,50,11,80,55,66,47,88,5,18,18,55,8,92,20,42,98,37,82,5,1,11,32,41,86,93,49,56,37,64,45,79,24,26,82,49,47,43,56,51,17,11,18,36,86,49,38,58,33,97,65,56,86,57,23,74,70,58,50,29,14,20,5,78,54,20,90,39,95,80,3,29,50,47,74,25,98,98,66,1,13,50,38,48,97,89,20,78,74,5,23,45,44,65,31,5,44,71,91,86,81,86,87,28,1,71,38,19,34,16,92,92,2,71,93,12,97,87,33,86,26,15,81,88,85,98,10,27,42,26,20,78,4,42,62,57,38,84,27,21,54,55,34,63,41,7,18,93,18,27,94,83,85,92,97,43,21,12,91,17,96,56,60,15,93,3,13,39,85,49,8,39,54,54,66,44,7,23,98,2,1,3,9,1,85,88,27,82,15,5,67,43,93,23,35,57,57,24,11,65,12,61,44,40,76,60,60,45,8,24,34,91,22,38,34,33,69,8,75,7,3,19,35,39,73,64,79,50,89,75,29,96,59,26,64,30,90,15,68,18,71,31,6,84,15,80,3,43,71,65,54,16,79,38,58,81,73,53,21,13,18,49,72,66,58,74,4,78,19,73,51,97,93,53,53,57,34,89,57,49,13,7,16,44,42,49,26,85,31,72,13,19,30,22,12,39,92,98,26,17,46,25,78,77,94,40,74,90,52,2,51,33,16,6,55,66,82,10,6,7,96,98,43,10,42,34,15,9,92,64,15,18,13,8,72,37,20,76,72,90,48,65,55,5,65,66,50,44,76,97,61,72,24,23,33,91,68,31,29,63,51,98,83,6,53,43,14,71,98,50,5,81,49,72,56,58,77,14,74,51,66,77,31,2,3,45,37,25,53,78,3,74,76,26,72,74,86,96,98,90,71,61,95,85,68,68,89,85,47,82,59,28,60,6,44,33,97,67,51,13,90,77,63,49,27,22,6,49,68,33,15,39,83,51,66,85,57,8,75,13,37,39,78,52,31,83,8,26,35,65,25,11,69,71,3,91,6,66,88,82,10,59,28,30,66,60,26,19,87,62,14,97,9,94,42,27,5,90,73,81,67,13,71,67,77,28,48,36,17,29,91,53,87,9,23,20,77,61,76,549350";
		Map<Long, Long> inputMap = new HashMap<Long, Long>();
		for (String s : inputString.split(",")) {
			//System.out.println("S:"+ s);
			inputMap.put((long) inputMap.size(), Long.valueOf(s));
		}
		inputMap.put(0l, 2l);
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
				System.out.printf("inputspointer:%d/%d%n", inputsPointer, inputs.size() );
				
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
