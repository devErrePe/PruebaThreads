package rp;

import java.util.concurrent.locks.ReentrantLock;

public class CentroDeMonitoreoLock extends CentroDeMonitoreo {

	ReentrantLock lock = new ReentrantLock();

	@Override
	public void repotarInoculacion() {
		
		lock.lock();
		
		try {
			this.cantVacunadosHoy++;
		} finally {
			lock.unlock();
		}
	}
}