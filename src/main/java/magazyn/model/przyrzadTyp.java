package magazyn.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "przyrzadTyp")
public class przyrzadTyp {
    @DatabaseField(generatedId = true)
    private Integer idTyp;
    @DatabaseField(canBeNull = false)
    private String typ;

    public przyrzadTyp() {
    }

    public przyrzadTyp(Integer idTyp, String typ) {
        this.idTyp = idTyp;
        this.typ = typ;
    }

    public Integer getIdTyp() {
        return idTyp;
    }

    public void setIdTyp(Integer idTyp) {
        this.idTyp = idTyp;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
