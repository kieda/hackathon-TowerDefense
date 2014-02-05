package util;

/**
 * An implementation of ArrayStorage that checks that all of the elements are
 * non-null.
 * 
 * @author zkieda
 */
public final class NonNullStorage<S> extends ArrayStorage<S> {
    
    /**
     * verifies that all of the inputs are non-null, and returns the same array, 
     * unaltered if successful. If unsuccessful, either the input array is 
     * {@code null}, or an element of {@code d} is {@code null}.
     * 
     * @param d input array, where each Object of d is of type S
     * @return unaltered input array, given as an Object. 
     */
    private static Object verify(Object[] d){
        err:{
            //throw an error if the array itself is null
            if(d==null) break err;
            for (int i = 0; i < d.length; i++) {
                //each element must be non-null
                if(d[i]==null)
                    break err;

            }
        return d;
        }
        //todo erroroutput
        throw new NullPointerException();
    }
    public NonNullStorage(S... data){
        super((S[])verify(data));
    }
}
