/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle.DatenKlassen;

import DatenbankSchnittestelle.DatenSchnittstelle;
import java.sql.Timestamp;

/**
 *
 * @author user
 */
public class Sensor {
    private final long id_Sensor;
    private final String beschreibung;
    private final int stoerung;
    private final String phy_adresse;
    private final int zustand;                      //fehlerzustand
    private final Timestamp zeitstempel;
    private final String user_Parameter;

    public Sensor(long id_Sensor, String beschreibung, int stoerung, String phy_adresse, int zustand, Timestamp zeitstempel, String user_Parameter) {
        this.id_Sensor = id_Sensor;
        this.beschreibung = beschreibung;
        this.stoerung = stoerung;
        this.phy_adresse = phy_adresse;
        this.zustand = zustand;
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

    public String getPhy_adresse() {
        return phy_adresse;
    }

    public int getZustand() {
        return zustand;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Parameter() {
        return user_Parameter;
    }
    


    @Override
    public String toString() {
        return super.toString()+"  :  Sensor{"  + ", id_Sensor=" + id_Sensor + ", beschreibung=" + beschreibung + ", stoerung=" + stoerung + ", phy_adresse=" + phy_adresse + ", zustand=" + zustand + ", zeitstempel=" + zeitstempel + ", user_Parameter=" + user_Parameter + '}';
    }
    
}
