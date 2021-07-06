package com.vr.hotelService.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotels")
public class HotelEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hotelId;
	
	@Column(nullable=false)
	private String location;
	
	@Column(nullable=false)
	private BigDecimal price;
	
	@Column(nullable=false, unique=true)
	private String telephoneNumber;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=true)
	private String website;
	
	@Column(nullable=false)
	private String managerName;
	
	@Column(nullable=false)
	private boolean status;

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public HotelEntity(String location, BigDecimal price, String telephoneNumber, String email, String website,
			String managerName, boolean status) {
		this.location = location;
		this.price = price;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.website = website;
		this.managerName = managerName;
		this.status = status;
	}

	public HotelEntity() {}
	
}
