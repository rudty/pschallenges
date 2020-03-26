    static void printArray(StringBuilder output, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            output.append(arr[i]);
            output.append(' ');
        }
        output.append("\n");
    }
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < arr.length; ++i) {
            int elem = arr[i];
            int j;
            for (j = i - 1; j >= 0 && elem < arr[j]; --j) {
                arr[j + 1] = arr[j];
                printArray(output, arr);
            }
            arr[j + 1] = elem;
        }
        printArray(output, arr);
        System.out.print(output.toString());
    }