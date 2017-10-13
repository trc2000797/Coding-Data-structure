public class BouncyBubbleSort {


    public void Sort(int arr[]) {
        int temp = 0;
        int count = 0;
        for ( int i = arr.length - 2; i >= 0; i--) {
            if (count % 2 == 0) {
                for (int j = 0; j <= i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            } else {
                for (int j = i; j >= 0; j--) {
                    if (arr[j + 1] < arr[j]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,1,5,8,3,6,7,0,-2,11};
        BouncyBubbleSort test = new BouncyBubbleSort();
        test.Sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
