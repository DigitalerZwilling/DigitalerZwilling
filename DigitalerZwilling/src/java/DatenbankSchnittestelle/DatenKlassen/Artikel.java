/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle.DatenKlassen;

import DatenbankSchnittestelle.DatenSchnittstelle;
import DatenbankSchnittestelle.Qualifier.db;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author chris
 */


public class Artikel{
    
    private final DatenSchnittstelle data;
    private final long id_Artikel;
    private final String bezeichnung;
    private final Timestamp zeit;
    private final String user_Parameter;
    

    public Artikel(DatenSchnittstelle data, long id_Artikel, String bezeichnung, Timestamp zeit, String user_Parameter) {
        this.data = data;
        this.id_Artikel = id_Artikel;
        this.bezeichnung = bezeichnung;
        this.zeit = zeit;
        this.user_Parameter = user_Parameter;
    }

    
    
    @PostConstruct
    public void init(){
        System.out.println("hmm");
        System.out.println(this.data.toString());
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
        return user_Parameter;
    }

    /**
     *
     * @return Gibt Warentraeger zurueck
     * @throws Exception
     */
    public List<Warentraeger> getLiegt_auf_Warentraeger() throws Exception {
        return data._Artikel_Warentraeger(id_Artikel);
    }
   
    
    
}
