package com.grokonez.jwtauthentication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.model.Scores;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.ScoresRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/scores")
public class ScoresAPIs {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ScoresRepository scoresRepository;
	
	@GetMapping
	public List<Scores> hello() {
		return scoresRepository.findByOrderByScoreDesc();
	}
	
	@GetMapping("/{username}")
	public Scores getScores(@PathVariable("username") String username) {
		User user = userRepository.findOneByUsername(username);
		Scores scores = scoresRepository.findByUser_id(user.getId());
		if(scores == null) {
			Scores scores2 = new Scores();
			scores2.setUser(user);
			scores2.setScore(0);
			scoresRepository.save(scores2);
			return scores2;
		}
		return scores;
	}
	
	@PutMapping
	public Scores postScoes(@Valid @RequestBody Scores scores) {
		scoresRepository.save(scores);
		return scores;
	}
	
}