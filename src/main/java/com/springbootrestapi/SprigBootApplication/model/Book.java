package com.springbootrestapi.SprigBootApplication.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;










@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	

	private String name;

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
	
	//correct code
	/*@OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Employee emp;*/
	//*********************************************************
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private Employee emp;*/
	
	//*********************************************************
	
	@OneToOne
	@JoinColumn(name ="emp_id")
	private Employee emp;

}
