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
    public List<Long> getArtikelWarentraegerIDs(long artikelID);
    
    //Warentraeger---------------------------------------------------------------------------

    /**
     *  Relation: Artikeltypen auf diesem Warentraeger
     * @param warentraegerID
     * @return Liste
     */
    public List<Long> getWarentraegerArtikelIDs(long warentraegerID);

    /**
     *  Relation: Transportband auf dem der Warentraeger ist
     * @param warentraegerID
     * @return Liste(Länge 1 oder 0)
     */
    public List<Long> getWarentraegerTransportbandID(long warentraegerID);

    /**
     * Relation: In welchem Sektor ist der Warentraeger
     * @param warentraegerID
     * @return Liste(Länge 1 oder 0)
     */
    public List<Long> getWarentraegerSektorID(long warentraegerID);
    //-------------------------------------------------------------------------
    //Transportband------------------------------------------------------------

    /**
     * Relation: Warentraeger auf diesem Transportband
     *
     * @param transportbandID
     * @return Liste
     */
    public List<Long> getTransportbandWarentraegerIDs(long transportbandID);

    /**
     * Relation:Transportband ist vor Sektor
     * @param transportbandID
     * @return Sektor
     */
    public Long getTransportbandVorSektorID(long transportbandID);

    /**
     * Relation: Transportband ist nach Sektor
     * @param transportbandID
     * @return Sektor
     */
    public Long getTransportbandNachSektorID(long transportbandID);
    //---------------------------------------------------------------------------
    //Sektor--------------------------------------------------------------------

    /**
     * Relation: Warentraeger im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<Long> getSektorWarentraegerIDs(long sektorID);

    /**
     * Relation: Sektor vor Transportband(gehoert also zu Transportband_nach_Sektor)
     * @param sektorID
     * @return Liste
     */
    public List<Long> getSektorVorTransportbandIDs(long sektorID);

    /**
     * Relation: Sektor nach Transportband(gehoert also zu Transportband_vor_Sektor)
     * @param sektorID
     * @return Liste
     */
    public List<Long> getSektorNachTransportbandIDs(long sektorID);

    /**
     * Relation: HubPodeste im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<Long> getSektorHubPodestIDs(long sektorID);

    /**
     * Relation: HubQuerPodeste im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<Long> getSektorHubQuerPodestIDs(long sektorID);

    /**
     * Relation: Sensoren im Sektor
     * @param sensorID
     * @return Liste
     */
    public List<Long> getSektorSensorIDs(long sensorID);

    /**
     * Relation: Roboter im Sektor
     * @param sektorID
     * @return Liste
     */
    public List<Long> getSektorRoboterIDs(long sektorID);
    //---------------------------------------------------------------------------
    //HubPodest-------------------------------------------------------------------

    /**
     * Relation: Sektor vom hubpodest
     * @param hubPodestId
     * @return SektorID
     */
    public Long getHubPodestSektorID(long hubPodestId);
    //----------------------------------------------------------------------------
    //HubQuerPodest---------------------------------------------------------------

    /**
     * Relation: Sektor vom HubQuerPodest
     * @param hubQuerPodestId
     * @return SektorID
     */
    public Long getHubQuerPodestSektorID(long hubQuerPodestId);
    //---------------------------------------------------------------------------
    //Sensor---------------------------------------------------------------------

    /**
     * Relation: Sektor vom Sensor
     * @param sensorID
     * @return SektorID
     */
    public Long getSensorSektorID(long sensorID);
    //---------------------------------------------------------------------------
    //Roboter-------------------------------------------------------------------

    /**
     * Relation Sektor in dem der Roboter gerade ist (sofern er gerade in einem Sektor ist)
     * @param roboterID
     * @return Liste(Länge 1 oder 0)
     */
    public List<Long> getRoboterSektorID(long roboterID);

    /**
     * Relation Gelenke vom Roboter
     * @param roboterID
     * @return Liste
     */
    public List<Long> getRoboterGelenkIDs(long roboterID);
    //----------------------------------------------------------------------------
    //Gelenk---------------------------------------------------------------------

    /**
     * Relation Roboter vom Gelenk
     * @param gelenkID
     * @return RoboterID;
     */
    public Long getGelenkRoboterID(long gelenkID);
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
