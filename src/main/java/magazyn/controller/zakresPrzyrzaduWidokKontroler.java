package magazyn.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import magazyn.dbUtils.dbSqlite;
import magazyn.model.przyrzadTyp;
import magazyn.model.przyrzadZakres;

import java.sql.SQLException;

public class zakresPrzyrzaduWidokKontroler {
    public zakresPrzyrzaduWidokKontroler() {
        System.out.println("Jestem konstruktorem klasy zakresPrzyrzaduWidokKontroler"); }


        @FXML
    private TextField nowyZakresPrzyrzaduTextField;
    @FXML
    private Button dodajNowyZakresPrzyrzadButton;
    @FXML
    private Button anulujNowyZakresPrzyrzadButton;

    @FXML
    private void initialize() {
        System.out.println("Jestem funkcją initialize obiektu klasy zakresPrzyrzaduWidokKontroler");

    }
    @FXML
    private void dodajNowyZakres(){
        try {
            Dao<przyrzadZakres, Integer> nazwaDao = DaoManager.createDao(dbSqlite.getConnectionSource(),przyrzadZakres.class);

            nazwaDao.create(new przyrzadZakres(0,nowyZakresPrzyrzaduTextField.getText()));

            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
