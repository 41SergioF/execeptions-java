package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exeptions.DomainExeptions;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExeptions {
		if (!checkOut.after(checkIn)) {
			throw new DomainExeptions("heck-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getcheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainExeptions {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainExeptions("Reservation dates for update must be future dates");	
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainExeptions("heck-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	} 
	
	@Override
	public String toString() {
		return "Reservation: Roomm "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+", "+ this.duration()+ " nights";
	}

}
