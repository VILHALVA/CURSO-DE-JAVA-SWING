package util;

import java.awt.Color;
import javax.swing.JTextField;

public class ValidarCampo {

    //---- VALIDA CEP COM TRAÇO E DELIMITA TAMANHO 

    public JTextField validarCep(JTextField cep) {
        //Expressões regulares
        boolean validar = cep.getText().matches("[0-9]{5}(-)[0-9]{3}");
        if (cep.getText().length() == 5) {
            cep.setText(cep.getText() + "-");
        }
        if (cep.getText().length() > 8) {
            cep.setText(cep.getText().substring(0, 9));
            validar = true;
        }
        if (validar == false) {
            cep.setForeground(Color.red);
        } else {
            cep.setForeground(Color.blue);
        }
        return cep;
    }

    //---RETIRA O TRAÇO - DO CEP PARA ARMAZENAR INTEIRO NO BANCO DE DADOS 
    public int ajustaCepInt(Object cep) {
        String cepInt;
        cepInt = cep.toString().substring(0, 5) + cep.toString().substring(6, 9);
        return Integer.parseInt(cepInt);
    }
    
    public String inserirMascaraCep(Integer cep) {
        String cepMasc;
        cepMasc = cep.toString().substring(0, 5) + ("-") + cep.toString().substring(5, 8);
        return (cepMasc);
    }

}