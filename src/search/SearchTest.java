package search;

import java.io.IOException;

/**
 * Test program for the Search class.
 */
public class SearchTest {

    /**
     * Test program for the Search class. Put whatever tests you like in the
     * body of the method.
     *
     * @param args the command line arguments
     * @throws java.io.IOException of error reading the input
     */
    public static void main(String[] args) throws IOException {
        // Don't change this line
        final Search search = new Search();

        // You can set this to any of the text files in the data folder
        final FileStrings strings = new FileStrings("data/large.txt");

//        add your tests here
        System.out.println(search.longestWord(strings));
        System.out.println();

        System.out.println(search.countUnique(strings));
        System.out.println();

        System.out.println("Result: " + search.mostFrequent(strings));
        System.out.println();

        System.out.println(search.findElement(strings, "the"));
        System.out.println(search.findElement(strings, "ziggurat"));
        System.out.println();

        System.out.println(search.countGreaterOrEqual(strings, "its"));
        System.out.println(search.countGreaterOrEqual(strings, "orange"));
        System.out.println();

        System.out.println(search.countGreater(strings, "guardian"));
        System.out.println(search.countGreater(strings, "them"));
        System.out.println();

        System.out.println(search.countBetween(strings, "first", "they"));
        System.out.println(search.countBetween(strings, "guardian", "the"));
        System.out.println();

        System.out.println(search.countMatches(strings, "on", "l"));
        System.out.println(search.countMatches(strings, "the", "em"));
    }

}
