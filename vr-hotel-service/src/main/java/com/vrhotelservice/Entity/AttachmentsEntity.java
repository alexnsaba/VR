package com.vrhotelservice.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="attachments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Long attachmentId;
	
	@Column(name="attachment_name")
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private String name;
	
	@ManyToOne(targetEntity=HotelEntity.class)
	@JoinColumn(name="hotel_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private HotelEntity hotel;
}
