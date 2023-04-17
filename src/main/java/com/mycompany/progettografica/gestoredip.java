/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettografica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author itismeucci
 */
public class gestoredip 
{
    private ArrayList<Dipendente>lista=new ArrayList();
    
    public boolean aggiungi(Dipendente d)
    {
        if(lista.contains(d))
        {
            return false;
        }
        else 
        {
            lista.add(d);
            return true;
        }
    }
    
    public double calcola_media()
    {
        double media=0.0;
        for(int i=0;i<lista.size();i++)
        {
            media=media+lista.get(i).getStipendio();
        }
        media=media/lista.size();
        return media;
    }
    public void salva()
    {
        String nomefile="lista.txt";
        try 
        {
            FileWriter fileWriter = new FileWriter(nomefile,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<lista.size();i++)
            {
                bufferedWriter.write(lista.get(i).getId()+","+lista.get(i).getCf()+","+lista.get(i).getStipendio());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch(IOException ex) 
        {
            System.out.println("Errore nella scrittura sul file '" + nomefile + "'");
        }
    }
    
    public int carica()
    {
        lista.clear();
        String line = "";
        int i=0;
        String nomefile="lista.txt";
        try 
        {
            FileReader fileReader = new FileReader(nomefile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) 
            {
                i++;
                String[] elementi = line.split(",");
                Dipendente a=new Dipendente(elementi[0],elementi[1],Double.parseDouble(elementi[2]));
                lista.add(a);
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Impossibile aprire il file '" + nomefile + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println("Errore durante la lettura del file '" + nomefile + "'");                  
        }
        
        for(int j=0;j<lista.size();j++)
        {
            System.out.println("\n"+lista.get(j).getId()+","+lista.get(j).getCf()+","+lista.get(j).getStipendio());
        }
        return i;
    }
}
