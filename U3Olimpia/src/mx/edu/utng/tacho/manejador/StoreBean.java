package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.edu.utng.tacho.datos.DistributerDAO;
import mx.edu.utng.tacho.datos.StoreDAO;
import mx.edu.utng.tacho.modelo.Distributer;
import mx.edu.utng.tacho.modelo.Store;

@ManagedBean
@SessionScoped
public class StoreBean implements Serializable {
	
	private List<Store> stores;
	private Store store;
	private List<Distributer> distributers;
	
	
	public StoreBean() {
		store = new Store(); 
	}


	public String listar(){
		StoreDAO dao = new StoreDAO();
		try {
			stores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Stores";
	}
	
	public String eliminar(){
		StoreDAO dao = new StoreDAO();
		try {
			dao.delete(store);
			stores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		store = new Store();
		store.setDistributer(new Distributer());
		try{
			distributers = new DistributerDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}
	
	public String guardar(){
		StoreDAO dao = new StoreDAO();
		try {
			if (store.getId() != 0) {
				dao.update(store);
			} else {
				dao.insert(store);
			}
			stores = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Store store){
		this.store = store;
		try{
			distributers = new DistributerDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}


	public List<Store> getStores() {
		return stores;
	}


	public void setStores(List<Store> stores) {
		this.stores = stores;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public List<Distributer> getDistributers() {
		return distributers;
	}


	public void setDistributers(List<Distributer> distributers) {
		this.distributers = distributers;
	}

	
}
