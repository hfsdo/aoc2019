package advent07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class intcomp implements Runnable {

	List<Integer> inputs = new ArrayList<Integer>();
	int output = 0;
	
	intcomp nextAmp = null;
	
	String letter = "";

	public intcomp(int phase, String ampLetter) {
		// TODO Auto-generated constructor stub
		inputs.add(0, phase);
		letter = ampLetter;
	}
	
	public void setNext(intcomp nextA) {
		nextAmp = nextA;
	}
	
	public int getOutput() {
		return output;
	}


	public void addInput(int input) {
		inputs.add(inputs.size(), input);
	}



	@Override
	public void run() {
		boolean print = false;
		// TODO Auto-generated method stub
		Integer[] input = new Integer[]{3,8,1001,8,10,8,105,1,0,0,21,38,63,88,97,118,199,280,361,442,99999,3,9,1002,9,3,9,101,2,9,9,1002,9,4,9,4,9,99,3,9,101,3,9,9,102,5,9,9,101,3,9,9,1002,9,3,9,101,3,9,9,4,9,99,3,9,1002,9,2,9,1001,9,3,9,102,3,9,9,101,2,9,9,1002,9,4,9,4,9,99,3,9,102,2,9,9,4,9,99,3,9,102,4,9,9,101,5,9,9,102,2,9,9,101,5,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,99};
		//Integer[] input = new Integer[] {3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5};
		//Integer[] input = new Integer[] {3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10};
		List<Integer> inputlist = new ArrayList<Integer>();
		inputlist = Arrays.asList(input);
		//1202 program alarm
		//input[1] = noun;//12;
		//input[2] = verb;//2;
		/*
				List<Integer> inputs = new ArrayList<Integer>();
				inputs = Arrays.asList(inputArr);
		 */
		Scanner s = new Scanner(System.in);

		int pointer = 0;
		int inputsPointer = 0;
		//int result = 0;


		//System.out.println("result" + Arrays.toString(input));
		while (pointer < inputlist.size()) {
			//System.out.println("atpointer: " + inputlist.get(pointer));
			int opcode = inputlist.get(pointer) % 100;
			if (print) {System.out.println(letter + " pointer: " + pointer);}
			if (print) {System.out.println(letter + " opcode: " + opcode);}
			if (opcode == 1) { 

				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));


				inputlist.set(inputlist.get(pointer+3), a+b);
				pointer += 4;
			} else if (opcode == 2) {
				int a = (inputlist.get(pointer) / 100) % 10;
				//System.out.println(a);
				//System.out.println(inputlist.get(pointer+1));
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				//System.out.println(b);
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));



				inputlist.set(inputlist.get(pointer+3), a*b);
				pointer += 4;
			} else if (opcode == 3) {
				//System.out.println("input?");
				//int a = s.nextInt();
				while (inputs.size() == inputsPointer) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int a = inputs.get(inputsPointer);
				inputsPointer++;
				inputlist.set(inputlist.get(pointer+1), a);
				pointer += 2;
			} else if (opcode == 4) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));
				output = a;
				nextAmp.addInput(a);
				if (print) {System.out.println(letter + " output: "+ a);}
				
				output = a;
				pointer += 2;
			} else if (opcode == 5) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				if (a != 0) {
					int b = (inputlist.get(pointer) / 1000) % 10;
					b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

					pointer = b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 6) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				if (a == 0) {
					int b = (inputlist.get(pointer) / 1000) % 10;
					b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

					pointer = b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 7) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

				if (a < b) {
					inputlist.set(inputlist.get(pointer+3), 1);
				} else {
					inputlist.set(inputlist.get(pointer+3), 0);
				}
				pointer += 4;
			} else if (opcode == 8) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

				if (a == b) {
					inputlist.set(inputlist.get(pointer+3), 1);
				} else {
					inputlist.set(inputlist.get(pointer+3), 0);
				}
				pointer += 4;
			} else if (opcode == 99) {
				if (print) {System.out.println(letter + " halted");}
				break;
			} else {
				System.out.println(letter + " error:" + inputlist.get(pointer));
				break;
			}
			//System.out.println("result" + Arrays.toString(input));

		}


		//System.out.println("result" + Arrays.toString(input));
		//return input[0];

	}

}

