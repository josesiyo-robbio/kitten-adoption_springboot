package com.josesiyo_robbio.kitten_adoption.shelter.controller;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.AdoptionDto;
import com.josesiyo_robbio.kitten_adoption.shelter.request.NewAdoptionRequest;
import com.josesiyo_robbio.kitten_adoption.shelter.response.NewAdoptionResponse;
import com.josesiyo_robbio.kitten_adoption.shelter.service.NewAdoptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shelter")
public class NewAdoptionController
{
    @Autowired
    private  NewAdoptionService newAdoptionService;

    @PostMapping("/add")
    public ResponseEntity<NewAdoptionResponse> addAdoptionRequest(@Valid @RequestBody NewAdoptionRequest newAdoptionRequest)
    {
        //convert request data to DTO
        AdoptionDto adoptionDto = new AdoptionDto();
        adoptionDto.setKitten_id(newAdoptionRequest.getKittenId());
        adoptionDto.setApplicant_name(newAdoptionRequest.getApplicant_name());
        adoptionDto.setPhone(newAdoptionRequest.getPhoneNumber());
        adoptionDto.setEmail(newAdoptionRequest.getEmail());
        adoptionDto.setMessage(newAdoptionRequest.getMessage());
        adoptionDto.setSocial_media_url(newAdoptionRequest.getSocialMediaUrl());


        //call the service for the result
        AdoptionDto addAdoption = newAdoptionService.newAdoptionReq(adoptionDto);

        //convert dto to response
        NewAdoptionResponse newAdoptionResponse = new NewAdoptionResponse();
        newAdoptionResponse.setMessage("kitty request added successfully");

        return ResponseEntity.ok(newAdoptionResponse);


    }

}
