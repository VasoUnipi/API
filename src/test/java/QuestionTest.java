import static org.junit.jupiter.api.Assertions.*;

import org.example.Questions;
import org.example.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class QuestionsTest {

    private Questions questions;

    @BeforeEach
    void setUp() {
        questions = new Questions();
    }

    // Χρήση εικονικών παραμέτρων για την κλήση
    @Test
    void testConstructorAndGetters() {
        List<Result> results = List.of(new Result("multiple", "medium", "Science", "What is Java?", "A programming language", List.of("A coffee brand", "A car model", "An island")));
        Questions questions = new Questions(0, results);

        assertEquals(0, questions.getResponseCode(), "Response code should be 0");
        assertNotNull(questions.getResults(), "Results should not be null");
        assertEquals(1, questions.getResults().size(), "Results should contain 1 question");
        assertEquals("What is Java?", questions.getResults().get(0).getQuestion(), "Question text should match");
    }

    @Test
    void testSetters() {
        questions.setResponseCode(1);
        assertEquals(1, questions.getResponseCode(), "Response code should be updated to 1");

        List<Result> results = List.of(new Result("boolean", "easy", "Math", "Is 2+2=4?", "True", List.of("False")));
        questions.setResults(results);

        assertNotNull(questions.getResults(), "Results should not be null");
        assertEquals(1, questions.getResults().size(), "Results should contain 1 question");
        assertEquals("Is 2+2=4?", questions.getResults().get(0).getQuestion(), "Question text should match");
    }

    @Test
    void testAdditionalProperties() {
        questions.setAdditionalProperty("extra_info", "Test Data");
        Map<String, Object> additionalProperties = questions.getAdditionalProperties();

        assertNotNull(additionalProperties, "Additional properties should not be null");
        assertEquals(1, additionalProperties.size(), "There should be 1 additional property");
        assertEquals("Test Data", additionalProperties.get("extra_info"), "Additional property value should match");
    }

    @Test
    void testToString() {
        questions.setResponseCode(0);
        String toStringOutput = questions.toString();

        assertTrue(toStringOutput.contains("responseCode=0"), "toString() should contain 'responseCode=0'");
    }
}
