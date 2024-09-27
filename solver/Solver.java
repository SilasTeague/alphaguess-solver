import dictionary.ArrayProducer;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        ArrayProducer ap = new ArrayProducer("dictionary/sowpods.gz.txt");
        String[] words = ap.getDictionary();
        run(words);
    }

    public static void run(String[] words) {
        int left = 0, right = words.length - 1, mid;

        Scanner in = new Scanner(System.in);

        while (left <= right) {
            mid = (left + right) / 2;

            System.out.println("Current word: " + words[mid]);

            System.out.print("Does the word come 'before, 'after', or is the word 'correct'? Type 'exit' to quit: ");
            String input = in.next().toLowerCase();

            switch (input) {
                case "before":
                    right = mid - 1;
                    break;
                case "after":
                    left = mid + 1;
                    break;
                case "correct":
                    System.out.println("Congratulations! You found the word: " + words[mid]);
                    return;
                case "exit":
                    System.out.println("Exiting the game.");
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}