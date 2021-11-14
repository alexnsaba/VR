package com.vrhotelservice.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="hotel_comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Long commentId;	
	
	@Column(nullable=false)
	@Schema(example = "This hotel has the best services.", required = true)
	private String description;
	
	@Column(nullable=false)
	@Schema(example = "alex", required = true)
	private String commentedBy;
	
	@ManyToOne(targetEntity = HotelEntity.class)
	@JoinColumn(name="hotel_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private HotelEntity hotel;
}
