package rp;

public class CentroDeMonitoreoSync extends CentroDeMonitoreo {

	@Override
	public synchronized void repotarInoculacion() {
		cantVacunadosHoy++;
	}

}
