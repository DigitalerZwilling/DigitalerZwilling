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
 * @author chris
 */
public class HubPodest {
    private final DatenSchnittstelle data;
    private final long id_HubPodest;
    private final int oben;
    private final int unten;
    private final Timestamp zeitstempel;
    private final String user_Parameter;

    public HubPodest(DatenSchnittstelle data, long id_HubPodest, int oben, int unten, Timestamp zeitstempel, String user_Parameter) {
        this.data = data;
        this.id_HubPodest = id_HubPodest;
        this.oben = oben;
        this.unten = unten;
        this.zeitstempel = zeitstempel;
        this.user_Parameter = user_Parameter;
    }

    public DatenSchnittstelle getData() {
        return data;
    }

    public long getId_HubPodest() {
        return id_HubPodest;
    }

    public boolean isOben() {
        return oben>0;
    }

    public boolean isUnten() {
        return unten>0;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public String getUser_Parameter() {
        return user_Parameter;
    }
    
    public Sektor getSektor(){
        return data._HubPodest_Sektor(id_HubPodest);
    }
}
