package advent19;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Advent19 {

	private static long x = 0;
	private static long y = 0;
	
	private static List<Long> inputs = new ArrayList<Long>();
	private static Map<String, Long> tractorBeamMap = new HashMap<String, Long>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point result = new Point();
		long begin = 500;
		for (x=begin; x<10000; x++) {
			System.out.println("x:"+x);
			for (y = begin;y<10000; y++) {
				//System.out.println(""+x+":"+y);
				inputs.clear();
				inputs.add(0, x);
				inputs.add(1, y);
				
				testcomp();
				
				
				if (tractorBeamMap.containsKey(""+x+":"+y) && tractorBeamMap.get(""+x+":"+y) == 1 && tractorBeamMap.containsKey(""+x+":"+(y-99)) && tractorBeamMap.get(""+x+":"+(y-99)) == 1 && tractorBeamMap.containsKey(""+(x-99)+":"+y) && tractorBeamMap.get(""+(x-99)+":"+y) == 1 && tractorBeamMap.containsKey(""+(x-99)+":"+(y-99)) && tractorBeamMap.get(""+(x-99)+":"+(y-99)) == 1 ) {
						
						
					result.x = (int) x-99;
					result.y = (int) y-99;
					x = 10001;
					y = 10001;
				}
					
			}
		}
		
		System.out.println(result.toString());
		//draw();
		
	}
	
	private static void draw() {
		int total = 0; 
	
		for (int i=0; i<1000; i++) {
			for (int j = 0;j<1000; j++) {

				if (!tractorBeamMap.containsKey(""+i+":"+j)) {
					System.out.print(".");
				} else if (tractorBeamMap.get(""+i+":"+j) == 0) {
					System.out.print(".");
				} else if (tractorBeamMap.get(""+i+":"+j) == 1) {
					System.out.print("#");
					total++;
				}
			}
			System.out.println();
		}
		System.out.println("total:"+total);
	}
	
	private static void output(long val) {
		tractorBeamMap.put(""+x+":"+y, val);
		//draw();
	}

	private static long testcomp() {
		boolean print = false;
		boolean output = false;
		String inputString = "109,424,203,1,21101,11,0,0,1106,0,282,21102,18,1,0,1105,1,259,1201,1,0,221,203,1,21101,0,31,0,1105,1,282,21102,1,38,0,1106,0,259,21001,23,0,2,22101,0,1,3,21102,1,1,1,21101,57,0,0,1106,0,303,1202,1,1,222,21002,221,1,3,20102,1,221,2,21101,259,0,1,21102,1,80,0,1105,1,225,21101,83,0,2,21101,91,0,0,1105,1,303,2102,1,1,223,20102,1,222,4,21102,259,1,3,21101,225,0,2,21101,225,0,1,21102,1,118,0,1105,1,225,20102,1,222,3,21101,0,51,2,21102,1,133,0,1105,1,303,21202,1,-1,1,22001,223,1,1,21102,1,148,0,1106,0,259,1201,1,0,223,21002,221,1,4,21002,222,1,3,21101,13,0,2,1001,132,-2,224,1002,224,2,224,1001,224,3,224,1002,132,-1,132,1,224,132,224,21001,224,1,1,21102,195,1,0,106,0,108,20207,1,223,2,21002,23,1,1,21102,-1,1,3,21101,0,214,0,1106,0,303,22101,1,1,1,204,1,99,0,0,0,0,109,5,2102,1,-4,249,21202,-3,1,1,21202,-2,1,2,22102,1,-1,3,21101,0,250,0,1105,1,225,22102,1,1,-4,109,-5,2106,0,0,109,3,22107,0,-2,-1,21202,-1,2,-1,21201,-1,-1,-1,22202,-1,-2,-2,109,-3,2106,0,0,109,3,21207,-2,0,-1,1206,-1,294,104,0,99,22101,0,-2,-2,109,-3,2105,1,0,109,5,22207,-3,-4,-1,1206,-1,346,22201,-4,-3,-4,21202,-3,-1,-1,22201,-4,-1,2,21202,2,-1,-1,22201,-4,-1,1,22101,0,-2,3,21101,0,343,0,1106,0,303,1105,1,415,22207,-2,-3,-1,1206,-1,387,22201,-3,-2,-3,21202,-2,-1,-1,22201,-3,-1,3,21202,3,-1,-1,22201,-3,-1,2,21202,-4,1,1,21102,384,1,0,1106,0,303,1105,1,415,21202,-4,-1,-4,22201,-4,-3,-4,22202,-3,-2,-2,22202,-2,-4,-4,22202,-3,-2,-3,21202,-4,-1,-2,22201,-3,-2,1,22101,0,1,-4,109,-5,2105,1,0";
		Map<Long, Long> inputMap = new HashMap<Long, Long>();
		for (String s : inputString.split(",")) {
			//System.out.println("S:"+ s);
			inputMap.put((long) inputMap.size(), Long.valueOf(s));
		}
		//inputMap.put(0l, 2l);//override movement logic
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
				long a = (inputMap.get(pointer) / 100) % 10;

				long input = inputs.get(inputsPointer);
				//long a = inputs.get(inputs.size()-1);
				//System.out.println(input);
				inputsPointer++;
				//long a = (inputMap.get(pointer) / 100) % 10;
				inputMap.put(inputMap.get(pointer+1)+(a==2?offset:0), input);
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

