package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class Simpson3_8 {
    private Funcion fx;
    private String res;
    private String mensaje;
    private double x0;
    private double x1;

    private double f(double x){
        x = fx.evaluar(x);
        return x;
    }

    public String getRes(){
        return res;
    }

    public String getMensaje(){
        return mensaje;
    }
    public Simpson3_8() {
        // this.fx = new Funcion(funcion);
        //mensaje= "";
    }

    public String simpson3_8Method(double x0, double xn){
        double h= (xn - x0)/3;
        double integ = f(x0);
        integ += 3*f(x0+h);
        integ += 3*f(x0 + 2*h);
        integ += f(xn);
        integ = (3*h/8)*integ;
        res+="the area under the curve "+fx.getFuncion()+" interval between ("+x0+","+xn+") is: "+integ+" + E";
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
}
