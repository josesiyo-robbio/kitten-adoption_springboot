package com.josesiyo_robbio.kitten_adoption.kitten.service;

import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.model.Kitten;
import com.josesiyo_robbio.kitten_adoption.kitten.repository.KittenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddKittyService
{
    @Autowired
    private KittenRepository kittenRepository;

    public  AddKittyService(KittenRepository kittenRepository)
    {
        this.kittenRepository = kittenRepository;
    }


    public KittenDto AddKitty(KittenDto kittenDto)
    {
        Kitten kitten = new Kitten();
        kitten.setName(kittenDto.getName());
        kitten.setAge(kittenDto.getAge());
        kitten.setBreed(kittenDto.getBreed());
        kitten.setDescription(kittenDto.getDescription());
        kitten.setPhoto(kittenDto.getPhoto());
        kitten.setAdopted(kittenDto.isAdopted());

        kittenRepository.save(kitten);

        return kittenDto;
    }


}
