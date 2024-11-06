package com.josesiyo_robbio.kitten_adoption.kitten.service;


import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import com.josesiyo_robbio.kitten_adoption.kitten.repository.KittenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetKittensService
{
    private final KittenRepository kittenRepository;


    public GetKittensService(   KittenRepository kittenRepository)
    {
        this.kittenRepository = kittenRepository;
    }


    public List<KittenDto> getKittens()
    {
        // Map entities to DTOs
        return kittenRepository.findAllByAdoptedFalse().stream()
                .map(kitten -> new KittenDto(kitten.getId(),kitten.getName(),kitten.getBreed(), kitten.getDescription(), kitten.getPhoto(),kitten.isAdopted(),kitten.getAge()))
                .collect(Collectors.toList());
    }
}
