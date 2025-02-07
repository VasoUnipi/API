
package org.example;
// Εισαγωγή των απαραίτητων βιβλιοθηκών για τη διαχείριση JSON και συλλογών
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * Η κλάση Questions χρησιμοποιείται για την αναπαράσταση της απόκρισης που λαμβάνεται από το Open Trivia Database API.
 * Περιέχει δύο βασικά πεδία: τον κωδικό απόκρισης και τη λίστα των αποτελεσμάτων (ερωτήσεων).
 * Χρησιμοποιεί annotations της βιβλιοθήκης Jackson για τη σωστή διαχείριση της σειριοποίησης και αποσειριοποίησης JSON.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // Εξασφαλίζει ότι τα null κατά τη μετατροπή σε JSON για μείωση μεγέθους
@JsonPropertyOrder({
    "response_code",
    "results"
}) // Ορίζει τη σειρά των πεδίων στο JSON
//@Generated("jsonschema2pojo")
public class Questions {
    @JsonProperty("response_code") // Συνδέει το πεδίο με το αντίστοιχο JSON property ώστε να διαβάζεται/γράφεται σωστά
    private long responseCode;
    @JsonProperty("results") // Συνδέει το πεδίο results με την αντίστοιχη λίστα αποτελεσμάτων του JSON
    private List<Result> results;
    @JsonIgnore // Αγνοεί αυτό το πεδίο κατά τη μετατροπή σε JSON, γιατί περιέχει δυναμικά δεδομένα
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Προεπιλεγμένος κατασκευαστής χωρίς ορίσματα.
     * Χρησιμοποιείται κατά την αποσειριοποίηση από JSON σε αντικείμενο Java.
     */

    public Questions() {
    }
    /**
     * Κατασκευαστής με ορίσματα για αρχικοποίηση των πεδίων.
     *
     * @param responseCode Ο κωδικός απόκρισης του API
     * @param results Η λίστα των αποτελεσμάτων (ερωτήσεων) που επιστράφηκαν από το API
     */
    public Questions(long responseCode, List<Result> results) {
        super();
        this.responseCode = responseCode;
        this.results = results;
    }
    /**
     * Επιστρέφει τον κωδικό απόκρισης του API.\
     *
     * @return Ο κωδικός απόκρισης
     */
    @JsonProperty("response_code")
    public long getResponseCode() {
        return responseCode;
    }
    /**
     * Ορίζει τον κωδικό απόκρισης του API.
     *
     * @param responseCode Ο νέος κωδικός απόκρισης
     */
    @JsonProperty("response_code")
    public void setResponseCode(long responseCode) {
        this.responseCode = responseCode;
    }
    /**
     * Επιστρέφει τη λίστα με τις ερωτήσεις που επιστράφηκαν από το API.
     *
     * @return Λίστα αποτελεσμάτων (ερωτήσεων)
     */
    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }
    /**
     * Ορίζει τη λίστα των ερωτήσεων που επιστράφηκαν από το API.
     *
     * @param results Νέα λίστα αποτελεσμάτων (ερωτήσεων)
     */
    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }
    /**
     * Επιστρέφει έναν χάρτη (Map) με επιπλέον ιδιότητες που δεν έχουν δηλωθεί ρητά ως πεδία της κλάσης.
     * Χρησιμοποιείται για την αποθήκευση άγνωστων ή επιπρόσθετων πεδίων που μπορεί να περιλαμβάνονται στο JSON.
     *
     * @return Ένας χάρτης με επιπλέον ιδιότητες
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    /**
     * Προσθέτει μια νέα ιδιότητα στον χάρτη επιπλέον ιδιοτήτων.
     *
     * @param name Το όνομα της ιδιότητας
     * @param value Η τιμή της ιδιότητας
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    /**
     * Υπερκαθορισμένη μέθοδος toString για την επιστροφή της αναπαράστασης του αντικειμένου ως συμβολοσειρά.
     * Χρησιμοποιείται για debugging και logging.
     * @return Αναπαράσταση του αντικειμένου ως String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Questions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("responseCode");
        sb.append('=');
        sb.append(this.responseCode);
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
