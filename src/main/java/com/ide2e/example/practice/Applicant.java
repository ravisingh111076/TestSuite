package com.ide2e.example.practice;

public class Applicant {

	private String name;
	
	private String surname;
	
	private long creditScore;
	
	private boolean crimeRecord;
	
	public Applicant(String name, String surname, long creditScore, boolean crimeRecord) {
		super();
		this.name = name;
		this.surname = surname;
		this.creditScore = creditScore;
		this.crimeRecord = crimeRecord;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public long getCreditScore() {
		return creditScore;
	}

	public boolean isCrimeRecord() {
		return crimeRecord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (creditScore ^ (creditScore >>> 32));
		result = prime * result + (crimeRecord ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Applicant other = (Applicant) obj;
		if (creditScore != other.creditScore)
			return false;
		if (crimeRecord != other.crimeRecord)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
}
