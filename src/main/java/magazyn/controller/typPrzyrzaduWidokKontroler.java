package magazyn.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import magazyn.dbUtils.dbSqlite;
import magazyn.model.przyrzadNazwa;
import magazyn.model.przyrzadTyp;

import java.sql.SQLException;

public class typPrzyrzaduWidokKontroler {
    public typPrzyrzaduWidokKontroler() {
        System.out.println("Jestem konstruktorem klasy typPrzyrzaduWidokKontroler");
    }

    @FXML
    private Button anulujNowyTypPrzyrzadButton;
    @FXML
    private TextField nowyTypPrzyrzaduTextField;
    @FXML
    private Button dodajNowyTypPrzyrzadButton;

    @FXML
    private void initialize() {
        System.out.println("Jestem funkcją initialize obiektu klasy typPrzyrzaduWidokKontroler");

    }
    @FXML
    private void dodajNowyTyp(){
        try {
            Dao<przyrzadTyp, Integer> nazwaDao = DaoManager.createDao(dbSqlite.getConnectionSource(),przyrzadTyp.class);

            nazwaDao.create(new przyrzadTyp(0,nowyTypPrzyrzaduTextField.getText()));

            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
