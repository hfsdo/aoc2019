package advent09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Advent09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		for (int noun = 0; noun < 100; noun++) {
			for (int verb = 0; verb < 100; verb++) {
				if (testcomp(noun,verb) == 19690720) {
					System.out.println("noun:"+noun);
					System.out.println("verb:"+verb);
				}
				
				
			}
		}
		*/
		System.out.println(testcomp());
		
		
		
	}
	
	
	private static long testcomp() {
		boolean print = false;
		boolean output = true;
		Integer[] input = new Integer[]{1102,34463338,34463338,63,1007,63,34463338,63,1005,63,53,1102,1,3,1000,109,988,209,12,9,1000,209,6,209,3,203,0,1008,1000,1,63,1005,63,65,1008,1000,2,63,1005,63,904,1008,1000,0,63,1005,63,58,4,25,104,0,99,4,0,104,0,99,4,17,104,0,99,0,0,1102,521,1,1028,1101,0,33,1011,1101,0,22,1006,1101,28,0,1018,1102,37,1,1008,1102,1,20,1019,1101,0,405,1026,1101,25,0,1015,1101,330,0,1023,1101,0,29,1016,1101,0,560,1025,1101,24,0,1017,1102,516,1,1029,1102,333,1,1022,1102,1,34,1012,1101,0,402,1027,1101,0,1,1021,1102,36,1,1013,1102,30,1,1002,1101,21,0,1000,1102,1,23,1005,1102,39,1,1003,1102,1,32,1007,1102,26,1,1004,1101,565,0,1024,1101,0,0,1020,1101,0,31,1014,1101,27,0,1001,1101,0,38,1009,1101,0,35,1010,109,-3,2102,1,10,63,1008,63,32,63,1005,63,203,4,187,1106,0,207,1001,64,1,64,1002,64,2,64,109,26,21108,40,40,-4,1005,1019,229,4,213,1001,64,1,64,1105,1,229,1002,64,2,64,109,-20,2102,1,-3,63,1008,63,22,63,1005,63,253,1001,64,1,64,1105,1,255,4,235,1002,64,2,64,109,-10,1208,10,39,63,1005,63,277,4,261,1001,64,1,64,1106,0,277,1002,64,2,64,109,15,2107,20,-8,63,1005,63,299,4,283,1001,64,1,64,1106,0,299,1002,64,2,64,109,-8,1208,3,40,63,1005,63,315,1106,0,321,4,305,1001,64,1,64,1002,64,2,64,109,29,2105,1,-6,1106,0,339,4,327,1001,64,1,64,1002,64,2,64,109,-18,1205,10,353,4,345,1106,0,357,1001,64,1,64,1002,64,2,64,109,11,1206,-1,373,1001,64,1,64,1105,1,375,4,363,1002,64,2,64,109,-2,1205,0,391,1001,64,1,64,1106,0,393,4,381,1002,64,2,64,109,10,2106,0,-3,1106,0,411,4,399,1001,64,1,64,1002,64,2,64,109,-18,21108,41,39,3,1005,1015,427,1105,1,433,4,417,1001,64,1,64,1002,64,2,64,109,-7,21101,42,0,6,1008,1011,45,63,1005,63,457,1001,64,1,64,1106,0,459,4,439,1002,64,2,64,109,-14,2101,0,9,63,1008,63,21,63,1005,63,481,4,465,1105,1,485,1001,64,1,64,1002,64,2,64,109,22,1207,-7,21,63,1005,63,505,1001,64,1,64,1106,0,507,4,491,1002,64,2,64,109,15,2106,0,0,4,513,1106,0,525,1001,64,1,64,1002,64,2,64,109,-14,21101,43,0,-1,1008,1013,43,63,1005,63,551,4,531,1001,64,1,64,1106,0,551,1002,64,2,64,109,10,2105,1,0,4,557,1106,0,569,1001,64,1,64,1002,64,2,64,109,-12,21102,44,1,3,1008,1015,44,63,1005,63,595,4,575,1001,64,1,64,1105,1,595,1002,64,2,64,109,-4,1201,-8,0,63,1008,63,21,63,1005,63,621,4,601,1001,64,1,64,1106,0,621,1002,64,2,64,109,5,2108,37,-5,63,1005,63,639,4,627,1105,1,643,1001,64,1,64,1002,64,2,64,109,-14,1202,1,1,63,1008,63,21,63,1005,63,669,4,649,1001,64,1,64,1105,1,669,1002,64,2,64,109,-2,1207,7,27,63,1005,63,691,4,675,1001,64,1,64,1106,0,691,1002,64,2,64,109,13,2107,33,-3,63,1005,63,711,1001,64,1,64,1105,1,713,4,697,1002,64,2,64,109,19,1206,-9,727,4,719,1105,1,731,1001,64,1,64,1002,64,2,64,109,-24,1202,0,1,63,1008,63,20,63,1005,63,755,1001,64,1,64,1106,0,757,4,737,1002,64,2,64,109,8,21102,45,1,-3,1008,1010,46,63,1005,63,781,1001,64,1,64,1106,0,783,4,763,1002,64,2,64,109,-15,2108,40,10,63,1005,63,799,1105,1,805,4,789,1001,64,1,64,1002,64,2,64,109,20,21107,46,45,-1,1005,1017,821,1106,0,827,4,811,1001,64,1,64,1002,64,2,64,109,-23,1201,6,0,63,1008,63,29,63,1005,63,847,1106,0,853,4,833,1001,64,1,64,1002,64,2,64,109,17,21107,47,48,2,1005,1014,875,4,859,1001,64,1,64,1106,0,875,1002,64,2,64,109,-10,2101,0,-2,63,1008,63,20,63,1005,63,895,1105,1,901,4,881,1001,64,1,64,4,64,99,21102,27,1,1,21101,0,915,0,1105,1,922,21201,1,37574,1,204,1,99,109,3,1207,-2,3,63,1005,63,964,21201,-2,-1,1,21102,942,1,0,1105,1,922,22102,1,1,-1,21201,-2,-3,1,21101,957,0,0,1105,1,922,22201,1,-1,-2,1105,1,968,21201,-2,0,-2,109,-3,2105,1,0};
		//Long[] input = new Long[] {104l,1125899906842624l,99l};
		//Integer[] input = new Integer[] {3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10};
		//List<Integer> inputlist = new ArrayList<Integer>();
		//inputlist = Arrays.asList(input);
		
		Map<Long, Long> inputMap = new HashMap<Long, Long>();
		for (int i = 0; i<input.length;i++) {
			inputMap.put((long) i, (long) input[i]);
		}
		
		//1202 program alarm
		//input[1] = noun;//12;
		//input[2] = verb;//2;
		/*
				List<Integer> inputs = new ArrayList<Integer>();
				inputs = Arrays.asList(inputArr);
		 */
		Scanner s = new Scanner(System.in);

		long pointer = 0;
		long inputsPointer = 0;
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
				System.out.println("input?");
				long in = s.nextLong();
				/*
				while (inputs.size() == inputsPointer) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int a = inputs.get(inputsPointer);
				*/
				//inputsPointer++;
				long a = (inputMap.get(pointer) / 100) % 10;
				inputMap.put(inputMap.get(pointer+1)+(a==2?offset:0), in);
				pointer += 2;
			} else if (opcode == 4) {
				long a = (inputMap.get(pointer) / 100) % 10;
				try {
					a = a==1?inputMap.get(pointer+1):inputMap.get(inputMap.get(pointer+1)+(a==2?offset:0));
				} catch(NullPointerException ne) {
					a = 0;
				}
				
				if (print || output) {System.out.println("output: "+ a);}
				
				
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
	
	private static int testcompOLD(int noun, int verb) {
		int[] input = new int[]{3,225,1,225,6,6,1100,1,238,225,104,0,1101,81,30,225,1102,9,63,225,1001,92,45,224,101,-83,224,224,4,224,102,8,223,223,101,2,224,224,1,224,223,223,1102,41,38,225,1002,165,73,224,101,-2920,224,224,4,224,102,8,223,223,101,4,224,224,1,223,224,223,1101,18,14,224,1001,224,-32,224,4,224,1002,223,8,223,101,3,224,224,1,224,223,223,1101,67,38,225,1102,54,62,224,1001,224,-3348,224,4,224,1002,223,8,223,1001,224,1,224,1,224,223,223,1,161,169,224,101,-62,224,224,4,224,1002,223,8,223,101,1,224,224,1,223,224,223,2,14,18,224,1001,224,-1890,224,4,224,1002,223,8,223,101,3,224,224,1,223,224,223,1101,20,25,225,1102,40,11,225,1102,42,58,225,101,76,217,224,101,-153,224,224,4,224,102,8,223,223,1001,224,5,224,1,224,223,223,102,11,43,224,1001,224,-451,224,4,224,1002,223,8,223,101,6,224,224,1,223,224,223,1102,77,23,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,8,226,677,224,1002,223,2,223,1006,224,329,1001,223,1,223,7,226,226,224,102,2,223,223,1006,224,344,101,1,223,223,108,677,677,224,1002,223,2,223,1006,224,359,101,1,223,223,1107,226,677,224,1002,223,2,223,1005,224,374,101,1,223,223,1008,677,226,224,1002,223,2,223,1005,224,389,101,1,223,223,1007,677,226,224,1002,223,2,223,1005,224,404,1001,223,1,223,1107,677,226,224,1002,223,2,223,1005,224,419,1001,223,1,223,108,677,226,224,102,2,223,223,1006,224,434,1001,223,1,223,7,226,677,224,102,2,223,223,1005,224,449,1001,223,1,223,107,226,226,224,102,2,223,223,1006,224,464,101,1,223,223,107,677,226,224,102,2,223,223,1006,224,479,101,1,223,223,1007,677,677,224,1002,223,2,223,1006,224,494,1001,223,1,223,1008,226,226,224,1002,223,2,223,1006,224,509,101,1,223,223,7,677,226,224,1002,223,2,223,1006,224,524,1001,223,1,223,1007,226,226,224,102,2,223,223,1006,224,539,101,1,223,223,8,677,226,224,1002,223,2,223,1006,224,554,101,1,223,223,1008,677,677,224,102,2,223,223,1006,224,569,101,1,223,223,1108,677,226,224,102,2,223,223,1005,224,584,101,1,223,223,107,677,677,224,102,2,223,223,1006,224,599,1001,223,1,223,1108,677,677,224,1002,223,2,223,1006,224,614,1001,223,1,223,1107,677,677,224,1002,223,2,223,1005,224,629,1001,223,1,223,108,226,226,224,1002,223,2,223,1005,224,644,101,1,223,223,8,226,226,224,1002,223,2,223,1005,224,659,101,1,223,223,1108,226,677,224,1002,223,2,223,1006,224,674,101,1,223,223,4,223,99,226};
		//int[] input = new int[] {1,9,10,3,2,3,11,0,99,30,40,50};
		//int[] input = new int[] {3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
		//1202 program alarm
		//input[1] = noun;//12;
		//input[2] = verb;//2;
		
		Scanner s = new Scanner(System.in);
		
		int pointer = 0;
		
		
		//System.out.println("result" + Arrays.toString(input));
		while (pointer < input.length) {
			//System.out.println("atpointer: " + input[pointer]);
			int opcode = input[pointer] % 100;
			System.out.println("opcode: " + opcode);
			if (opcode == 1) { 
				
				int a = (input[pointer] / 100) % 10;
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				
				int b = (input[pointer] / 1000) % 10;
				b = b==1?input[pointer+2]:input[input[pointer+2]];
				
				input[input[pointer+3]] = a+b;
				pointer += 4;
			} else if (opcode == 2) {
				int a = (input[pointer] / 100) % 10;
				//System.out.println(a);
				//System.out.println(input[pointer+1]);
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				
				int b = (input[pointer] / 1000) % 10;
				//System.out.println(b);
				b = b==1?input[pointer+2]:input[input[pointer+2]];
				
				
				
				input[input[pointer+3]] = a*b;
				pointer += 4;
			} else if (opcode == 3) {
				System.out.println("input?");
				int a = s.nextInt();
				input[input[pointer+1]] = a;
				pointer += 2;
			} else if (opcode == 4) {
				int a = (input[pointer] / 100) % 10;
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				System.out.println("output: "+ a);
				pointer += 2;
			} else if (opcode == 5) {
				int a = (input[pointer] / 100) % 10;
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				
				if (a != 0) {
					int b = (input[pointer] / 1000) % 10;
					b = b==1?input[pointer+2]:input[input[pointer+2]];
					
					pointer = b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 6) {
				int a = (input[pointer] / 100) % 10;
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				
				if (a == 0) {
					int b = (input[pointer] / 1000) % 10;
					b = b==1?input[pointer+2]:input[input[pointer+2]];
					
					pointer = b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 7) {
				int a = (input[pointer] / 100) % 10;
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				
				int b = (input[pointer] / 1000) % 10;
				b = b==1?input[pointer+2]:input[input[pointer+2]];
				
				if (a < b) {
					input[input[pointer+3]] = 1;
				} else {
					input[input[pointer+3]] = 0;
				}
				pointer += 4;
			} else if (opcode == 8) {
				int a = (input[pointer] / 100) % 10;
				a = a==1?input[pointer+1]:input[input[pointer+1]];
				
				int b = (input[pointer] / 1000) % 10;
				b = b==1?input[pointer+2]:input[input[pointer+2]];
				
				if (a == b) {
					input[input[pointer+3]] = 1;
				} else {
					input[input[pointer+3]] = 0;
				}
				pointer += 4;
			} else if (opcode == 99) {
				System.out.println("halted");
				break;
			} else {
				System.out.println("error:" + input[pointer]);
				break;
			}
			//System.out.println("result" + Arrays.toString(input));
			
		}
		
		
		//System.out.println("result" + Arrays.toString(input));
		return input[0];
	}

}
