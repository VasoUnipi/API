

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Questions;
import org.example.Result;
import org.example.TriviaApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TriviaApiClientTest {

    @Mock
    private HttpClient mockHttpClient;

    @Mock
    private HttpResponse<String> mockResponse;

    private TriviaApiClient apiClient;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        apiClient = new TriviaApiClient();

        // Εικονικό JSON
        String fakeJson = "{ \"response_code\": 0, \"results\": [ { \"question\": \"What is Java?\", \"correct_answer\": \"A programming language\", \"incorrect_answers\": [\"A coffee brand\", \"A car model\", \"An island\"] } ] }";

        // Εικονικό HTTP response
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);
        when(mockResponse.body()).thenReturn(fakeJson);
    }

    @Test
    void testFetchQuestions() throws Exception {
        // Χρησιμοποιούμε τον ObjectMapper για να διαβάσουμε το mock JSON (εικονικό)
        ObjectMapper mapper = new ObjectMapper();
        Questions questions = mapper.readValue(mockResponse.body(), Questions.class);

        assertNotNull(questions, "Το αποτέλεσμα δεν πρέπει να είναι null.");
        assertEquals(1, questions.getResults().size(), "Πρέπει να επιστρέψει 1 ερώτηση.");

        Result firstQuestion = questions.getResults().get(0);
        assertEquals("What is Java?", firstQuestion.getQuestion(), "Η ερώτηση δεν είναι σωστή.");
        assertEquals("A programming language", firstQuestion.getCorrectAnswer(), "Η σωστή απάντηση δεν είναι σωστή.");
        assertEquals(3, firstQuestion.getIncorrectAnswers().size(), "Πρέπει να υπάρχουν 3 λανθασμένες απαντήσεις.");
    }
}
