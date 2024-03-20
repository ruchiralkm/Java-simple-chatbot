import java.util.*;
import java.io.File;

public class bot {

    HashMap<String, String> knowledge;

    public bot() {
        knowledge = new HashMap<>();
        knowledge.put("good morning", "good morning!");
        knowledge.put("good evening", "good evening!");
        knowledge.put("need advice", "please ask!");
        knowledge.put("follow a course", "ok...go on..");
        knowledge.put("thank you", "you are welcome dear");
    }

    public boolean answer(String question) {
        String lowerQuestion = question.toLowerCase();
        if (knowledge.containsKey(lowerQuestion)) {
            System.out.println("Bot: " + knowledge.get(lowerQuestion));
            return true;
        } else if (lowerQuestion.contains("how are you")) {
            String[] responses = {"I'm fine", "I am ok", "Not bad dear", "good", "Alright"};
            System.out.println("Bot: " + responses[new Random().nextInt(responses.length)]);
            return true;
        } else if (lowerQuestion.contains("hi") || lowerQuestion.contains("hello")) {
            String[] greetings = {"Hi!", "Hello!", "Hello Dear", "Hey, nice to see you"};
            System.out.println("Bot: " + greetings[new Random().nextInt(greetings.length)]);
            return true;
        } else if (lowerQuestion.contains("courses")) {
            showDataFromFile("courses.txt");
            return true;
        } else if (lowerQuestion.contains("branches")) {
            showDataFromFile("branches.txt");
            return true;
        }
        return false;
    }

    public void showDataFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bot bot = new bot();
        String userName = "";

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();
            if (input.contains("your name")) {
                System.out.println("Bot: I'm Robby and your name ?");
                System.out.print("You: ");
                userName = scanner.nextLine();
            } else if (input.contains("bye")) {
                System.out.println("Bot: Good Bye " + userName);
                break;
            } else {
                bot.answer(input);
            }
        }
        scanner.close();
    }
}
