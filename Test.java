public class Test {
    public static void main(String[] args) {
        int arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        int l = 0 , r = arr.length - 1;
        while (l < r) {
            while (arr[l] > 0) {
                l++;
            }
            while (arr[r] < 0){
                r--;
            }
            swap(arr,l,r);
            l++;
            r--;


        }
        print(arr);
        System.out.println();
        System.out.println("Time " + (long)Math.floor(Math.random()*5));
    }
    public static void swap(int arr[],int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int i : arr)
        System.out.print(i +" ");
    }
}
