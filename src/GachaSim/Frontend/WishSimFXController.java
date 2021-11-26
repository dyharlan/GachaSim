/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GachaSim.Frontend;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import GachaSim.Banners.StdBanner;
import GachaSim.Banners.CharacterBanner;
import GachaSim.Banners.WeaponBanner;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author dyhar
 */
public class WishSimFXController implements Initializable {
    //Creating an instance of the Character Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    CharacterBanner CbannerStatus = new CharacterBanner(); 
    //Creating an instance of the Weapon Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static WeaponBanner WbannerStatus = new WeaponBanner();
    //Creating an instance of the Standard Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static StdBanner SbannerStatus = new StdBanner();

    @FXML
    private Label guaranteed5;
    @FXML
    private TextArea CharWishHistory;
    @FXML
    private Label CharRolls;
    @FXML
    private Label CharLast4;
    @FXML
    private TextArea WpnWishHistory;
    @FXML
    private Label WpnRolls;
    @FXML
    private Label WpnLast4;
    @FXML
    private TextArea StdWishHistory;
    @FXML
    private Label StdRolls;
    @FXML
    private Label StdLast4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCharRoll(ActionEvent event) {
        CharWishHistory.appendText(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle") + "\n");
        guaranteed5.setText(String.valueOf(CbannerStatus.guaranteed5));
        CharRolls.setText(String.valueOf(CbannerStatus.Crolls));
        CharLast4.setText(String.valueOf(CbannerStatus._4Spity));
    }

    @FXML
    private void handleCharRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
           CharWishHistory.appendText(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle") + "\n");
           guaranteed5.setText(String.valueOf(CbannerStatus.guaranteed5));
           CharRolls.setText(String.valueOf(CbannerStatus.Crolls));
           CharLast4.setText(String.valueOf(CbannerStatus._4Spity));  
       }
    }

    @FXML
    private void handleCharClearHistory(ActionEvent event) {
        CharWishHistory.clear();
        System.gc();
    }

    @FXML
    private void handleWpnRoll(ActionEvent event) {
        WpnWishHistory.appendText(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Roar", "Sacrificial Greatsword", "Dragon's Bane") + "\n");
        WpnRolls.setText(String.valueOf(WbannerStatus.Wrolls));
        WpnLast4.setText( String.valueOf(WbannerStatus._4Spity) );
    }

    @FXML
    private void handleWpnRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
            WpnWishHistory.appendText(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Roar", "Sacrificial Greatsword", "Dragon's Bane") + "\n");
            WpnRolls.setText(String.valueOf(WbannerStatus.Wrolls));
            WpnLast4.setText( String.valueOf(WbannerStatus._4Spity) );
       }
    }

    @FXML
    private void handleWpnClearHistory(ActionEvent event) {
        WpnWishHistory.clear();
        System.gc();
    }

    @FXML
    private void handleStdRoll(ActionEvent event) {
        StdWishHistory.appendText(StdBanner.StdRoll() + "\n");
        StdRolls.setText(String.valueOf(WbannerStatus.Wrolls));
        StdLast4.setText( String.valueOf(WbannerStatus._4Spity) );
    }

    @FXML
    private void handleStdRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
            StdWishHistory.appendText(StdBanner.StdRoll() + "\n");
            StdRolls.setText(String.valueOf(SbannerStatus.Srolls));
            StdLast4.setText( String.valueOf(SbannerStatus._4Spity) );
       }
    }

    @FXML
    private void handleStdClearHistory(ActionEvent event) {
        StdWishHistory.clear();
        System.gc();
    }
    
}
