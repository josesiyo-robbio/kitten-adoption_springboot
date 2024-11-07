package com.josesiyo_robbio.kitten_adoption.shelter.service;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.AdoptionDto;
import com.josesiyo_robbio.kitten_adoption.shelter.dto.KittenShelterDto;
import com.josesiyo_robbio.kitten_adoption.shelter.model.Adoption;
import com.josesiyo_robbio.kitten_adoption.shelter.model.KittenShelter;
import com.josesiyo_robbio.kitten_adoption.shelter.repository.AdoptionRepository;
import com.josesiyo_robbio.kitten_adoption.shelter.repository.KittenShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NewAdoptionService
{
    @Autowired
    private AdoptionRepository adoptionRepository;

    @Autowired
    private KittenShelterRepository kittenShelterRepository;

    public NewAdoptionService (AdoptionRepository adoptionRepository, KittenShelterRepository kittenShelterRepository)
    {
        this.adoptionRepository = adoptionRepository;
        this.kittenShelterRepository = kittenShelterRepository;
    }

    public AdoptionDto newAdoptionReq (AdoptionDto adoptionDto)
    {
        Optional<KittenShelter> kittenId = kittenShelterRepository.findByIdAndAdoptedIsFalse(adoptionDto.getKitten_id());

        if(kittenId.isPresent())
        {
            Adoption adoption = new Adoption();
            adoption.setKittenId(kittenId.get().getId());
            adoption.setApplicant_name(adoptionDto.getApplicant_name());
            adoption.setPhone(adoptionDto.getPhone());
            adoption.setEmail(adoptionDto.getEmail());
            adoption.setMessage(adoptionDto.getMessage());
            adoption.setSocial_media_url(adoptionDto.getSocial_media_url());
            adoption.setStatus("pending");

            adoptionRepository.save(adoption);

            return adoptionDto;
        }
        else
        {
            throw new IllegalArgumentException("The kitten with ID " + adoptionDto.getKitten_id() + " is not available for adoption.");
        }
    }
}
