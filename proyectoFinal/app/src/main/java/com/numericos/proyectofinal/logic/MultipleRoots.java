package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 20/11/2014.
 */
public class MultipleRoots {

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
    public MultipleRoots() {
        //this.fx = new Funcion(funcion);
        //this.dfx = new Funcion(funcion2);
        //this.ddfx = new Funcion(funcion3);
    }

    public String multipleRootsMethod(double Xm, double t, double i) {
        double E = t+1;
        int cont = 0;
        double y = f(Xm);
        double z = df(Xm);
        double w = ddf(Xm);
        double den = Math.pow(z, 2)- y*w;
        double aux = Xm;
        tabla = new double[1][6];
        tabla[0][0] = cont;
        tabla[0][1] = Xm;
        tabla[0][2] = y;
        tabla[0][3] = z;
        tabla[0][4] = w;
        double[] Taux = new double[6];
        while (y!=0 && E>t && (z!=0 || w!=0) && cont<i) {
            double X1 = Xm -((y*z)/((z*z)-(y*w)));
            y = f(X1);
            z = df(X1);
            w = ddf(X1);
            E = Math.abs((X1 - Xm)/X1);
            Xm = X1;
            cont++;
            Taux[0] = cont;
            Taux[1] = Xm;
            Taux[2] = y;
            Taux[3] = z;
            Taux[4] = w;
            Taux[5] = E;
            agregarDatos(Taux);
        }
        if (y == 0) {
            mensaje = "Hay una raiz en x = "+Xm;
            return mensaje;
        } else {
            if (E<=t) {
                mensaje = "Hay una raiz en x = "+Xm+" con una tolerancia de "+E;
                return mensaje;
            } else {
                if (z== 0  && w==0) {
                    mensaje = "El método de Raices Multiples no es apropiado para este caso";
                    return mensaje;
                } else {

                    mensaje = "Fracaso: no se halló raiz en "+i+" iteraciones";
                    return mensaje;
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
