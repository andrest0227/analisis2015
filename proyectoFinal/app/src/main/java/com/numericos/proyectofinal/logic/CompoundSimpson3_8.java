package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class CompoundSimpson3_8 {
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

    public CompoundSimpson3_8() {
        // this.fx = new Funcion(funcion);
        //mensaje= "";
    }
    public String compoundSimpson3_8Method(double x0, double xn, double n){
        if(n%3!=0){
            mensaje = "the number of intervals must be a multiple of three.";
            return mensaje;
        }else{
            double h= (xn - x0)/n;
            double integ = f(x0);
            double suma1 = 0;
            double suma2 = 0;
            double suma3 =0;
            res = "";
            for(int i=1;i<n;i++){
                if(i%3==1){
                    suma1 += f(x0+ i*h);
                }else{
                    if(i%3==2){
                        suma2 += f(x0+ i*h);
                    }else{
                        suma3 += f(x0+i*h);
                    }
                }
            }
            integ += 3*suma1;
            integ += 3*suma2;
            integ += 2*suma3;
            integ += f(xn);
            integ = (3*h/8)*integ;
            res+="the area under the curve "+fx.getFuncion()+" interval between ("+x0+","+xn+") is: "+integ+" + E";
            return res;
        }
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
