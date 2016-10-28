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
 * @author user
 */
public class HubQuerPodest {
    
    private final DatenSchnittstelle data;
    private final long id_HubQuerPodest;
    private final int oben;
    private final int unten;
    private final int mittig;
    private final int moter;
    private final Timestamp zeitstempel;
    private final String user_Parameter;

    public HubQuerPodest(DatenSchnittstelle data, long id_HubQuerPodest, int oben, int unten, int mittig, int moter, Timestamp zeitstempel, String user_Parameter) {
        this.data = data;
        this.id_HubQuerPodest = id_HubQuerPodest;
        this.oben = oben;
        this.unten = unten;
        this.mittig = mittig;
        this.moter = moter;
        this.zeitstempel = zeitstempel;
        this.user_Parameter = user_Parameter;
    }

    public long getId_HubQuerPodest() {
        return id_HubQuerPodest;
    }

    public boolean isOben() {
        return oben>0;
    }

    public boolean isUnten() {
        return unten>0;
    }

    public boolean isMittig() {
        return mittig>0;
    }

    public boolean isMoter() {
        return moter>0;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Parameter() {
        return user_Parameter;
    }
    public Sektor getSektor(){
        return this.data._HubQuerPodest_Sektor(id_HubQuerPodest);
    }

    @Override
    public String toString() {
        return super.toString()+"  :  HubQuerPodest{" + "data=" + data + ", id_HubQuerPodest=" + id_HubQuerPodest + ", oben=" + oben + ", unten=" + unten + ", mittig=" + mittig + ", moter=" + moter + ", zeitstempel=" + zeitstempel + ", user_Parameter=" + user_Parameter + '}';
    }
    
    
}
