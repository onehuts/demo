package com.example.demo.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceRequestDto {
    
    @NotBlank
    private String players;
    @NotBlank
    private String callings;
}
