package com.example.mvphr.Repos;

import com.example.mvphr.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// репа кандидатов, бд леер
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

Candidate getById(Long id);

}
