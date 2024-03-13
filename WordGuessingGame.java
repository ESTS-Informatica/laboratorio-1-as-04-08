/**
 * Write a description of class WordGuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    private WordGenerator wordGenerator;

    public WordGuessingGame() {
        this.hiddenWord = "abc";
        this.guessedWord = "___";
        this.numberOfTries = 0;
        this.reader = new InputReader();
        this.wordGenerator = new WordGenerator();
        hiddenWord = wordGenerator.generateWord();
    }

    public String getHiddenWord () {
        return hiddenWord;
    }

    public String getGuessedWord () {
        return guessedWord;
    }

    public int getNumberOfTries () {
        return numberOfTries;
    }
    
    private void showGuessedWord () {
        System.out.println("Guessed Word: " + guessedWord);
    }
    
    public void Play (String question) {
        showWelcome();
        showGuessedWord();
        guess(question);
    }
    
    private void showWelcome () {
        System.out.println("Bem-vindo ao jogo Word Guessing Game!");
    }
    
    private void guess (String question) {
        char answer = reader.getChar(question);
        if (hiddenWord.contains(String.valueOf(answer))) {
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == answer) {
                    char[] temp = guessedWord.toCharArray();
                    temp[i] = answer;
                    guessedWord = String.valueOf(temp);
                    numberOfTries++;
                    return;
                }
            }
        }
        numberOfTries++;
    }

    private void showResult () {
        System.out.println("Número de tentativas: " +numberOfTries);
    }

    public void initializeGuessedWord () {
        guessedWord = "";
        for (int i = 0; i <= hiddenWord.length(); i++) {
            guessedWord += "_";
        }
    }
}
