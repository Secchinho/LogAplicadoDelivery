/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.logauditoria;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author raphael
 */
public class JsonlLoggerImpl implements ILogger {
    private final String nomeArquivo;
    
    public JsonlLoggerImpl(String nomeArquivo){
        if(nomeArquivo == null || nomeArquivo.isBlank()){
            throw new IllegalArgumentException("Nome de arquivo vazio.");
        }
        this.nomeArquivo = nomeArquivo;
    }
    
    @Override
    public void criarLog(RegistroDeLogDTO logDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            String dtoString = mapper.writeValueAsString(logDTO);
            Files.writeString(Paths.get(this.nomeArquivo), dtoString + System.lineSeparator(), 
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (JsonProcessingException e) {
            System.out.println("Erro!!! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro!!! " + e.getMessage());

        }
    }

}
