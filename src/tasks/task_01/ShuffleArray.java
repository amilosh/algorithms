package tasks.task_01;

import java.util.Random;

public class ShuffleArray {
    public static int[] shuffle(int[] values) {
        int size = values.length - 1;

        int[] target = new int[size + 1];

        Random random = new Random();
        int j = 0;
        for (int i = size; i >= 0; i--) {
            int r = random.nextInt(i + 1);
            int val = values[r];
            target[j++] = val;

            change(values, r, i);
        }

        return target;
    }

    public static int[] shuffle2(int[] values) {
        Random random = new Random();

        for (int i = 0; i <= values.length - 1; i++) {
            int r = random.nextInt(values.length - 1);
            change(values, i, r);
        }

        return values;
    }

    private static void change(int[] values, int left, int last) {
        int temp = values[last];
        values[last] = values[left];
        values[left] = temp;
    }
}
