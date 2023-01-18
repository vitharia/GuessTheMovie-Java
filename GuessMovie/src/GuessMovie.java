/*
1. Computer randomly picks a movie from file.
2. It shows how many letters it's made up of.
3. User needs to guess one letter at a time.
4. If letter is ok, it shows the position in the word.
5. If not, you lose a point. 10 points = game over.
 */


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessMovie {
    public static void main(String [] args) throws Exception {

        Path path = Paths.get("movies.txt"); // checks how many lines are in a file
        long lines = 0;
        try {
            lines = Files.lines(path).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int randomMovie = (int) (Math.random() * lines); // picks a random line from the file
        // System.out.println(randomMovie);


        File fileMovies = new File("movies.txt"); // reading the file
        Scanner scanner1 = new Scanner(fileMovies);
        for (int i = 0; i < randomMovie; i++) { // reading the random number line
            scanner1.nextLine();
        }
        String movie = scanner1.nextLine();
        // System.out.println(randomMovieString);
        // System.out.println(movie);

        boolean gameOver = false;

        // String movie = "pulp fiction";
        // System.out.println(movie);

        char[] movieArray = movie.toCharArray();
        char[] movieSecret = movie.replaceAll("\\w", "_").toCharArray(); // changing letters to underscores
        // System.out.println(movieSecret);
        String secretString = String.valueOf(movieSecret); // Creating string of underscores
        // char[] wrongLetters = null;
        List<Character> wrongLetters = new ArrayList<>();
        int lives = 10;
        System.out.println("Guess the movie title: " + secretString);
        /* for (int l = 10; l > 0; l--) */  // loop for number of points

        while (!gameOver) {
            if (lives > 0) {

            /* HOW TO LET USER GUESS THE TITLE IF HE KNOWS IT BEFORE GAME OVER??????? */

                System.out.println("Guesses left: " + lives + ". Guess a letter.");
                lives--;

                Scanner input = new Scanner(System.in);
                char guess = input.next().charAt(0); // User's guess
                // char guess = 'o';

                for (int index = movie.indexOf(guess); // loop for checking if guess in the title
                     index >= 0;
                     index = movie.indexOf(guess, index + 1))
                     movieSecret[index] = guess;
                    if ((new String(movieArray).indexOf(guess) == -1)) {
                         System.out.println("No " + guess + " in the title.");
                         wrongLetters.add(guess);
                         System.out.println("Wrong letters: " + wrongLetters);
                     }
                    else {
                    System.out.println(movieSecret);
                    String movieSecretString = new String(movieSecret);

                if (movieSecretString.equals(movie)) {
                    System.out.println("Congratulations, you won!");
                    break;
                }}

            }

            else {gameOver = true; // Out of lives
                System.out.println("Oh no, you're out of lives.");
                System.out.println("The movie was: " + movie);
            }

    }}}










