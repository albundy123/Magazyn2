package magazyn.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "przyrzadNazwa")
public class przyrzadNazwa {
    @DatabaseField(generatedId = true)
    private Integer idNazwa;
    @DatabaseField(canBeNull = false)
    private String nazwa;

    public przyrzadNazwa() {
    }

    public przyrzadNazwa(Integer idNazwa, String nazwa) {
        this.idNazwa = idNazwa;
        this.nazwa = nazwa;
    }

    public Integer getIdNazwa() {
        return idNazwa;
    }

    public void setIdNazwa(Integer idNazwa) {
        this.idNazwa = idNazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
