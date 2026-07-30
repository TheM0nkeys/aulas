package com.example.demo.controller;

import com.example.demo.DTO.SomaResponse;
import com.example.demo.DTO.SomaRequest;
import com.example.demo.DTO.SubtracaoRequest;
import com.example.demo.DTO.SubtracaoResponse;
import com.example.demo.model.Calculos;
import com.example.demo.service.CalculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CalculosController {
    @Autowired
    private CalculosService calculosService;

    @PostMapping("soma")
    public ResponseEntity<SomaResponse> soma (@RequestBody SomaRequest entrada){
        try{
            SomaResponse somaResponse = this.calculosService.soma(entrada);
            return new ResponseEntity<SomaResponse>(somaResponse, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("subtracao")
    public ResponseEntity<SubtracaoResponse> subtracao (@RequestBody SubtracaoRequest entrada){
        try{
            SubtracaoResponse subtracaoResponse = this.calculosService.subtracao(entrada);
            return new ResponseEntity<SubtracaoResponse>(subtracaoResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
