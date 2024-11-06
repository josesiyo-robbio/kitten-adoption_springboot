package com.josesiyo_robbio.kitten_adoption.kitten.controller;


import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.request.EditKittyRequest;
import com.josesiyo_robbio.kitten_adoption.kitten.response.EditKittenResponse;
import com.josesiyo_robbio.kitten_adoption.kitten.service.EditKittyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/kitty")
public class EditKittyController
{
    @Autowired
    private  EditKittyService editKittyService;

    @PutMapping("/edit/{id}")
    public ResponseEntity<EditKittenResponse> editKitty(@Valid @PathVariable Long id, @RequestBody EditKittyRequest editKittyRequest)
    {
        //convert request to dto
        KittenDto kittenDto = new KittenDto();
        kittenDto.setName(editKittyRequest.getName());
        kittenDto.setBreed(editKittyRequest.getBreed());
        kittenDto.setDescription(editKittyRequest.getDescription());
        kittenDto.setPhoto(editKittyRequest.getPhoto());
        kittenDto.setAge(editKittyRequest.getAge());
        kittenDto.setAdopted(false);

        //call service for the result
        KittenDto updatedKitten = editKittyService.EditKitty(id, kittenDto);

        //convert to response
        EditKittenResponse response = new EditKittenResponse();
        response.setName(updatedKitten.getName());
        response.setBreed(updatedKitten.getBreed());
        response.setDescription(updatedKitten.getDescription());
        response.setPhoto(updatedKitten.getPhoto());
        response.setAge(updatedKitten.getAge());
        response.setAdopted(updatedKitten.isAdopted());

        return ResponseEntity.ok(response);



    }
}
