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
            rs = stmt.executeQuery("SELECT * from Warentraeger O,Artikel_Warentraeger R where R.id_artikel="+artikelID+" and R.id_warentraeger=O.id_warentraeger" );//where TIPP.USERNAME='"+username+"')=0");
            while(rs.next()){
                back.add(new Warentraeger(this,
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
            rs.close();
            stmt.close();
            return back;
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }


    @Override
    public List<Artikel> _Warentraeger_Artikel(long warentraegerID) {
        try {
            List<Artikel> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Artikel O,Artikel_Warentraeger R where R.id_warentraeger="+warentraegerID+" and R.id_artikel=O.id_artikel" );//where TIPP.USERNAME='"+username+"')=0");
            while(rs.next()){
                back.add(new Artikel(this,
                    rs.getLong("id_artikel"),
                    rs.getString("bezeichnung"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Transportband> _Warentraeger_Transportband(long warentraegerID) {
        try {
            List<Transportband> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Transportband O,Transportband_Warentraeger R where R.id_warentraeger="+warentraegerID+" and R.id_transportband=O.id_transportband" );
            while(rs.next()){
                back.add(new Transportband(this,
                    rs.getLong("id_transportband"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getInt("laenge"),
                    rs.getInt("geschwindigkeit"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }
    

    @Override
    public List<Sektor> _Warentraeger_Sektor(long warentraegerID) {
        try {
            List<Sektor> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Sektor O,Sektor_Warentraeger R where R.id_warentraeger="+warentraegerID+" and R.id_sektor=O.id_sektor" );
            while(rs.next()){
                back.add(new Sektor(this,
                    rs.getLong("id_sektor"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getInt("position_X"),
                    rs.getInt("position_Y"),
                    rs.getInt("position_Z"),
                    rs.getInt("position_Ausrichtung"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Warentraeger> _Transportband_Warentraeger(long transportbandID) {
        try {
            List<Warentraeger> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Warentraeger O,Transportband_Warentraeger R where R.id_transportband="+transportbandID+" and R.id_warentraeger=O.id_warentraeger" );
            while(rs.next()){
                back.add(new Warentraeger(this,
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
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sektor _Transportband_vor_Sektor(long transportbandID) {
        try {
            Sektor back;
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Transportband, Sektor where id_transportband="+transportbandID+" and id_sektor_nach=id_sektor" );
            rs.next();
            back = new Sektor(this,
                rs.getLong("id_sektor"),
                rs.getString("bezeichnung"),
                rs.getInt("stoerung"),
                rs.getInt("position_X"),
                rs.getInt("position_Y"),
                rs.getInt("position_Z"),
                rs.getInt("position_Ausrichtung"),
                rs.getTimestamp("zeitstempel"),
                rs.getString("user_parameter")
            );
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public Sektor _Transportband_nach_Sektor(long transportbandID) {
        try {
            Sektor back;
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Transportband, Sektor where id_transportband="+transportbandID+" and id_sektor_vor=id_sektor" );
            rs.next();
            back = new Sektor(this,
                rs.getLong("id_sektor"),
                rs.getString("bezeichnung"),
                rs.getInt("stoerung"),
                rs.getInt("position_X"),
                rs.getInt("position_Y"),
                rs.getInt("position_Z"),
                rs.getInt("position_Ausrichtung"),
                rs.getTimestamp("zeitstempel"),
                rs.getString("user_parameter")
            );
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Warentraeger> _Sektor_Warentraeger(long sektorID) {
        try {
            List<Warentraeger> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Warentraeger O,Sektor_Warentraeger R where R.id_sektor="+sektorID+" and R.id_warentraeger=O.id_warentraeger" );
            while(rs.next()){
                back.add(new Warentraeger(this,
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
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Transportband> _Sektor_vor_Transportband(long sektorID) {
        try {
            List<Transportband> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Transportband O where O.id_sektor_vor="+sektorID);
            while(rs.next()){
                back.add(new Transportband(this,
                    rs.getLong("id_transportband"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getInt("laenge"),
                    rs.getInt("geschwindigkeit"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Transportband> _Sektor_nach_Transportband(long sektorID) {
        try {
            List<Transportband> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Transportband O where O.id_sektor_nach="+sektorID);
            while(rs.next()){
                back.add(new Transportband(this,
                    rs.getLong("id_transportband"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getInt("laenge"),
                    rs.getInt("geschwindigkeit"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<HubPodest> _Sektor_HubPodest(long sektorID) {
        try {
            List<HubPodest> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from HubPodest O where O.id_sektor="+sektorID );
            while(rs.next()){
                back.add(new HubPodest(this,
                    rs.getLong("id_hubpodest"),
                    rs.getInt("oben"),
                    rs.getInt("unten"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<HubQuerPodest> _Sektor_HubQuerPodest(long sektorID) {
        try {
            List<HubQuerPodest> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from HubQuerPodest O where O.id_sektor="+sektorID );
            while(rs.next()){
                back.add(new HubQuerPodest(this,
                    rs.getLong("id_hubquerpodest"),
                    rs.getInt("oben"),
                    rs.getInt("unten"),
                    rs.getInt("mittig"),
                    rs.getInt("motor"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Sensor> _Sektor_Sensor(long sensorID) {
        try {
            List<Sensor> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Sensor O where O.id_sensor="+sensorID );
            while(rs.next()){
                back.add(new Sensor(this,
                    rs.getLong("id_sensor"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getString("phy_adresse"),
                    rs.getInt("zustand"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Roboter> _Sektor_Roboter(long sektorID) {
        try {
            List<Roboter> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Roboter O,Roboter_Sektor R where R.id_sektor="+sektorID+" and R.id_roboter=O.id_roboter" );
            while(rs.next()){
                back.add(new Roboter(this,
                    rs.getLong("id_roboter"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getInt("position_X"),
                    rs.getInt("position_Y"),
                    rs.getInt("position_Z"),
                    rs.getInt("position_Ausrichtung"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public Sektor _HubPodest_Sektor(long hubPodestId) {
        try {
            Sektor back;
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from HubPodest,Sektor where id_hubpodest="+hubPodestId+" and id_sektor=id_sektor" );
            rs.next();
            back = new Sektor(this,
                rs.getLong("id_sektor"),
                rs.getString("bezeichnung"),
                rs.getInt("stoerung"),
                rs.getInt("position_X"),
                rs.getInt("position_Y"),
                rs.getInt("position_Z"),
                rs.getInt("position_Ausrichtung"),
                rs.getTimestamp("zeitstempel"),
                rs.getString("user_parameter")
            );
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public Sektor _HubQuerPodest_Sektor(long hubQuerPodestId) {
        try {
            Sektor back;
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from HubQuerPodest,Sektor where id_hubquerpodest="+hubQuerPodestId+" and id_sektor=id_sektor" );
            rs.next();
            back = new Sektor(this,
                rs.getLong("id_sektor"),
                rs.getString("bezeichnung"),
                rs.getInt("stoerung"),
                rs.getInt("position_X"),
                rs.getInt("position_Y"),
                rs.getInt("position_Z"),
                rs.getInt("position_Ausrichtung"),
                rs.getTimestamp("zeitstempel"),
                rs.getString("user_parameter")
            );
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public Sektor _Sensor_Sektor(long sensorID) {
        try {
            Sektor back;
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Sensor O,Sektor R where O.id_sensor="+sensorID+" and O.id_sektor=R.id_sektor" );
            rs.next();
            back = new Sektor(this,
                rs.getLong("id_sektor"),
                rs.getString("bezeichnung"),
                rs.getInt("stoerung"),
                rs.getInt("position_X"),
                rs.getInt("position_Y"),
                rs.getInt("position_Z"),
                rs.getInt("position_Ausrichtung"),
                rs.getTimestamp("zeitstempel"),
                rs.getString("user_parameter")
            );
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Sektor> _Roboter_Sektor(long roboterID) {
        try {
            List<Sektor> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Roboter O,Roboter_Sektor R where R.id_roboter="+roboterID+" and R.id_sektor=O.id_sektor" );
            while(rs.next()){
                back.add(new Sektor(this,
                    rs.getLong("id_sektor"),
                    rs.getString("bezeichnung"),
                    rs.getInt("stoerung"),
                    rs.getInt("position_X"),
                    rs.getInt("position_Y"),
                    rs.getInt("position_Z"),
                    rs.getInt("position_Ausrichtung"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public List<Gelenk> _Roboter_Gelenk(long roboterID) {
        try {
            List<Gelenk> back = new ArrayList<>();
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Gelenk O where O.id_roboter="+roboterID );
            while(rs.next()){
                back.add(new Gelenk(this,
                    rs.getLong("id_gelenk"),
                    rs.getString("typ"),
                    rs.getInt("nummer"),
                    rs.getInt("gelenkstellung"),
                    rs.getTimestamp("zeitstempel"),
                    rs.getString("user_parameter")
                ));  
            }
            rs.close();
            stmt.close();
            return back;
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
            return null; // durch Exception ersetzten
        }
    }

    @Override
    public Roboter _Gelenk_Roboter(long gelenkID) {
        try {
            Roboter back;
            Statement stmt = this.db.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * from Roboter O,Gelenk R where R.id_gelenk="+gelenkID+" and R.id_roboter=O.id_roboter" );
            rs.next();
            back = new Roboter(this,
                rs.getLong("id_roboter"),
                rs.getString("bezeichnung"),
                rs.getInt("stoerung"),
                rs.getInt("position_X"),
                rs.getInt("position_Y"),
                rs.getInt("position_Z"),
                rs.getInt("position_Ausrichtung"),
                rs.getTimestamp("zeitstempel"),
                rs.getString("user_parameter")
            );  
            
            rs.close();
            stmt.close();
            return back;
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
            Artikel a=new Artikel(this,rs.getLong("id_artikel"),rs.getString("bezeichnung"),rs.getTimestamp("zeitstempel"),rs.getString("user_parameter"));
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

    @Override
    public String toString() {
        return super.toString()+"  :  DatenbankSchnittstelle{" + "db=" + db + '}';
    }
    
}
