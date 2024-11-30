package cursoPOO.persistencia;

import java.util.List;

public interface RegistroClienteInterfaz {

	public void insertar(List<Cliente> LCliente, Cliente cliente);
	public void eliminar(List<Cliente> LCliente, Cliente cliente);
	public void imprimirLista(List<Cliente> LCliente);
	public Cliente buscarCliente(List<Cliente> LCliente, int id);
	public void escribirEnArchivo(List<Cliente> LCliente);
	public void leerDeArchivo(List<Cliente> LCliente);
	public void eliminarCola(List<Cliente> LCliente);
}
