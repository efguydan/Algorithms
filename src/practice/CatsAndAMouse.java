package practice;

public class CatsAndAMouse {

    static String catAndMouse(int x, int y, int z) {
        int a = Math.abs(x-z);
        int b = Math.abs(y-z);
        return a < b ? "Cat A" : b < a ? "Cat B" : "Mouse C";
    }

}
