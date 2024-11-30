package cursoPOO.persistencia;

import java.io.Serializable;
import java.util.Date;

public class Ganancia implements Serializable {

	private static final long serialVersionUID = 1830404287821870383L;
	private int idGanancia, ventaId;
	private Date fecha;
	private float ganancia;
	
	public Ganancia(){
		
	}
	
	public Ganancia(int idGanancia, int ventaId, Date fecha, float ganancia){
		setIdGanancia(idGanancia);
		setVentaId(ventaId);
		setFecha(fecha);
		setGanancia(ganancia);
	}
	
	public void setIdGanancia(int idGanancia){
		this.idGanancia=idGanancia;
	}
	
	public void setVentaId(int ventaId){
		this.ventaId=ventaId;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	
	public void setGanancia(float ganancia){
		this.ganancia=ganancia;
	}
	
	public int getIdGanancia(){
		return idGanancia;
	}
	
	public int getVentaId(){
		return ventaId;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public float getGanancia(){
		return ganancia;
	}
	
	public String toString(){
		return "idGanancia		IdVenta		Ganancia		Fecha"+"\n" +getIdGanancia() + "\t\t\t" + getVentaId() + "\t\t" + getGanancia() + "\t\t\t" + getFecha();
	}

}
