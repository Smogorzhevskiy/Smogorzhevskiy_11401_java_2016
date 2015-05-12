package Hash_Table;
public class HashMaker<T> {
    public int returnHash(T x) {
        return x.hashCode();
    }
}