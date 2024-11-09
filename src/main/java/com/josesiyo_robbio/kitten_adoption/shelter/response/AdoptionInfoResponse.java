package com.josesiyo_robbio.kitten_adoption.shelter.response;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.ApplicationStatusDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AdoptionInfoResponse
{
    @Enumerated(EnumType.STRING)
    private ApplicationStatusDto status;

    public AdoptionInfoResponse(ApplicationStatusDto status, String applicant_name, String phone, String email, String message, String social_media_url)
    {
        this.status = status;
        this.applicant_name = applicant_name;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.social_media_url = social_media_url;
    }


    private String applicant_name;
    private String phone;
    private String email;
    private String message;
    private String social_media_url;


    //GETTERS
    public String getApplicant_name()       { return applicant_name;    }
    public String getPhone()                { return phone;             }
    public String getEmail()                { return email;             }
    public String getMessage()              { return message;           }
    public ApplicationStatusDto getStatus() { return status;            }
    public String getSocial_media_url()     { return social_media_url;  }

}
