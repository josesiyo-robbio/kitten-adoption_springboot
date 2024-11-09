package com.josesiyo_robbio.kitten_adoption.shelter.repository;

import com.josesiyo_robbio.kitten_adoption.shelter.model.KittenShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;



public interface KittenShelterRepository extends JpaRepository<KittenShelter, Long>
{
    Optional<KittenShelter> findByIdAndAdoptedIsFalse(Long id);
}
