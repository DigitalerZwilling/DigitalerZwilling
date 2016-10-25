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
import javax.inject.Inject;

/**
 *
 * @author user
 */
public class Warentraeger {
    @Inject @db private DatenSchnittstelle data;
    private long id_Warentraeger;
    private String bezeichnung;
    private int stoerung;
    private String rFID_inhalt;
    private int montagezustand;
    private int abstand_mm;
    private Timestamp zeitstempel;
    private String user_Parameter;

    public Warentraeger(long id_Warentraeger, String bezeichnung, int stoerung, String rFID_inhalt, int montagezustand, int abstand_mm, Timestamp zeitstempel, String user_Parameter) {
        this.id_Warentraeger = id_Warentraeger;
        this.bezeichnung = bezeichnung;
        this.stoerung = stoerung;
        this.rFID_inhalt = rFID_inhalt;
        this.montagezustand = montagezustand;
        this.abstand_mm = abstand_mm;
        this.zeitstempel = zeitstempel;
        this.user_Parameter = user_Parameter;
    }

    public long getId_Warentraeger() {
        return id_Warentraeger;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getStoerung() {
        return stoerung;
    }

    public String getrFID_inhalt() {
        return rFID_inhalt;
    }

    public int getMontagezustand() {
        return montagezustand;
    }

    public int getAbstand_mm() {
        return abstand_mm;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Parameter() {
        return user_Parameter;
    }
    
    public List<Artikel> getArtikel(){
        return this.data._Warentraeger_Artikel(id_Warentraeger);
    }
    
    public List<Sektor> getSektor(){
        return this.data._Warentraeger_Sektor(id_Warentraeger);
    }
    public List<Transportband> getTransportband(){
        return this.data._Warentraeger_Transportband(id_Warentraeger);
    }
}
