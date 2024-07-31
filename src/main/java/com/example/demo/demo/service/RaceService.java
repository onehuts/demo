package com.example.demo.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.demo.dto.RaceRequestDto;
import com.example.demo.demo.dto.RaceResponseDto;
import com.example.demo.demo.exception.BusinessException;
import com.example.demo.demo.exception.ErrorCode;

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
                // calling이 첫번째 선수인 경우 예외 발생
                if(i == 0){
                    throw new BusinessException(ErrorCode.FIRST_PLAYER.getMessage(), ErrorCode.FIRST_PLAYER);
                }
                return i;
            }
        }
        // calling이 players 명단에 없는 경우 예외 발생
        throw new BusinessException(ErrorCode.WORNG_PLAYER.getMessage(), ErrorCode.WORNG_PLAYER);
    }
    
    private String[] changeRank(String[] players, int num){
        String temp = players[num-1];
        players[num-1] = players[num];
        players[num] = temp;
        return players;
    }
}
