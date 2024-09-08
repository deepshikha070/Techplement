package QuizGenerator;

import java.util.ArrayList;

public class Quiz {
    private String quizName;
    private ArrayList<Question> questions;

    public Quiz(String quizName) {
        this.quizName = quizName;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }
}
