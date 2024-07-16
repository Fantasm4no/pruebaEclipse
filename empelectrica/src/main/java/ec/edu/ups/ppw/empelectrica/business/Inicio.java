package ec.edu.ups.ppw.empelectrica.business;

import java.util.Date;

import ec.edu.ups.ppw.empelectrica.dao.ClienteDAO;
import ec.edu.ups.ppw.empelectrica.dao.PlanillaDAO;
import ec.edu.ups.ppw.empelectrica.model.Cliente;
import ec.edu.ups.ppw.empelectrica.model.Planilla;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {

	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private PlanillaDAO daoPlanilla;
	
	@PostConstruct
	public void init() {
		
		Cliente cliente = new Cliente();
	    cliente.setNombre("Erick Zhigue");
	    cliente.setCedula("0706656188");
	    cliente.setDireccion("El Vecino");
	    cliente.setEmail("erickzhigue@gmail.com");
	    daoCliente.insert(cliente);
	    
	    Planilla planilla = new Planilla();
	    planilla.setClientes(cliente);
	    planilla.setFechaInicio(new Date());
	    planilla.setFechaFin(new Date());
	    planilla.setConsumo(250.5);
	    daoPlanilla.insert(planilla);
	}
}