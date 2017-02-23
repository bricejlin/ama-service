package com.newtownscriptkiddies.ama.resources;

import com.newtownscriptkiddies.ama.api.Question;
import org.junit.Test;
import org.mockito.Mock;

public class QuestionsResourceTest {

    @Mock Question question;

    private final QuestionsResource questionsResource = new QuestionsResource();

    @Test
    public void testAddQuestion_Should_AddQuestionToDB() {
        // TODO
    }
}
