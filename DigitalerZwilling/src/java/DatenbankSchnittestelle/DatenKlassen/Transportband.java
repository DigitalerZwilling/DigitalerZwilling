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
public class Transportband {
    private final DatenSchnittstelle data;
    private final long id_Sensor;
    private final String beschreibung;
    private final int stoerung;
    private final int laenge;
    private final int geschwindigkeit;
    private final Timestamp zeitstempel;
    private final String user_Parameter;

    public Transportband(DatenSchnittstelle data, long id_Sensor, String beschreibung, int stoerung, int laenge, int geschwindigkeit, Timestamp zeitstempel, String user_Parameter) {
        this.data = data;
        this.id_Sensor = id_Sensor;
        this.beschreibung = beschreibung;
        this.stoerung = stoerung;
        this.laenge = laenge;
        this.geschwindigkeit = geschwindigkeit;
        this.zeitstempel = zeitstempel;
        this.user_Parameter = user_Parameter;
    }

    public long getId_Sensor() {
        return id_Sensor;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public int getStoerung() {
        return stoerung;
    }

    public int getLaenge() {
        return laenge;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Parameter() {
        return user_Parameter;
    }
    
    public Sektor getSektorVorMe(){
        return this.data._Transportband_nach_Sektor(id_Sensor);
    }
    public Sektor getSektorNachMe(){
        return this.data._Transportband_vor_Sektor(id_Sensor);
    }
    public List<Warentraeger> getWarentraeger(){
        return this.data._Transportband_Warentraeger(id_Sensor);
    } 
}
