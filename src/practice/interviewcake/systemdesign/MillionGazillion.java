package practice.interviewcake.systemdesign;

import java.util.HashMap;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/compress-url-list?course=fc1&section=system-design
 * Progress: Done
 */
public class MillionGazillion {

    static class TrieNode {

        private HashMap<Character, TrieNode> nodeChildren;

        public TrieNode() {
            this.nodeChildren = new HashMap<>();
        }

        public boolean hasChildNode(char character) {
            return this.nodeChildren.containsKey(character);
        }

        public void makeChildNode(char character) {
            this.nodeChildren.put(character, new TrieNode());
        }

        public TrieNode getChildNode(char character) {
            return this.nodeChildren.get(character);
        }
    }

    static class Trie {

        private TrieNode rootNode;
        private static final char END_OF_WORD_MARKER = '\0';

        public Trie() {
            this.rootNode = new TrieNode();
        }

        public boolean addWord(String word) {

            TrieNode currentNode = this.rootNode;
            boolean isNewWord = false;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                if (!currentNode.hasChildNode(character)) {
                    isNewWord = true;
                    currentNode.makeChildNode(character);
                }

                currentNode = currentNode.getChildNode(character);
            }

            if (!currentNode.hasChildNode(END_OF_WORD_MARKER)) {
                isNewWord = true;
                currentNode.makeChildNode(END_OF_WORD_MARKER);
            }

            return isNewWord;
        }

    }


}
