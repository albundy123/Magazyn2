package magazyn.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Przyrzady")
public class przyrzad {
    @DatabaseField(generatedId = true)
    private Integer idPrzyrzad;
    @DatabaseField(canBeNull = false, foreign = true)
    private przyrzadNazwa nazwaPrzyrzadu;
    @DatabaseField(canBeNull = false, foreign = true)
    private przyrzadTyp typPrzyrzadu;
    @DatabaseField(canBeNull = false, foreign = true)
    private przyrzadZakres zakresPrzyrzadu;
    public przyrzad() {
    }
    public przyrzad(Integer idPrzyrzad, przyrzadNazwa nazwaPrzyrzadu, przyrzadTyp typPrzyrzadu, przyrzadZakres zakresPrzyrzadu) {
        this.idPrzyrzad = idPrzyrzad;
        this.nazwaPrzyrzadu = nazwaPrzyrzadu;
        this.typPrzyrzadu = typPrzyrzadu;
        this.zakresPrzyrzadu = zakresPrzyrzadu;
    }
    public Integer getIdPrzyrzad() {
        return idPrzyrzad;
    }
    public void setIdPrzyrzad(Integer idPrzyrzad) {
        this.idPrzyrzad = idPrzyrzad;
    }
    public przyrzadNazwa getNazwaPrzyrzadu() {
        return nazwaPrzyrzadu;
    }

    public void setNazwaPrzyrzadu(przyrzadNazwa nazwaPrzyrzadu) {
        this.nazwaPrzyrzadu = nazwaPrzyrzadu;
    }

    public przyrzadTyp getTypPrzyrzadu() {
        return typPrzyrzadu;
    }

    public void setTypPrzyrzadu(przyrzadTyp typPrzyrzadu) {
        this.typPrzyrzadu = typPrzyrzadu;
    }

    public przyrzadZakres getZakresPrzyrzadu() {
        return zakresPrzyrzadu;
    }

    public void setZakresPrzyrzadu(przyrzadZakres zakresPrzyrzadu) {
        this.zakresPrzyrzadu = zakresPrzyrzadu;
    }
}
