package com.xaoyv.magicbox.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class ByteArrayUtil {
    public static byte[] string2bytes(String s) {
        int length = s.length();
        byte[] bytes = new byte[length / 2];
        int position = 0;
        String temp;
        while (position < length) {
            char a = s.charAt(position);
            position++;
            char b = s.charAt(position);
            position++;

            temp = "0x" + a + b;
            int decimal = Integer.decode(temp);
            bytes[position / 2 - 1] = (byte) (decimal);
        }
        return bytes;
    }

    public static float[] byteArrayToFloatArray(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        FloatBuffer fb = buffer.asFloatBuffer();
        float[] floatArray = new float[fb.limit()];
        fb.get(floatArray);
        return floatArray;
    }


    /**
     * 网络字节序转bitmap
     */
    public static int[] byte_arr2int_arr(byte[] byteArr) {
        if (byteArr.length % 4 != 0) {
            return null;
        }
        int[] intarr = new int[byteArr.length / 4];

        int i1, i2, i3, i4;
        for (int j = 0, k = 0; j < intarr.length; j++, k += 4)//j循环int		k循环byte数组
        {
            i1 = byteArr[k];
            i2 = byteArr[k + 1];
            i3 = byteArr[k + 2];
            i4 = byteArr[k + 3];

            //使用位运算
            intarr[j] = ((i4 & 0xFF) << 24) | ((i1 & 0xFF) << 16) | ((i2 & 0xFF) << 8) | (i3 & 0xFF);

        }
        return intarr;
    }
}
