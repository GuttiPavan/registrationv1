package com.api.debug;

public class D {

    public static void main(String[] args) {

        int[] in = {1,2,2,3,4,4};
        int[] rs = new int[in.length];

        int k = 0;

        for (int i = 0; i < in.length - 1; i++) {

                if (in[i] != in[i+1]){
                    rs[k] = in[i];
                    k++;
                }

        }
        for (int i = 0; i < rs.length; i++) {
            System.out.print(rs[i]);
        }


    }
}
