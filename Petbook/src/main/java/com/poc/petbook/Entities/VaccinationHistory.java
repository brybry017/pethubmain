package com.poc.petbook.Entities;

import org.springframework.data.mongodb.core.mapping.Field;

public class VaccinationHistory {
	
	
	private String vaccineType;
	private String vaccineDate;

	public VaccinationHistory() {
		
	}
	
	public VaccinationHistory(String vaccineType, String vaccineDate) {
		this.vaccineType = vaccineType;
		this.vaccineDate = vaccineDate;
	}
	
	public String getVaccineType() {
		return vaccineType;
	}
	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}
	public String getVaccineDate() {
		return vaccineDate;
	}
	public void setVaccineDate(String vaccineDate) {
		this.vaccineDate = vaccineDate;
	}
	@Override
	public String toString() {
		return "VaccinationHistory [vaccineType=" + vaccineType + ", vaccineDate=" + vaccineDate + "]";
	}
}

