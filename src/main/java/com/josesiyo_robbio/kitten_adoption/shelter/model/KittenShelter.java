package com.josesiyo_robbio.kitten_adoption.shelter.model;

import jakarta.persistence.*;



@Entity
@Table(name = "kittens")
public class KittenShelter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private String description;
    private String photo;
    private Boolean adopted =false;
    private int age;


    //GETTERS
    public Long     getId()             { return id;            }
    public String   getName()           { return name;          }
    public String   getBreed()          { return breed;         }
    public String   getPhoto()          { return photo;         }
    public String   getDescription()    { return description;   }
    public Boolean  isAdopted()         { return adopted;       }
    public int      getAge()            { return age;           }


    //SETTERS
    public void setAdopted(boolean adopted)         {   this.adopted = adopted;         }
    public void setId(Long id)                      {   this.id = id;                   }
    public void setBreed(String breed)              {   this.breed = breed;             }
    public void setName(String name)                {   this.name = name;               }
    public void setAge(int age)                     {   this.age = age;                 }
    public void setDescription(String description)  {   this.description = description; }
    public void setPhoto(String photo)              {   this.photo = photo;             }

}