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
import java.util.List;

/**
 *
 * @author user
 */
public interface DatenSchnittstelle {
    
    //Abfragen fuer Relationen-------------------------------------------------------------
    //Artikel------------------------------------------------------------------------------
    /**
     * Relation: Artikel liget auf Warentraeger
     *
     * @param artikelID
     * @return alle Warentraeger auf denen dieser Artikel ist
     * 
     */
    public List<Warentraeger> _Artikel_Warentraeger(long artikelID);
    
    //Warentraeger---------------------------------------------------------------------------

    /**
     *  Relation: Artikeltypen auf diesem Warentraeger
     * @param warentraegerID
     * @return Liste
     */
    public List<Artikel> _Warentraeger_Artikel(long warentraegerID);

    /**
     *  Relation: Transportband auf dem der Warentraeger ist
     * @param warentraegerID
     * @return Liste(Länge 1 oder 0)
     */
    public List<Transportband> _Warentraeger_Transportband(long warentraegerID);

    /**
     * Relation: In welchem Sektor ist der Warentraeger
     * @param warentraegerID
     * @return Liste(Länge 1 oder 0)
     */
    public List<Sektor> _Warentraeger_Sektor(long warentraegerID);
    //-------------------------------------------------------------------------
    //Transportband------------------------------------------------------------

    /**
     * Relation: Warentraeger auf diesem Transportband
     *
     * @param transportbandID
     * @return Liste
     */
    public List<Warentraeger> _Transportband_Warentraeger(long transportbandID);

    /**
     * Relation:Transportband ist vor Sektor
     * @param transportbandID
     * @return Sektor
     */
    public Sektor _Transportband_vor_Sektor(long transportbandID);

    /**
     * Relation: Transportband ist nach Sektor
     * @param transportbandID
     * @return Sektor
     */
    public Sektor _Transportband_nach_Sektor(long transportbandID);
    //---------------------------------------------------------------------------
    //Sektor--------------------------------------------------------------------

    /**
     * Relation: Warentraeger im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<Warentraeger> _Sektor_Warentraeger(long sektorID);

    /**
     * Relation: Sektor vor Transportband(gehoert also zu Transportband_nach_Sektor)
     * @param sektorID
     * @return Liste
     */
    public List<Transportband> _Sektor_vor_Transportband(long sektorID);

    /**
     * Relation: Sektor nach Transportband(gehoert also zu Transportband_vor_Sektor)
     * @param sektorID
     * @return Liste
     */
    public List<Transportband> _Sektor_nach_Transportband(long sektorID);

    /**
     * Relation: HubPodeste im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<HubPodest> _Sektor_HubPodest(long sektorID);

    /**
     * Relation: HubQuerPodeste im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<HubQuerPodest> _Sektor_HubQuerPodest(long sektorID);

    /**
     * Relation: Sensoren im Sektor
     * @param sensorID
     * @return Liste
     */
    public List<Sensor> _Sektor_Sensor(long sensorID);

    /**
     * Relation: Roboter im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<Roboter> _Sektor_Roboter(long sektorID);
    //---------------------------------------------------------------------------
    //HubPodest-------------------------------------------------------------------

    /**
     * Relation: Sektor vom hubpodest
     * @param hubPodestId
     * @return Sektor
     */
    public Sektor _HubPodest_Sektor(long hubPodestId);
    //----------------------------------------------------------------------------
    //HubQuerPodest---------------------------------------------------------------

    /**
     * Relation: Sektor vom HubQuerPodest
     * @param hubQuerPodestId
     * @return Sektor
     */
    public Sektor _HubQuerPodest_Sektor(long hubQuerPodestId);
    //---------------------------------------------------------------------------
    //Sensor---------------------------------------------------------------------

    /**
     * Relation: Sektor vom Sensor
     * @param sensorID
     * @return Sektor
     */
    public Sektor _Sensor_Sektor(long sensorID);
    //---------------------------------------------------------------------------
    //Roboter-------------------------------------------------------------------

    /**
     * Relation Sektor in dem der Roboter gerade ist (sofern er gerade in einem Sektor ist)
     * @param roboterID
     * @return Liste(Länge 1 oder 0)
     */
    public List<Sektor> _Roboter_Sektor(long roboterID);

    /**
     * Relation Gelenke vom Roboter
     * @param roboterID
     * @return Liste
     */
    public List<Gelenk> _Roboter_Gelenk(long roboterID);
    //----------------------------------------------------------------------------
    //Gelenk---------------------------------------------------------------------

    /**
     * Relation Roboter vom Gelenk
     * @param gelenkID
     * @return Roboter;
     */
    public Roboter _Gelenk_Roboter(long gelenkID);
    //----------------------------------------------------------------------------
    //Abfragen fuer Einzelobjekt--------------------------------------------------

    /**
     * 
     * @param artikelID
     * @return Angefragten Artikel
     * 
     */
    public Artikel getArtikel(long artikelID);
    
    /**
     *
     * @param warentraegerID
     * @return 
     * 
     */
    public Warentraeger getWarentraeger(long warentraegerID);
    
    /**
     *
     * @param transportbandID
     * @return
     */
    public Transportband getTransportband(long transportbandID);
    
    /**
     *
     * @param sektorID
     * @return
     */
    public Sektor getSektor(long sektorID);
    
    /**
     *
     * @param hubpodestID
     * @return
     */
    public HubPodest getHubpodest(long hubpodestID);
    
    /**
     *
     * @param hubquerpodestID
     * @return
     */
    public HubQuerPodest getHubQuerPodest(long hubquerpodestID);
    
    /**
     *
     * @param sensorID
     * @return
     */
    public Sensor getSensor(long sensorID);
    
    /**
     *
     * @param roboterID
     * @return
     */
    public Roboter getRoboter(long roboterID);
    
    /**
     *
     * @param gelenkID
     * @return
     */
    public Gelenk getGelenk(long gelenkID);
    
}
