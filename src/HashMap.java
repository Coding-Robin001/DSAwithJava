import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {

    ArrayList<LinkedList<KeyValuePair>> list;
    private int size = 0;
    private float loadFactor = 0.5f;

    HashMap(){
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(String key, String  value){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<KeyValuePair> keysArray = list.get(hash);

        for (KeyValuePair singleKey: keysArray){
            if (singleKey.key.equals(key)){
                singleKey.value = value;
                return;
            }
        }

        if ((float)(size) / list.size() > loadFactor){
            rehash();
        }
        keysArray.add(new KeyValuePair(key, value));
        size++;
    }

    private void rehash() {
        System.out.println("rehashing triggered!");

        ArrayList<LinkedList<KeyValuePair>> old = list;
        list = new ArrayList<>();
        size = 0;
        for (int i = 0; i < old.size() * 2; i++){
            list.add(new LinkedList<>());
        }

        for (LinkedList<KeyValuePair> entries: old){
            for (KeyValuePair singleKey: entries){
                put(singleKey.key, singleKey.value);
            }
        }
    }


    public String get(String key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<KeyValuePair> keysArray = list.get(hash);
        for (KeyValuePair singleKey: keysArray){
            if (singleKey.key.equals(key)){
                return singleKey.value;
            }
        }
        return null;
    }


    public void remove(String key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<KeyValuePair> keysArray = list.get(hash);

        KeyValuePair target = null;
        for (KeyValuePair singleKey: keysArray){
            if (singleKey.key.equals(key)){
                target = singleKey;
                break;
            }
        }

        keysArray.remove(target);
        size--;
    }

    public boolean containsKey(String key){
        return get(key) != null;
    }


@Override
public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (LinkedList<KeyValuePair> keysArray: list){
            for (KeyValuePair singleKey: keysArray){
                builder.append(singleKey.key);
                builder.append(" = ");
                builder.append(singleKey.value);
                builder.append(" , ");
            }
        }
        builder.append("}");
        return builder.toString();
}




    private class KeyValuePair {
        String key;
        String value;


        private KeyValuePair (String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}



