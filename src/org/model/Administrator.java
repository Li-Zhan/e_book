package org.model;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Administrator implements java.io.Serializable {

	// Fields

	private Integer administratorId;
	private String administratorName;
	private String administratorPassword;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** full constructor */
	public Administrator(String administratorName, String administratorPassword) {
		this.administratorName = administratorName;
		this.administratorPassword = administratorPassword;
	}

	// Property accessors

	public Integer getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	public String getAdministratorName() {
		return this.administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public String getAdministratorPassword() {
		return this.administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}

}