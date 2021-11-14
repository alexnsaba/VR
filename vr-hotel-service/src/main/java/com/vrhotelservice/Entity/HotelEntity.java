package com.vrhotelservice.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Long hotelId;
	
	@Column(nullable = false)
	@Schema(example = "SS Hotels", required = true)
	private String hotelName;
	
	@Column(nullable=false)
	@Schema(example = "Nyabugogo", required = true)
	private String location;
	
	@Column(nullable=false)
	@Schema(example = "3333333")
	private String longitude;
	
	@Column
	@Schema(example = "222222222")
	private String latitude;
	
	@Column(nullable=false)
	@Schema(example = "50000",required = true)
	private BigDecimal price;
	
	@Column(nullable=false, unique=true)
	@Schema(example = "+256787923456", required = true)
	private String telephoneNumber;
	
	@Column(nullable=false, unique=true)
	@Schema(example = "aaaa@gmail.com")
	private String email;
	
	@Column
	@Schema(example = "aaaa.com")
	private String website;
	
	@Column(nullable=false)
	@Schema(example = "Maniriho Jean", required = true)
	private String managerName;
	
	@Column(nullable=false)
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private boolean status;
}
