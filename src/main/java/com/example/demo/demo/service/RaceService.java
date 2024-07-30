package com.example.demo.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.demo.dto.RaceRequestDto;
import com.example.demo.demo.dto.RaceResponseDto;

@Service
public class RaceService {

    public RaceResponseDto logic(RaceRequestDto raceRequest){

        String[] players = convertToArr(raceRequest.getPlayers());
        String[] callings = convertToArr(raceRequest.getCallings());

        for(int i=0; i<callings.length; i++){
            int num = findNumber(players, callings[i]);
            changeRank(players, num);
        }

        RaceResponseDto raceResult = new RaceResponseDto();
        raceResult.setResult(convertToString(players));

        return raceResult;
    }

    private String[] convertToArr(String str){
        str = str.trim();
        str = str.replace(" ", "");
        String[] arr = str.split(",");
        return arr;
    }

    private String convertToString(String[] arr){
        String str = String.join(", ", arr);
        return str;
    }

    private int findNumber(String[] players, String calling){
        for(int i = 0; i < players.length; i++){
            if(players[i].equals(calling)){
                return i;
            }
        }
        return 0;
    }
    
    private String[] changeRank(String[] players, int num){
        String temp = players[num-1];
        players[num-1] = players[num];
        players[num] = temp;
        return players;
    }
}
