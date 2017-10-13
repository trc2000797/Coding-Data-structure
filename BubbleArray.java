public class BubbleArray {

    public void bubbleSort(int[] arr) {
        int temp = 0;
        int count = 0;
        while (count < arr.length - 1) {
            for (int i = 0; i < arr.length - 1 - count; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            count++;
        }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    public static void main(String[] args) {
        int[] bubbleArray = {9,1,5,8,3,6,7,0,-2,11};
        BubbleArray test = new BubbleArray();
        test.bubbleSort(bubbleArray);
    }
}
