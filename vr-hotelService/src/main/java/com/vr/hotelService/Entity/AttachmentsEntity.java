package com.vr.hotelService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="attachments")
public class AttachmentsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long attachmentId;
	
	private String name;
	private String description;
	
	@ManyToOne(targetEntity=HotelEntity.class)
	@JoinColumn(name="hotel_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private HotelEntity hotel;

	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}

	public AttachmentsEntity(String name, String description, HotelEntity hotel) {		
		this.name = name;
		this.description = description;
		this.hotel = hotel;
	}

	public AttachmentsEntity() {}		
}
