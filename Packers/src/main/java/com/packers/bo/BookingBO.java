package com.packers.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "BOOKING")
public class BookingBO {
	@Override
	public String toString() {
		return "BookingBO [id=" + id + ", shiftingFrom=" + shiftingFrom + ", shiftingTo=" + shiftingTo + ", date="
				+ dates + ", custId=" + customer_Id + "]";
	}

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "SHIFTING_FROM")
	private String shiftingFrom;
	@Column(name = "SHIFTING_TO")
	private String shiftingTo;
	//@Column(name = "dates")
	private String dates; //If variable and column name are same no annotation required.
	private String customer_Id ;

	public String getBookingId() {
		return id;
	}

	public void setBookingId(String bookingId) {
		this.id = bookingId;
	}

	public String getShiftingFrom() {
		return shiftingFrom;
	}

	public void setShiftingFrom(String shiftingFrom) {
		this.shiftingFrom = shiftingFrom;
	}

	public String getShiftingTo() {
		return shiftingTo;
	}

	public void setShiftingTo(String shiftingTo) {
		this.shiftingTo = shiftingTo;
	}

	public String getDate() {
		return dates;
	}

	public void setDate(String date) {
		this.dates = date;
	}

	public String getCustId() {
		return customer_Id;
	}

	public void setCustId(String custId) {
		this.customer_Id = custId;
	}

}
