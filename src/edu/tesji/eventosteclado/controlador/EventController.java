package edu.tesji.eventosteclado.controlador;


import edu.tesji.eventosteclado.modelo.EventModel;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class EventController implements Initializable{
   
        ObservableList<String> opCarrera=FXCollections.observableArrayList(
            "Ingenieria en sistemas computacionales",
            "Licenciatura en administracion",
            "Ingenieria Industrial",
            "Ingenieria en Mecatronica");
        
    @FXML private ComboBox<String> cmbCarrera;  
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    
    @FXML
    void txtNombreKeyTyped(KeyEvent chismoso) {
        Palabra(chismoso);
    }
    @FXML
    void txtApellidosKeyTyped(KeyEvent chismoso) {
        Palabra(chismoso);
    }
    @FXML 
    void txtEdadKeyTyped(KeyEvent chismoso) {
        Numero(chismoso);
    }
    
    public void Palabra(KeyEvent chismoso){   //capturar escrito
        char c = chismoso.getCharacter().charAt(0); //recolecta la primer letra de una palabra
        if(Character.isDigit(c)){ //comparar si es numero no escribirlo
            chismoso.consume();//no deja escribir
            Toolkit.getDefaultToolkit().beep();//sonido
        }   
    } 
    public void Numero(KeyEvent chismoso){
        char c = chismoso.getCharacter().charAt(0);
        if(Character.isLetter(c)){
            chismoso.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        cmbCarrera.setItems(opCarrera);
    }     
}


    