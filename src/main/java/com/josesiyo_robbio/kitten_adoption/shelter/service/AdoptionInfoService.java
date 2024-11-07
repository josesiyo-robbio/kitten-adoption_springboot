package com.josesiyo_robbio.kitten_adoption.shelter.service;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.AdoptionDto;
import com.josesiyo_robbio.kitten_adoption.shelter.model.Adoption;
import com.josesiyo_robbio.kitten_adoption.shelter.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;


@Service
public class AdoptionInfoService {
    @Autowired
    private AdoptionRepository adoptionRepository;

    public AdoptionDto info(Long adoptionId)
    {
        Optional<Adoption> adoption = adoptionRepository.findById(adoptionId);

        if (adoption.isPresent())
        {
            Adoption adop = adoption.get();
            AdoptionDto adoptionDto = new AdoptionDto();

            adoptionDto.setApplicant_name(adop.getApplicant_name());
            adoptionDto.setEmail(adop.getEmail());
            adoptionDto.setPhone(adop.getPhone());
            adoptionDto.setMessage(adop.getMessage());
            adoptionDto.setSocial_media_url(adop.getSocial_media_url());
            adoptionDto.setStatus(String.valueOf(adop.getStatus()));

            return adoptionDto;
        }
        else
        {
            throw new IllegalArgumentException("Adoption with ID " + adoptionId + " not found");
        }
    }
}

