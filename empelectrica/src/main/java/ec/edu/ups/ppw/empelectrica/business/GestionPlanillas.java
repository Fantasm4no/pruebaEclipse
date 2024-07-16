package ec.edu.ups.ppw.empelectrica.business;

import java.util.List;

import ec.edu.ups.ppw.empelectrica.dao.PlanillaDAO;
import ec.edu.ups.ppw.empelectrica.model.Planilla;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionPlanillas {

	@Inject
	private PlanillaDAO daoPlanilla;
	
	public Planilla getPlanilla(int id) throws Exception {
		Planilla planilla = daoPlanilla.read(id);
		if(planilla == null)
			throw new Exception("Planilla no existe");
		return planilla;
	}
	
	public List<Planilla> getPlanillas(){
		return daoPlanilla.getAll();
	}
	
	public void createPlanillas(Planilla planilla) throws Exception {
		if(planilla.getPlanillaId() < 0) {
			throw new Exception("Id Incorrecto");
		}
		daoPlanilla.insert(planilla);
	}
	
	public void updatePlanilla(Planilla planilla) throws Exception{
		if(planilla.getPlanillaId() < 0) {
			throw new Exception("Id Incorrecta");
		}
		daoPlanilla.update(planilla);
	}
	
	public void deletePlanilla(int id) throws Exception{
		Planilla planilla = daoPlanilla.read(id);
		if(planilla == null) {				
			throw new Exception("Planilla no existe");
		}
		else {
			daoPlanilla.delete(id);
		}
	}
}
