package com.josesiyo_robbio.kitten_adoption.kitten.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class KittenInfoResponse
{
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Positive(message = "Age must be a positive number")
    private int age;

    @NotBlank(message = "Breed cannot be empty")
    private String breed;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Photo cannot be empty")
    private String photo;

    @NotNull(message = "Adoption status cannot be null")
    private Boolean adopted;

    private Long id;


    // GETTERS
    public String getName()         { return name;          }
    public String getBreed()        { return breed;         }
    public String getDescription()  { return description;   }
    public String getPhoto()        { return photo;         }
    public boolean isAdopted()      { return adopted;       }
    public int getAge()             { return age;           }
    public Long getId()             { return id;            }


    // SETTERS
    public void setName(String name)                { this.name = name;                 }
    public void setBreed(String breed)              { this.breed = breed;               }
    public void setDescription(String description)  { this.description = description;   }
    public void setPhoto(String photo)              { this.photo = photo;               }
    public void setAdopted(boolean adopted)         { this.adopted = adopted;           }
    public void setAge(int age)                     { this.age = age;                   }
    public void setId(Long id)                      { this.id = id;                     }
}