package Practice;

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/summing-the-n-series/problem
 * Progress: Done
 */

public class SummingNSeries {
    public static void main(String[] args) {
        System.out.println(summingSeries(5351871996120528L) == 578351320);
        System.out.println(summingSeries(2248813659738258L) == 404664464);
        System.out.println(summingSeries(2494359640703601L) == 20752136);
        System.out.println(summingSeries(6044763399160734L) == 999516029);
        System.out.println(summingSeries(3271269997212342L) == 743537718);
        System.out.println(summingSeries(4276346434761561L) == 323730244);
        System.out.println(summingSeries(2372239019637533L) == 174995256);
        System.out.println(summingSeries(5624204919070546L) == 593331567);
        System.out.println(summingSeries(9493965694520825L) == 136582381);
        System.out.println(summingSeries(8629828692375133L) == 305527433);
        System.out.println(summingSeries(2L) == 4);
    }

    public static int summingSeries(long n) {
        long m = 1000000007L;
        long answer = (n % m) * (n % m);
        return (int) (answer % m);
    }
}
