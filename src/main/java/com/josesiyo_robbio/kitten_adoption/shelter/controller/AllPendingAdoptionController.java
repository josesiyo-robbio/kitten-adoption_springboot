package com.josesiyo_robbio.kitten_adoption.shelter.controller;


import com.josesiyo_robbio.kitten_adoption.shelter.response.AllPendingAdoptionResponse;
import com.josesiyo_robbio.kitten_adoption.shelter.service.AllPendingAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shelter")
public class AllPendingAdoptionController
{
    private  final AllPendingAdoptionService allPendingAdoptionService;

    @Autowired
    public AllPendingAdoptionController(AllPendingAdoptionService allPendingAdoptionService)
    {
        this.allPendingAdoptionService = allPendingAdoptionService;
    }

    @GetMapping
    public ResponseEntity<AllPendingAdoptionResponse> getAllPendingAdoptions()
    {
        AllPendingAdoptionResponse response = new AllPendingAdoptionResponse(allPendingAdoptionService.adoptionDtoList());
        return ResponseEntity.ok(response);
    }

}
