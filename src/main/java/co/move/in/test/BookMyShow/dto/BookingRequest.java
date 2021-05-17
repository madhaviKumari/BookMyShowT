package co.move.in.test.BookMyShow.dto;

import java.util.List;
import co.move.in.test.BookMyShow.model.CustomerBooking;
import co.move.in.test.BookMyShow.model.PaymentMathod;

public class BookingRequest {
	
	List<CustomerBooking> customerBokking;
	double totalPaidAmount;
	String gstnNumber;
	PaymentMathod paymentMethod;
	public List<CustomerBooking> getCustomerBokking() {
		return customerBokking;
	}
	public void setCustomerBokking(List<CustomerBooking> customerBokking) {
		this.customerBokking = customerBokking;
	}
	public double getTotalPaidAmount() {
		return totalPaidAmount;
	}
	public void setTotalPaidAmount(double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}
	public PaymentMathod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMathod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getGstnNumber() {
		return gstnNumber;
	}
	public void setGstnNumber(String gstnNumber) {
		this.gstnNumber = gstnNumber;
	}
	
	

}