public class Advent07 {

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

		
		
		List<Integer> thrust = new ArrayList<Integer>();

		int low = 5;
		int high = 9;

		for(int i=low; i <= high; i++) {
			for(int j=low; j<=high;j++) {
				if (i!=j) {
					for(int k=low; k<=high;k++) {
						if (i!=k && j!=k) {
							for(int l=low;l<=high;l++) {
								if(i!=l && j!=l && k!=l) {
									for (int m=low;m<=high;m++) {
										if (i!=m && j!=m && k!=m && l!=m) {
											
											
											intcomp icampA = new intcomp(i, "A");
											intcomp icampB = new intcomp(j, "B");
											intcomp icampC = new intcomp(k, "C");
											intcomp icampD = new intcomp(l, "D");
											intcomp icampE = new intcomp(m, "E");
											
											icampA.addInput(0);
											
											icampA.setNext(icampB);
											icampB.setNext(icampC);
											icampC.setNext(icampD);
											icampD.setNext(icampE);
											icampE.setNext(icampA);
											
											Thread ampA = new Thread(icampA);
											Thread ampB = new Thread(icampB);
											Thread ampC = new Thread(icampC);
											Thread ampD = new Thread(icampD);
											Thread ampE = new Thread(icampE);

											
											ampA.start();
											ampB.start();
											ampC.start();
											ampD.start();
											ampE.start();
											
											
											while (ampE.isAlive()) {
												try {
													Thread.sleep(100);
													//System.out.println("sleeping");
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											System.out.println("out:"+icampE.getOutput());
											thrust.add(icampE.getOutput());
											
											/*
											int tmp;
											tmp = testcomp(new Integer[] {i,testcomp(new Integer[] {j,testcomp(new Integer[] {k,testcomp(new Integer[] {l,testcomp(new Integer[] {m,0})})})})});
											System.out.println(""+i+":"+j+":"+k+":"+l+":"+m);
											System.out.println("thrust:" + tmp);
											thrust.add(tmp);
											*/
										}
									}
								}
							}
						}
					}
				}
			}
		}


		Collections.sort(thrust);
		Collections.reverse(thrust);
		System.out.println("first:"+thrust.get(0));
		System.out.println(thrust.get(0));

		/*
		int phase1 = testcomp(new int[] {4,0});
		int phase2 = testcomp(new int[] {3,phase1});
		int phase3 = testcomp(new int[] {2,phase2});
		int phase4 = testcomp(new int[] {1,phase3});
		int phase5 = testcomp(new int[] {0,phase4});

		System.out.println("thrust:"+phase5);
		 */

	}

	private static int feedloop(int input) {
		List<Integer> thrust = new ArrayList<Integer>();

		int low = 5;
		int high = 9;

		for(int i=low; i <= high; i++) {
			for(int j=low; j<=high;j++) {
				if (i!=j) {
					for(int k=low; k<=high;k++) {
						if (i!=k && j!=k) {
							for(int l=low;l<=high;l++) {
								if(i!=l && j!=l && k!=l) {
									for (int m=low;m<=high;m++) {
										if (i!=m && j!=m && k!=m && l!=m) {
											int tmp;
											tmp = testcomp(new Integer[] {i,testcomp(new Integer[] {j,testcomp(new Integer[] {k,testcomp(new Integer[] {l,testcomp(new Integer[] {m,input})})})})});
											System.out.println(""+i+":"+j+":"+k+":"+l+":"+m);
											System.out.println("thrust:" + tmp);
											thrust.add(tmp);
										}
									}
								}
							}
						}
					}
				}
			}
		}


		Collections.sort(thrust);
		Collections.reverse(thrust);
		System.out.println("first:"+thrust.get(0));
		return thrust.get(0);
	}

	private static int testcomp(Integer[] inputArr) {
		//int[] input = new int[]{3,8,1001,8,10,8,105,1,0,0,21,38,63,88,97,118,199,280,361,442,99999,3,9,1002,9,3,9,101,2,9,9,1002,9,4,9,4,9,99,3,9,101,3,9,9,102,5,9,9,101,3,9,9,1002,9,3,9,101,3,9,9,4,9,99,3,9,1002,9,2,9,1001,9,3,9,102,3,9,9,101,2,9,9,1002,9,4,9,4,9,99,3,9,102,2,9,9,4,9,99,3,9,102,4,9,9,101,5,9,9,102,2,9,9,101,5,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,99};
		Integer[] input = new Integer[] {3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5};
		//Integer[] input = new Integer[] {3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0};
		List<Integer> inputlist = new ArrayList<Integer>();
		inputlist = Arrays.asList(input);
		//1202 program alarm
		//input[1] = noun;//12;
		//input[2] = verb;//2;

		List<Integer> inputs = new ArrayList<Integer>();
		inputs = Arrays.asList(inputArr);

		Scanner s = new Scanner(System.in);

		int pointer = 0;
		int inputsPointer = 0;
		int result = 0;


		//System.out.println("result" + Arrays.toString(input));
		while (pointer < inputlist.size()) {
			//System.out.println("atpointer: " + inputlist.get(pointer));
			int opcode = inputlist.get(pointer) % 100;
			System.out.println("pointer: " + pointer);
			System.out.println("opcode: " + opcode);
			if (opcode == 1) { 

				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));


				inputlist.set(inputlist.get(pointer+3), a+b);
				pointer += 4;
			} else if (opcode == 2) {
				int a = (inputlist.get(pointer) / 100) % 10;
				//System.out.println(a);
				//System.out.println(inputlist.get(pointer+1));
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				//System.out.println(b);
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));



