import java.util.ArrayList;

/**
 * Created by developer on 4/23/2015.
 */
public class ComponentList<T>{

    private ArrayList arrayList;


    public ComponentList(){
        this.arrayList = new ArrayList<T>();
    }

    public void add(T t){
        this.arrayList.add(t);
    }

    public String printLength(){
        return Integer.toString(getLength());
    }

    public int getLength() {
        int length = 0;
        if (arrayList.isEmpty()) {
            return length;
        } else {
            for (Object o : arrayList) {
                length++;
            }
        }
        return length;
    }

}
