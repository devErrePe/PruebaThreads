package rp;

public abstract class CentroDeMonitoreo {

	protected int cantVacunadosHoy;
	
	public int getCantVacunadosHoy() {
		return cantVacunadosHoy;
	}

	public abstract void repotarInoculacion();

	public synchronized void repotarInoculacion(int cant) {
		cantVacunadosHoy += cant;
	}

}
