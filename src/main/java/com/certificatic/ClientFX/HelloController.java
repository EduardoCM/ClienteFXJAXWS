package com.certificatic.ClientFX;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.certificatic.ws.Calculadora;
import com.certificatic.ws.CalculadoraService;

public class HelloController
{
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private Label messageLabel;

    public void sayHello() {

        int num1 = Integer.parseInt(firstNameField.getText());
        int num2 = Integer.parseInt(lastNameField.getText());

        StringBuilder builder = new StringBuilder();
        
        Calculadora cal = 
        		new CalculadoraService().getCalculadoraPort(); 
        		
       int resultado = cal.sumar(num1, num2);
       
          builder.append("Resultado Suma: " + resultado);
        

        if (builder.length() > 0) {
            String name = builder.toString();
            log.debug("Saying hello to " + name);
            messageLabel.setText("Hello " + name);
        } else {
            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
            messageLabel.setText("Hello mysterious person");
        }
    }

}
