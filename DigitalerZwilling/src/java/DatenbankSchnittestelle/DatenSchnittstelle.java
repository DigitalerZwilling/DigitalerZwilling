/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatenbankSchnittestelle;

import DatenbankSchnittestelle.DatenKlassen.Artikel;
import DatenbankSchnittestelle.DatenKlassen.Warentraeger;
import java.util.List;

/**
 *
 * @author user
 */
public interface DatenSchnittstelle {
    public List<Warentraeger> artikel_auf_Warentraegern(long artikelID) throws Exception;
    public Artikel getArtikel(long artikelID) throws Exception;
}
