package com.example.demo.layer2;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the FLIGHTS database table.
 * 
 */
@Entity
@Table(name="FLIGHTS")
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight  {
	

	@Id
	@GeneratedValue
	private Integer flightid;

	private String arrivaltime;

	private String departuretime;

	private String destination;

	private int durationinhrs;

	private String flightname;

	private String flightstatus;

	private String source;

	private int totalseats;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="flight", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Reservation> reservations;

	public Flight() {
		super();
		System.out.println("Flight contr()......");
	}

	public Integer getFlightid() {
		return this.flightid;
	}

	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}

	public String getArrivaltime() {
		return this.arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getDeparturetime() {
		return this.departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDurationinhrs() {
		return this.durationinhrs;
	}

	public void setDurationinhrs(int durationinhrs) {
		this.durationinhrs = durationinhrs;
	}

	public String getFlightname() {
		return this.flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getFlightstatus() {
		return this.flightstatus;
	}

	public void setFlightstatus(String flightstatus) {
		this.flightstatus = flightstatus;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getTotalseats() {
		return this.totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setFlight(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setFlight(null);

		return reservation;
	}

}