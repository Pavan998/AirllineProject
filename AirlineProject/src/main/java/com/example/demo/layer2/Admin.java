package com.example.demo.layer2;


import javax.persistence.*;


/**
 * The persistent class for the "ADMIN" database table.
 * 
 */
@Entity
@Table(name="ADMIN")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin  {
	

	@Id
	@GeneratedValue
	private int adminid;

	private String adminname;

	private String password;

	public Admin() {
		super();
		System.out.println("Admin contr()......");
	}

	

	public int getAdminid() {
		return adminid;
	}



	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}



	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}