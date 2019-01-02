package magazyn.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import magazyn.dbUtils.dbSqlite;
import magazyn.model.przyrzadNazwa;

import java.sql.SQLException;
import java.util.List;

public class nazwaPrzyrzaduWidokKontroler {
    public nazwaPrzyrzaduWidokKontroler() {
        System.out.println("Jestem konstruktorem klasy nazwaPrzyrzaduWidokKontroler");
    }
    @FXML
    private Button dodajNowaNazwaPrzyrzadButton;
    @FXML
    private Button anulujNowaNazwaPrzyrzadButton;
    @FXML
    private TextField nowaNazwaPrzyrzaduTextField;

    @FXML
    private void initialize() {
        System.out.println("Jestem funkcją initialize obiektu klasy nazwaPrzyrzaduWidokKontroler");

    }
    @FXML
    private void dodajNowaNazwe(){
        try {
            Dao<przyrzadNazwa, Integer> nazwaDao = DaoManager.createDao(dbSqlite.getConnectionSource(),przyrzadNazwa.class);

            nazwaDao.create(new przyrzadNazwa(0,nowaNazwaPrzyrzaduTextField.getText()));

            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
