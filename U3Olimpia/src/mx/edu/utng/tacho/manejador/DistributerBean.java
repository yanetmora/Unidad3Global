package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.DistributerDAO;
import mx.edu.utng.tacho.modelo.Distributer;


@ManagedBean
@SessionScoped
public class DistributerBean implements Serializable {

	private List<Distributer> distributers;
	private Distributer distributer;
	

	public String listar() {
		DistributerDAO dao = new DistributerDAO();
		try {
			distributers = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Distributers";
	}

	public String eliminar() {
		DistributerDAO dao = new DistributerDAO();
		try {
			dao.delete(distributer);
			distributers = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		distributer = new Distributer();	
		return "Agregar";
	}

	public String guardar() {
		DistributerDAO dao = new DistributerDAO();
		try {
			if (distributer.getId() != 0) {
				dao.update(distributer);
			} else {
				dao.insert(distributer);
			}
			distributers = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Distributer distributer){
		this.distributer = distributer;
		return "Editar";
	}

	public List<Distributer> getDistributers() {
		return distributers;
	}

	public void setDistributers(List<Distributer> distributers) {
		this.distributers = distributers;
	}

	public Distributer getDistributer() {
		return distributer;
	}

	public void setDistributer(Distributer distributer) {
		this.distributer = distributer;
	}

	
}
