package com.example.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.dto.RaceRequestDto;
import com.example.demo.demo.dto.RaceResponseDto;
import com.example.demo.demo.service.RaceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RaceController {

    private final RaceService raceService;

    @GetMapping("/rank")
    @ResponseBody
    public RaceResponseDto query(@Valid RaceRequestDto raceRequest){
        RaceResponseDto raceResult = raceService.logic(raceRequest);
        return raceResult;
    }
}
