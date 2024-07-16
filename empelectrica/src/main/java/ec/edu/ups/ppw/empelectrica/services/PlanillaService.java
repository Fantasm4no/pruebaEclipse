package ec.edu.ups.ppw.empelectrica.services;

import java.util.List;

import ec.edu.ups.ppw.empelectrica.business.GestionPlanillas;
import ec.edu.ups.ppw.empelectrica.model.Planilla;
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

@Path("/planilla")
public class PlanillaService {

	@Inject
	private GestionPlanillas gPlanillas;
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Planilla planilla) {
		try {
			gPlanillas.createPlanillas(planilla);
			return Response.ok(planilla).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
	}
	
	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Planilla planilla) {
		try {
			gPlanillas.updatePlanilla(planilla);
			return Response.ok(planilla).build();
		} catch (Exception e) {
			// TODO: handle exceptione.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("id") int id) {
		try {
			gPlanillas.deletePlanilla(id);
			return Response.ok(id).build();
			
		} catch (Exception e) {
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
		
	}
	
	@GET
	@Produces("application/json")
	public List<Planilla> list(@QueryParam("id") int id){
		List<Planilla> planillas = gPlanillas.getPlanillas();
		return planillas;
	}
	
}
