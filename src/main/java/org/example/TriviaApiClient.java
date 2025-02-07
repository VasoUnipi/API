package org.example;
// Εισαγωγή των απαραίτητων βιβλιοθηκών

import com.fasterxml.jackson.databind.ObjectMapper; // Βιβλιοθήκη Jackson για μετατροπή JSON σε αντικείμενα Java
import java.net.URI; // Κλάση για τη διαχείριση Uniform Resource Identifiers (URIs), χρήσιμη για τον ορισμό του API endpoint
import java.net.http.HttpClient; // HTTP client που χρησιμοποιείται για την αποστολή και λήψη αιτημάτων HTTP
import java.net.http.HttpRequest;  // Κλάση για τη δημιουργία HTTP αιτήσεων
import java.net.http.HttpResponse; // Κλάση που διαχειρίζεται τις αποκρίσεις από HTTP αιτήσεις
/**
 * Η κλάση TriviaApiClient χρησιμοποιείται για την επικοινωνία με το Open Trivia Database.
 * Εκτελεί HTTP αιτήσεις GET, λαμβάνει JSON δεδομένα και τα μετατρέπει σε αντικείμενα Java.
 */
public class TriviaApiClient {
    /**
     * Ανάκτηση ερωτήσεων από το Open Trivia Database API.
     *
     * @param amount Ο αριθμός των ερωτήσεων που θα ανακτηθούν
     * @param category Η κατηγορία των ερωτήσεων (σύμφωνα με το API της Open Trivia Database)
     * @param difficulty Το επίπεδο δυσκολίας των ερωτήσεων ("easy", "medium" ή "hard")
     * @param type Ο τύπος των ερωτήσεων ("multiple" για πολλαπλής επιλογής, "boolean" για σωστό/λάθος)
     * @return Ένα αντικείμενο Questions που περιέχει τις ερωτήσεις απόκρισης του API
     * @throws Exception Σε περίπτωση αποτυχίας του HTTP αιτήματος ή αποτυχίας μετατροπής JSON σε αντικείμενο Java
     */
        public Questions fetchQuestions(int amount, int category, String difficulty, String type) throws Exception {
            // Δημιουργία του URL της API κλήσης χρησιμοποιώντας δυναμική εισαγωγή παραμέτρων
        String apiUrl = String.format("https://opentdb.com/api.php?amount=%d&category=%d&difficulty=%s&type=%s",
                amount, category, difficulty, type);
            // Δημιουργία HttpClient που θα εκτελέσει το αίτημα
        HttpClient client = HttpClient.newHttpClient();
            // Δημιουργία HTTP GET αιτήματος με το συγκεκριμένο URI
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl)) // Καθορισμός του URI του API
                .GET() // Ορισμός της HTTP μεθόδου ως GET
                .build();
        // Αποστολή του HTTP αιτήματος και λήψη της απόκρισης ως συμβολοσειρά string
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
// Έλεγχος αν η απόκριση είναι επιτυχής (200 OK)
            if (response.statusCode() != 200) {
                throw new RuntimeException("Σφάλμα στην ανάκτηση δεδομένων από το API: " + response.statusCode());
            }
            // Δημιουργία ενός ObjectMapper (Jackson) για μετατροπή της απόκρισης JSON σε αντικείμενο Java
        ObjectMapper mapper = new ObjectMapper();
            // Μετατροπή της JSON απόκρισης σε αντικείμενο Questions
        return mapper.readValue(response.body(), Questions.class);
    }
    /**
     * Κύρια μέθοδος (main) για δοκιμαστική εκτέλεση του API client
     * Δημιουργεί ένα στιγμιότυπο του TriviaApiClient και καλεί τη μέθοδο fetchQuestions
     * για την ανάκτηση ερωτήσεων από το API.
     * Αν οι ερωτήσεις ληφθούν επιτυχώς, εκτυπώνονται στην κονσόλα, αλλιώς εκτυπώνεται μήνυμα σφάλματος.
     */
    public static void main(String[] args) {
        try {
            // Δημιουργία στιγμιότυπου της κλάσης TriviaApiClient
            TriviaApiClient apiClient = new TriviaApiClient();
            // Παράδειγμα δοκιμής με 5 ερωτήσεις, κατηγορία "Science: Computers" (18), δυσκολία "medium", τύπο "multiple"
            Questions questions = apiClient.fetchQuestions(5, 18, "medium", "multiple");
            // Εκτύπωση των ερωτήσεων στην κονσόλα
            System.out.println("Ερωτήσεις που ελήφθησαν από το API:");
            System.out.println(questions);
        } catch (Exception e) {
            // Διαχείριση εξαιρέσεων: εκτύπωση του stack trace σε περίπτωση σφάλματος
            System.err.println("Προέκυψε σφάλμα κατά την επικοινωνία με το API:");
            e.printStackTrace();
        }
    }
}