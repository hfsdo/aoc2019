package advent23;

import java.util.ArrayList;
import java.util.List;

public class Advent23 {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<IntComp> intCompList = new ArrayList<IntComp>();
		List<Thread> threadList = new ArrayList<Thread>();
		
		NAT natcomp = new NAT(intCompList);
		
		for (int i = 0; i < 50; i++) {
			IntComp comp = new IntComp(intCompList, i, natcomp);
			intCompList.add(comp);
			
		}
		
		for (IntComp comp : intCompList) {
			Thread thread = new Thread(comp);
			threadList.add(thread);
			thread.start();
		}
		Thread thread = new Thread(natcomp);
		thread.start();
		
	}

}


