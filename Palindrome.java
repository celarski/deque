/** A class checking whether the word is a palindrome (a word that is the same whether it is forward
 * or backwards or a word of length 0 or 1) using Double Ended Queue */
public class Palindrome {

    /**
     * Produces a deque of characters creating a provided word.
     * @param word A string of letters with no spaces
     * @return Double Ended Queue of Characters from the provided string
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charactersDeque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            charactersDeque.addLast(word.charAt(i));
        }

        return charactersDeque;
    }

    /**
     * Checks whether a given word is a palindrome. Uses recursion
     * @param word A string of letters with no spaces
     * @return true if the word is a palindrome, false otherwise
     */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = this.wordToDeque(word);

        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        } else {
            // remove the first and the last element and compare them, if they are the same continue
            // checking whether the stripped word is a palindrome, if they are different return false
            if (wordDeque.removeFirst() == wordDeque.removeLast()) {
                return isPalindrome(dequeToString(wordDeque));
            } else {
                return false;
            }
        }
    }

    /**
     * Helper method for isPalindrome()s used to convert deque of characters to a string
     * @param wordDeque Double ended queue of characters
     * @return Ordered String consisting of characters from the deque
     */
    private String dequeToString(Deque<Character> wordDeque) {
        String convertedDeque = "";
        while (wordDeque.size() > 0) {
            convertedDeque += wordDeque.removeFirst();
        }
        return convertedDeque;
    }

    /**
     * Method that checks whether the word is an off-palindrome based to character comparision test.
     * Uses recursion
     * @param word String of letters with no spaces
     * @param cc Comparator object, either a standard one with no parameters provided
     *           (i.e. offByOne: 'a' -> 'a') or one with a specified parameter for the difference
     *           between letters (i.e. offByN(5): 'a' -> 'f')
     * @return true if the word is an off-palindrome, false otherwise
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = this.wordToDeque(word);

        if (wordDeque.size() == 0 || wordDeque.size() == 1)
            return true;
        else {
            // remove the first and the last element and compare them, if they are away from each other
            // by correct number of places continue checking whether the stripped word is a palindrome,
            // if they are different return false
            if (cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast()))
                return isPalindrome(dequeToString(wordDeque), cc);
            else
                return false;
        }
    }

}
