package practice.codilitylessons.timecomplexity;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * Progress: Done
 */
public class FrogJmp {

    public int solution(int x, int y, int d) {
        int diff = y - x;
        int answer = diff / d;
        if (diff % d > 0) answer++;
        return answer;
    }

}
