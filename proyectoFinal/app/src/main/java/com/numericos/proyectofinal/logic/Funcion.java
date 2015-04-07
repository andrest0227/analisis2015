package com.numericos.proyectofinal.logic;
import org.nfunk.jep.*;

public class Funcion {
    private boolean parseError;
    private String funcion;
    private JEP parser;
    
    public Funcion(String funcion){
        this.funcion = funcion;
    }
    
    public String getFuncion(){
        return funcion;
    }
    
    public void prepararParser(){
    	parser = new JEP();
    	parser.addStandardFunctions(); //agrega las funciones comunes
    	parser.addStandardConstants(); 
    	parser.addComplex(); 
    	parser.addFunction("sen", new org.nfunk.jep.function.Sine());
        parser.addFunction("log", new org.nfunk.jep.function.Logarithm());
        parser.addFunction("cos", new org.nfunk.jep.function.Cosine());
        parser.addFunction("exp", new org.nfunk.jep.function.Exp());
    	parser.addVariable("x", 0); 
    	parser.setImplicitMul(true); //permite 2x en vez de 2*x
    	
    }
   
    public double evaluar(double valorx){
    	prepararParser();
    	parser.parseExpression(funcion);
    	parser.addVariable("x", valorx);
    	return parser.getValue(); 
    }
    
    public boolean revisarFunc (){
    	prepararParser();
    	parser.parseExpression(funcion);
    	parser.addVariable("x", 1);
    	boolean error = parser.hasError();
		return error;
    } 
}