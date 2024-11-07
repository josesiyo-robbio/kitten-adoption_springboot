package com.josesiyo_robbio.kitten_adoption.shelter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class KittenShelterDto
{
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Breed cannot be empty")
    private String breed;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Photo cannot be empty")
    private String photo;

    @NotNull(message = "Adoption status cannot be null")
    private Boolean adopted;

    @Positive(message = "Age must be a positive number")
    private int age;

    private Long id;

    public KittenShelterDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public KittenShelterDto(Long id, String name, String breed, String description, String photo, Boolean adopted, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adopted = adopted;
        this.breed = breed;
        this.description = description;
        this.photo = photo;
    }


    // GETTERS
    public String getName()         { return name;          }
    public String getBreed()        { return breed;         }
    public String getDescription()  { return description;   }
    public String getPhoto()        { return photo;         }
    public Boolean isAdopted()      { return adopted;       }
    public int getAge()             { return age;           }


    // SETTERS
    public void setName(String name)                { this.name = name;                 }
    public void setBreed(String breed)              { this.breed = breed;               }
    public void setDescription(String description)  { this.description = description;   }
    public void setPhoto(String photo)              { this.photo = photo;               }
    public void setAdopted(boolean adopted)         { this.adopted = adopted;           }
    public void setAge(int age)                     { this.age = age;                   }

}
