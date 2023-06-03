package com.nagarro.java1.alfahad;

public class Tshirt {
	String ID;
	String NAME;
	String COLOUR;
	String GENDER_RECOMMENDATION;
	String SIZE;
	double PRICE;
	double RATING;
	String AVAILIBILITY;
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public String getCOLOUR() {
		return COLOUR;
	}
	public void setCOLOUR(String COLOUR) {
		this.COLOUR = COLOUR;
	}
	public String getGENDER_RECOMMENDATION() {
		return GENDER_RECOMMENDATION;
	}
	public void setGENDER_RECOMMENDATION(String GENDER_RECOMMENDATION) {
		this.GENDER_RECOMMENDATION = GENDER_RECOMMENDATION;
	}
	public String getSIZE() {
		return SIZE;
	}
	public void setSIZE(String SIZE) {
		this.SIZE = SIZE;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double PRICE) {
		this.PRICE = PRICE;
	}
	public double getRATING() {
		return RATING;
	}
	public void setRATING(double RATING) {
		this.RATING = RATING;
	}
	public String getAVAILIBILITY() {
		return AVAILIBILITY;
	}
	public void setAVAILIBILITY(String AVAILIBILITY) {
		this.AVAILIBILITY=AVAILIBILITY;
	}
	
	@Override
	public String toString() {
		return "Tshirt{"+ 
				"ID='" +ID +'\''+
				",NAME='"+ NAME + '\''+
				",COLOUR='" + COLOUR + '\''+
				",GENDER_RECOMMENDATION='" + GENDER_RECOMMENDATION + '\''+
				",SIZE='" + SIZE + '\''+
				",PRICE='" + PRICE + '\''+
				",RATING='" + RATING + '\''+
				",AVAILIBILITY='" + AVAILIBILITY + '\''+
				'}';
	 
	}
	

	

}
