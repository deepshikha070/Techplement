package QuizGenerator;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Generator!");

        // Create a new quiz
        Quiz quiz = createQuiz(scanner);

        // Take the quiz
        takeQuiz(scanner, quiz);

        scanner.close();
    }

    public static Quiz createQuiz(Scanner scanner) {
        System.out.print("Enter the name of the quiz: ");
        String quizName = scanner.nextLine();
        Quiz quiz = new Quiz(quizName);

        String continueAdding;
        do {
            System.out.print("Enter the question: ");
            String questionText = scanner.nextLine();

            ArrayList<String> options = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                System.out.print("Enter option " + i + ": ");
                options.add(scanner.nextLine());
            }

            System.out.print("Enter the number of the correct option: ");
            int correctOption = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            Question question = new Question(questionText, options, correctOption);
            quiz.addQuestion(question);

            System.out.print("Do you want to add another question? (yes/no): ");
            continueAdding = scanner.nextLine();
        } while (continueAdding.equalsIgnoreCase("yes"));

        return quiz;
    }

    public static void takeQuiz(Scanner scanner, Quiz quiz) {
        int score = 0;
        for (Question question : quiz.getQuestions()) {
            question.displayQuestion();
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            if (answer == question.getCorrectOption()) {
                score++;
            }
        }
        System.out.println("Your score: " + score + "/" + quiz.getQuestions().size());
    }
}
