package soccer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Een enum voor de verschillende spelerStatussen. 
 */
public enum SpelerStatus {

    /**
     * Enum gele kaart
     */
    Gele_kaart,

    /**
     * Enum rode kaart
     */
    Rode_kaart,

    /**
     * Enum geblesseerd
     */
    Geblesseerd,

    /**
     * enum normaal
     */
    Normaal;
}
