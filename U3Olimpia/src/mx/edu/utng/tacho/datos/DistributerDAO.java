package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Distributer;



public class DistributerDAO extends DAO<Distributer> {

	public DistributerDAO() {
		super(new Distributer());	
	}
	
	public Distributer getOneById(Distributer distributer) throws HibernateException {
		return super.getOneById(distributer.getId());
	}

}
