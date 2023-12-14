public class Main {
    public static void main(String[] args) {
        APList list = new APList();     // ← max capacity 4
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(( "getsize" + list.size() ));		     // ← displays 3
        list.remove();			     // ← removes last element

        System.out.println( "get(1)="+ list.get(1) );		     // ← returns “b”
        list.add("c");
        list.add("d");
        list.add("e");			     // ← doesn’t do anything

        System.out.println(("listsize="+ list.size() ));		     // ← displays 4

        list.add(5,"dea");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list("+i+")"+list.get(i));
        }

    }
}