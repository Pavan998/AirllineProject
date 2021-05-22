package com.example.demo.layer2;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SEATS database table.
 * 
 */
@Entity
@Table(name="SEATS")
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
public class Seat  {
	
	@Id
	private int sno;
	
	private String seatno;
	
	private int age;

	private String agegroup;

	private String passengerfullname;

	//bi-directional many-to-one association to Reservation
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TICKETNO")
	private Reservation reservation;

	public Seat() {
		super();
		System.out.println("Seat contr()......");
	}

	
	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAgegroup() {
		return this.agegroup;
	}

	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}

	public String getPassengerfullname() {
		return this.passengerfullname;
	}

	public void setPassengerfullname(String passengerfullname) {
		this.passengerfullname = passengerfullname;
	}

	public String getSeatno() {
		return this.seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	@JsonIgnore
	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}