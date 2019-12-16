package advent16;

import java.util.ArrayList;
import java.util.List;

public class Advent16 {
	public static void main(String[] args) {

		String input = "59731816011884092945351508129673371014862103878684944826017645844741545300230138932831133873839512146713127268759974246245502075014905070039532876129205215417851534077861438833829150700128859789264910166202535524896960863759734991379392200570075995540154404564759515739872348617947354357737896622983395480822393561314056840468397927687908512181180566958267371679145705350771757054349846320639601111983284494477902984330803048219450650034662420834263425046219982608792077128250835515865313986075722145069152768623913680721193045475863879571787112159970381407518157406924221437152946039000886837781446203456224983154446561285113664381711600293030463013";
		//String input = "03036732577212944063491565474664";
		int offset = Integer.parseInt(input.substring(0, 7));
		System.out.println("offset:"+offset);


		//char[] inputchars = input.toCharArray();

		List<Integer> inputList = new ArrayList<Integer>();
		for (int multi = 0; multi < 10000;multi++) {
			for (int i =0; i<input.length();i++) {
				inputList.add(Integer.parseInt(input.substring(i,i+1)));
			}
		}

		System.out.println("size:"+inputList.size());

		int[] phasevals = new int[] {0,1,0,-1};
		int phase = 0;

		String result = input;

		for (int step = 0; step<100;step++) {
			//inputchars = result.toCharArray();
			result = "";
			for (long i = 0; i < inputList.size(); i++) {
				int tmp = 0;

				phase = 0;
				//System.out.println("phase:"+phase);
				//System.out.println("phase:"+phasevals[phase]);

				for (long j = 0; j < inputList.size(); j++) {
					//char c = inputchars[(int) j];
					int c = inputList.get((int) j);
					if ((j+1)%(i+1)==0) {
						phase++;
						phase = phase==4?0:phase;
					}
					//System.out.println(phasevals[phase]);
					
					//System.out.printf("%d*%d + ",Integer.parseInt(String.valueOf(c)), phasevals[phase]);
					tmp += c * phasevals[phase];
				}

				if (i%1000 == 0) {System.out.printf("%d = %d%n", i, Math.abs(tmp)%10);}
				result += Math.abs(tmp)%10;
			}
			System.out.println("step:"+step);
			inputList.clear();
			for (int i =0; i<result.length();i++) {
				inputList.add(Integer.parseInt(result.substring(i,i+1)));
			}

		}
		System.out.println("result:"+result.substring(offset, offset+8));
	}
}
