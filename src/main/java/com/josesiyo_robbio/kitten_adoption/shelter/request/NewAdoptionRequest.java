package com.josesiyo_robbio.kitten_adoption.shelter.request;



public class NewAdoptionRequest
{
    private Long KittenId;
    private String phoneNumber;
    private String email;
    private String message;
    private String socialMediaUrl;
    private String applicant_name;

    public String getSocialMediaUrl() {
        return socialMediaUrl;
    }

    public void setSocialMediaUrl(String socialMediaUrl) {
        this.socialMediaUrl = socialMediaUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Long getKittenId() {
        return KittenId;
    }

    public void setKittenId(Long kittenId) {
        KittenId = kittenId;
    }

    public void setApplicant_name(String applicant_name)
    { this.applicant_name = applicant_name;         }
    public String getApplicant_name()       { return applicant_name;    }


}
