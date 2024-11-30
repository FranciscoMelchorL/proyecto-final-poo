package cursoPOO.servicios;

import java.util.List;

import cursoPOO.persistencia.Producto;

public interface RegistroProductoInterfaz {

	public void insertar(List<Producto> LProducto, Producto producto);
	public void eliminar(List<Producto> LProducto, Producto producto);
	public void imprimirLista(List<Producto> LProducto);
	public Producto buscarProducto(List<Producto> LProducto, int id);
	public void escribirEnArchivo(List<Producto> LProducto);
	public void leerDeArchivo(List<Producto> LProducto);

}
