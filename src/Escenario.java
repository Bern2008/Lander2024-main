import java.util.ArrayList;

public class Escenario {

	private String nombre;		// nombre del planeta o satelite
	private double g;			// gravedad del escenario
	private double ve;			// velocidad de entrada
	private double he;			// Distancia de aproximacion
	
	public Escenario (String nombre, double g, double ve, double he){
		this.nombre=nombre;
		this.g=g;
		this.ve=ve;
		this.he=he;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
	
	public double getG(){
		return g;
	}
	
	public void setG(double velG){
		this.g = velG;
	}
	
	public double getVe(){
		return ve;
	}
	
	public void setVe(double VelEnt){
		this.ve = VelEnt;
	}
	
	public double getHe(){
		return he;
	}
	
	public void setHe(double VelAprox){
		this.he = VelAprox;
	}

	
}
