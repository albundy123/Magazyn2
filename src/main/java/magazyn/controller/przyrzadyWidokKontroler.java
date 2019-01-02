package magazyn.controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import magazyn.dbUtils.dbSqlite;
import magazyn.model.przyrzad;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class przyrzadyWidokKontroler {
    public przyrzadyWidokKontroler() {System.out.println("Jestem konstruktorem klasy przyrzadyWidokKontroler");
    }

    @FXML
    private TableView<przyrzad> przyrzadyTableView;
    @FXML
    private TableColumn<przyrzad, Integer> idPrzyrzaduColumn;
    @FXML
    private TableColumn<przyrzad, String> nazwaPrzyrzaduColumn;
    @FXML
    private TableColumn<przyrzad, String> typPrzyrzaduColumn;
    @FXML
    private TableColumn<przyrzad, String> zakresPrzyrzaduColumn;
    @FXML
    private Button edytujPrzyrzadButton;
    @FXML
    private Label nazwaPrzyrzaduLabel;
    @FXML
    private Label typPrzyrzaduLabel;
    @FXML
    private Label zakresPrzyrzaduLabel;
    @FXML
    private Button dodajNowyPrzyrzadButton;


    private List<przyrzad> przyrzadyLista;
    private ObservableList<przyrzad> przyrzadyListaObserwowalna = FXCollections.observableArrayList();
    @FXML
    private void initialize(){
        System.out.println("Jestem funkcją initialize obiektu klasy przyrzadyWidokKontroler");
        idPrzyrzaduColumn.setCellValueFactory(new PropertyValueFactory<>("idPrzyrzad"));
        nazwaPrzyrzaduColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        typPrzyrzaduColumn.setCellValueFactory(new PropertyValueFactory<>("typ"));
        zakresPrzyrzaduColumn.setCellValueFactory(new PropertyValueFactory<>("zakres"));
        przyrzadyTableView.setItems(przyrzadyListaObserwowalna);
        pobierzListe();
    }
    @FXML
    private void dodajNowyPrzyrzad(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nowyPrzyrzadWidok.fxml"));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Dodaj nowy przyrząd");
            VBox vBox = loader.load();
            Scene scene = new Scene(vBox);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pobierzListe(){
        try {
            przyrzadyListaObserwowalna.clear();
            Dao<przyrzad, Integer> przyrzadDao = DaoManager.createDao(dbSqlite.getConnectionSource(),przyrzad.class);
            List<przyrzad> przyrzadyLista = przyrzadDao.queryForAll();
            przyrzadyLista.forEach(przyrzad2 ->{
                System.out.println(przyrzad2.toString());
                przyrzadyListaObserwowalna.add(przyrzad2);
            });
            dbSqlite.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
