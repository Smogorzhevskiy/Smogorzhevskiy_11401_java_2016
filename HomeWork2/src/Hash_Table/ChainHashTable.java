package Hash_Table;
import java.util.ArrayList;

public class ChainHashTable<T1, T2> extends HashMaker<T1> implements HashTable<T1, T2> {
    private ArrayList<Pair<T1, T2>>[] table;

    public ChainHashTable() {
        table = new ArrayList[100000];
    }

    public boolean push(T1 x, T2 y) {
        int h = returnHash(x);
        int n;
        try{
            n = table[h].size();
        }catch (NullPointerException e){
            table[h] = new ArrayList<Pair<T1, T2>>();
            n = 0;
        }
        for (int i = 0; i < n; i++) {
            if (table[h].get(i).getKey() == x) {
                table[h].set(i, new Pair<T1, T2>(x, y));
                return false;
            }
        }
        table[h].add(new Pair<T1, T2>(x, y));
        return true;
    }

    public boolean delete(T1 x) {
        int h = returnHash(x);
        int n;
        try {
            n = table[h].size();
        } catch (NullPointerException e) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (table[h].get(i).getKey().equals(x)) {
                table[h].remove(i);
                return true;
            }
        }
        return false;
    }

    public T2 get(T1 x) {
        int h = returnHash(x);
        int n;
        try {
            n = table[h].size();
        } catch (NullPointerException e){
            return  null;
        }
        for (int i = 0; i < n; i++) {
            if (table[h].get(i).getKey().equals(x)) {
                return table[h].get(i).getValue();
            }
        }
        return null;
    }
}