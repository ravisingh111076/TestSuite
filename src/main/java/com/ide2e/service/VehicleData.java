package com.ide2e.service;

/**
 * Immutable class all fields are mandatory;
 * @author ravisingh
 *
 */
public final class VehicleData {

	private final String registrationNo;

	private final String color;

	private final String make;

	public VehicleData(String registrationNo, String color, String make) {
		// use apache StringUtils is better option
		if (registrationNo == null || registrationNo.equals("")) {
			throw new IllegalArgumentException("Invalid registration");
		}
		if (color == null || color.equals("")) {
			throw new IllegalArgumentException("Invalid color");
		}
		if (make == null || make.equals("")) {
			throw new IllegalArgumentException("Invalid make");
		}
		this.registrationNo = registrationNo;
		this.color = color;
		this.make = make;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((registrationNo == null) ? 0 : registrationNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleData other = (VehicleData) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (registrationNo == null) {
			if (other.registrationNo != null)
				return false;
		} else if (!registrationNo.equals(other.registrationNo))
			return false;
		return true;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public String getColor() {
		return color;
	}

	public String getMake() {
		return make;
	}

}
