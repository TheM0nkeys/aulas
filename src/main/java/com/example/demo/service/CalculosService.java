package com.example.demo.service;

import com.example.demo.DTO.*;
import com.example.demo.model.Calculos;
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

        return subtracaoResponse;
    }

    public MediaResponse media (MediaRequest entrada)
    {
        Double media = 0.0;
        Integer contador = 0;
        for(Double i : entrada.getLista())
        {
            media += i;
            contador++;
        }
        media /= contador;

        Calculos calculos = new Calculos();
        calculos.setMedia(media);

        MediaResponse mediaResponse = new MediaResponse();
        mediaResponse.setMedia(calculos.getMedia());

        return mediaResponse;
    }
}
