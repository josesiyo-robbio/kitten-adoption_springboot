package com.josesiyo_robbio.kitten_adoption.shelter.response;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.AdoptionDto;

import java.util.List;

public class AllPendingAdoptionResponse
{
    private List<AdoptionDto> adoptions;


    public AllPendingAdoptionResponse(List<AdoptionDto> adoptions)
    {
        this.adoptions = adoptions;

    }


    public void setAdoptions(List<AdoptionDto> adoptions) {
        this.adoptions = adoptions;
    }

    public List<AdoptionDto> getAdoptions() {
        return adoptions;
    }


}
