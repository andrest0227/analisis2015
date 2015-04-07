package com.numericos.proyectofinal.logic;

import android.app.Activity;

/**
 * Created by Sara Castrillón on 25/11/2014.
 */
public class Neville {
    public String res;

    public String neville  ( int n, double[] x, double[] y, double t )

/*
     Geted from: http://www.torkian.info/Site/Research/Entries/2008/2/29_Nevilles_algorithm_Java_Code_files/N.java

     INPUTS:
          n		number of interpolating points
          x		array containing interpolating points [x]
          y		array containing function values to F[x]
			be interpolated;  y[i] is the function
			value corresponding to x[i]
          t		value for evaluation

*/

    {
        int i, j;
        double[] f=new double[n] ;
        double total;
        for ( j = 1; j < n; j++ )
            for ( i = n-1; i >= j; i-- ) {
                y[i] = ( (t-x[i-j])*y[i] - (t-x[i])*y[i-1] ) / ( x[i] - x[i-j] );
            }

        total = y[n-1];
        res= " Total = " +total ;
        return res;
    }
    public String getRes()
    {
        return res;
    }
}

