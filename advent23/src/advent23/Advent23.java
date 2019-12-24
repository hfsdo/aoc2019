package advent23;

import java.util.ArrayList;
import java.util.List;

public class Advent23 {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<IntComp> intCompList = new ArrayList<IntComp>();
		List<Thread> threadList = new ArrayList<Thread>();
		
		for (int i = 0; i < 50; i++) {
			IntComp comp = new IntComp(intCompList, i);
			intCompList.add(comp);
			Thread thread = new Thread(comp);
			threadList.add(thread);
			thread.start();
		}
		
	}

}


