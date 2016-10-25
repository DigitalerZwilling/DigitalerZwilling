/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle;

import DatenbankSchnittestelle.DatenKlassen.Artikel;
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
    public List<Warentraeger> artikel_auf_Warentraegern(long artikelID) throws Exception {
        List<Warentraeger> back = new ArrayList<>();
        Statement stmt = this.db.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * from Warentraerger where id_artikel="+artikelID);//where TIPP.USERNAME='"+username+"')=0");
        while(rs.next()){
                back.add(new Warentraeger());
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
        rs.next();
        Artikel a=new Artikel(/*rs.getB("id_artikel")*/1,rs.getString("bezeichnung"),rs.getTimestamp("zeitstempel"),"");
        rs.close();
        stmt.close();
        return a;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
