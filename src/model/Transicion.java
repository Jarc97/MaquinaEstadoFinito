package model;
public class Transicion {
    private Estado estadoSaliente,estadoEntrante;
    private String simbolo;
    
    public Transicion(Estado estadoSaliente, Estado estadoEntrante, String simbolo) {
        this.estadoSaliente = estadoSaliente;
        this.estadoEntrante = estadoEntrante;
        this.simbolo = simbolo;
    }

    public Estado getEstadoSaliente() {
        return estadoSaliente;
    }

    public Estado getEstadoEntrante() {
        return estadoEntrante;
    }

    public String getSimbolo() {
        return simbolo;
    }
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    

}
