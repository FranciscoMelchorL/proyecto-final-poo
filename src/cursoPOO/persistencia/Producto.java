package cursoPOO.persistencia;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = -4482371539520140383L;
	private int idProducto, cantidad;
	private String nombre;
	private float precioCompra, precioVenta;
	
	public Producto(){
		
	}
	
	public Producto(int idProducto, String nombre, int cantidad, float precioCompra, float precioVenta){
		setIdProducto(idProducto);
		setNombre(nombre);
		setCantidad(cantidad);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
	}
	
	public void setIdProducto(int idProducto){
		this.idProducto=idProducto;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}
	
	public void setPrecioCompra(float precioCompra){
		this.precioCompra=precioCompra;
	}
	
	public void setPrecioVenta(float precioVenta){
		this.precioVenta=precioVenta;
	}
	
	public int getIdProducto(){
		return idProducto;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getCantidad(){
		return cantidad;
	}
	
	public float getPrecioCompra(){
		return precioCompra;
	}
	
	public float getPrecioVenta(){
		return precioVenta;
	}
}
