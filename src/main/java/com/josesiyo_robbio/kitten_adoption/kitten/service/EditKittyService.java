package com.josesiyo_robbio.kitten_adoption.kitten.service;

import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.model.Kitten;
import com.josesiyo_robbio.kitten_adoption.kitten.repository.KittenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditKittyService
{
    @Autowired
    private KittenRepository kittenRepository;

    public EditKittyService(KittenRepository kittenRepository)
    {
        this.kittenRepository = kittenRepository;
    }


    public KittenDto EditKitty(Long id, KittenDto kittenDto)
    {
        Optional<Kitten> existingKitten = kittenRepository.findById(id);
        if(existingKitten.isPresent())
        {
            //take the kitten selection
            Kitten kitten = existingKitten.get();

            //update the fields
            kitten.setName(kittenDto.getName());
            kitten.setAge(kittenDto.getAge());
            kitten.setBreed(kittenDto.getBreed());
            kitten.setDescription(kittenDto.getDescription());
            kitten.setPhoto(kittenDto.getPhoto());
            kitten.setAdopted(kittenDto.isAdopted());

            kitten = kittenRepository.save(kitten);

            return new KittenDto(
                    kitten.getId(),
                    kitten.getName(),
                    kitten.getBreed(),
                    kitten.getDescription(),
                    kitten.getPhoto(),
                    kitten.isAdopted(),
                    kitten.getAge()
            );
        }
        else
        {
            throw new RuntimeException("Kitten not found with ID: " + id);
        }

    }


}
