package com.josesiyo_robbio.kitten_adoption.shelter.service;


import com.josesiyo_robbio.kitten_adoption.shelter.dto.AdoptionDto;
import com.josesiyo_robbio.kitten_adoption.shelter.dto.ApplicationStatusDto;
import com.josesiyo_robbio.kitten_adoption.shelter.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllPendingAdoptionService
{
    @Autowired
    private AdoptionRepository adoptionRepository;

    public AllPendingAdoptionService(AdoptionRepository adoptionRepository)
    {
        this.adoptionRepository = adoptionRepository;
    }

    public List<AdoptionDto> adoptionDtoList()
    {
        ApplicationStatusDto pendingStatus = ApplicationStatusDto.pending;

        return adoptionRepository.findByStatus(pendingStatus).stream().map(
                adoption -> new AdoptionDto(
                        adoption.getStatus(),
                        adoption.getApplicant_name(),
                        adoption.getPhone(),
                        adoption.getEmail(),
                        adoption.getMessage(),
                        adoption.getSocial_media_url(),
                        adoption.getKittenId()
                )
        ).collect(Collectors.toList());

    }

}
