package practice;

import okio.ByteString;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

class MiscClass {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        String usernameAndPassword = "efguydan:DANass1.";
        String encoded = ByteString.encodeString(usernameAndPassword, ISO_8859_1).base64();
        System.out.println("Basic " + encoded);

        long finish = System.currentTimeMillis();

        System.out.println(finish - start);
    }
}