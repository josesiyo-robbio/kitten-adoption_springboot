package com.josesiyo_robbio.kitten_adoption.shelter.request;

public class ApprovedAdoptionRequest
{
    private Long adoptionId;
    private Long kittenId;


    public Long getKittenId() {
        return kittenId;
    }

    public void setKittenId(Long kittenId) {
        this.kittenId = kittenId;
    }

    public Long getAdoptionId() {
        return adoptionId;
    }

    public void setAdoptionId(Long adoptionId) {
        this.adoptionId = adoptionId;
    }


}
