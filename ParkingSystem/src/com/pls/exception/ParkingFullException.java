package com.pls.exception;

public class ParkingFullException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		System.out.println("Parking Full");
		return super.getMessage();
	}

}
