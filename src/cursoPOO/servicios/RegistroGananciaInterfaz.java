package cursoPOO.servicios;

import java.util.Date;
import java.util.List;

import cursoPOO.persistencia.Ganancia;

public interface RegistroGananciaInterfaz {

	public void insertarGanancia(List<Ganancia> LGanancia, Ganancia ganancia);
	public Ganancia consultar(List<Ganancia> LGanancia, Date fecha);
	public void imprimirLista(List<Ganancia> LGanancia);
	public void escribirArchivo(List<Ganancia> LGanancia);
	public int leerDeArchivo(List<Ganancia> LGanancia);
	public Ganancia consultarID(List<Ganancia> LGanancia, int id);

}
