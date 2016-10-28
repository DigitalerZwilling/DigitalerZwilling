/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle;

import DatenbankSchnittestelle.DatenKlassen.Artikel;
import DatenbankSchnittestelle.DatenKlassen.Gelenk;
import DatenbankSchnittestelle.DatenKlassen.HubPodest;
import DatenbankSchnittestelle.DatenKlassen.HubQuerPodest;
import DatenbankSchnittestelle.DatenKlassen.Roboter;
import DatenbankSchnittestelle.DatenKlassen.Sektor;
import DatenbankSchnittestelle.DatenKlassen.Sensor;
import DatenbankSchnittestelle.DatenKlassen.Transportband;
import DatenbankSchnittestelle.DatenKlassen.Warentraeger;
import DatenbankSchnittestelle.Qualifier.DB_Info;
import DatenbankSchnittestelle.Qualifier.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author chris
 */
@ApplicationScoped @db
public class DatenbankSchnittstelle implements DatenSchnittstelle{
    //---------------------------------------------------------------------------
    //Datenbank verbindungs daten
    
   // private final String _DbURL="jdbc:derby://localhost:1527/db_DigitalerZwilling";   //URL
   // private final String _DbUser="db_user";                                            //User
   // private final String _DbPw="SB0222";                                              //Passswort
    //---------------------------------------------------------------------------
    
    @Inject @DB_Info(
            db_name="jdbc:derby://localhost:1527/db_DigitalerZwilling",
            db_user="db_user",
            db_pw="SB0222"
    ) private Connection db;   

    public DatenbankSchnittstelle() {
        
    }
    
    @PostConstruct
    private void init(){
        ;
    }

    @Override
    public List<Warentraeger> _Artikel_Warentraeger(long artikelID)  {
        try {
            List<Warentraeger> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Warentraerger where id_artikel="+artikelID);//where TIPP.USERNAME='"+username+"')=0");
            while(rs.next()){
                back.add(new Warentraeger(
                    rs.getLong("id_warentraeger"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getString("RFID_inhalt"),
                    rs.getInt("montagezustand"),
                    rs.getInt("abstand_mm"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));
            }
            return back;
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public Artikel getArtikel(long artikelID)  {
        try {
            System.out.println("test");
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Artikel Where id_artikel="+artikelID);
            rs.next();
            Artikel a=new Artikel(/*rs.getB("id_artikel")*/1,rs.getString("bezeichnung"),rs.getTimestamp("zeitstempel"),"");
            rs.close();
            stmt.close();
            return a;
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Artikel> _Warentraeger_Artikel(long warentraegerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transportband> _Warentraeger_Transportband(long warentraegerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sektor> _Warentraeger_Sektor(long warentraegerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Warentraeger> _Transportband_Warentraeger(long transportbandID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor _Transportband_vor_Sektor(long transportbandID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor _Transportband_nach_Sektor(long transportbandID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Warentraeger> _Sektor_Warentraeger(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transportband> _Sektor_vor_Transportband(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transportband> _Sektor_nach_Transportband(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HubPodest> _Sektor_HubPodest(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HubQuerPodest> _Sektor_HubQuerPodest(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sensor> _Sektor_Sensor(long sensorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Roboter> _Sektor_Roboter(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor _HubPodest_Sektor(long hubPodestId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor _HubQuerPodest_Sektor(long hubQuerPodestId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor _Sensor_Sektor(long sensorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sektor> _Roboter_Sektor(long roboterID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gelenk> _Roboter_Gelenk(long roboterID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Roboter _Gelenk_Roboter(long gelenkID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Warentraeger getWarentraeger(long warentraegerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transportband getTransportband(long transportbandID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor getSektor(long sektorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HubPodest getHubpodest(long hubpodestID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HubQuerPodest getHubQuerPodest(long hubquerpodestID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sensor getSensor(long sensorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Roboter getRoboter(long roboterID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gelenk getGelenk(long gelenkID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
