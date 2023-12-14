import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>( Arrays.asList(5, 3, 2, 6, 3) );
        System.out.println(test);
        leftRotate(test);
        System.out.println(test);
    }

    public static void leftRotate(ArrayList<Integer> list) {
        int startval = list.get(0);
        list.remove(0);
        list.add(startval);
    }

    public static ArrayList<Integer> makeRandomList(int n, int max){
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int randnum = (int)(Math.random()*max);
            randomList.add(randnum);
        } return randomList;
    }

    public static ArrayList<Double> withoutmins(ArrayList<Double> list, double min){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)<min){
                list.remove(i);
                i--;
            }
        }return list;
    }

    public static void swap(ArrayList<Integer> list, int a, int b) {
        int val1 = list.get(a);
        int val2 = list.get(b);
        list.set(a, val2);
        list.set(b, val1);
    }


}