/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package componentes_blancaadrian;

import java.io.IOException;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Adrián Blanca Enríquez
 * 28/11/2022
 */
public class CampoTextoNumerico extends TextField{
    
    public CampoTextoNumerico() {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("CampoTextoNumerico.fxml"));
        fxmlloader.setRoot(this);
        fxmlloader.setController(this);
        
        try {
            fxmlloader.load();
            
        } catch(IOException ex) {
            throw new RuntimeException(ex);
            
        }
        
    }
    
    @Override
    public void replaceText(int start, int end, String text) {
        if (!text.matches("[a-z, A-Z]"))
            super.replaceText(start, end, text);

    }
    
    @Override
    public void replaceSelection(String text) {
        if (!text.matches("[a-z, A-Z]"))
            super.replaceSelection(text);

    }
    
}
