public class APList {
    String[] yourList;
    int currindex=0;
    int capacity;
    public APList(int capacity){
        yourList = new String[capacity];
        this.capacity = capacity;
    }
    public APList(){
        capacity = 1;
        yourList = new String[capacity];

    }

    public void add(String newval){
        if(currindex>=0 && currindex<capacity){
            yourList[currindex] = newval;
            currindex++;
        } else if(currindex>=capacity){
            capacity = capacity*2;
            String[] yourListnew = new String[capacity];
            for (int i = 0; i < yourList.length; i++) {
                yourListnew[i] = yourList[i];
            }
            yourList = yourListnew;
            yourList[currindex] = newval;
            currindex++;
        }
    }

    public int size(){
        return currindex;
    }

    public void remove(){
        if(currindex>0&&currindex<capacity){
            yourList[currindex] = null;
            currindex--;
        }
    }
    public String get(int index){
        return yourList[index];
    }

    public void add(int index, String value){
        if(index<=this.size()) {
            if (currindex >= capacity) {
                capacity = capacity * 2;
                String[] yourListnew = new String[capacity];
                for (int i = 0; i < yourList.length; i++) {
                    yourListnew[i] = yourList[i];
                }
                yourList = yourListnew;
            }
            String[] yournewListnew = new String[capacity];
            for (int i = 0; i < index; i++) {
                yournewListnew[i] = yourList[i];
            }
            yournewListnew[index] = value;
            currindex++;
            for (int i = index; i < currindex; i++) {
                yournewListnew[i + 1] = yourList[i];
            }
            yourList = yournewListnew;
        }else{
            System.out.println("ERROR");
        }
    }

    public String remove(int index){
        if(currindex>=0){
            String removedval = yourList[index];
            String[] yournewListnew = new String[capacity];
            yournewListnew[index] = null;
            for (int i = 0; i <index; i++) {
                yournewListnew[i] = yourList[i];
            }

            for (int i = index; i < currindex; i++) {
                yournewListnew[i] = yourList[i+1];
            }
            yourList = yournewListnew;
            currindex--;
            return removedval;
        }else{
            return null;
        }
    }

    public boolean remove(String value){
        int index = 0;
        boolean istrue = false;
        for (int i = 0; i <currindex; i++) {
            if((yourList[i]).equals(value)){
                index = i;
                istrue = true;
                break;
            }
        }
        remove(index);
        return istrue;
    }

    public int removeAll(String value){
        int counter = 0;
        for (int i = 0; i < currindex; i++) {
            if((yourList[i]).equals(value)){
                remove(i);
                i--;
                counter++;
            }
        }return counter;
    }
}
