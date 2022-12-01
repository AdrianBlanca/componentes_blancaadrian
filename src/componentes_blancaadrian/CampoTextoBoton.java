/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes_blancaadrian;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author Adrián Blanca Enríquez
 * 24/11/2022
 */
public class CampoTextoBoton extends HBox{

    @FXML
    private TextField textField;
    
    @FXML
    private Button button;
    
    private ObjectProperty<EventHandler<MouseEvent>> OnAction = new SimpleObjectProperty<EventHandler<MouseEvent>>();

    public CampoTextoBoton() {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("CampoTextoBoton.fxml"));
        fxmlloader.setRoot(this);
        fxmlloader.setController(this);
        
        try {
            fxmlloader.load();
            
        } catch(IOException ex) {
            throw new RuntimeException(ex);
            
        }
        
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onActionProperty().get().handle(event);
                
            }
            
        
        });
        
    }
    
    public String getText() {
        return textProperty().get();
        
    }

    public void setText(String value) {
        textProperty().set(value);
        
    }

    public StringProperty textProperty() {
        return textField.textProperty();
        
    }
    
    public final ObjectProperty<EventHandler<MouseEvent>> onActionProperty() {
        return OnAction;
        
    }
    
    public final void setOnAction(EventHandler<MouseEvent> handler) {
        OnAction.set(handler);
        
    }
    
    public final EventHandler<MouseEvent> getOnAction() {
        return OnAction.get();
        
    }
    
}
