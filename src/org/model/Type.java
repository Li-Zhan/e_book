package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private Set bookses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(String typeName, Set bookses) {
		this.typeName = typeName;
		this.bookses = bookses;
	}
	

	public Type(Integer typeId) {
		super();
		this.typeId = typeId;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getBookses() {
		return this.bookses;
	}

	public void setBookses(Set bookses) {
		this.bookses = bookses;
	}

}