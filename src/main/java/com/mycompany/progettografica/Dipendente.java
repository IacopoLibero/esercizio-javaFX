/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettografica;

/**
 *
 * @author itismeucci
 */
public class Dipendente 
{
    private String id;
    private String cf;
    private double stipendio;

    public Dipendente(String id, String cf, double stipendio) {
        this.id = id;
        this.cf = cf;
        this.stipendio = stipendio;
    }

    public String getId() {
        return id;
    }

    public String getCf() {
        return cf;
    }

    public double getStipendio() {
        return stipendio;
    }
    
}
