package com.josesiyo_robbio.kitten_adoption.shelter.repository;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.ApplicationStatusDto;
import com.josesiyo_robbio.kitten_adoption.shelter.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface AdoptionRepository extends JpaRepository<Adoption, Long>
{
    List<Adoption> findByStatus(ApplicationStatusDto status);

    List<Adoption> findByKittenId(int kittenId);


   // List<Adoption> findByStatus(String status);
}
