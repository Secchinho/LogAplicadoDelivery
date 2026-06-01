/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufes.logauditoria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author raphael
 */
public class RegistroDeLogDTO {

    private String nomeUsuario;
    private String data;
    private String hora;
    private int codigoPedido;
    private String nomeOperacao;
    private String nomeCliente;

    public RegistroDeLogDTO(String nomeUsuario, LocalDateTime dataHora,
            int codidoPedido, String nomeOperacao, String nomeCliente) {
        this.nomeUsuario = nomeUsuario;
        this.data = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = dataHora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.codigoPedido = codidoPedido;
        this.nomeOperacao = nomeOperacao;
        this.nomeCliente = nomeCliente;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public String getData() {
        return data;
    }
    
    public String getHora() {
        return hora;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setCodigoPedido(int codidoPedido) {
        this.codigoPedido = codidoPedido;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setNomeOperacao(String nomeOperacao) {
        this.nomeOperacao = nomeOperacao;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

}
