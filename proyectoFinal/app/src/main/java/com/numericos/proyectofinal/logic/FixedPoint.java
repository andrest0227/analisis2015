package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 20/11/2014.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.IncrementalSearch;
import com.numericos.proyectofinal.logic.Bisection;
import com.numericos.proyectofinal.views.util.CustomKeyboard;

public class FixedPoint {
    private double[][] tabla;
    private String mensaje;
    private Funcion fx;
    private Funcion gx;
    private Funcion dfx;
    private Funcion ddfx;
    private double x0;
    private double x1;
    private double tolerance;
    private double iterations;




    public void setdfx(String dfx){
        this.dfx = new Funcion(dfx);
    }

    public void setddfx(String ddfx){
        this.ddfx = new Funcion(ddfx);
    }

    public void setgx(String gx){
        this.gx = new Funcion(gx);
    }

    public double[][] getTabla(){
        return tabla;
    }

    public String getMensaje(){
        return mensaje;
    }

    private double g(double x){
        x = gx.evaluar(x);
        return x;
    }

    private double f(double x){
        x = fx.evaluar(x);
        return x;
    }

    private double df(double x){
        x = dfx.evaluar(x);
        return x;
    }

    private double ddf(double x){
        x = ddfx.evaluar(x);
        return x;
    }



    private void agregarDatos(double[] dato){
        double[][] aux = new double[tabla.length][tabla[0].length];
        for(int i=0;i<tabla.length;i++){
            for(int j=0;j<tabla[0].length;j++){
                aux[i][j] = tabla[i][j];
            }
        }

        tabla = new double[tabla.length+1][tabla[0].length];
        for(int i=0;i<aux.length;i++){
            for(int j=0;j<aux[0].length;j++){
                tabla[i][j] = aux[i][j];
            }
        }
        for(int i=0;i<dato.length;i++){
            tabla[aux.length][i] = dato[i];
        }
    }
    public FixedPoint() {
        // TODO Auto-generated constructor stub
       //this.fx = new Funcion(funtion1);
       //this.gx = new Funcion(funtion2);


    }



    public String fixedPointMethod(double Xm, double t, double i){
        double aux;
        double E = t+1;
        int cont=1;
        double Ym = f(Xm);
        tabla = new double[1][4];
        tabla[0][0] = cont;
        tabla[0][1] = Xm;
        tabla[0][2] = Ym;
        double[] Taux = new double[4];
        while(Ym!=0 && E>t && cont<i){
            aux = Xm;
            Xm = g(Xm);
            Ym = f(Xm);
            E = Math.abs((Xm - aux)/Xm);
            cont++;
            Taux[0] = cont;
            Taux[1] = Xm;
            Taux[2] = Ym;
            Taux[3] = E;
            agregarDatos(Taux);
        }
        if(Ym == 0){
            mensaje = "Hay una raiz en x = "+Xm;
            return mensaje;
        }else{
            if(E<=t){
                mensaje = "Hay una raiz en x = "+Xm+" con un Error de "+E;
                return mensaje;
            }else{
                mensaje = "Fracaso: no se halló raiz en "+i+" iteraciones";
                return mensaje;

            }
        }
    }

    public Funcion getFx() {
        return fx;
    }

    public void setFx(String funct) {
        this.fx = new Funcion(funct);
    }

    public Funcion getDFx() {
        return dfx;
    }

    public void setDFx(String funct) {
        this.dfx = new Funcion(funct);
    }

    public Funcion getDdFx() {
        return ddfx;
    }

    public void setDdfx(String funct) {
        this.ddfx = new Funcion(funct);
    }

    public Funcion getGx() {
        return gx;
    }

    public void setGx(String funct) {
        this.gx = new Funcion(funct);
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getIterations() {
        return iterations;
    }

    public void setIterations(double iteraciones) {
        this.iterations = iteraciones;
    }

}
