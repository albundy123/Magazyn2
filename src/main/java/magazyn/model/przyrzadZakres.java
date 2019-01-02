package magazyn.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "przyrzadZakres")
public class przyrzadZakres {
    @DatabaseField(generatedId = true)
    private Integer idZakres;
    @DatabaseField(canBeNull = false)
    private String zakres;

    public przyrzadZakres() {
    }

    public przyrzadZakres(Integer idZakres, String zakres) {
        this.idZakres = idZakres;
        this.zakres = zakres;
    }

    public Integer getIdZakres() {
        return idZakres;
    }

    public void setIdZakres(Integer idZakres) {
        this.idZakres = idZakres;
    }

    public String getZakres() {
        return zakres;
    }

    public void setZakres(String zakres) {
        this.zakres = zakres;
    }
}
