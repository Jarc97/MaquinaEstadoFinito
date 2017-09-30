package model;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("estado")
public class Estado {
    private String tipo;
    private String id;
    private int x;
    private int y;
    private int unico =0;
    public int getUnico() {
        return unico;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   

    public Estado(String tipo, String id, int x, int y, int u) {
        this.tipo = tipo;
        this.id = id;
        this.x = x;
        this.y = y;
        this.unico = u;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}