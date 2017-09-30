
    package model;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Julio
 */
public class XMLDocument {
    
    static final String SEPARATOR = "<!---->";
    
    String xmlStr;
    XStream xstream;
    FileOutputStream fos;
    
    public XMLDocument() {
        xmlStr = "";
        xstream = new XStream(new DomDriver());
        // XStream.setupDefaultSecurity(xstream);
    }
    
    public void addAlias(String str, Class cls) {
        xstream.alias(str, cls);
    }
    
    public void addImplicitCollection(Class cls, String str) {
        xstream.addImplicitCollection(cls, str);
    }
    
    public void serialize(Object obj, Class type) {
        // System.out.println(type);
        // System.out.println(obj.getClass());
        
        if (obj.getClass() == type) {
            xmlStr = xmlStr + xstream.toXML(obj);
            xmlStr = xmlStr + "\n";
        }
    }
    
    public void serializeSeparator() {
        xmlStr = xmlStr + SEPARATOR;
        xmlStr = xmlStr + "\n";
    }
    public boolean save(String s) throws IOException {
        try {
            fos = new FileOutputStream(s);
            byte[] bytes = xmlStr.getBytes();
            fos.write(bytes);
            
        } catch (Exception e) {
            return false;
        } finally {
            fos.flush();
            fos.close();
            return true;
        }
    }
    
    
    static String readFile(String path, Charset encoding)
    throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public Object load(String xml) throws IOException {
        return xstream.fromXML(xml);
    }
}
   
    
