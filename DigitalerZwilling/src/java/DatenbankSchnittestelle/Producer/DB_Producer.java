/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle.Producer;



import DatenbankSchnittestelle.Qualifier.DB_Info;
//import java.io.Serializable;
//import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
//import javax.enterprise.inject.Any;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author chrklaas
 */

// Kooperiert mir der dem Qualifier DB_Info


@Dependent
public class DB_Producer  {
 
    
    @Produces @DB_Info
    private Connection produceCon(InjectionPoint in)   {
        System.out.println("Producer_Datenbankverbindung");
        try {
            
            String member_name=in.getMember().getName();
            DB_Info db=in.getMember().getDeclaringClass().getDeclaredField(member_name).getAnnotation(DB_Info.class);
            //System.out.println("Individuelle Zugangsdaten werden genutzt");
            return DriverManager.getConnection(db.db_name(),db.db_user(),db.db_pw());

        } catch (SQLException | NoSuchFieldException ex) {
            Logger.getLogger(DB_Producer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fehler beim erstellen der Datenbankverbindung");
            return null;
        }
    }
    
    private void disposeCon(@Disposes @DB_Info Connection con){
        System.out.println("Aufruf disposer");
        try {
            if(con==null) return;
            
            System.out.println(con.toString());
            
            if(con.isClosed()){
                System.out.println("Datenbank Verbindung war schon geschlossen");
            }
            else {
                //if(!con.getAutoCommit()) con.commit();
                
                System.out.println("Datenbank Verbindung wird geschlossen");
                con.close();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB_Producer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fehler beim schließen der DB-Verbindung");
        }
    }
}
