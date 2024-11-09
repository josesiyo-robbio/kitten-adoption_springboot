package com.josesiyo_robbio.kitten_adoption.shelter.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;

public class AdoptionDto
{
    @Enumerated(EnumType.STRING)
    private ApplicationStatusDto status;

    @NotNull(message = "Kitten ID cannot be null")
    private Long kitten_id;

    @NotBlank(message = "Applicant name cannot be empty")
    private String applicant_name;

    @NotBlank(message = "Phone number cannot be empty")
    private String phone;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Message cannot be empty")
    private String message;

    @NotBlank(message = "Social media URL cannot be empty")
    @URL(message = "Social media URL should be a valid URL")
    private String social_media_url;


    public AdoptionDto(ApplicationStatusDto status, String applicant_name, String phone, String email, String message, String social_media_url, Long kitten_id)
    {
        this.status             =   status;
        this.applicant_name     =   applicant_name;
        this.phone              =   phone;
        this.email              =   email;
        this.message            =   message;
        this.social_media_url   =   social_media_url;
        this.kitten_id          =   kitten_id;
    }


    public AdoptionDto() { }


    //GETTERS
    public Long getKitten_id()                  { return kitten_id;         }
    public String getApplicant_name()           { return applicant_name;    }
    public String getPhone()                    { return phone;             }
    public String getEmail()                    { return email;             }
    public String getMessage()                  { return message;           }
    public ApplicationStatusDto getStatus()     { return status;            }
    public String getSocial_media_url()         { return social_media_url;  }


    //SETTERS
    public void setKitten_id(Long kitten_id)                    { this.kitten_id = kitten_id;                           }
    public void setApplicant_name(String applicant_name)        { this.applicant_name = applicant_name;                 }
    public void setPhone(String phone)                          { this.phone = phone;                                   }
    public void setEmail(String email)                          { this.email = email;                                   }
    public void setMessage(String message)                      { this.message = message;                               }
    public void setStatus(String status)                        { this.status = ApplicationStatusDto.valueOf(status);   }
    public void setSocial_media_url(String social_media_url)    { this.social_media_url = social_media_url;             }

}
