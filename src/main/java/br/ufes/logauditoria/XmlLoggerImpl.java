/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.logauditoria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author fabricio
 */
public class XmlLoggerImpl implements ILogger{

    private final String nomeArquivo;
    
    public XmlLoggerImpl(String nomeArquivo){
        if(nomeArquivo == null || nomeArquivo.isBlank()){
            throw new IllegalArgumentException("Nome de arquivo vazio.");
        }
        this.nomeArquivo = nomeArquivo;
    }
    
    @Override
    public void criarLog(RegistroDeLogDTO logDTO) {
        String stringXml = "<Registro>\n<NomeUsuario>" + logDTO.getNomeUsuario() 
                + "</NomeUsuario>\n<Data>" + logDTO.getData() + "</Data>\n<Hora>" 
                + logDTO.getHora() +"</Hora>\n<CodigoPedido>" + logDTO.getCodigoPedido() 
                +"</CodigoPedido>\n<NomeOperacao>" + logDTO.getNomeOperacao() 
                + "</NomeOperacao>\n<NomeCliente>" + logDTO.getNomeCliente() 
                +"</NomeCliente>\n</Registro>";
        try {
            Files.writeString(Paths.get(this.nomeArquivo), stringXml + System.lineSeparator(), 
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro!!! " + e.getMessage());
        }
    }
}
