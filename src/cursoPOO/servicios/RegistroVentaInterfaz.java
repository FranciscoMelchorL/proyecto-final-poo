package cursoPOO.servicios;

import java.util.List;

import cursoPOO.persistencia.Ganancia;
import cursoPOO.persistencia.Venta;

public interface RegistroVentaInterfaz {

	public void insertarVenta(List<Venta> LVenta, Venta venta);
	public void imprimirLista(List<Venta> LVenta);
	public void atender(List<Venta> LVenta, List<Ganancia> LGanancia);
	public void escribirArchivo(List<Venta> LVenta);
	public int leerDeArchivo(List<Venta> LVenta);

}
