package ec.edu.ups.ppw.empelectrica.services;

import java.util.List;

import ec.edu.ups.ppw.empelectrica.business.GestionClientes;
import ec.edu.ups.ppw.empelectrica.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteService {

	@Inject
	private GestionClientes gClientes;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Cliente cliente) {
		try {
			gClientes.createCliente(cliente);
			return Response.ok(cliente).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
	}
	
	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Cliente cliente) {
		try {
			gClientes.updateCliente(cliente);
			return Response.ok(cliente).build();
		} catch (Exception e) {
			// TODO: handle exceptione.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("cedula") int cedula) {
		try {
			gClientes.deleteCliente(cedula);
			return Response.ok(cedula).build();
			
		} catch (Exception e) {
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Produces("application/json")
	public List<Cliente> list(){
		List<Cliente> clientes = gClientes.getClientes();
		return clientes;
	}
}
