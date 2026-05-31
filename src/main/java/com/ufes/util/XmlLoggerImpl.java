/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author fabricio
 */
public class XmlLoggerImpl implements ILogger{

    @Override
    public void criarLog(RegistroDeLogDTO logDTO) {
        String stringXml = "<Registro>\n<NomeUsuario>" + logDTO.getNomeUsuario() +"</NomeUsuario>\n<Data>" +logDTO.getData() +"</Data>\n<Hora>" +logDTO.getHora() +"</Hora>\n<CodigoPedido>" +logDTO.getCodigoPedido() +"</CodigoPedido>\n<NomeOperacao>" +logDTO.getNomeOperacao() +"</NomeOperacao>\n<NomeCliente>" +logDTO.getNomeCliente() +"</NomeCliente>\n</Registro>";
        try {
            Files.writeString(Paths.get("logXML.xml"), stringXml + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro!!! " + e.getMessage());
        }
    }
}
