package Cipher;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        String sentence = createSentence(message);
        System.out.println("Generated sentence: " + sentence);
    }

    public static String createSentence(String message) {
        StringBuilder sentence = new StringBuilder();

        HashMap<Character, List<String>> startWords = getStartWords();

        for (char letter : message.toCharArray()) {
            char startLetter = Character.toUpperCase(letter);
            if (startWords.containsKey(startLetter)) {
                List<String> wordList = startWords.get(startLetter);
                String randomWord = getRandomElement(wordList);
                sentence.append(randomWord).append(" ");
            }
        }

        return sentence.toString().trim();
    }

    public static HashMap<Character, List<String>> getStartWords() {
        HashMap<Character, List<String>> startWords = new HashMap<>();
        startWords.put('A', Arrays.asList("Amazing", "Awesome", "Adventurous"));
        startWords.put('B', Arrays.asList("Beautiful", "Brilliant", "Breathtaking"));
        startWords.put('C', Arrays.asList("Captivating", "Charming", "Creative"));
        startWords.put('D', Arrays.asList("Delightful", "Dazzling", "Dynamic"));
        startWords.put('E', Arrays.asList("Enchanting", "Elegant", "Energetic"));
        startWords.put('F', Arrays.asList("Fascinating", "Fantastic", "Fun"));
        startWords.put('G', Arrays.asList("Glorious", "Gorgeous", "Great"));
        startWords.put('H', Arrays.asList("Heavenly", "Heartwarming", "Happy"));
        startWords.put('I', Arrays.asList("Incredible", "Inspiring", "Impressive"));
        startWords.put('J', Arrays.asList("Joyful", "Jubilant", "Jaw-dropping"));
        startWords.put('K', Arrays.asList("Kaleidoscopic", "Kinetic", "Kind"));
        startWords.put('L', Arrays.asList("Luminous", "Lovely", "Lively"));
        startWords.put('M', Arrays.asList("Magical", "Marvelous", "Memorable"));
        startWords.put('N', Arrays.asList("Nurturing", "Noble", "Nice"));
        startWords.put('O', Arrays.asList("Opulent", "Outstanding", "Optimistic"));
        startWords.put('P', Arrays.asList("Pristine", "Positive", "Playful"));
        startWords.put('Q', Arrays.asList("Quirky", "Quick-witted", "Quality"));
        startWords.put('R', Arrays.asList("Radiant", "Remarkable", "Refreshing"));
        startWords.put('S', Arrays.asList("Serene", "Stunning", "Spectacular"));
        startWords.put('T', Arrays.asList("Transcendent", "Terrific", "Thrilling"));
        startWords.put('U', Arrays.asList("Unforgettable", "Unique", "Upbeat"));
        startWords.put('V', Arrays.asList("Vibrant", "Valiant", "Victorious"));
        startWords.put('W', Arrays.asList("Whimsical", "Wonderful", "Witty"));
        startWords.put('X', Arrays.asList("Xenial", "Xtraordinary", "Xcellent"));
        startWords.put('Y', Arrays.asList("Youthful", "Yearning", "Yummy"));
        startWords.put('Z', Arrays.asList("Zealous", "Zesty", "Zingy"));
        return startWords;
    }

    public static String getRandomElement(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
