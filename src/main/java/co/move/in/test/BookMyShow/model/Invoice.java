package co.move.in.test.BookMyShow.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Invoice {
	
	@Id
	private String id;
	
	private double totalPaidAmount;
	private String gstnNumber;
	private PaymentMathod paymentMethod;
	private Date generatedDate;
	
	@DBRef
	private Booking booking;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public void setTotalPaidAmount(double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}

	public String getGstnNumber() {
		return gstnNumber;
	}

	public void setGstnNumber(String gstnNumber) {
		this.gstnNumber = gstnNumber;
	}

	public PaymentMathod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMathod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}
}
