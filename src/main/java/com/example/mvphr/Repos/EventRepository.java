package com.example.mvphr.Repos;



import com.example.mvphr.Entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// репа мероприятий, бд леер
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    EventEntity getById(Long id);
}
