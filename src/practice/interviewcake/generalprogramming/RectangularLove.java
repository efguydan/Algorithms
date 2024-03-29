package practice.interviewcake.generalprogramming;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/rectangular-love?course=fc1&section=general-programming
 * Progress: Done
 */
public class RectangularLove {

    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return String.format("(left: %d, bottom: %d, width: %d, height: %d)",
                    leftX, bottomY, width, height);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Rectangle)) {
                return false;
            }
            final Rectangle r = (Rectangle) o;
            return leftX == r.leftX && bottomY == r.bottomY
                    && width == r.width && height == r.height;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + leftX;
            result = result * 31 + bottomY;
            result = result * 31 + width;
            result = result * 31 + height;
            return result;
        }
    }

    private static class RangeOverlap {

        private int startPoint;
        private int length;

        public RangeOverlap(int startPoint, int length) {
            this.startPoint = startPoint;
            this.length = length;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public int getLength() {
            return length;
        }
    }

    private static RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2) {

        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        if (highestStartPoint >= lowestEndPoint) {
            return new RangeOverlap(0, 0);
        }

        int overlapLength = lowestEndPoint - highestStartPoint;

        return new RangeOverlap(highestStartPoint, overlapLength);
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

        RangeOverlap xOverlap = findRangeOverlap(rect1.getLeftX(), rect1.getWidth(),
                rect2.getLeftX(), rect2.getWidth());
        RangeOverlap yOverlap = findRangeOverlap(rect1.getBottomY(), rect1.getHeight(),
                rect2.getBottomY(), rect2.getHeight());

        if (xOverlap.getLength() == 0 || yOverlap.getLength() == 0) {
            return new Rectangle();
        }

        return new Rectangle(
                xOverlap.getStartPoint(),
                yOverlap.getStartPoint(),
                xOverlap.getLength(),
                yOverlap.getLength()
        );
    }

}
