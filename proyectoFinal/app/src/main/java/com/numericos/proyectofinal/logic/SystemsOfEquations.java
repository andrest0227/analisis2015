package com.numericos.proyectofinal.logic;

/**
 * Created by JU on 11/24/2014.
 */
public class SystemsOfEquations {

    private double[][] tabla;
    private String mensaje;
    private String res;


    public double[][] textToMatrix(String entrada){

        String [] rows = entrada.split("[\\r\\n]+");
        int equationsQty = rows.length;
        double [][] matrix = new double[equationsQty][equationsQty];
        clearMatrix(matrix);
        int i = 0;
        double celda;
        while(i < equationsQty){

            String [] cells = rows[i].split("\\s+");
            int j = 0;
            while(j < equationsQty ){
                celda = Double.parseDouble(cells[j]);
                matrix[i][j] = celda;
                j++;
            }
            i++;
        }

        return matrix;
    }

    public double[] textToVector(String entrada){

        String [] cells = entrada.split("\\s+");
        double [] vector = new double[cells.length];
        int i = 0;
        while(i < cells.length ){
            vector[i] = Double.parseDouble(cells[i]);
            i++;
        }
        return vector;
    }

    private double[][] clearMatrix(double[][] matrix){
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                matrix[i][j]= 0;
            }
        }
        return matrix;
    }

    public void printMatrix(double[][] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public double[] eliminacionGauss(double[][] A, double[] b, int typePiv){
        int n = A.length;
        int l = A[0].length;
        tabla = new double[A.length][A[0].length+1];
        if(n!=l){
            mensaje = "A no es una matriz cuadrada.";
            return new double[0];
        }else{
            aumentada(A, b);
            int[] vectorDeMarcas = null;
            vectorDeMarcas = createVectorDeMarcas(tabla.length, vectorDeMarcas);
            res = "";
            double m = 0;
            for(int k=0;k<n-1;k++){
                res += "Etapa "+(k+1)+"\n";
                switch(typePiv){
                    case 0:
                        pivoteoParcial(k);
                        break;
                    case 1:
                        vectorDeMarcas = pivoteoTotal(k,vectorDeMarcas);
                        break;
                    case 2:
                        pivoteoEscalonado(k);
                        break;
                    default:
                        break;
                }
                for(int i=k+1;i<n;i++){
                    m = tabla[i][k] / tabla[k][k];
                    for(int j=k;j<n+1;j++){
                        tabla[i][j] = (double) tabla[i][j] - m*tabla[k][j];
                    }
                }
                for(int i=0;i<n+1;i++){
                    if(i==n){
                        res+= "b";
                    }else{
                        res+= "x"+vectorDeMarcas[i]+"\t";
                    }
                }
                res+="\n";
                agregarRes(tabla);
                res+="\n";
            }

            double suma;
            double[] x = new double[n];
            for(int i=n-1;i>=0;i--){
                suma=0;
                for(int j=i+1;j<n;j++){
                    suma = suma + tabla[i][j]*x[j];
                }
                x[i] = (tabla[i][n] - suma)/tabla[i][i];
                res+= "x"+vectorDeMarcas[i]+" = "+x[i]+"\n";
            }
            return x;
        }
    }

    public void aumentada(double[][] A, double[] b){
        int n = A.length;
        int m = b.length;
        tabla = new double[n][n+1];
        if(n!=m){
            System.out.println("no es posible hacer la matriz aumentada A|b debido que"
                    + "las filas de A es diferente al numero de elementos de b");
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<n+1;j++){
                    if(j==n){
                        tabla[i][j] = b[i];
                    }else{
                        tabla[i][j] = A[i][j];
                    }
                }
            }
        }
    }

    public int[] createVectorDeMarcas(int n, int[] var){
        var = new int[n];
        for(int i=0;i<n;i++){
            var[i] = i;
        }
        return var;
    }

    public void pivoteoParcial(int piv){
        int n = tabla.length;
        double mayor = Math.abs(tabla[piv][piv]);
        int fMayor = piv;
        for(int i=piv+1;i<n;i++){
            double aux = Math.abs(tabla[i][piv]);
            if(mayor < aux){
                fMayor = i;
                mayor = aux;
            }
        }
        if(mayor == 0){
            mensaje += "El sistema no tiene solución única.";
        }else{
            if(fMayor != piv){
                tabla = cambioFila(tabla,piv,fMayor);
            }
        }
    }

    public int[] pivoteoTotal(int piv, int[] variables){
        int n = tabla.length;
        double mayor = Math.abs(tabla[piv][piv]);
        int fMayor = piv;
        int cMayor = piv;
        for(int i=piv;i<n;i++){
            for(int j=piv;j<n;j++){
                double aux = Math.abs(tabla[i][j]);
                if(mayor < aux){
                    fMayor = i;
                    cMayor = j;
                    mayor = aux;
                }
            }
        }
        if(mayor == 0){
            mensaje = "El sistema no tiene solución única.";
            return variables;
        }else{
            if(fMayor != piv){
                tabla = cambioFila(tabla,piv,fMayor);
            }
            if(cMayor != piv){
                tabla = cambioCol(tabla,piv,cMayor);
                variables = cambioVariables(variables,piv,cMayor);
            }
            return variables;
        }
    }

    public void pivoteoEscalonado(int piv){
        int n = tabla.length;
        double mayor = 0;
        double[] Mayores = new double[n-piv];
        double aux = 0;
        for(int i=piv;i<n;i++){
            mayor = Math.abs(tabla[i][piv]);
            for(int j=piv+1;j<n;j++){
                aux = Math.abs(tabla[i][j]);
                if(mayor < aux){
                    mayor = aux;
                }
            }
            Mayores[i-piv] = mayor;
        }
        mayor = 0;
        int fMayor = piv;
        int i=piv;
        while(i<n && Mayores[i-piv]!=0){
            aux = tabla[i][piv]/Mayores[i-piv];
            if(mayor < aux){
                mayor = aux;
                fMayor = i;
            }
            i++;
        }
        if(i!=n && Mayores[i-piv]==0){
            mensaje = "El sistema no tiene solución única.";
        }else{
            if(fMayor != piv){
                tabla = cambioFila(tabla,piv,fMayor);
            }
        }
    }

    public double[][] cambioFila(double[][] A, int piv, int fCambio){
        int m = A[0].length;
        double aux;
        for(int i=0;i<m;i++){
            aux = A[piv][i];
            A[piv][i] = A[fCambio][i];
            A[fCambio][i] = aux;
        }
        return A;
    }

    public double[][] cambioCol(double[][] A, int piv, int cCambio){
        int n = A.length;
        double aux;
        for(int i=0;i<n;i++){
            aux = A[i][piv];
            A[i][piv] = A[i][cCambio];
            A[i][cCambio] = aux;
        }
        return A;
    }

    public int[] cambioVariables(int[] var, int piv, int cambio){
        int aux= var[piv];
        var[piv] = var[cambio];
        var[cambio] = aux;
        return var;
    }

    public void agregarRes(double[][] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                res+= A[i][j]+"\t";
            }
            res += "\n";
        }
    }

    public void Jacobi(double[][] A, double [] b, double t, int iter, double[] x0, double lamda){
        int n = A.length;
        int l = A[0].length;
        mensaje = "";
        if(n!=l){
            mensaje = "A no es una matriz cuadrada.";
        }else{
            tabla = new double[1][x0.length+2];
            double[] x = new double[n];
            double aux;
            int cont=0;
            double E= t+1;
            tabla[0][0] = cont;
            tabla[0][x0.length+1] = E;
            for(int i=1;i<=x0.length;i++){
                tabla[0][i] = x0[i-1];
            }
            double[] dato = new double[x0.length+2];
            while(E>t && cont<=iter){
                E=0;
                for(int i=0;i<n;i++){
                    double suma=0;
                    for (int j=0;j<n; j++){
                        if (i!=j){
                            suma=suma+A[i][j]*x0[j];
                        }
                    }
                    x[i] = lamda*((b[i] - suma)/A[i][i]) + (1-lamda)*x0[i];
                    aux = x[i]-x0[i];
                    E = E + Math.pow(aux,2);
                }
                E=Math.pow(E,0.5);
                dato[dato.length-1] = E;
                for (int i=0;i<n;i++){
                    x0[i] = x[i];
                    dato[i+1]=x[i];
                }
                cont++;
                dato[0]=cont;
                agregarDatos(dato);
            }
            if(cont==iter){
                mensaje = "no se llegó a la solución en "+iter+" iteraciones";
            }
        }
    }

    public void Seidel(double[][] A, double [] b, double t, int iter, double[] x0, double lamda){
        int n = A.length;
        int l = A[0].length;
        mensaje = "";
        if(n!=l){
            mensaje = "A no es una matriz cuadrada.";
        }else{
            tabla = new double[1][x0.length+2];
            double[] x = new double[n];
            double aux;
            int cont=0;
            double E= t+1;
            tabla[0][0] = cont;
            tabla[0][x0.length+1] = E;
            for(int i=1;i<=x0.length;i++){
                tabla[0][i] = x0[i-1];
            }
            double[] dato = new double[x0.length+2];
            while(E>t && cont<=iter){
                E=0;
                for(int i=0;i<n;i++){
                    double suma=0;
                    for (int j=0;j<n; j++){
                        if (i!=j){
                            suma=suma+A[i][j]*x0[j];
                        }
                    }
                    x[i] = lamda*((b[i] - suma)/A[i][i]) + (1-lamda)*x0[i];
                    aux = x[i]-x0[i];
                    E = E + Math.pow(aux,2);
                    x0[i]=x[i];
                }
                E=Math.pow(E,0.5);
                dato[dato.length-1] = E;
                for (int i=0;i<n;i++){
                    dato[i+1]=x[i];
                }
                cont++;
                dato[0]=cont;
                agregarDatos(dato);
            }
            if(cont==iter){
                mensaje = "no se llegó a la solución en "+iter+" iteraciones";
            }
        }
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

    public String printTabla(double[][] A){
        String result = "";
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                result = result.concat(A[i][j]+"\t");
            }
            result = result.concat("\n");
        }
        return result;
    }

    public String getRes(){
        return res;
    }
    public double[][] getTabla(){  return tabla;
    }
}
