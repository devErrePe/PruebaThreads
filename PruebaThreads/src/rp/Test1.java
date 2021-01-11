package rp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Test1 {

	@Test
	void test1CVSinDosis() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoBásico(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(500);
		CVOlavarria.comenzarAVacunar(mc);
		
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(500, mc.getCantVacunadosHoy());
	}
	
	@Test
	void test1CVBasico() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoBásico(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);
		
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(1000, mc.getCantVacunadosHoy());
	}
	
	@Test
	void Test2CVBasico() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoBásico(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);

		CentroDeVacunacion CVCABA = new CentroDeVacunacion("Hospital Pirovano", "C.A.B.A.", 1000);
		
		CVCABA.recibirVacunas(20000);
		CVCABA.comenzarAVacunar(mc);

		
		// ESPERA A QUE TERMINEN DE VACUNAR TODOS
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando || CVCABA.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(2000, mc.getCantVacunadosHoy());
	}
	
	
	@Test
	void Test3CVBasico() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoBásico(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);

		CentroDeVacunacion CVCABA = new CentroDeVacunacion("Hospital Pirovano", "C.A.B.A.", 1000);
		
		CVCABA.recibirVacunas(20000);
		CVCABA.comenzarAVacunar(mc);

		CentroDeVacunacion CVPBA = new CentroDeVacunacion("Hospital Ballestrini", "La Plata", 1000);
		
		CVPBA.recibirVacunas(20000);
		CVPBA.comenzarAVacunar(mc);
		
		// ESPERA A QUE TERMINEN DE VACUNAR TODOS
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando || CVCABA.estaVacunando || CVPBA.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(3000, mc.getCantVacunadosHoy());
	}

	
	@Test
	void Test2CVSync() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoSync(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);

		CentroDeVacunacion CVCABA = new CentroDeVacunacion("Hospital Pirovano", "C.A.B.A.", 1000);
		
		CVCABA.recibirVacunas(20000);
		CVCABA.comenzarAVacunar(mc);

		
		// ESPERA A QUE TERMINEN DE VACUNAR TODOS
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando || CVCABA.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(2000, mc.getCantVacunadosHoy());
	}
	
	
	@Test
	void Test3CVSync() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoSync(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);

		CentroDeVacunacion CVCABA = new CentroDeVacunacion("Hospital Pirovano", "C.A.B.A.", 1000);
		
		CVCABA.recibirVacunas(20000);
		CVCABA.comenzarAVacunar(mc);

		CentroDeVacunacion CVPBA = new CentroDeVacunacion("Hospital Ballestrini", "La Plata", 1000);
		
		CVPBA.recibirVacunas(20000);
		CVPBA.comenzarAVacunar(mc);
		
		// ESPERA A QUE TERMINEN DE VACUNAR TODOS
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando || CVCABA.estaVacunando || CVPBA.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(3000, mc.getCantVacunadosHoy());
	}

	@Test
	void Test2CVLock() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoLock(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);

		CentroDeVacunacion CVCABA = new CentroDeVacunacion("Hospital Pirovano", "C.A.B.A.", 1000);
		
		CVCABA.recibirVacunas(20000);
		CVCABA.comenzarAVacunar(mc);

		
		// ESPERA A QUE TERMINEN DE VACUNAR TODOS
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando || CVCABA.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(2000, mc.getCantVacunadosHoy());
	}
	
	
	@Test
	void Test3CVLock() {
		CentroDeMonitoreo mc = new CentroDeMonitoreoLock(); 
		
		CentroDeVacunacion CVOlavarria = new CentroDeVacunacion("Hospital Evita", "Olavarria", 1000);
		
		CVOlavarria.recibirVacunas(10000);
		CVOlavarria.comenzarAVacunar(mc);

		CentroDeVacunacion CVCABA = new CentroDeVacunacion("Hospital Pirovano", "C.A.B.A.", 1000);
		
		CVCABA.recibirVacunas(20000);
		CVCABA.comenzarAVacunar(mc);

		CentroDeVacunacion CVPBA = new CentroDeVacunacion("Hospital Ballestrini", "La Plata", 1000);
		
		CVPBA.recibirVacunas(20000);
		CVPBA.comenzarAVacunar(mc);
		
		// ESPERA A QUE TERMINEN DE VACUNAR TODOS
		try {
			Thread.sleep(1000);
			while (CVOlavarria.estaVacunando || CVCABA.estaVacunando || CVPBA.estaVacunando)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};

		Assert.assertEquals(3000, mc.getCantVacunadosHoy());
	}

}
