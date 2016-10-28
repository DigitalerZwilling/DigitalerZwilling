/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle.DatenKlassen;

import DatenbankSchnittestelle.DatenSchnittstelle;
import DatenbankSchnittestelle.Qualifier.db;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author chris
 */
public class Artikel {
    
    @Inject @db private DatenSchnittstelle data;
    private long id_Artikel;
    private String bezeichnung;
    private Timestamp zeit;
    private String userparameter;
    //private List<Warentraeger> liegt_auf_Warentraeger;

    public Artikel(long id_Artikel, String bezeichnung, Timestamp zeit, String userparameter) {
        this.id_Artikel = id_Artikel;
        this.bezeichnung = bezeichnung;
        this.zeit = zeit;  
        this.userparameter = userparameter;
    }

    public long getId_Artikel() {
        return id_Artikel;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public Timestamp getZeit() {
        return zeit;
    }

    public String getUserparameter() {
        return userparameter;
    }

    public List<Warentraeger> getLiegt_auf_Warentraeger() throws Exception {
        return data._Artikel_Warentraeger(id_Artikel);
    }
    
    
    
}
