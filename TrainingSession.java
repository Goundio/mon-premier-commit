package com.coursesMP.model;


import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "training_sessions")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TrainingSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "beginning_date")
	private Date beginningDate;
	
	@JsonManagedReference
	@ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn (name = "id_course" )
	private Course course;
	
//	@JsonManagedReference
	@ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn (name = "id_instructor" )
	private Instructor instructor;
	
	
	//AJOUT DE LOUIS: fetchTYpe.EAGER (avant rien)
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinTable (name = "session_student",
	joinColumns = {@JoinColumn(name = "id_session")},
	inverseJoinColumns = { @JoinColumn(name = "id_student")})
	private List<Student> listStudents; 
	
	
	public TrainingSession() {
		
	}

	public String toString() {
		return (this.course.getTitle() + this.beginningDate);
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getBeginningDate() {
		return beginningDate;
	}


	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	public List<Student> getListStudents() {
		return listStudents;
	}


	public void setListStudents(List<Student> listStudents) {
		this.listStudents = listStudents;
	}

	
	
}
