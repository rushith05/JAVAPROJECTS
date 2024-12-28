package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registrationId;
	private String registrationFirstName;
	private String registrationLastName;
	private String registrationDOB;
	private String registrationEmail;
	private long registrationPhone;
	private String registrationGender;
	private String registrationPassword;
	private String registrationAddress;
	private double registrationAmount;
	private int registrationPIN;
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public String getRegistrationFirstName() {
		return registrationFirstName;
	}
	public void setRegistrationFirstName(String registrationFirstName) {
		this.registrationFirstName = registrationFirstName;
	}
	public String getRegistrationLastName() {
		return registrationLastName;
	}
	public void setRegistrationLastName(String registrationLastName) {
		this.registrationLastName = registrationLastName;
	}
	public String getRegistrationDOB() {
		return registrationDOB;
	}
	public void setRegistrationDOB(String registrationDOB) {
		this.registrationDOB = registrationDOB;
	}
	public String getRegistrationEmail() {
		return registrationEmail;
	}
	public void setRegistrationEmail(String registrationEmail) {
		this.registrationEmail = registrationEmail;
	}
	public long getRegistrationPhone() {
		return registrationPhone;
	}
	public void setRegistrationPhone(long registrationPhone) {
		this.registrationPhone = registrationPhone;
	}
	public String getRegistrationGender() {
		return registrationGender;
	}
	public void setRegistrationGender(String registrationGender) {
		this.registrationGender = registrationGender;
	}
	public String getRegistrationPassword() {
		return registrationPassword;
	}
	public void setRegistrationPassword(String registrationPassword) {
		this.registrationPassword = registrationPassword;
	}
	public String getRegistrationAddress() {
		return registrationAddress;
	}
	public void setRegistrationAddress(String registrationAddress) {
		this.registrationAddress = registrationAddress;
	}
	public double getRegistrationAmount() {
		return registrationAmount;
	}
	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}
	
	public int getRegistrationPIN() {
		return registrationPIN;
	}
	public void setRegistrationPIN(int registrationPIN) {
		this.registrationPIN = registrationPIN;
	}
	
	
	

}
