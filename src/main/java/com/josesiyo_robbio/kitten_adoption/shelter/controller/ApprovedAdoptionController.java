package com.josesiyo_robbio.kitten_adoption.shelter.controller;

import com.josesiyo_robbio.kitten_adoption.shelter.request.ApprovedAdoptionRequest;
import com.josesiyo_robbio.kitten_adoption.shelter.response.ApprovedAdoptionResponse;
import com.josesiyo_robbio.kitten_adoption.shelter.service.ApprovedAdoptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/shelter")
public class ApprovedAdoptionController
{

    @Autowired
    private  ApprovedAdoptionService approvedAdoptionService;


    public void setApprovedAdoptionService(ApprovedAdoptionService approvedAdoptionService)
    {
        this.approvedAdoptionService = approvedAdoptionService;
    }


    @PostMapping("/approved")
    public ResponseEntity<ApprovedAdoptionResponse> approved(@Valid @RequestBody ApprovedAdoptionRequest approvedAdoptionRequest)
    {
        try
        {
            approvedAdoptionService.approveAdoption(approvedAdoptionRequest.getAdoptionId(),approvedAdoptionRequest.getKittenId());

            // Return a response indicating success with a message
            ApprovedAdoptionResponse response = new ApprovedAdoptionResponse("Adoption successfully approved.");
            return ResponseEntity.ok(response); // Return 200 OK with the response body
        }
        catch (Exception e)
        {
            // Return a 500 Internal Server Error if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApprovedAdoptionResponse("Error: " + e.getMessage()));
        }
    }

}
