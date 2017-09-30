

package model;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Observable;
public class MaquinaEstadoFinito extends Observable {
    private ArrayList <Estado> estados;
    private ArrayList <Transicion> transiciones;
    private ArrayList <Estado>arr;
    private ArrayList <Transicion>arr2;
    private int idEstado;
    private int idTran;
    private int u;
    boolean lineatemp;
    int templinex;
    int templinex2;
    int templiney;
    int templiney2;
    private int transicion;
    private int radioCirculo;
    
    XMLDocument xmlDoc;

    public boolean isLineatemp() {
        return lineatemp;
    }

    public void setLineatemp(boolean lineatemp) {
        this.lineatemp = lineatemp;
        this.setChanged();
        this.notifyObservers(null);
    }

    public int getTemplinex() {
        return templinex;
    }

    public void setTemplinex(int templinex) {
        this.templinex = templinex;
    }

    public int getTemplinex2() {
        return templinex2;
        
    }

    public void setTemplinex2(int templinex2) {
        this.templinex2 = templinex2;
        this.setChanged();
        this.notifyObservers(null);
    }

    public int getTempliney() {
        return templiney;
    }

    public void setTempliney(int templiney) {
        this.templiney = templiney;
    }

    public int getTempliney2() {
        return templiney2;
    }

    public void setTempliney2(int templiney2) {
        this.templiney2 = templiney2;
        this.setChanged();
        this.notifyObservers(null);
    }
    

    public int getIdTran() {
        return idTran;
    }

    public void setIdTran(int idTran) {
        this.idTran = idTran;
    }
    
    public int getidEstado() {
        return idEstado;
    }

    public void setidEstado(int estado) {
        this.idEstado = estado;
    }

    public int getTransicion() {
        return transicion;
    }

    public void setTransicion(int transicion) { 
        this.transicion = transicion;
    }
            
    public MaquinaEstadoFinito(){
      estados=new ArrayList<Estado>();
      transiciones= new ArrayList<Transicion>();
      arr2 = new ArrayList<Transicion>();
      idEstado = 0; 
      idTran =0;
      radioCirculo = 10;
      lineatemp = false;
    }
    
    public void crearTransicion(Estado s, Estado e, String simb){
        transiciones.add( new Transicion(e,s,simb));
        this.idEstado++;
        
    }

    public Estado getEstado(int posicion) {
        
        return estados.get(posicion);
    }

    public Transicion getTransiciones(int posicion) {
        return transiciones.get(posicion);
    }
  
    
    public boolean crearEstado(String t,String i, int x, int y){
           if(!this.id_Repetido(i)){
                estados.add(new Estado(t,i,x,y,u));
                this.u++;
                this.idEstado++;
                this.setChanged();
                this.notifyObservers(null);
               return true;
           }
           return false;
    }
    
    public boolean validaEstadoInicialUnico(){
        for(int i=0; i<this.getNumeroEstados();i++){
            if(this.getEstado(i).getTipo().equals("Inicial")){
                return false;
            }
        }
        return true;
    }
    
    public boolean id_Repetido(String a){
        
        if(estados.isEmpty())
            return false;
        else{
            for(int i=0;i<estados.size();i++){
                if(estados.get(i).getId().equals(a))
                    return true;
            }
            return false;
        }
    }
    public void muestraEstados(){
        if(!estados.isEmpty()){
            for(int i=0;i<estados.size();i++){
                System.out.println("Estado "+i+"  ID:"+estados.get(i).getId()+
                        "   Tipo:  "+estados.get(i).getTipo());
           }
        }
        else{
            System.out.println("No hay estados creados.");
        }
    }
    
    public boolean validaClickEstado(int x, int y){
        
        if(estados.size()>0){
            int temp_x=-1;
            int temp_y=-1;
            for(int i=0; i< estados.size(); i++){
                temp_x = estados.get(i).getX();
                temp_y = estados.get(i).getY();
                    if(x >= temp_x - radioCirculo && x <= temp_x + radioCirculo && y >= temp_y - radioCirculo && y <= temp_y + radioCirculo){
                      idEstado = i;
                      return true;
                    }
            }
        }
       return false;
    }
    
    public int getNumeroEstados(){
        return estados.size();
    }
    public int getNumeroTran(){
        return this.transiciones.size();
    }
    
    public void setEndPoint(int x, int y) {

        this.getEstado(this.getidEstado()).setX(x);
        this.getEstado(this.getidEstado()).setY(y);
        this.setChanged();
        this.notifyObservers(null);
    }
    
    public void setEndPointTran(int x, int y){
        this.getTransiciones(this.getIdTran()).getEstadoSaliente().setX(x);
        this.getTransiciones(this.getIdTran()).getEstadoSaliente().setY(y);
    }
    
    public void setCoordenadasEstado(int pos, int x, int y){
        this.getEstado(pos).setX(x);
        this.getEstado(pos).setY(y);
        this.setChanged();
        this.notifyObservers(null);
    }
    
    public void Limpiar(){
        this.estados.clear();
        this.transiciones.clear();
        
        this.idEstado = 0;
        this.u = 0;
        
        this.setChanged();
        this.notifyObservers(null);
    }

