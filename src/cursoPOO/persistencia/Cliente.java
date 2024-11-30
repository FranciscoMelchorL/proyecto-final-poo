package cursoPOO.persistencia;

import java.io.Serializable;

public class Cliente implements   Serializable{

	private static final long serialVersionUID = -5357060402469548543L;
	private String nombre, direccion;
	private int idCliente;
	
	public Cliente(){
		
	}
	
	public Cliente(String nombre, String direccion, int idCliente){
		setNombre(nombre);
		setDireccion(direccion);
		setIdCliente(idCliente);
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	
	public void setIdCliente(int idCliente){
		this.idCliente=idCliente;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public int getIdCliente(){
		return idCliente;
	}

}
