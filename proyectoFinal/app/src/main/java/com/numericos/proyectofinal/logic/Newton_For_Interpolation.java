package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 25/11/2014.
 */
public class Newton_For_Interpolation {
    public String res;
    public double[][] tabla;

    public void addRes(double[][] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                res+= A[i][j]+"\t";
            }
            res += "\n";
        }
    }

    public String Newton (double[] F, double[] X, double val){
        res = "";
        int n = X.length;
        tabla = new double[n][n];
        for (int j=0;j<n;j++){
            tabla[j][0]=F[j];
        }
        int q;
        for (int k=0; k<n-1;k++){
            q=0;
            for(int i=k+1;i<n;i++){
                tabla[i][k+1]=(tabla[i][k]-tabla[i-1][k])/(X[i]-X[q]);
                q++;
            }
        }

        addRes(tabla);
        double p=0;
        double aux;
        res+="\nInterpolating Polynomial:\n";
        res+="p(x) = ";
        for(int s=0;s<n;s++){
            aux=1;

            if(tabla[s][s]>=0 && s!=0){
                res+= "+";
            }
            res+= tabla[s][s];

            for(int c=0;c<s;c++){
                res+= "(x-"+X[c]+")";
                aux=aux*(val-X[c]);
            }
            res+=" ";
            p = p + tabla[s][s]*aux;
        }
        res+="\n\nSearched Value\n";
        res+= "p("+val+") = "+p;
        return res;
    }

    public String getRes()
    {return res;}
}
