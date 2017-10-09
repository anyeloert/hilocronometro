/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilocronometro;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Rental Servicios
 */
public class Cronometro extends Thread {
    
    JLabel label;
    static int seg=0,min=0,hora=0;
    
    //Contructor
    
    public Cronometro(JLabel labelCrono){
        this.label = labelCrono;
    }

    @Override
    public void run() {
        while (InterfazCronometro.iniciarCronometro){            
            mostrarCronometro();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
    
    public void mostrarCronometro(){
        seg++; 
        if (seg>59){
            seg=0;
            min++;   
        }
        if (min>59){
            min=0;
            hora++;  
        }
        
        String textomin="",textoseg="",textohora="";
        if(seg<10){
            textoseg= "0" + seg;
        }else{
            textoseg= String.valueOf(seg);
        }
        if(min<10){
            textomin= "0" + min;
        }else{
            textomin= String.valueOf(min);
        }
        if(hora<10){
            textohora= "0" + hora;
        }else{
            textohora= String.valueOf(hora);
        }
        
        String reloj = textohora + ":" + textomin + ":" + textoseg;
        label.setText(reloj);
        
    }
    
}
