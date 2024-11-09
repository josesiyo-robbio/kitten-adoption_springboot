package com.josesiyo_robbio.kitten_adoption.shelter.service;

import com.josesiyo_robbio.kitten_adoption.shelter.model.Adoption;
import com.josesiyo_robbio.kitten_adoption.shelter.model.KittenShelter;
import com.josesiyo_robbio.kitten_adoption.shelter.repository.AdoptionRepository;
import com.josesiyo_robbio.kitten_adoption.shelter.repository.KittenShelterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ApprovedAdoptionService
{
    @Autowired
    private AdoptionRepository adoptionRepository;

    private final KittenShelterRepository kittenShelterRepository;

    public ApprovedAdoptionService(AdoptionRepository adoptionRepository, KittenShelterRepository kittenShelterRepository)
    {
        this.adoptionRepository = adoptionRepository;
        this.kittenShelterRepository = kittenShelterRepository;
    }


    @Transactional
    public void approveAdoption(Long adoptionId, Long kittenId)
    {
        // Validate if the kitten has already been adopted
        KittenShelter kittenShelter = kittenShelterRepository.findById(kittenId)
                .orElseThrow(() -> new EntityNotFoundException("KittenShelter not found with id: " + kittenId));

        if (kittenShelter.isAdopted())
        {
            // If the kitten is already adopted, throw an exception or handle the error as needed
            throw new IllegalStateException("This kitten has already been adopted.");
        }


        // First transaction: Retrieve and update the approved adoption status
        Adoption adoption = adoptionRepository.findById(adoptionId)
                .orElseThrow(() -> new EntityNotFoundException("Adoption not found with id: " + adoptionId));
        adoption.setStatus("approved");
        adoptionRepository.save(adoption);


        // Second transaction: Decline other adoption requests for the same kittenId
        adoptionRepository.declineOtherRequests(kittenId, adoptionId);


        // Third transaction: Mark the kitten as adopted
        kittenShelter.setAdopted(true);
        kittenShelterRepository.save(kittenShelter); // Persist the change to the database
    }

}
