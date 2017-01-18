package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Store;

public class StoreDAO extends DAO<Store> {

	public StoreDAO() {
		super(new Store());	
	}
	
	public Store getOneById(Store store) throws HibernateException {
		return super.getOneById(store.getId());
	}

}
