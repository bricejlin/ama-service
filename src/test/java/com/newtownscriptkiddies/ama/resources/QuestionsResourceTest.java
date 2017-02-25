package com.newtownscriptkiddies.ama.resources;

import static org.mockito.Mockito.verify;

import com.newtownscriptkiddies.ama.api.Question;
import com.newtownscriptkiddies.ama.db.dao.QuestionDAO;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuestionsResourceTest {

    private Question question = new Question(UUID.randomUUID(), "Hi?", "Cats");

    private QuestionsResource questionsResource;

    @Mock QuestionDAO questionDAO;

    @Before
    public void setUp() {
        questionsResource = new QuestionsResource(questionDAO);
    }

    @Test
    public void testGetQuestions_Should_ReturnAllQuestions() {
        questionsResource.getQuestions();
        verify(questionDAO).getAll();
    }

    @Test
    public void testAddQuestion_Should_AddQuestionToDB() {
        questionsResource.addQuestion(question);
        verify(questionDAO).insert(question);
    }
}
