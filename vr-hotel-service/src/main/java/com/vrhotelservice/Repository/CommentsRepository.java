package com.vrhotelservice.Repository;

import com.vrhotelservice.Entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {

}
