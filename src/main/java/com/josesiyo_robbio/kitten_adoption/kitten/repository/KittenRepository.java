package com.josesiyo_robbio.kitten_adoption.kitten.repository;

import com.josesiyo_robbio.kitten_adoption.kitten.model.Kitten;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface KittenRepository extends JpaRepository<Kitten, Long>
{
    List<Kitten> findAllByAdoptedFalse();
}
