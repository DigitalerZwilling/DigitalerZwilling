/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle;

import DatenbankSchnittestelle.DatenKlassen.Artikel;
import DatenbankSchnittestelle.DatenKlassen.Warentraeger;
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

/**
 *
 * @author user
 */
@ApplicationScoped
public class DatenbankSchnittstelle implements DatenSchnittstelle{
    //---------------------------------------------------------------------------
    //Datenbank verbindungs daten
    
    private final String _DbURL="jdbc:derby://localhost:1527/db_DigitalerZwilling";   //URL
    private final String _DbUser="db_user";                                            //User
    private final String _DbPw="SB0222";                                              //Passswort
    //---------------------------------------------------------------------------
    private Connection db;   // muss noch irgendwie geschlossen werden(Destruktor?)

    public DatenbankSchnittstelle() {
        try {
            db= DriverManager.getConnection(this._DbURL,this._DbUser,this._DbPw);
        } catch (SQLException ex) {
            Logger.getLogger(DatenbankSchnittstelle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PostConstruct
    private void init(){
        
    }

    @Override
    public List<Warentraeger> artikel_auf_Warentraegern(long artikelID) throws Exception {
        List<Warentraeger> back = new ArrayList<>();
        Statement stmt = this.db.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * from Warentraerger ");//where TIPP.USERNAME='"+username+"')=0");
        while(rs.next()){
                //hilf = new Match(rs.getInt("ID"), rs.getString("MANNSCHAFT1"), rs.getString("MANNSCHAFT2"), rs.getTimestamp("START").getTime());
               // ergebnis.add(hilf);
                
        }          
        return back;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Artikel getArtikel(long artikelID) throws Exception {
        System.out.println("test");
        Statement stmt = this.db.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * from Artikel Where id_artikel="+artikelID);
        Artikel a=new Artikel(/*rs.getB("id_artikel")*/1,rs.getString("bezeichnung"),rs.getTimestamp("zeitstempel"),"");
        rs.close();
        stmt.close();
        return a;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
