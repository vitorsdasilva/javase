/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.udemy.desafioDadosMedico;

import br.com.cursojavaseudemy.dadosmedicos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author e333832
 */



public class ConsultaDadosMedico {
    
    
    private int crm;
    private String nome, especialidade;
        
     
    
    public ConsultaDadosMedico(int crm, String nome, String especialidade){
        this.crm=crm;
        this.nome=nome;
        this.especialidade=especialidade;
    }    
    
    public ConsultaDadosMedico(){
        
    }    
        
    public static void main (String[] args){
        
    }
        

    /**
     * @return the crm
     */
    public int getCrm() {
        return crm;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(int crm) {
        this.crm = crm;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
        
}
