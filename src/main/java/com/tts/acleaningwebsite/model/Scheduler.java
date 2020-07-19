package com.tts.acleaningwebsite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Scheduler {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "scheduler_Id")
	private long Id;
	
	private String firstName;
	private String lastName;
	private String contactTel;
	private String areaCode;
	private String email;
	private String prefferedContactMethod;
	private boolean mayWeContactYou;
	private String additionalInformation;
	
	@Column
	@CreationTimestamp
	private Date scheduledDate;


	public Scheduler() {
		// TODO Auto-generated constructor stub
	}


	public Scheduler( String firstName, String lastName, String contactTel, String areaCode, String email,
			String prefferedContactMethod, boolean mayWeContactYou, String additionalInformation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactTel = contactTel;
		this.areaCode = areaCode;
		this.email = email;
		this.prefferedContactMethod = prefferedContactMethod;
		this.mayWeContactYou = mayWeContactYou;
		this.additionalInformation = additionalInformation;
		this.scheduledDate = new Date();
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getContactTel() {
		return contactTel;
	}


	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPrefferedContactMethod() {
		return prefferedContactMethod;
	}


	public void setPrefferedContactMethod(String prefferedContactMethod) {
		this.prefferedContactMethod = prefferedContactMethod;
	}


	public boolean isMayWeContactYou() {
		return mayWeContactYou;
	}


	public void setMayWeContactYou(boolean mayWeContactYou) {
		this.mayWeContactYou = mayWeContactYou;
	}


	public String getAdditionalInformation() {
		return additionalInformation;
	}


	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}


	public long getId() {
		return Id;
	}


	public Date getScheduledDate() {
		return scheduledDate;
	}


	@Override
	public String toString() {
		return "Scheduler [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactTel="
				+ contactTel + ", areaCode=" + areaCode + ", email=" + email + ", prefferedContactMethod="
				+ prefferedContactMethod + ", mayWeContactYou=" + mayWeContactYou + ", additionalInformation="
				+ additionalInformation + ", scheduledDate=" + scheduledDate + "]";
	}
	
	
	
	
	
}
