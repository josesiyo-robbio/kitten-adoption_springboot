package com.josesiyo_robbio.kitten_adoption.shelter.response;

import com.josesiyo_robbio.kitten_adoption.shelter.dto.ApplicationStatusDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AdoptionInfoResponse
{
    @Enumerated(EnumType.STRING)
    private ApplicationStatusDto status;
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
    public ApplicationStatusDto getStatus()               { return status;            }
    public String getSocial_media_url()     { return social_media_url;  }

    //SETTERS
    public void setApplicant_name(String applicant_name)        { this.applicant_name = applicant_name;         }
    public void setPhone(String phone)                          { this.phone = phone;                           }
    public void setEmail(String email)                          { this.email = email;                           }
    public void setMessage(String message)                      { this.message = message;                       }
    public void setStatus(String status)                        { this.status = ApplicationStatusDto.valueOf(status);                         }
    public void setSocial_media_url(String social_media_url)    { this.social_media_url = social_media_url;     }
}
