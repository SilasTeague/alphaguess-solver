import dictionary.ArrayProducer;

public class Solver {
    public static void main(String[] args) {
        ArrayProducer ap = new ArrayProducer("dictionary/sowpods.gz.txt");
        String[] words = ap.getDictionary();
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}