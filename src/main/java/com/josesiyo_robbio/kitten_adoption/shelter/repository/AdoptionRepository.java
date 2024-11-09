package com.josesiyo_robbio.kitten_adoption.shelter.repository;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.ApplicationStatusDto;
import com.josesiyo_robbio.kitten_adoption.shelter.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;



public interface AdoptionRepository extends JpaRepository<Adoption, Long>
{
    List<Adoption> findByStatus(ApplicationStatusDto status);

    @Modifying
    @Query("UPDATE Adoption a SET a.status = 'rejected' WHERE a.kittenId = :kittenId AND a.id <> :adoptionId")
    void declineOtherRequests(Long kittenId, Long adoptionId);

}
