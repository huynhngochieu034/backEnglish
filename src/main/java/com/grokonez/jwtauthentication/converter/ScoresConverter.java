package com.grokonez.jwtauthentication.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grokonez.jwtauthentication.dto.ScoresDTO;
import com.grokonez.jwtauthentication.model.Scores;

@Component
public class ScoresConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ScoresDTO convertToDto(Scores entity) {
		ScoresDTO result = modelMapper.map(entity, ScoresDTO.class);
        return result;
    }

    public Scores convertToEntity(ScoresDTO dto) {
    	Scores result = modelMapper.map(dto, Scores.class);
        return result;
    }

}
