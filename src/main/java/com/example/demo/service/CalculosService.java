package com.example.demo.service;

import com.example.demo.DTO.SomaRequest;
import com.example.demo.DTO.SomaResponse;
import com.example.demo.DTO.SubtracaoRequest;
import com.example.demo.DTO.SubtracaoResponse;
import com.example.demo.model.Calculos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculosService {


    public SomaResponse soma(SomaRequest entrada){
        Integer soma = 0;
        for(Integer i : entrada.getLista()){
            soma += i;
        }
        Calculos calculos = new Calculos();
        calculos.setSoma(soma);

        SomaResponse somaResponse = new SomaResponse();
        somaResponse.setSoma(calculos.getSoma());

        return somaResponse;
    }

    public SubtracaoResponse subtracao(SubtracaoRequest entrada)
    {
        Integer subtracao = 0;
        for(Integer i : entrada.getLista()){
            subtracao -= i;
        }
        Calculos calculos = new Calculos();
        calculos.setSubtracao(subtracao);

        SubtracaoResponse subtracaoResponse = new SubtracaoResponse();
        subtracaoResponse.setSubtracao(calculos.getSubtracao());
    }
}
