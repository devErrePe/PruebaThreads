package elo;

public class CentroDeVacunacion extends CentroDeMonitoreo {
	
	String nombre;
	String localidad;
	
	int cantDosis;
	int capacidadDeVacunacionDiaria;
	boolean estaVacunando;
	
	int cantVacunadosDeOtrosCV;

	public CentroDeVacunacion(String nombre, String localidad, int capacidadDeVacunacionDiaria) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.capacidadDeVacunacionDiaria = capacidadDeVacunacionDiaria;
	}

	public boolean estaVacunando() {
		return estaVacunando;
	}

	public void recibirVacunas(int cantDosis) {
		this.cantDosis = cantDosis;
	}
	
	public void comenzarAVacunar(CentroDeMonitoreo mc) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {

				for (int i = 0; i < capacidadDeVacunacionDiaria && cantDosis > 0; i++) {
					
					estaVacunando = true;
					mc.repotarInoculacion();
					cantDosis--;
 
					System.out.println(nombre + " de " + localidad + " inoculó a un paciente. Aún conserva " + cantDosis + " dosis.");
		
					try {
						Thread.sleep(Double.valueOf(Math.ceil(500/((float)capacidadDeVacunacionDiaria/24))).intValue());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (cantDosis == 0)
					System.out.println(nombre + " de " + localidad + " se quedó sin dosis!");

				estaVacunando = false;
				mc.repotarInoculacion(cantVacunadosDeOtrosCV);
			}
		};
		
		new Thread(r).start();
	}

	@Override
	public void repotarInoculacion() {
		cantVacunadosDeOtrosCV++;
	}
}
