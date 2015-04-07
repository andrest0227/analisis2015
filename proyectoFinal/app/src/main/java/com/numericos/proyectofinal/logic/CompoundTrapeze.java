package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class CompoundTrapeze {
    private Funcion fx;
    private String res;
    private String mensaje;
    private double x0;
    private double x1;
    private double intervals;

    private double f(double x) {
        x = fx.evaluar(x);
        return x;
    }

    public String getRes() {
        return res;
    }

    public String getMensaje() {
        return mensaje;
    }

    public CompoundTrapeze() {
        // this.fx = new Funcion(funcion);
        //mensaje= "";
    }

    public String compoundTrapezeMethod(double x0, double xn, double n) {
        double h = (xn - x0) / n;
        double integ = f(x0);
        double suma = 0;
        res = "";
        double aux;
        for (int i = 1; i < n; i++) {
            aux = f(x0 + i * h);
            suma = suma + aux;
        }
        integ += 2 * suma;
        integ += f(xn);
        integ = (h / 2) * integ;
        res+="the are under the curve "+fx.getFuncion()+" interval between ("+x0+","+xn+") is: "+integ+" + E";
        return res;
    }

    public Funcion getFx() {
        return fx;
    }

    public void setFx(String funct) {
        this.fx = new Funcion(funct);
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
        return intervals;
    }

    public void setIntervals(double iteraciones) {
        this.intervals= iteraciones;
    }
}
