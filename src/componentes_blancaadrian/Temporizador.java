/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package componentes_blancaadrian;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class Temporizador {

    @FXML
    private Label tiempo;

      public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
          fxmlLoader.load();

        } catch(IOException ex) {
            throw new RuntimeException(ex);

        }
          
      }
    
      public void setTiempo(int t) {
          tiempo.setText(String.valueOf(t));
          
      }
      
      public void empezarCuenta() {
          Timeline timeline = new Timeline();
          timeline.setCycleCount(Timeline.INDEFINITE);
          timeline.setAutoReverse(false);
          
          timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler() {
              @Override
              public void handle(Event event) {
                  int t = Integer.parseInt(tiempo.getText()) - 1;
                  tiempo.setText(String.valueOf(t));
                  if(t <= 0)
                      timeline.stop();
                  
              }
              
          
          }));
          
          timeline.play();
          
      }
      
}
