package graphics;

/**
 * Has various utilities for graphics
 * @author zkieda
 */
public final class Util {
    private Util(){}
    
    private static final float[] YUV = {
        0.299f,     0.587f,     0.144f, 
       -0.14713f,  -0.2886f,    0.436f,
        0.615f,    -0.51499f,  -0.10001f
    };
    
    public static float clamp255(float in){
        return in<0 ? 0 :
                    in>255 ? 255 : in;
    }
    
    /**
     * if dst is null, we allocate a new array. The input and output floar 
     * arrays will be in the range 0 .. 255.
     * 
     * @param src the input array in RGB color space to be converted to YUV
     * @param dst the destination array that stores the YUV representation of
     * {@code in}. {@code dst}, if non-null, should have length greater than or 
     * equal to 3. 
     * 
     * @return the YUV representation of {@code}. If {@code dst} is null, 
     * we allocate a new array and return it. Otherwise, we return {@code dst}.
     * 
     * We allow the {@code src} to be equal to the {@code dst}
     */
    public static float[] cRGBtoYUV(float[] src, float[] dst){
        assert src!=null;
        
        if(dst == null){
            dst = new float[3];
        }
        
        assert dst.length >= 3 &&  src.length >= 3;
        assert src[0]>=0 && src[1]>=0 && src[2]>=0;
        
        float i0 = src[0], i1 = src[1], i2 = src[2];
        
        dst[0] = clamp255(YUV[0]*i0 + YUV[1]*i1 + YUV[2]*i2);
        dst[1] = clamp255(YUV[3]*i0 + YUV[4]*i1 + YUV[5]*i2);
        dst[2] = clamp255(YUV[6]*i0 + YUV[7]*i1 + YUV[8]*i2);
        
        return dst;
    }
    /**
     * A basic algorithm to determine the difference in colors. Done in YUV 
     * space for additional accuracy.
     * 
     * @param yuv1
     * @param yuv2
     * @return 
     */
    public static float deviationYUV(float[] yuv1, float[] yuv2){
        
        float d0 = yuv1[0] - yuv2[0],
              d1 = yuv1[1] - yuv2[1],
              d2 = yuv1[2] - yuv2[2];
        
        return (float)StrictMath.sqrt
               (d0*d0 + d1*d1 + d2*d2);
        
    }
    
    public static float deviationRGB(float[] rgb1, float[] rgb2){
        //convert to YUV for more accuracy
        return deviationYUV(cRGBtoYUV(rgb1, null), cRGBtoYUV(rgb2, null));
    }
    
    /**
     * Converts a byte into the 0 .. 255 floating point representation of 
     * {@code b}
     * 
     * @param b
     * @return 
     */
    public static float byteToFloat(byte b){
        return (float)(b&0xFF);
    }
}
