package com.mycompany.progettografica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController 
{
    
    @FXML
    private Label L1;
    @FXML
    private Label L2;
    @FXML
    private Label L3;
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField cf;
    
    @FXML
    private TextField stipendio;
    
    gestoredip gestore = new gestoredip();
   
    
    @FXML
    public void aggiungi_dipendente(ActionEvent event)
    {
        boolean status;
        Dipendente d=new Dipendente(id.getText(),cf.getText(),Double.parseDouble(stipendio.getText()));
        status=gestore.aggiungi(d);
        if(status==true)
            L1.setText("Dipendente <"+d.getCf()+"> inserito correttamente");
        else
            L1.setText("Dipendente errore di inserimento");
        
    }
    @FXML
    public void mediaStipendi(ActionEvent event)
    {
        L2.setText(String.valueOf(gestore.calcola_media()));
    }
    @FXML
    public void salvaDipendenti(ActionEvent event)
    {
        gestore.salva();
    }
    @FXML
    public void caricaDipendenti(ActionEvent event)
    {
        L3.setText("dipendenti letti: "+String.valueOf(gestore.carica()));
    }
    
}
