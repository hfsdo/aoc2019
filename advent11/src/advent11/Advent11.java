package advent11;

import java.awt.Point;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Advent11 {

	private static List<Long> inputs = new ArrayList<Long>();
	private static Map<String, String> hull = new HashMap<String, String>();
	private static int x = 0;
	private static int y = 0;
	private static int angle = 0;
	private static int paint = 0;
	private static int total = 0;
	private static boolean move = false;
	private static Point topLeft = new Point(0,0);
	private static Point bottomRight = new Point(0,0);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		
		inputs.add(1l);
		
		testcomp();
		System.out.println("painted:"+paint);
		System.out.println("total:"+total);
		
		
		System.out.println(topLeft.toString());
		System.out.println(bottomRight.toString());
		for (int j = topLeft.x;j>=bottomRight.x; j--) {
			for (int i=topLeft.y; i<=bottomRight.y; i++) {
			
				if (hull.containsKey(""+j+":"+i)) {
					System.out.print(hull.get(""+j+":"+i));
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		
	}

	private static void output(long val) {
		if (move) {
			angle = val==0?angle-90:angle+90;
			angle = angle<0?angle+360:angle;
			angle = angle>=360?angle-360:angle;
			System.out.println("angle:"+angle);
			if (angle==0) {
				x++;
			} else if (angle==180) {
				x--;
			} else if (angle==90) {
				y++;
			} else if (angle==270) {
				y--;
			}
			if (hull.containsKey(""+x+":"+y)) {
				if (hull.get(""+x+":"+y).equals(".")) {
					inputs.add(0l);
				} else if (hull.get(""+x+":"+y).equals("#")) {
					inputs.add(1l);
				}
			} else {
				inputs.add(0l);
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
			
			move = false;
		} else {
			String toPaint = val==0?".":"#";
			System.out.println("topaint:"+toPaint);
			if (!hull.containsKey(""+x+":"+y)) {
				paint++;
			} else if (!hull.get(""+x+":"+y).equals(toPaint)) {
				//paint++;
			}
			total++;
			hull.put(""+x+":"+y, toPaint);
			move = true;
		}
	}
	
	private static long testcomp() {
		boolean print = false;
		boolean output = true;
		String inputString = "3,8,1005,8,324,1106,0,11,0,0,0,104,1,104,0,3,8,1002,8,-1,10,1001,10,1,10,4,10,1008,8,1,10,4,10,1001,8,0,29,1,1107,14,10,1006,0,63,1006,0,71,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,1,10,4,10,1002,8,1,61,1,103,18,10,1006,0,14,1,105,7,10,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,1,10,4,10,101,0,8,94,1006,0,37,1006,0,55,2,1101,15,10,3,8,1002,8,-1,10,1001,10,1,10,4,10,1008,8,0,10,4,10,101,0,8,126,2,1006,12,10,3,8,102,-1,8,10,101,1,10,10,4,10,1008,8,1,10,4,10,1001,8,0,152,3,8,102,-1,8,10,1001,10,1,10,4,10,108,0,8,10,4,10,101,0,8,173,1006,0,51,1006,0,26,3,8,102,-1,8,10,101,1,10,10,4,10,1008,8,0,10,4,10,1001,8,0,202,2,8,18,10,1,103,19,10,1,1102,1,10,1006,0,85,3,8,102,-1,8,10,1001,10,1,10,4,10,108,0,8,10,4,10,1001,8,0,238,2,1002,8,10,1006,0,41,3,8,102,-1,8,10,1001,10,1,10,4,10,108,0,8,10,4,10,101,0,8,267,2,1108,17,10,2,105,11,10,1006,0,59,1006,0,90,3,8,1002,8,-1,10,1001,10,1,10,4,10,1008,8,1,10,4,10,1001,8,0,304,101,1,9,9,1007,9,993,10,1005,10,15,99,109,646,104,0,104,1,21102,936735777688,1,1,21101,341,0,0,1105,1,445,21101,0,937264173716,1,21101,352,0,0,1106,0,445,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,21101,3245513819,0,1,21102,1,399,0,1105,1,445,21102,1,29086470235,1,21102,410,1,0,1105,1,445,3,10,104,0,104,0,3,10,104,0,104,0,21101,825544712960,0,1,21102,1,433,0,1106,0,445,21102,825460826472,1,1,21101,0,444,0,1106,0,445,99,109,2,22102,1,-1,1,21101,0,40,2,21101,0,476,3,21102,466,1,0,1105,1,509,109,-2,2105,1,0,0,1,0,0,1,109,2,3,10,204,-1,1001,471,472,487,4,0,1001,471,1,471,108,4,471,10,1006,10,503,1101,0,0,471,109,-2,2106,0,0,0,109,4,2101,0,-1,508,1207,-3,0,10,1006,10,526,21101,0,0,-3,21202,-3,1,1,21201,-2,0,2,21101,0,1,3,21101,0,545,0,1105,1,550,109,-4,2105,1,0,109,5,1207,-3,1,10,1006,10,573,2207,-4,-2,10,1006,10,573,21202,-4,1,-4,1106,0,641,21202,-4,1,1,21201,-3,-1,2,21202,-2,2,3,21101,0,592,0,1105,1,550,22101,0,1,-4,21101,1,0,-1,2207,-4,-2,10,1006,10,611,21102,1,0,-1,22202,-2,-1,-2,2107,0,-3,10,1006,10,633,22101,0,-1,1,21102,633,1,0,105,1,508,21202,-2,-1,-2,22201,-4,-2,-4,109,-5,2105,1,0";
		Map<Long, Long> inputMap = new HashMap<Long, Long>();
		for (String s : inputString.split(",")) {
			System.out.println("S:"+ s);
			inputMap.put((long) inputMap.size(), Long.valueOf(s));
		}
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
				long a = inputs.get(inputsPointer);
				
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
