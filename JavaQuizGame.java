import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> choices;
    private int answerIndex;

    public QuizQuestion(String question, List<String> choices, int answerIndex) {
        this.question = question;
        this.choices = choices;
        this.answerIndex = answerIndex;
    }

    public void showQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }
    }

    public boolean checkAnswer(int choice) {
        return choice == (answerIndex + 1);
    }
}

public class JavaQuizGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<QuizQuestion> quiz = new ArrayList<>();

        // New question set
        quiz.add(new QuizQuestion("What is the size of int in Java?", Arrays.asList("2 bytes", "4 bytes", "8 bytes", "Depends on OS"), 1));
        quiz.add(new QuizQuestion("Which of these is a valid keyword in Java?", Arrays.asList("interface", "unsigned", "typeof", "intcast"), 0));
        quiz.add(new QuizQuestion("What is a Map in Java?", Arrays.asList("A GUI tool", "Stores key-value pairs", "A network model", "An interface for sorting"), 1));
        quiz.add(new QuizQuestion("What does Iterator do?", Arrays.asList("Sorts elements", "Stores numbers", "Traverses collections", "Converts types"), 2));
        quiz.add(new QuizQuestion("Which method is used to sort a List?", Arrays.asList("Collections.sort()", "List.sort()", "Arrays.sort()", "All of the above"), 3));

        Collections.shuffle(quiz);  // Shuffle questions randomly
        int total = quiz.size();
        int correct = 0;

        for (QuizQuestion q : quiz) {
            q.showQuestion();
            System.out.print("Your answer (1-4): ");
            int ans = input.nextInt();

            if (q.checkAnswer(ans)) {
                System.out.println("✅ Correct Answer!");
                correct++;
            } else {
                System.out.println("❌ Incorrect.");
            }
        }

        System.out.println("\n📊 Final Score: " + correct + " out of " + total);
        if (correct == total) {
            System.out.println("🎉 Excellent! You got all correct!");
        } else if (correct >= total / 2) {
            System.out.println("👍 Good attempt. Keep learning!");
        } else {
            System.out.println("📘 Try again to improve your score.");
        }

        input.close();
    }
}
