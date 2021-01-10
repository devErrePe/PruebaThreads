package elo;

public abstract class CentroDeMonitoreo {

	protected int cantVacunadosHoy;
	
	public int getCantVacunadosHoy() {
		return cantVacunadosHoy;
	}

	public abstract void repotarInoculacion();
}
