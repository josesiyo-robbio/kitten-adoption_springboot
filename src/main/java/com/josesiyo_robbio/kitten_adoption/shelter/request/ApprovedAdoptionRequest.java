package com.josesiyo_robbio.kitten_adoption.shelter.request;

public class ApprovedAdoptionRequest
{
    private Long adoptionId;
    private Long kittenId;


    //GETTERS
    public Long getKittenId() { return kittenId;        }
    public Long getAdoptionId() { return adoptionId;    }


    //SETTERS
    public void setKittenId(Long kittenId)      { this.kittenId = kittenId;         }
    public void setAdoptionId(Long adoptionId)  { this.adoptionId = adoptionId;     }

}
