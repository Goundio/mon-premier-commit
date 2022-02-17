package com.coursesMP.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "categories")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name="name_cat")
	private String name;
	
	@JsonBackReference
	@OneToMany (cascade = CascadeType.ALL, mappedBy="category",  fetch = FetchType.EAGER) 
	List <Subcategory> listSubCat;
	
	public Category() {
		
	}
	
	public String toString() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subcategory> getListSubCat() {
		return listSubCat;
	}

	public void setListSubCat(List<Subcategory> listSubCat) {
		this.listSubCat = listSubCat;
	}
	
	
}
