package Main;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test
	void testInsertarCustomer() {
		NeocioCustomer nc=new NeocioCustomer();
		nc.setId("2");
		nc.setDato("2");
		assertTrue(nc.insertarCustomer());
	}

	@org.junit.jupiter.api.Test
	void testConsultarCustomer() {
		NeocioCustomer nc=new NeocioCustomer();
		nc.setId("2");
		assertTrue(nc.consultarCustomer());
	}

	@org.junit.jupiter.api.Test
	void testActualizarCustomer() {
		NeocioCustomer nc=new NeocioCustomer();
		nc.setId("2");
		nc.setDato("4");
		assertTrue(nc.actualizarCustomer());
	}

}