				inputlist.set(inputlist.get(pointer+3), a*b);
				pointer += 4;
			} else if (opcode == 3) {
				//System.out.println("input?");
				//int a = s.nextInt();
				int a = inputs.get(inputsPointer);
				inputsPointer++;
				inputlist.set(inputlist.get(pointer+1), a);
				pointer += 2;
			} else if (opcode == 4) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));


				System.out.println("output: "+ a);
				result = a;
				pointer += 2;
			} else if (opcode == 5) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				if (a != 0) {
					int b = (inputlist.get(pointer) / 1000) % 10;
					b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

					pointer = b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 6) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				if (a == 0) {
					int b = (inputlist.get(pointer) / 1000) % 10;
					b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

					pointer = b;
				} else {
					pointer += 3;
				}
			} else if (opcode == 7) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

				if (a < b) {
					inputlist.set(inputlist.get(pointer+3), 1);
				} else {
					inputlist.set(inputlist.get(pointer+3), 0);
				}
				pointer += 4;
			} else if (opcode == 8) {
				int a = (inputlist.get(pointer) / 100) % 10;
				a = a==1?inputlist.get(pointer+1):inputlist.get(inputlist.get(pointer+1));

				int b = (inputlist.get(pointer) / 1000) % 10;
				b = b==1?inputlist.get(pointer+2):inputlist.get(inputlist.get(pointer+2));

				if (a == b) {
					inputlist.set(inputlist.get(pointer+3), 1);
				} else {
					inputlist.set(inputlist.get(pointer+3), 0);
				}
				pointer += 4;
			} else if (opcode == 99) {
				System.out.println("halted");
				break;
			} else {
				System.out.println("error:" + inputlist.get(pointer));
				break;
			}
			//System.out.println("result" + Arrays.toString(input));

		}


		//System.out.println("result" + Arrays.toString(input));
		//return input[0];
		return result;
	}

}
