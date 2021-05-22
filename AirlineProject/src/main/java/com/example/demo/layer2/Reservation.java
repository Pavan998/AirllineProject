package com.example.demo.layer2;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.Set;


/**
 * The persistent class for the RESERVATION database table.
 * 
 */
@Entity
@Table(name="RESERVATION")
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation  {
	

	@Id
	@GeneratedValue
	private int ticketno;

	@Column(name="CLASS")
	private String cls;

	
	private Date dateofdeparture;

	
	private Date dateofreturn;

	private int noofpassengers;

	private String paymentstatus;

	private Double price;

	
	private Date ticketissue;

	private String ticketstatus;

	private Double totalprice;

	private String triptype;

	//bi-directional many-to-one association to Cancelticket
	@OneToOne(mappedBy="reservation", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Cancelticket canceltickets;

	//bi-directional many-to-one association to Flight
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FLIGHTID")
	private Flight flight;

	//bi-directional many-to-one association to Signup
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USERID")
	private Signup signup;

	//bi-directional many-to-one association to Seat
	@OneToMany(mappedBy="reservation", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Seat> seats;

	public Reservation() {
		super();
		System.out.println("Reservation contr()......");
	}

	

	
	public int getTicketno() {
		return ticketno;
	}

	public void setTicketno(int ticketno) {
		this.ticketno = ticketno;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	
	public Date getDateofdeparture() {
		return dateofdeparture;
	}

	public void setDateofdeparture(Date dateofdeparture) {
		this.dateofdeparture = dateofdeparture;
	}

	public Date getDateofreturn() {
		return dateofreturn;
	}

	public void setDateofreturn(Date dateofreturn) {
		this.dateofreturn = dateofreturn;
	}

	public Date getTicketissue() {
		return ticketissue;
	}

	public void setTicketissue(Date ticketissue) {
		this.ticketissue = ticketissue;
	}

	public int getNoofpassengers() {
		return this.noofpassengers;
	}

	public void setNoofpassengers(int noofpassengers) {
		this.noofpassengers = noofpassengers;
	}

	public String getPaymentstatus() {
		return this.paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTicketstatus() {
		return this.ticketstatus;
	}

	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getTriptype() {
		return this.triptype;
	}

	public void setTriptype(String triptype) {
		this.triptype = triptype;
	}

	@JsonIgnore
	public Cancelticket getCanceltickets() {
		return canceltickets;
	}

	public void setCanceltickets(Cancelticket canceltickets) {
		this.canceltickets = canceltickets;
	}

	@JsonIgnore
	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@JsonIgnore
	public Signup getSignup() {
		return this.signup;
	}

	public void setSignup(Signup signup) {
		this.signup = signup;
	}

	@JsonIgnore
	public Set<Seat> getSeats() {
		return this.seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Seat addSeat(Seat seat) {
		getSeats().add(seat);
		seat.setReservation(this);

		return seat;
	}

	public Seat removeSeat(Seat seat) {
		getSeats().remove(seat);
		seat.setReservation(null);

		return seat;
	}

}