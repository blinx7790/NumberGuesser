/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguesser;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Parks
 */
public class FXMLDocumentController implements Initializable {
    
    //
    //Number guessing game the computer generates a random number
    //and the used guesses a number the computer then tells the user
    //if the guess was too high, too low, or correct.
    
    
    @FXML private Label label;
    Random rand = new Random();
    @FXML private TextField userGuess;
    @FXML private Button button;
    
    //number between 0-99
    int number = rand.nextInt(100 + 1);
    int num = 0;
   
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        //get the users guess and turn it into an int
        //for comparison
        String sUserGuess = userGuess.getText();
        int nUserGuess = Integer.parseInt(sUserGuess);
         button.setText("Guess It!");
       
        
       
        //If the user gets it correct in one guess
         if(nUserGuess == number){
            
             if(num < 1){
                 num++;
                 label.setText("WowZerZ you guessed it right \n on your "
                         + num + "st Try!!!  \n Go Play The Lotto" );
             }
             //when the user guesses the right number greater than 1
             //it tells the user how many guesses it took
             else if(num >= 1){
             num++;
            label.setText("Yay you got it in " + num + " times");
            }
             //get a new number and reset the counter to 0
            button.setText("Guess Again?");
            number = rand.nextInt(100 + 1);
            num = 0;
            //tell the user if the guess was too high or low
        }else if(nUserGuess > number){
            label.setText("Too High");
            num++;
        }else{
            label.setText("Too Low");
            num++;
        }
        
    
         //print the number to the console for testing
        //System.out.println(number);
        
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
