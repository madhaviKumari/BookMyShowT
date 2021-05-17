package co.move.in.test.BookMyShow.dto;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;

import co.move.in.test.BookMyShow.model.SeatStatus;
import co.move.in.test.BookMyShow.model.SeatType;

public class SeatRow {
	@ExcelRow                  
    private int rowIndex;
	@ExcelCell(0) 
	private int number;
	@ExcelCell(1) 
	private String show;
	@ExcelCell(2) 
	private SeatType type;
	@ExcelCell(3) 
	private SeatStatus status;
	@ExcelCell(4) 
	private double price;
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public SeatType getType() {
		return type;
	}
	public void setType(SeatType type) {
		this.type = type;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
