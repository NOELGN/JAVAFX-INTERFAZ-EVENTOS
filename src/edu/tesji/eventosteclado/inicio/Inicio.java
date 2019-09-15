
package edu.tesji.eventosteclado.inicio;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Inicio extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root=FXMLLoader.load(getClass().getResource("/edu/tesji/eventosteclado/vista/FXMLdiseñoEvent.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
           @Override
            public void handle(WindowEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Tesji");
            alert.setHeaderText("¿En realidad deseas salir?");
            alert.setContentText(null);
            Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {//valida si se pulso aceptar
                   // System.out.println("cerrado");
                }else{ 
                    event.consume();
                }
           }
       });
        primaryStage.show();
    }
    public static void main(String[]args){
        launch(args);
    }    
}
