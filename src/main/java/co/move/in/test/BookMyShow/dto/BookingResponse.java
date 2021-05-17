package co.move.in.test.BookMyShow.dto;

import co.move.in.test.BookMyShow.model.Invoice;

public class BookingResponse {
	
	private int status;
	private String bookingId;
	private Invoice invoice;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	

}
