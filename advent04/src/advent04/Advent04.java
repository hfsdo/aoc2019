package advent04;

public class Advent04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int low = 284639;
		int high = 748759;
		
		
		
		int count = 0;
		
		for (int i = low; i <= high; i++) {
			
			String tests = String.valueOf(i);
			
			
			int[] testArr = new int[tests.length()];
			
			for (int j = 0; j < tests.length(); j++) {
				testArr[j] = Integer.parseInt(tests.substring(j, j+1));
				
			}
			
			boolean bIncrease = true;
			
			for (int j = 0; j < tests.length()-1; j++) {
				if (testArr[j] > testArr[j+1]) {
					bIncrease = false;
					break;
				}
				
				
			}
			boolean bDouble = false;
			for (int j = 0; j < tests.length()-1; j++) {
				
				if (j != 0 && j != tests.length() - 2) {
					
					if (testArr[j] == testArr[j+1]) {
						
						if (testArr[j] != testArr[j-1] && testArr[j+1] != testArr[j+2]) {
							bDouble = true;
						}
					}
				} else if (j == 0) {
					if (testArr[j] == testArr[j+1]) {
						
						if (testArr[j+1] != testArr[j+2]) {
							bDouble = true;
						}
					}
				} else if (j == tests.length() -2) {
					if (testArr[j] == testArr[j+1]) {
						
						if (testArr[j] != testArr[j-1]) {
							bDouble = true;
						}
					}
				}
				
				
				
			}
			
			if (bIncrease && bDouble) {
				System.out.println(tests);
				count += 1;
			}
			
			
		}
		
		System.out.println("result: " + count);
		
		
	}

}
