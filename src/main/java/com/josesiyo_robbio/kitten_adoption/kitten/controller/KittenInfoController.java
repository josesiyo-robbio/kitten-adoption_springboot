package com.josesiyo_robbio.kitten_adoption.kitten.controller;


import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.response.KittenInfoResponse;
import com.josesiyo_robbio.kitten_adoption.kitten.service.KittenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/kitty")
public class KittenInfoController
{
    @Autowired
    private  KittenInfoService kittenInfoService;

    @GetMapping("/info/{id}")
    public ResponseEntity<KittenInfoResponse> kittenIfo(@PathVariable Long id)
    {
        //Call the Service
        KittenDto info = kittenInfoService.kittenInfo(id);

        //Response
        KittenInfoResponse response = new KittenInfoResponse();
        response.setId(info.getId());
        response.setName(info.getName());
        response.setAge(info.getAge());
        response.setBreed(info.getBreed());
        response.setDescription(info.getDescription());
        response.setPhoto(info.getPhoto());
        response.setAdopted(info.isAdopted());

        return ResponseEntity.ok(response);
    }
}
