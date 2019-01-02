package magazyn.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import magazyn.dbUtils.dbSqlite;
import magazyn.model.przyrzad;
import magazyn.model.przyrzadNazwa;
import magazyn.model.przyrzadTyp;
import magazyn.model.przyrzadZakres;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class nowyPrzyrzadWidokKontroler {

    public nowyPrzyrzadWidokKontroler() {System.out.println("Jestem konstruktorem klasy nowyPrzyrzadWidokKontroler");}

    @FXML
    private ComboBox<String> nowaNazwaComboBox;
    @FXML
    private Button dodajNazweButton;
    @FXML
    private ComboBox<String> nowytypComboBox;
    @FXML
    private Button dodajTypButton;
    @FXML
    private ComboBox<String> nowyZakresComboBox;
    @FXML
    private Button dodajZakresButton;
    @FXML
    private Button dodajNowyPrzyrzadButton;
    @FXML
    private Button anulujNowyPrzyrzadButton;

    private ObservableList<String> nazwyListaObserwowalna = FXCollections.observableArrayList();
    private ObservableList<String> typyListaObserwowalna = FXCollections.observableArrayList();
    private ObservableList<String> zakresyListaObserwowalna = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        System.out.println("Jestem funkcją initialize obiektu klasy nowyPrzyrzadWidokKontroler");
        pobierzListeNazw();
        nowaNazwaComboBox.getItems().addAll(nazwyListaObserwowalna);
        pobierzListeTypow();
        nowytypComboBox.getItems().addAll(typyListaObserwowalna);
        pobierzListeZakresow();
        nowyZakresComboBox.getItems().addAll(zakresyListaObserwowalna);
    }
    private void dodajNowyPrzyrzad(){
        Dao<przyrzad, Integer> przyrzadDaoDao;
        Dao<przyrzadTyp, Integer> typDao;
        Dao<przyrzadNazwa, Integer> nazwaDao;
        Dao<przyrzadZakres, Integer> zakresDao;


    }


    @FXML
    private void dodajNazwe(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nazwaPrzyrzaduWidok.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Dodaj nazwę przyrządu");
            VBox vBox = loader.load();
            Scene scene = new Scene(vBox);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void dodajTyp(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/typPrzyrzaduWidok.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Dodaj typ przyrządu");
            VBox vBox = loader.load();
            Scene scene = new Scene(vBox);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void dodajZakres(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/zakresPrzyrzaduWidok.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Dodaj zakres przyrządu");
            VBox vBox = loader.load();
            Scene scene = new Scene(vBox);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pobierzListeNazw(){
        try {
            nazwyListaObserwowalna.clear();
            Dao<przyrzadNazwa, Integer> nazwaDao = DaoManager.createDao(dbSqlite.getConnectionSource(),przyrzadNazwa.class);
            List<przyrzadNazwa> nazwyLista = nazwaDao.queryForAll();
            nazwyLista.forEach(nazwa ->{
                nazwyListaObserwowalna.add(nazwa.getNazwa());
            });
            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void pobierzListeTypow(){
        try {
            typyListaObserwowalna.clear();
            Dao<przyrzadTyp, Integer> typDao = DaoManager.createDao(dbSqlite.getConnectionSource(),przyrzadTyp.class);
            List<przyrzadTyp> typyLista = typDao.queryForAll();
            typyLista.forEach(typ ->{
                typyListaObserwowalna.add(typ.getTyp());
            });
            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void pobierzListeZakresow(){
        try {
            zakresyListaObserwowalna.clear();
            Dao<przyrzadZakres, Integer> zakresDao = DaoManager.createDao(dbSqlite.getConnectionSource(), przyrzadZakres.class);
            List<przyrzadZakres> zakresyLista = zakresDao.queryForAll();
            zakresyLista.forEach(zakres ->{
                zakresyListaObserwowalna.add(zakres.getZakres());
            });
            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
