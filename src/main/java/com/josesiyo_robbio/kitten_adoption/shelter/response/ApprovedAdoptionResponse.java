package com.josesiyo_robbio.kitten_adoption.shelter.response;

public class ApprovedAdoptionResponse
{
    private String message;


    // Constructor that sets the message
    public ApprovedAdoptionResponse(String message)
    {
        this.message = message;
    }


    //GETTERS AND SETTERS
    public String getMessage()              { return message;           }
    public void setMessage(String message)  { this.message = message;   }

}