    public int estadoInicial(){
        for(int j=0; j<this.getNumeroEstados(); j++){
            if(this.getEstado(j).getTipo().equals("Inicial")){
                return j;
            }
        }
        return -1;
    }
    
    public int verificaTran(Estado es, String caracter){
        
        for(int p=0; p<this.getNumeroTran(); p++){
            if(this.getTransiciones(p).getEstadoEntrante().getUnico() == es.getUnico() && this.getTransiciones(p).getSimbolo().contains(caracter)){
              return this.getTransiciones(p).getEstadoSaliente().getUnico();
            }
        }
        return -1;
    }
    
    public int getEstadoByUnico(int unico){
        int x = -1;
        for(int i=0; i<this.getNumeroEstados(); i++)
            if(this.getEstado(i).getUnico()== unico){
                x = i;
                break;
            }
       return x;         
    }
    
    public boolean verificaHilera(String hile){
       int estadoActual = estadoInicial();
       int posicion;
       if(estadoActual >= 0 ){
           for(int i=0; i<hile.length(); i++){
               
               posicion = verificaTran(this.getEstado(estadoActual), hile.substring(i, (i+1)));
               if (posicion > -1){
                   estadoActual = this.getEstadoByUnico(posicion);
               }
               else{
                return false;                         
               }
           }
           if(this.getEstado(estadoActual).getTipo().equals("Final")){
               return true;
           }
           else{
               return false;
           }
       }
       return false;
    }

    public void guardar(String s) {
        try {
            System.out.print("Guardando... ");
            System.out.println(estados.size());
            xmlDoc = new XMLDocument();
            
            xmlDoc.addAlias("estados", MaquinaEstadoFinito.class);
            xmlDoc.addAlias("estado", Estado.class);
            xmlDoc.addAlias("transicion", Transicion.class);
            xmlDoc.addImplicitCollection(MaquinaEstadoFinito.class, "estados");
            xmlDoc.addImplicitCollection(MaquinaEstadoFinito.class, "transiciones"); // ***
            xmlDoc.serialize(estados, ArrayList.class);
            xmlDoc.serializeSeparator();
            xmlDoc.serialize(transiciones, ArrayList.class);  // *****
            xmlDoc.save(s);
            xmlDoc = null;
        } catch (Exception e) {
            
        }
    }
    
    public void cargar(String filename) {
        String xml1 = "";
        String xml2 = "";
        // Separar XML
        try {
            String fullXML = XMLDocument.readFile(filename, StandardCharsets.UTF_8);
            int i = fullXML.indexOf("<!---->");
            xml1 = fullXML.substring(0, i);
            xml2 = fullXML.substring(i + XMLDocument.SEPARATOR.length(), fullXML.length());
            
        } catch (IOException e) {
            
        }
        // Cargar Estados
        try {
            xmlDoc = new XMLDocument();
            xmlDoc.addAlias("estados", MaquinaEstadoFinito.class);
            xmlDoc.addAlias("estado", Estado.class);
            xmlDoc.addImplicitCollection(MaquinaEstadoFinito.class, "estados");
            arr = (ArrayList)xmlDoc.load(xml1);
            //estados = arr;
            xmlDoc = null;
        } catch (IOException e) {
            
        }
        // Cargar Transiciones
        try {
            xmlDoc = new XMLDocument();
            xmlDoc.addAlias("transiciones", MaquinaEstadoFinito.class);
            xmlDoc.addAlias("transicion", Transicion.class);
            xmlDoc.addAlias("estadoSaliente", Estado.class);
            xmlDoc.addAlias("estadoEntrante", Estado.class);
            xmlDoc.addImplicitCollection(MaquinaEstadoFinito.class, "transiciones");
            arr2 = (ArrayList)xmlDoc.load(xml2);
            //transiciones = arr2;
            xmlDoc = null;
        } catch (IOException e) {
            
        }
        for (int j=0;j<arr.size(); j++){
            this.crearEstado(arr.get(j).getTipo(), arr.get(j).getId(), arr.get(j).getX(), arr.get(j).getY());
        }
        
        for(int i=0;i<arr2.size();i++){
        this.crearTransicion( arr2.get(i).getEstadoEntrante(), arr2.get(i).getEstadoSaliente(), arr2.get(i).getSimbolo());
        }

        
        this.setChanged();
        this.notifyObservers(null);
    }
    
    public String CargaTransicionIds(Estado es){
        String valores ="";
        for(int i=0; i<this.getNumeroTran();i++){
            if(this.getTransiciones(i).getEstadoEntrante().getUnico() == es.getUnico()){
                valores=valores+this.getTransiciones(i).getSimbolo();
            }
        }
        return valores;
    }
    
    public boolean ValidaTransicionIds(Estado es, String input){
        String Ids = this.CargaTransicionIds(es);
        for(int i=0; i<input.length(); i++){
            if(Ids.contains(input.substring(i, i+1))){
                return false;
            }
        }
        return true;
    }
}
    
    
    