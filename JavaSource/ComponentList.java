import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by developer on 4/23/2015.
 */
public class ComponentList<E>{

    private ArrayList<E> arrayList;


    public ComponentList(){
        this.arrayList = new ArrayList<E>();
    }

    public boolean isUser() {
        if (arrayList.equals(User.class)) {
            return true;
        }
        return false;
    }

    public boolean isGame(){
        if (arrayList.equals(Game.class)) {
            return true;
        }
        return false;
    }

    public void add(E e){
        this.arrayList.add(e);
    }

    public String printLength(){
        String out = Integer.toString(getLength()) + "\n";
        return out;
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

    public void removeItem(E inItem){
        this.arrayList.remove(inItem);
    }

    public ArrayList<E> getList(){
        return this.arrayList;
    }

    public String printInfo() {
        String output = "";
        User u;
        Game g;
        if (arrayList.isEmpty()) {
            return "No objects in list";
        }
        else if (arrayList.get(0).getClass().equals(User.class)) {
            for (int i = 0; i < getLength(); i++) {
                u = User.class.cast(arrayList.get(i));
                output += u.printUserInfo();
            }
        }
        else if (arrayList.get(0).getClass().equals(OwnedGame.class) || arrayList.get(0).getClass().equals(Game.class)) {
            for (int i = 0; i < getLength(); i++) {
                g = Game.class.cast(arrayList.get(i));
                output += g.printGameInfo();
            }
        }
        else {
                System.exit(1);
        }

        return output;
    }

    public boolean doesItemExistById(int inId){
        int searchId = inId;
        boolean isFound = false;
        User u;
        Game g;
        Class<? extends ArrayList> objType = arrayList.getClass();
        if(arrayList.isEmpty()){
            return isFound;
        }
        else if(objType.equals(User.class)) {
            for (int i = 0; i < getLength(); i++) {
                u = User.class.cast(arrayList.get(i));
                if (searchId == u.getUserId()) {
                    isFound = true;
                }
                else {
                    continue;
                }
            }
        }
        else if(objType.equals(Game.class)){
            for(int i = 0; i < getLength(); i++){
                g = Game.class.cast(arrayList.get(i));
                if (searchId == g.getGameId()) {
                    isFound = true;
                }
                else {
                    continue;
                }
            }
        }
        return isFound;
    }

    public E returnItemById(int inId) {
        User u = new User();
        Game g = new Game();
        Class<? extends ArrayList> objType = arrayList.getClass();
        if (arrayList.isEmpty()) {
            return null;
        } else if (objType.equals(u)) {
            for (int i = 0; i < getLength(); i++) {
                u = User.class.cast(arrayList.get(i));
                if (inId == u.getUserId()) {
                    return (E)u;
                } else {
                    continue;
                }
            }
        } else if (objType.equals(g)) {
            for (int i = 0; i < getLength(); i++) {
                g = Game.class.cast(arrayList.get(i));
                if (inId == g.getGameId()) {
                    return (E)g;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public boolean doesItemExistByName(String inName){
        String searchName = inName;
        boolean isFound = false;
        User u = new User();
        Game g = new Game();
        Class<? extends ArrayList> objType = arrayList.getClass();
        if(arrayList.isEmpty()){
            return isFound;
        }
        else if(objType.equals(u)) {
            for (int i = 0; i < getLength(); i++) {
                u = User.class.cast(arrayList.get(i));
                if (searchName.equalsIgnoreCase(u.getfName())) {
                    isFound = true;
                }
                else {
                    continue;
                }
            }
        }
        else if(objType.equals(g)){
            for(int i = 0; i < getLength(); i++){
                g = Game.class.cast(arrayList.get(i));
                if (searchName.equalsIgnoreCase(g.getName())) {
                    isFound = true;
                }
                else {
                    continue;
                }
            }
        }
        return isFound;
    }

    public E returnItemByName(String inName){
        User u = new User();
        Game g = new Game();
        Class<? extends ArrayList> objType = arrayList.getClass();
        if (arrayList.isEmpty()) {
            return null;
        } else if (objType.equals(u)) {
            for (int i = 0; i < getLength(); i++) {
                u = User.class.cast(arrayList.get(i));
                if (inName.equalsIgnoreCase(u.getfName())) {
                    return (E)u;
                } else {
                    continue;
                }
            }
        } else if (objType.equals(g)) {
            for (int i = 0; i < getLength(); i++) {
                g = Game.class.cast(arrayList.get(i));
                if (inName.equalsIgnoreCase(g.getName())) {
                    return (E)g;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public String printCSV(){
        String output = "";
        User u;
        OwnedGame g;
        if(arrayList.isEmpty()){
            return null;
        }
        else {
            if (arrayList.get(0).getClass().equals(User.class)) {
                for (int i = 0; i < getLength(); i++) {
                    u = User.class.cast(arrayList.get(i));
                    output += u.printCSV();
                }
            } else if (arrayList.get(0).getClass().equals(OwnedGame.class)) {
                for (int i = 0; i < getLength(); i++) {
                    g = OwnedGame.class.cast(arrayList.get(i));
                    output += g.printCSV();
                }
            }
        }
        return output;
    }

    public String appendCSV(int inNumber){
        int start = inNumber;
        String output = "";
        User u;
        OwnedGame g;
        if(arrayList.isEmpty()){
            return null;
        }
        else if(arrayList.get(0).getClass().equals(User.class)) {
            for (; start < getLength(); start++) {
                u = User.class.cast(arrayList.get(start));
                output += u.printCSV();
            }
        }
        else if(arrayList.get(0).getClass().equals(OwnedGame.class)) {
            for (; start < getLength(); start++) {
                g = OwnedGame.class.cast(arrayList.get(start));
                output += g.printCSV();
            }
        }
        return output;
    }

}