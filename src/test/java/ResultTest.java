
import static org.junit.jupiter.api.Assertions.*;

import org.example.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ResultTest {

    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    void testConstructorAndGetters() {
        List<String> incorrectAnswers = List.of("A coffee brand", "A car model", "An island");
        Result result = new Result("multiple", "medium", "Science", "What is Java?", "A programming language", incorrectAnswers);

        assertEquals("multiple", result.getType(), "Type should be 'multiple'");
        assertEquals("medium", result.getDifficulty(), "Difficulty should be 'medium'");
        assertEquals("Science", result.getCategory(), "Category should be 'Science'");
        assertEquals("What is Java?", result.getQuestion(), "Question should match");
        assertEquals("A programming language", result.getCorrectAnswer(), "Correct answer should match");
        assertEquals(3, result.getIncorrectAnswers().size(), "Should contain 3 incorrect answers");
    }

    @Test
    void testSetters() {
        result.setType("boolean");
        result.setDifficulty("hard");
        result.setCategory("Math");
        result.setQuestion("Is 2+2=4?");
        result.setCorrectAnswer("True");
        result.setIncorrectAnswers(List.of("False"));

        assertEquals("boolean", result.getType(), "Type should be 'boolean'");
        assertEquals("hard", result.getDifficulty(), "Difficulty should be 'hard'");
        assertEquals("Math", result.getCategory(), "Category should be 'Math'");
        assertEquals("Is 2+2=4?", result.getQuestion(), "Question should match");
        assertEquals("True", result.getCorrectAnswer(), "Correct answer should match");
        assertEquals(1, result.getIncorrectAnswers().size(), "Should contain 1 incorrect answer");
    }

    @Test
    void testAdditionalProperties() {
        result.setAdditionalProperty("extra_info", "Test Data");
        Map<String, Object> additionalProperties = result.getAdditionalProperties();

        assertNotNull(additionalProperties, "Additional properties should not be null");
        assertEquals(1, additionalProperties.size(), "There should be 1 additional property");
        assertEquals("Test Data", additionalProperties.get("extra_info"), "Additional property value should match");
    }

    @Test
    void testToString() {
        result.setType("multiple");
        result.setQuestion("What is Java?");
        String toStringOutput = result.toString();

        assertTrue(toStringOutput.contains("type=multiple"), "toString() should contain 'type=multiple'");
        assertTrue(toStringOutput.contains("question=What is Java?"), "toString() should contain the question");
    }
}
