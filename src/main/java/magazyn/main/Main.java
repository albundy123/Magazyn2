package magazyn.main;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import magazyn.dbUtils.dbSqlite;
import magazyn.model.przyrzad;
import magazyn.model.przyrzadNazwa;
import magazyn.model.przyrzadTyp;
import magazyn.model.przyrzadZakres;

public class Main extends Application {

    private Dao<przyrzad, Integer> przyrzadDaoDao;
    private Dao<przyrzadTyp, Integer> typDao;
    private Dao<przyrzadNazwa, Integer> nazwaDao;
    private Dao<przyrzadZakres, Integer> zakresDao;

    public void start(Stage primaryStage) throws Exception {

        //przyrzadDao = DaoManager.createDao(dbSqlite.getConnectionSource(), przyrzad.class);
     /*   typDao = DaoManager.createDao(dbSqlite.getConnectionSource(), przyrzadTyp.class);
        nazwaDao = DaoManager.createDao(dbSqlite.getConnectionSource(), przyrzadNazwa.class);
        zakresDao = DaoManager.createDao(dbSqlite.getConnectionSource(), przyrzadZakres.class);

        TableUtils.createTableIfNotExists(dbSqlite.getConnectionSource(), przyrzadTyp.class);
        TableUtils.createTableIfNotExists(dbSqlite.getConnectionSource(), przyrzadNazwa.class);
        TableUtils.createTableIfNotExists(dbSqlite.getConnectionSource(), przyrzadZakres.class);
        TableUtils.createTableIfNotExists(dbSqlite.getConnectionSource(), przyrzad.class);

        dbSqlite.closeConnection();
*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/przyrzadyWidok.fxml"));
        VBox vBox = loader.load();
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Magazynek");
        primaryStage.show();
    }
}
