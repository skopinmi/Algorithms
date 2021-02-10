package lesson3.homework;

import lesson3.stack.IStack;
import lesson3.stack.StackImpl;

import javax.xml.stream.events.Characters;


public class Overturner {

    public static void main(String[] args) {
        String string = """
                        public static void main(String[] args) {
                            testStack();
                        }
                """;
        invertPrint(string);
    }

    public static void invertPrint (String string) {
        IStack<Character> iStack = new StackImpl<>(string.length());
        char [] chars = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            iStack.push(chars[i]);
        }
        while (!iStack.isEmpty()) {
            System.out.print(iStack.pop());
        }
    }
}
