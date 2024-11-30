package cursoPOO.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Venta implements Serializable {
	
	private static final long serialVersionUID = 6549513426930147355L;
	private int idVenta;
	private Cliente cliente;
	private ArrayList<Producto> carritoProd;
	private float totalVenta;
	private Date fecha;
	
	public Venta(){
		
	}
	
	public Venta(int idVenta, Cliente cliente, ArrayList<Producto> carritoProd, float totalVenta, Date fecha){
		setIdVenta(idVenta);
		setCliente(cliente);
		setCarritoProd(carritoProd);
		setTotalVenta(totalVenta);
		setFecha(fecha);
	}
	
	public void setIdVenta(int idVenta) {
		this.idVenta=idVenta;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	public void setCarritoProd(ArrayList<Producto> carritoProd) {
		this.carritoProd=carritoProd;
	}
	
	public void setTotalVenta(float totalVenta){
		this.totalVenta=totalVenta;
	}
	
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ArrayList<Producto> getCarritoProd() {
		return carritoProd;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public float getTotalVenta(){
		return totalVenta;
	}

}
