package com.numericos.proyectofinal.logic;

import java.util.ArrayList;

/**
 * Created by Sara Castrillón on 19/11/2014.
 */
public class Bisection {

    private Funcion fx;
    private double x0;
    private double x1;
    private double tolerance;
    private double iteraciones;
    private ArrayList<Double> ArrayIteraciones = new ArrayList<Double>();
    private ArrayList<Double> Xi = new ArrayList<Double>();
    private ArrayList<Double> Xs = new ArrayList<Double>();
    private ArrayList<Double> Xm = new ArrayList<Double>();
    private ArrayList<Double> Fxm = new ArrayList<Double>();
    private ArrayList<Double> Error = new ArrayList<Double>();

    public Bisection(){
       // fx = new Funcion("e^(3x-12) + x*cos(3x) - (x^2) + 4");
    }

   private double f(double x){
        double y = fx.evaluar(x);
        return y;
    }

        public String bisectionMethod(double xinferior, double xsuperior, double tolerancia, double iteraciones){

        double yi, ys, medio, ymedio, error, xauxiliar;
        int contador;
        Xi.add(xinferior);
        Xs.add(xsuperior);
        ArrayIteraciones.add(iteraciones);
        yi = f(xinferior);
        ys = f(xsuperior);
        if (yi == 0) {
            return xinferior+" es una raíz.";
        }
        else {
            if(ys == 0){
                return xsuperior+" es una raíz.";
            }
            else if ((yi * ys) < 0) {
                medio = (xinferior + xsuperior) / 2;
                Xm.add(medio);
                ymedio = f(medio);
                Fxm.add(ymedio);
                System.out.println(medio + " es el valor medio.");
                contador = 1;
                error = tolerancia + 1;
                Error.add(error);
                while ((error > tolerancia) && (ymedio != 0) && (contador < iteraciones)) {
                    if ((yi * ymedio) < 0) {
                        xsuperior = medio;
                        ys = ymedio;
                    } else {
                        xinferior = medio;
                        yi = ymedio;
                    }
                    xauxiliar = medio;
                    medio = (xinferior + xsuperior) / 2;
                    System.out.println(medio + " es el valor medio.");
                    ymedio = f(medio);
                    //System.out.println(ymedio + " Es la función evaluada.");
                    error = Math.abs(medio - xauxiliar);

                    Xm.add(medio);
                    Xi.add(xinferior);
                    Xs.add(xsuperior);
                    Fxm.add(ymedio);
                    Error.add(error);
                    ArrayIteraciones.add((double)contador);
                    contador = contador + 1;
                }

                if (ymedio == 0) {
                    return medio + " es una raiz.";
                } else {
                    if (error < tolerancia) {
                        return medio + " es aproximadamente una raiz con tolerancia = " + tolerancia + "y error de: " + error;
                        //System.out.println("Error = " + error);
                    } else {
                        return "Fracasó en " + iteraciones + " iteraciones";
                        //System.out.println("Error = " + error);

                    }
                }

            } else {
                return "el intervalo es inadecuado.";
            }

        }
            //return "nada";

    }


    public Funcion getFx() {
        return fx;
    }

    public ArrayList getArray() {
        return ArrayIteraciones;
    }

    public void setFx(String funct) {
        this.fx = new Funcion(funct);
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

    public double getIteraciones() {
        return iteraciones;
    }

    public void setIterations(double iteraciones) {
        this.iteraciones = iteraciones;
    }
}
