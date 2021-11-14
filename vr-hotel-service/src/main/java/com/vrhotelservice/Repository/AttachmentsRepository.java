package com.vrhotelservice.Repository;

import com.vrhotelservice.Entity.AttachmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentsRepository extends JpaRepository<AttachmentsEntity, Long> {

}
