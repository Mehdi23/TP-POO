package org.mehdi.project.dao.implementation;

import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Table extends ObjectifyGenericDao<Table>  {

	@Id
	private String id;
	@Unindex
	private String numero;
	private String type;
	private String desc;
	
	
	public Table() {
	
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Table(String id, String numero,  String type) {
		this.id = id;
		this.numero = numero;
		this.type = type;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
}
