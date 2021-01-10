package elo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void test1CV1CVAux() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoSync(); 
		
		CentroDeVacunacion CVCordoba = new CentroDeVacunacion("Hospital Central", "Cordoba", 2000);
		
		CVCordoba.recibirVacunas(10000);
		CVCordoba.comenzarAVacunar(mc);

		CentroDeVacunacion CVLaCalera = new CentroDeVacunacion("Hospital Rodrigo Bueno", "La Calera", 200);
		
		CVLaCalera.recibirVacunas(1000);
		CVLaCalera.comenzarAVacunar(CVCordoba);

		try {
			Thread.sleep(1000);
			while (CVCordoba.estaVacunando || CVLaCalera.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(2200, mc.getCantVacunadosHoy());
	}
	
	@Test
	void test1CV2CVAux() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoSync(); 
		
		CentroDeVacunacion CVCordoba = new CentroDeVacunacion("Hospital Central", "Cordoba", 1000);
		
		CVCordoba.recibirVacunas(10000);
		CVCordoba.comenzarAVacunar(mc);

		CentroDeVacunacion CVLaCalera = new CentroDeVacunacion("Hospital Rodrigo Bueno", "La Calera", 500);
		
		CVLaCalera.recibirVacunas(1000);
		CVLaCalera.comenzarAVacunar(CVCordoba);

		CentroDeVacunacion CVRioIII = new CentroDeVacunacion("Hospital J.D.Peron", "Rio III", 500);
		
		CVRioIII.recibirVacunas(1000);
		CVRioIII.comenzarAVacunar(CVCordoba);

		CentroDeVacunacion CVEmbalse = new CentroDeVacunacion("Clínica Cura Brochero", "Embalse", 500);
		
		CVEmbalse.recibirVacunas(1000);
		CVEmbalse.comenzarAVacunar(CVCordoba);
		
		try {
			Thread.sleep(1000);
			while (CVCordoba.estaVacunando || CVLaCalera.estaVacunando || CVRioIII.estaVacunando
					|| CVEmbalse.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(2500, mc.getCantVacunadosHoy());
	}

}
