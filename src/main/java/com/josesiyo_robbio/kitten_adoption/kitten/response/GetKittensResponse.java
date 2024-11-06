package com.josesiyo_robbio.kitten_adoption.kitten.response;

import com.josesiyo_robbio.kitten_adoption.kitten.dto.KittenDto;
import java.util.List;

public class GetKittensResponse
{
    private List<KittenDto> kittens;


    public GetKittensResponse(List<KittenDto> kittens)
    {
        this.kittens = kittens;
    }


    //GETTERS AND SETTERS
    public List<KittenDto> getKittens()             { return kittens;           }
    public void setKittens(List<KittenDto> kittens) { this.kittens = kittens;   }
}
