package ec.edu.ups.ppw.empelectrica.business;

import java.util.List;
import ec.edu.ups.ppw.empelectrica.dao.ClienteDAO;
import ec.edu.ups.ppw.empelectrica.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {

	@Inject
	private ClienteDAO daoCliente;
	
	public Cliente getCliente(int id) throws Exception {
		Cliente cliente = daoCliente.read(id);
		if(cliente == null)
			throw new Exception("Cliente no existe");
		return cliente;
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
	public void createCliente(Cliente cliente) throws Exception {
		if(cliente.getClienteId() < 0) {
			throw new Exception("Id Incorrecto");
		}
		daoCliente.insert(cliente);
	}
	
	public void updateCliente(Cliente cliente) throws Exception{
		if(cliente.getClienteId() < 0) {
			throw new Exception("Id Incorrecta");
		}
		daoCliente.update(cliente);
	}
	
	public void deleteCliente(int id) throws Exception{
		Cliente cliente = daoCliente.read(id);
		if(cliente == null) {				
			throw new Exception("Cliente no existe");
		}
		else {
			daoCliente.delete(id);
		}
		
	}
}
