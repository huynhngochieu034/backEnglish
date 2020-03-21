package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grokonez.jwtauthentication.model.Scores;

@Repository
public interface ScoresRepository extends JpaRepository<Scores, Long> {
	 Scores findByUser_id(Long id);
	 List<Scores> findByOrderByScoreDesc();
}