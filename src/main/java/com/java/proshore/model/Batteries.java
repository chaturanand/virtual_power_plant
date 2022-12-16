package com.java.proshore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author chaturanand yadav
 *
 */


@Entity
@Table(name = "batteries")
public class Batteries {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "capacity")
	private double capacity;

	public Batteries(long id, String name, String postcode, double capacity) {
		this.id = id;
		this.name = name;
		this.postcode = postcode;
		this.capacity = capacity;
	}

	public Batteries() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Batteries [id=" + id + ", name=" + name + ", postcode=" + postcode + ", capacity=" + capacity + "]";
	}
	
	
	
	
	

}