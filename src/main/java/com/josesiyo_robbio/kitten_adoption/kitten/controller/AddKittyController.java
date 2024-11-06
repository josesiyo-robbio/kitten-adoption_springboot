package com.josesiyo_robbio.kitten_adoption.kitten.controller;

import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.request.AddKittyRequest;
import com.josesiyo_robbio.kitten_adoption.kitten.response.AddKittenResponse;
import com.josesiyo_robbio.kitten_adoption.kitten.service.AddKittyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kitty")
public class AddKittyController
{
    @Autowired
    private AddKittyService addKittyService;


    @PostMapping("/add")
    public ResponseEntity<AddKittenResponse> addKitty(@RequestBody @Valid AddKittyRequest addKittyRequest)
    {
        //convert request to dto
        KittenDto kittenDto = new KittenDto();
        kittenDto.setName(addKittyRequest.getName());
        kittenDto.setBreed(addKittyRequest.getBreed());
        kittenDto.setDescription(addKittyRequest.getDescription());
        kittenDto.setPhoto(addKittyRequest.getPhoto());
        kittenDto.setAge(addKittyRequest.getAge());
        kittenDto.setAdopted(false);


        //call service for the result
        KittenDto addKitty = addKittyService.AddKitty(kittenDto);


        //convert dto result to response
        AddKittenResponse addKittenResponse = new AddKittenResponse();
        addKittenResponse.setName(addKitty.getName());
        addKittenResponse.setBreed(addKitty.getBreed());
        addKittenResponse.setDescription(addKitty.getDescription());
        addKittenResponse.setPhoto(addKitty.getPhoto());
        addKittenResponse.setAge(addKitty.getAge());
        return ResponseEntity.ok(addKittenResponse);

    }
}
