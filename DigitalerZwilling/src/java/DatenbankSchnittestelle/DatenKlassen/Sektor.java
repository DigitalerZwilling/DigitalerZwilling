/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle.DatenKlassen;

import DatenbankSchnittestelle.DatenSchnittstelle;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author user
 */
public class Sektor {
    private final long id_Sektor;
    private final String beschreibung;
    private final int stoerung;
    private final int x;
    private final int y;
    private final int z;
    private final int ausrichtung;
    private final Timestamp zeitstempel;
    private final String user_Parameter;

    public Sektor( long id_Sektor, String beschreibung, int stoerung, int x, int y, int z, int ausrichtung, Timestamp zeitstempel, String user_Parameter) {
        this.id_Sektor = id_Sektor;
        this.beschreibung = beschreibung;
        this.stoerung = stoerung;
        this.x = x;
        this.y = y;
        this.z = z;
        this.ausrichtung = ausrichtung;
        this.zeitstempel = zeitstempel;
        this.user_Parameter = user_Parameter;
    }

    public long getId_Sektor() {
        return id_Sektor;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public int getStoerung() {
        return stoerung;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getAusrichtung() {
        return ausrichtung;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Parameter() {
        return user_Parameter;
    }
    


    @Override
    public String toString() {
        return super.toString()+"  :  Sektor{"  + ", id_Sektor=" + id_Sektor + ", beschreibung=" + beschreibung + ", stoerung=" + stoerung + ", x=" + x + ", y=" + y + ", z=" + z + ", ausrichtung=" + ausrichtung + ", zeitstempel=" + zeitstempel + ", user_Parameter=" + user_Parameter + '}';
    }
    
}
