package practice.CtCI.technicalquestions;

public class four_cube_sum {
    public static void main(String[] args) {
        betterFourCubeSum(1000);
    }

    public static void fourCubeSum(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    for (int l = 1; l < n; l++) {
                        if (cubeof(i) + cubeof(j) == cubeof(k) + cubeof(l)) {
                            System.out.println(String.format("%d %d %d %d", i, j, k, l));
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void betterFourCubeSum(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    int l = ((Double) Math.cbrt(cubeof(i) + cubeof(j) - cubeof(k))).intValue();
                    if (cubeof(i) + cubeof(j) == cubeof(k) + cubeof(l)) {
                        System.out.println(String.format("%d %d %d %d", i, j, k, l));
                    }
                }
            }
        }
    }

    public static int cubeof(int num) {
        return ((Double) Math.pow(num, 3)).intValue();
    }
}
