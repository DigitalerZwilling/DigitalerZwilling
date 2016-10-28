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
 * @author chris
 */
public class Gelenk {
    private final DatenSchnittstelle data;
    private final long id_Gelenk;
    private final String gelenktyp;           //hmmm
    private final int nummer;
    private final int gelenkstellung;          // evtl. auch mehere Variabeln
    private final Timestamp zeitstempel;
    private final String user_Paameter;

    public Gelenk(DatenSchnittstelle data, long id_Gelenk, String gelenktyp, int nummer, int gelenkstellung, Timestamp zeitstempel, String user_Paameter) {
        this.data = data;
        this.id_Gelenk = id_Gelenk;
        this.gelenktyp = gelenktyp;
        this.nummer = nummer;
        this.gelenkstellung = gelenkstellung;
        this.zeitstempel = zeitstempel;
        this.user_Paameter = user_Paameter;
    }

    public long getId_Gelenk() {
        return id_Gelenk;
    }

    public String getGelenktyp() {
        return gelenktyp;
    }

    public int getNummer() {
        return nummer;
    }

    public int getGelenkstellung() {
        return gelenkstellung;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Paameter() {
        return user_Paameter;
    }
    
    public Roboter getRoboter(){
        return this.data._Gelenk_Roboter(id_Gelenk);
    }
   
}
