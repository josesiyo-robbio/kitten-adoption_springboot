package com.josesiyo_robbio.kitten_adoption.kitten.controller;

import com.josesiyo_robbio.kitten_adoption.kitten.response.GetKittensResponse;
import com.josesiyo_robbio.kitten_adoption.kitten.service.GetKittensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/kittens")
public class GetKittensController
{

    private final GetKittensService getKittensService;

    @Autowired
    public GetKittensController(GetKittensService getKittensService)
    {
        this.getKittensService = getKittensService;
    }


    @GetMapping
    public ResponseEntity<GetKittensResponse> getKittens()
    {
        GetKittensResponse response = new GetKittensResponse(getKittensService.getKittens());
        return ResponseEntity.ok(response);
    }
}