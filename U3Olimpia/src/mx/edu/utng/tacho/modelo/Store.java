package mx.edu.utng.tacho.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="stores")
public class Store {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_store")
	private Long id;
	
	private String name;
	
	private String address;
	
	private int phone;

	
	@ManyToOne
	@JoinColumn(name="id_distributer")
	private Distributer distributer;
	
	public Store() {
		id = 0L;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Distributer getDistributer() {
		return distributer;
	}


	public void setDistributer(Distributer distributer) {
		this.distributer = distributer;
	}

	
	
}
