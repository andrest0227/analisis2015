package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 25/11/2014.
 */
public class Lagrange {

    public Lagrange(){}
    public String res;


    public String Lagrange (double[] F, double[] X, double val){
        double p=0;
        int n = X.length;
        double den;
        double num;
        res="";
        String aux = "";
        res = "\nInterpolating Polynomial:\n";
        res += "p(x) = ";
        for(int i=0;i<n;i++){
            den=1;
            num=1;
            aux = "";
            for(int j=0;j<n;j++){
                if(j!=i){
                    den = (X[i]-X[j])*den;
                    num=(val-X[j])*num;
                    aux+= "(x ";
                    if(X[j]<0){
                        aux+= "+ "+Math.abs(X[j])+")";
                    }else{
                        aux+= "- "+X[j]+")";
                    }
                }
            }
            if(F[i]/den >= 0 && i!=0){
                res+=" +";
            }
            res+=" "+(F[i]/den)+aux;
            p=p+((num/den)*F[i]);
        }
        res += "\np("+val+") = ";
        res+= p;
        return res;
    }
public String getRes()
{
    return res;
}
}
