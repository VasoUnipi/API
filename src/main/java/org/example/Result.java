package org.example;
// Εισαγωγή των απαραίτητων βιβλιοθηκών για τη διαχείριση JSON
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
 * Η κλάση Result αναπαριστά μία μεμονωμένη ερώτηση από το Open Trivia Database API.
 * Περιέχει πληροφορίες όπως τον τύπο της ερώτησης, τη δυσκολία, την κατηγορία,
 * την ερώτηση, τη σωστή απάντηση και τις λανθασμένες απαντήσεις.
 *
 * Χρησιμοποιεί annotations της βιβλιοθήκης Jackson για να διαχειριστεί τη μετατροπή
 * μεταξύ JSON και Java αντικειμένων αυτόματα.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // Εξασφαλίζει ότι τα null πεδία δεν περιλαμβάνονται στο JSON
@JsonPropertyOrder({
    "type",
    "difficulty",
    "category",
    "question",
    "correct_answer",
    "incorrect_answers"
}) // Καθορίζει τη σειρά των πεδίων στο JSON
//@Generated("jsonschema2pojo")
public class Result {
//Ορίζουμε τα πεδία της κλάσης με αντιστοίχιση στα ονόματα JSON
    @JsonProperty("type") // Ορίζει το αντίστοιχο JSON property
    private String type; // Ο τύπος της ερώτησης (π.χ., "multiple" ή "boolean")
    @JsonProperty("difficulty")
    private String difficulty; // Η δυσκολία της ερώτησης ("easy", "medium", "hard")
    @JsonProperty("category")
    private String category; // Η κατηγορία της ερώτησης
    @JsonProperty("question")
    private String question; // Το κυρίως κείμενο της ερώτησης
    @JsonProperty("correct_answer")
    private String correctAnswer; // Το κυρίως κείμενο της ερώτησης
    @JsonProperty("incorrect_answers")
    private List<String> incorrectAnswers; // Λίστα με τις λανθασμένες απαντήσεις
    @JsonIgnore // Το πεδίο αυτό αγνοείται κατά τη μετατροπή σε JSON για να μην επηρεάζει τη μετατροπή
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Προεπιλεγμένος κατασκευαστής χωρίς ορίσματα.
     * Χρησιμοποιείται κατά την αποσειριοποίηση από JSON σε αντικείμενο Java.
     */
    public Result() {
    }
    /**
     * Κατασκευαστής με ορίσματα για αρχικοποίηση των πεδίων της κλάσης.
     *
     * @param type Ο τύπος της ερώτησης (π.χ. "multiple" για πολλαπλής επιλογής, "boolean" για ναι/όχι)
     * @param difficulty Το επίπεδο δυσκολίας της ερώτησης (π.χ. "easy", "medium", "hard")
     * @param category Η κατηγορία στην οποία ανήκει η ερώτηση
     * @param question Το ερώτημα που τίθεται
     * @param correctAnswer Η σωστή απάντηση
     * @param incorrectAnswers Λίστα με τις λανθασμένες απαντήσεις
     */
    public Result(String type, String difficulty, String category, String question, String correctAnswer, List<String> incorrectAnswers) {
        super();
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }
    // Getters και Setters για κάθε πεδίο, χρησιμοποιώντας Jackson annotations για αντιστοίχιση με το JSON
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }

    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonProperty("correct_answer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @JsonProperty("correct_answer")
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @JsonProperty("incorrect_answers")
    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    @JsonProperty("incorrect_answers")
    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
    /**
     * Επιστρέφει έναν χάρτη (Map) με επιπλέον ιδιότητες που δεν έχουν δηλωθεί ρητά ως πεδία της κλάσης.
     * Χρησιμοποιείται για να επιστρέφει πρόσθετα πεδία JSON που μπορεί να υπάρχουν αλλά δεν έχουν δηλωθεί ρητά.
     * Αυτό είναι σημαντικό όταν το API μπορεί να επιστρέψει επιπλέον δεδομένα στο μέλλον
     * @return Ένας χάρτης με επιπλέον ιδιότητες
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    /**
     * Προσθέτει μια νέα ιδιότητα στον χάρτη επιπλέον ιδιοτήτων.
     * Χρησιμοποιείται για να προσθέσει δυναμικά επιπλέον πεδία JSON που δεν έχουν προϋπολογιστεί στη δομή της κλάσης
     * @param name Το όνομα της ιδιότητας
     * @param value Η τιμή της ιδιότητας
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    /**
     * Υπερκαθορισμένη μέθοδος toString για αναπαράσταση του αντικειμένου ως String.
     * Χρησιμοποιείται κυρίως για debugging και εκτύπωση δεδομένων
     * @return Αναπαράσταση του αντικειμένου ως String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("difficulty");
        sb.append('=');
        sb.append(((this.difficulty == null)?"<null>":this.difficulty));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        sb.append("question");
        sb.append('=');
        sb.append(((this.question == null)?"<null>":this.question));
        sb.append(',');
        sb.append("correctAnswer");
        sb.append('=');
        sb.append(((this.correctAnswer == null)?"<null>":this.correctAnswer));
        sb.append(',');
        sb.append("incorrectAnswers");
        sb.append('=');
        sb.append(((this.incorrectAnswers == null)?"<null>":this.incorrectAnswers));
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
