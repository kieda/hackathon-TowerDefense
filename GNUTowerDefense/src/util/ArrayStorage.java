package util;

/**
 * 
 * @author zkieda
 */
public class ArrayStorage<S> implements Storage<S>{
    private final Object[] data;

    public ArrayStorage(S... data) {
        this.data = new Object[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }
    @Override public final S get(int i) {
        return (S)data[i];
    }
    public final int len(){return data.length;}
}
