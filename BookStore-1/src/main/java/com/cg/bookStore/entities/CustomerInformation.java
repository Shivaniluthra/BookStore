package com.cg.bookStore.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "bookstore_customer",
uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}
)
public class CustomerInformation {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customerIdGenerator")
	@SequenceGenerator(name="customerIdGenerator", initialValue=100)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name = "email")
	@Size(min=10, max=64)
	private String emailAddress;

	@Column(name = "full_name")
	@Size(min=8, max=30)
	private String fullName;

	@Column(name = "password")
	@Size(min=8, max=16)
	private String password;

	@Column(name = "phone_no")
	@Size(min=10, max=15)
	private String phoneNumber;

	@Column(name = "address")
	@Size(min=10, max=128)
	private String address;
	
	@Column(name = "city")
	@Size(min=3, max=32)
	private String city;

	@Column(name = "zip_code")
	@Size(min=3, max=24)
	private Integer zipCode;

	@Column(name = "country")
	@Size(min=3, max=64)
	private String country;
	
	@Column(name="register_date")
	private LocalDate registerDate;

	
	
	public CustomerInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerInformation(@Size(min = 10, max = 64) String emailAddress, @Size(min = 8, max = 30) String fullName,
			@Size(min = 8, max = 16) String password, @Size(min = 10, max = 15) String phoneNumber,
			@Size(min = 10, max = 128) String address, @Size(min = 3, max = 32) String city,
			@Size(min = 3, max = 24) Integer zipCode, @Size(min = 3, max = 64) String country, LocalDate registerDate) {
		super();
		this.emailAddress = emailAddress;
		this.fullName = fullName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.registerDate = registerDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "CustomerInformation [customerId=" + customerId + ", emailAddress=" + emailAddress + ", fullName="
				+ fullName + ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", city=" + city + ", zipCode=" + zipCode + ", country=" + country + ", registerDate=" + registerDate
				+ "]";
	}
	
	
	
	
	
}