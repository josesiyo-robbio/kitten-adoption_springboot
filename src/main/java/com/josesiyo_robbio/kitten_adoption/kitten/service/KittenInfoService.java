package com.josesiyo_robbio.kitten_adoption.kitten.service;

import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.model.Kitten;
import com.josesiyo_robbio.kitten_adoption.kitten.repository.KittenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;



@Service
public class KittenInfoService
{
    @Autowired
    private KittenRepository kittenRepository;


    public  KittenInfoService(KittenRepository kittenRepository)
    {
        this.kittenRepository = kittenRepository;
    }


    public KittenDto kittenInfo(Long id)
    {
        Optional<Kitten> kittenOptional = kittenRepository.findById(id);
        return kittenOptional.map(kitten -> new KittenDto(kitten.getId(),kitten.getName(),kitten.getBreed(), kitten.getDescription(), kitten.getPhoto(),kitten.isAdopted(),kitten.getAge())).orElse(null);
    }

}
