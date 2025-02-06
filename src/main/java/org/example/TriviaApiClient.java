package org.example;

import org.example.Questions;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TriviaApiClient {

    private static final String API_URL = "https://opentdb.com/api.php?amount=10";

    public Questions fetchQuestions(int amount, int category, String difficulty, String type) throws Exception {
        String apiUrl = String.format("https://opentdb.com/api.php?amount=%d&category=%d&difficulty=%s&type=%s",
                amount, category, difficulty, type);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Questions.class);
    }

    public static void main(String[] args) {
        try {
            TriviaApiClient apiClient = new TriviaApiClient();
            // Παράδειγμα δοκιμής με 5 ερωτήσεις, κατηγορία "Science: Computers" (18), δυσκολία "medium", τύπο "multiple"
            Questions questions = apiClient.fetchQuestions(5, 18, "medium", "multiple");
            System.out.println(questions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}