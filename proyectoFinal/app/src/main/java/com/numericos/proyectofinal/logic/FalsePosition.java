package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 19/11/2014.
 */
public class FalsePosition {

    private double[][] tabla;
    private String mensaje;
    private Funcion fx;
    private Funcion dfx;
    private Funcion ddfx;
    private Funcion gx;

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

    private double g(double x){
        x = gx.evaluar(x);
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
    public FalsePosition() {
        // TODO Auto-generated constructor stub
        //this.fx = new Funcion(funcion);
    }
    public String falsePositionMethod(double a, double b, double t, double i){
        double Ya = f(a);
        double Yb = f(b);
        tabla = new double[1][6];
        if(Ya*Yb > 0){
            mensaje = "El intervalo ["+a+","+b+"] no es valido";
            return mensaje;
        }else{
            if(Ya == 0){
                mensaje = "Hay una raiz en x = "+a;
                return mensaje;
            }else{
                if(Yb == 0){
                    mensaje = "Hay una raiz en x = "+b;
                    return mensaje;
                }else{
                    double aux;
                    double Xm = a - Ya*((b-a)/(Yb-Ya));
                    double E = t+1;
                    int cont=1;
                    double Ym = f(Xm);
                    tabla[0][0] = cont;
                    tabla[0][1] = a;
                    tabla[0][2] = b;
                    tabla[0][3] = Xm;
                    tabla[0][4] = Ym;
                    double[] Taux = new double[6];
                    while(Ym!=0 && E>t && cont<i){
                        if(Ya*Ym<0){
                            b=Xm;
                            Yb=f(b);
                        }else{
                            a=Xm;
                            Ya=f(a);
                        }
                        aux = Xm;
                        Xm = a - Ya*((b-a)/(Yb-Ya));
                        Ym = f(Xm);
                        E = Math.abs(Xm - aux);
                        cont++;
                        Taux[0] = cont;
                        Taux[1] = a;
                        Taux[2] = b;
                        Taux[3] = Xm;
                        Taux[4] = Ym;
                        Taux[5] = E;
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
