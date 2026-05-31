/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author lucas
 */
public class CsvLoggerImpl implements ILogger{
    private final String nomeArquivo;
    
    public CsvLoggerImpl(String nomeArquivo){
        if(nomeArquivo == null || nomeArquivo.isBlank()){
            throw new IllegalArgumentException("Nome de arquivo vazio.");
        }
        this.nomeArquivo = nomeArquivo;
        criarArquivo();
    }
    @Override
    public void criarLog(RegistroDeLogDTO logDTO) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, false))){
            writer.write(logDTO.getNomeUsuario() + "," + logDTO.getData() + "," + logDTO.getHora() + "," + logDTO.getCodigoPedido() + "," + logDTO.getNomeOperacao() + "," + logDTO.getNomeCliente());
            writer.newLine();
        
        }catch(IOException e){
            System.out.println("Erro ao adicionar Log CSV: " + e.getMessage());
        }
    }
    
    private void criarArquivo(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, false))){
            writer.write("Usuario,Data,Hora,Codigo,Operacao,Cliente\n");
        }catch(IOException e){
            System.out.println("Erro ao inicializar arquivo CSV: " + e.getMessage());
        }
    }
    
}
