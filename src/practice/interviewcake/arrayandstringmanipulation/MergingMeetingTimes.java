package practice.interviewcake.arrayandstringmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/merging-ranges?course=fc1&section=array-and-string-manipulation
 * Progress: Done
 */
public class MergingMeetingTimes {

    public static void main(String[] args) {

    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {
        List<Meeting> answer = new ArrayList<>();
        int[] timeSlot = new int[32];
        for (Meeting meeting : meetings) {
            for (int i = meeting.startTime; i < meeting.endTime; i++) {
                timeSlot[i] = 1;
            }
        }


        Meeting temp = null;
        for (int slot = 0; slot < timeSlot.length; slot++) {
            if (timeSlot[slot] == 1 && temp == null) {
                temp = new Meeting(slot, 0);
            } else if (timeSlot[slot] == 0 && temp != null) {
                temp.setEndTime(slot);
                answer.add(temp);
                temp = null;
            }
        }

        return answer;
    }


    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

}
