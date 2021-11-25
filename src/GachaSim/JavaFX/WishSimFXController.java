/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GachaSim.JavaFX;

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
    static CharacterBanner CbannerStatus = new CharacterBanner(); 
    //Creating an instance of the Weapon Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static WeaponBanner WbannerStatus = new WeaponBanner();
    //Creating an instance of the Standard Banner Class
    //in order to check the counters for the 5 and 4 star pity, and the 5* guarantee.
    static StdBanner SbannerStatus = new StdBanner();
    static StringBuilder charStr = new StringBuilder();
    static StringBuilder wpnStr = new StringBuilder();
    static StringBuilder stdStr = new StringBuilder();

    @FXML
    private Label guaranteed5;
    @FXML
    private TextArea CharWishHistory;
    @FXML
    private Label CharRolls;
    @FXML
    private Label CharLast4;
    @FXML
    private Button CharClearHistory;
    @FXML
    private TextArea WpnWishHistory;
    @FXML
    private Label WpnRolls;
    @FXML
    private Label WpnLast4;
    @FXML
    private Button WpnClearHistory;
    @FXML
    private TextArea StdWishHistory;
    @FXML
    private Label StdRolls;
    @FXML
    private Label StdLast4;
    @FXML
    private Button StdClearHistory;
    @FXML
    private Button CharRoll;
    @FXML
    private Button CharRoll10;
    @FXML
    private Button WpnRoll;
    @FXML
    private Button WpnRoll10;
    @FXML
    private Button StdRoll;
    @FXML
    private Button StdRoll10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCharRoll(ActionEvent event) {
        charStr.append(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle") + "\n");
        CharWishHistory.setText(charStr.toString());
        guaranteed5.setText(String.valueOf(CbannerStatus.guaranteed5));
        CharRolls.setText(String.valueOf(CbannerStatus.Crolls));
        CharLast4.setText(String.valueOf(CbannerStatus._4Spity));
    }

    @FXML
    private void handleCharRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
            charStr.append(CharacterBanner.CharRoll("Albedo", "Rosaria", "Bennett", "Noelle") + "\n");
            CharWishHistory.setText(charStr.toString());
            guaranteed5.setText(String.valueOf(CbannerStatus.guaranteed5));
            CharRolls.setText(String.valueOf(CbannerStatus.Crolls));
            CharLast4.setText(String.valueOf(CbannerStatus._4Spity));  
       }
    }

    @FXML
    private void handleCharClearHistory(ActionEvent event) {
        charStr.setLength(0);
        CharWishHistory.setText(charStr.toString());
        System.gc();
    }

    @FXML
    private void handleWpnRoll(ActionEvent event) {
        wpnStr.append(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Roar", "Sacrificial Greatsword", "Dragon's Bane") + "\n");
        WpnWishHistory.setText(wpnStr.toString());
        WpnRolls.setText(String.valueOf(WbannerStatus.Wrolls));
        WpnLast4.setText( String.valueOf(WbannerStatus._4Spity) );
    }

    @FXML
    private void handleWpnRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
            wpnStr.append(WeaponBanner.WpnRoll("Freedom-Sworn", "Song of Broken Pines", "Wine and Song", "Alley Hunter", "Lion's Roar", "Sacrificial Greatsword", "Dragon's Bane") + "\n");
            WpnWishHistory.setText(wpnStr.toString());
            WpnRolls.setText(String.valueOf(WbannerStatus.Wrolls));
            WpnLast4.setText( String.valueOf(WbannerStatus._4Spity) );
       }
    }

    @FXML
    private void handleWpnClearHistory(ActionEvent event) {
        wpnStr.setLength(0);
        WpnWishHistory.setText(wpnStr.toString());
        System.gc();
    }

    @FXML
    private void handleStdRoll(ActionEvent event) {
        stdStr.append(StdBanner.StdRoll() + "\n");
        StdWishHistory.setText(stdStr.toString());
        StdRolls.setText(String.valueOf(WbannerStatus.Wrolls));
        StdLast4.setText( String.valueOf(WbannerStatus._4Spity) );
    }

    @FXML
    private void handleStdRoll10(ActionEvent event) {
       for(int ctr = 0 ; ctr < 10 ; ctr++)
       {
            stdStr.append(StdBanner.StdRoll() + "\n");
            StdWishHistory.setText(stdStr.toString());
            StdRolls.setText(String.valueOf(SbannerStatus.Srolls));
            StdLast4.setText( String.valueOf(SbannerStatus._4Spity) );
       }
    }

    @FXML
    private void handleStdClearHistory(ActionEvent event) {
        stdStr.setLength(0);
        StdWishHistory.setText(stdStr.toString());
        System.gc();
    }
    
}
