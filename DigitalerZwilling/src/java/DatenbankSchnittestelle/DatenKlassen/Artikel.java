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
 * @author chris
 */


public class Artikel{
    
    
    private final long id_Artikel;
    private final String bezeichnung;
    private final Timestamp zeit;
    private final String user_Parameter;
    

    public Artikel(long id_Artikel, String bezeichnung, Timestamp zeit, String user_Parameter) {
        
        this.id_Artikel = id_Artikel;
        this.bezeichnung = bezeichnung;
        this.zeit = zeit;
        this.user_Parameter = user_Parameter;
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
  

    @Override
    public String toString() {
        return super.toString()+"  :  Artikel{"  + ", id_Artikel=" + id_Artikel + ", bezeichnung=" + bezeichnung + ", zeit=" + zeit + ", user_Parameter=" + user_Parameter + '}';
    }
   
    
    
}
