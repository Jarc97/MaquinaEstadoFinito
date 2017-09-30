/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.MaquinaEstadoFinito;
import model.Transicion;
import view.View;


public class Controller extends MouseAdapter implements MouseListener {
    MaquinaEstadoFinito model;
    View view;
    boolean arrastrar;
    boolean tran;
    int estadoActual;
    int validaEstado;
    int primerestado;
    String simbolos;
    int j;
    int posicionestadoinicialx;
    int posicionestadoinicialy;
    
    public Controller(MaquinaEstadoFinito mef, View view) {
        this.model = mef;
        this.view = view;
        this.arrastrar = false;
        this.arrastrar = false;
        view.setModel(mef);
        view.setController(this);
        this.estadoActual = -1;
        this.primerestado = -1;
        this.j = 0;
    }
    
    public void mousePressed(MouseEvent e) {
                
        if(model.validaClickEstado(e.getX(), e.getY()) && model.getNumeroEstados() > 0){
            j++;
            model.setTemplinex(model.getEstado(model.getidEstado()).getX());
            model.setTemplinex2(model.getEstado(model.getidEstado()).getX());
            model.setTempliney(model.getEstado(model.getidEstado()).getY());
            model.setTempliney2(model.getEstado(model.getidEstado()).getY());
            
            estadoActual = model.getEstado(model.getidEstado()).getUnico();
            arrastrar = true;
            tran = true;
            validaEstado = model.getidEstado();
            posicionestadoinicialx = e.getX();
            posicionestadoinicialy = e.getY();
            
            model.setLineatemp(true);
            
            if(j==1){
            primerestado = model.getidEstado();
            }
            if(j==2){
                
                simbolos = JOptionPane.showInputDialog(null,"Ingrese los Simbolos","");
                if(simbolos != null){
                    if(model.ValidaTransicionIds(model.getEstado(primerestado), simbolos)){
                model.crearTransicion(model.getEstado(primerestado), model.getEstado(model.getidEstado()), simbolos);
                }
                    else{
                        JOptionPane.showMessageDialog(view, "Valores de trancicion repetidos");
                    }
                }
                model.setLineatemp(false);
                j=0;
                tran = false;
            }
            
            }
        else{
            arrastrar = false;
            tran = false;
            validaEstado =-1;
            posicionestadoinicialx = -1;
            posicionestadoinicialx = -1;
            model.setLineatemp(false);
            j = 0;
        }
    }
    
    
    public void mouseDragged(MouseEvent e) {
        if(arrastrar){
           // int j = model.getidEstado();
            model.setEndPoint(e.getX(), e.getY());
            model.setLineatemp(false);
            j = 0;
        }
        
        
        if(tran){
            for(int i=0; i<model.getNumeroTran(); i++){
                 if(model.getTransiciones(i).getEstadoEntrante().getUnico()== this.estadoActual){
                    model.getTransiciones(i).getEstadoEntrante().setX(e.getX());
                    model.getTransiciones(i).getEstadoEntrante().setY(e.getY());
                }
                if(model.getTransiciones(i).getEstadoSaliente().getUnico() == this.estadoActual){
                    model.getTransiciones(i).getEstadoSaliente().setX(e.getX());
                    model.getTransiciones(i).getEstadoSaliente().setY(e.getY());
                }
            }
        }
    }
            
    public void mouseReleased(MouseEvent e) {
        
        if(arrastrar){
        model.setEndPoint(e.getX(), e.getY());
        tran = false;
        
        }
        
            if(model.validaClickEstado(e.getX(), e.getY()) && model.getNumeroEstados() > 0){
            if(model.getidEstado() == validaEstado && e.getX()== posicionestadoinicialx && e.getY()== posicionestadoinicialy){
                tran = true;
                //model.setLineatemp(true);
                model.setTemplinex(e.getX());
                model.setTempliney(e.getY());
                model.setTemplinex2(e.getX());
                model.setTempliney2(e.getY());
                
                            
            }
            else{
                tran = false;
                model.setLineatemp(false);
                
                
            }
            
        }
       
    }
    public void mouseMoved(MouseEvent e){
        
        if(tran){
            model.setTemplinex2(e.getX());
            model.setTempliney2(e.getY());        
        }

    }

}
    
