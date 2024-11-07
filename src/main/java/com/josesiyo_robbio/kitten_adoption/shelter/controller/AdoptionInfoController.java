package com.josesiyo_robbio.kitten_adoption.shelter.controller;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.AdoptionDto;
import com.josesiyo_robbio.kitten_adoption.shelter.response.AdoptionInfoResponse;
import com.josesiyo_robbio.kitten_adoption.shelter.service.AdoptionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/shelter")
@RestController
public class AdoptionInfoController
{
    @Autowired
    private AdoptionInfoService adoptionInfoService;


    @GetMapping("/info/{id}")
    public ResponseEntity<AdoptionInfoResponse> adoptionInfo(@PathVariable Long id)
    {
        //call the service
        AdoptionDto info = adoptionInfoService.info(id);

        //use the service
        AdoptionInfoResponse response = new AdoptionInfoResponse();
        response.setApplicant_name(info.getApplicant_name());
        response.setPhone(info.getPhone());
        response.setEmail(info.getEmail());
        response.setMessage(info.getMessage());
        response.setSocial_media_url(info.getSocial_media_url());
        response.setStatus(String.valueOf(info.getStatus()));

        //convert to response
        AdoptionInfoResponse infoResponse = new AdoptionInfoResponse();
        infoResponse.setApplicant_name(info.getApplicant_name());
        infoResponse.setPhone(info.getPhone());
        infoResponse.setEmail(info.getEmail());
        infoResponse.setMessage(info.getMessage());
        infoResponse.setSocial_media_url(info.getSocial_media_url());
        infoResponse.setStatus(String.valueOf(info.getStatus()));

        return ResponseEntity.ok(infoResponse);




    }
}
