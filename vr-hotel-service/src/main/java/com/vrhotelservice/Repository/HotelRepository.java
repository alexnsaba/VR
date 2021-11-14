package com.vrhotelservice.Repository;

import com.vrhotelservice.Entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity,Long> {
	HotelEntity findByTelephoneNumber(String telephoneNumber);
	HotelEntity findByEmail(String email);
}
