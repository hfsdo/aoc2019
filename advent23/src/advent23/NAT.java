package advent23;

import java.util.ArrayList;
import java.util.List;

public class NAT implements Runnable {

	private long prevY = -1;
	private long[] packet = new long[2]; 
	private boolean cansend = false;
	private List<IntComp> intCompList = new ArrayList<IntComp>();

	public NAT(List<IntComp> intComps) {
		// TODO Auto-generated constructor stub
		packet[0] = -1;
		packet[1] = -1;
		intCompList = intComps;
	}

	public void setPacket(long x, long y) {
		packet[0] = x;
		packet[1] = y;
		cansend = true;
		//System.out.printf("NAT:X:%d:Y:%d%n", packet[0], packet[1]);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		checkQueues();
	}

	private void checkQueues() {
		boolean allEmpty = true;
		boolean running = true;

		while (running) {
			allEmpty = true;
			for (IntComp intComp : intCompList) {
				if (!intComp.isQueueEmpty()) {
					allEmpty = false;
					break;
				}
			}
			if (allEmpty && cansend) {
				intCompList.get(0).addInputs(packet[0], packet[1]);
				cansend = false;
				System.out.printf("put:X:%d:Y:%d%n", packet[0], packet[1]);
				if (packet[1] == prevY) {
					System.out.printf("double:X:%d:Y:%d%n", packet[0], packet[1]);
				} else {
					prevY = packet[1];
				}
			} else {
				//System.out.print(".");
			}
		}


	}

}
