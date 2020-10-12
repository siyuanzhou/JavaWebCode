public class TypeCast {
    public static void main(String[] args) {
        int i = 1;
        byte b = 2;
        b += 1;
        System.out.println(b);
        System.out.println(b);
        int k = (int) -1.5;
        System.out.println(k);
        short s = 32767;

        s = (short) (s + 10);
        System.out.println(s);

        System.out.println((char) ('c' + 1));
        byte b1 = 1;
        byte b2 = 2;
        int sum = 0;
        for (int j = 1; j <= 100; j++) {
            if (j % 2 == 0) {
                sum += j;
            }
        }
        System.out.println(sum);
        sum = 0;
        int j = 1;
        while (j <= 100) {
            if (j % 2 == 0) {
                sum += j;
            }
            j++;
        }
        System.out.println(sum);
        sum = 0;
        j = 1;
        do {
            if (j % 2 == 0) {
                sum += j;
            }
            j++;
        } while (j <= 100);
        System.out.println(sum);
        int arr[] = {1, 4, 6, 7, 8, 9};
        int max = Integer.MAX_VALUE + 1000;
        max = Integer.MIN_VALUE;
        for (int m = 0; m < arr.length; m++) {
            if (max <= arr[m]) {
                max = arr[m];
            }
        }
        System.out.println(max);
        for (int i1 = 0, i2 = arr.length - 1; i1 < i2; i1++, i2--) {
            int tmp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = tmp;
        }
        for (int l = 0; l < arr.length; l++) {
            System.out.println(arr[l]);
        }
        int a1 = 1, a2 = 2;
        change(a1, a2);
        System.out.println(a1);
        System.out.println(a2);
        change(arr);
        System.out.println();
        for (int l = 0; l < arr.length; l++) {
            System.out.println(arr[l]);
        }


    }

    public static void change(int a, int b) {
        a = a + b;
        b = a + b;
    }

    public static void change(int[] arr) {
        arr[0] = 100;
    }


}
