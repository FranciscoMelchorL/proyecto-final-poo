package cursoPOO.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

import cursoPOO.persistencia.Ganancia;
import cursoPOO.persistencia.RegistroGananciaInterfaz;

public class RegistroGanancia implements RegistroGananciaInterfaz {

	public void insertarGanancia(List<Ganancia> LGanancia, Ganancia ganancia){
		if(ganancia.getIdGanancia()>0){
			LGanancia.add(ganancia);
		}
	}
	
	public void imprimirLista(List<Ganancia> LGanancia){
		System.out.println("\t Todas las ganancias");
		System.out.println("idGanancia		IdVenta		Ganancia		Fecha");
		for(Ganancia ganTemp:LGanancia){
			System.out.println(ganTemp.getIdGanancia() + "\t\t\t" + ganTemp.getVentaId() + "\t\t" + ganTemp.getGanancia() + "\t\t\t" + ganTemp.getFecha());
		}
	}
	
	public Ganancia consultar(List<Ganancia> LGanancia, Date fecha){
		for(Ganancia ganTemp:LGanancia){
			if(ganTemp.getFecha()==fecha){
				return ganTemp;
			}
		}
		return null;
	}
	
	public Ganancia consultarID(List<Ganancia> LGanancia, int id){
		for(Ganancia ganTemp:LGanancia){
			if(ganTemp.getIdGanancia()==id){
				return ganTemp;
			}
		}
		return null;
	}
	
	public void escribirArchivo(List<Ganancia> LGanancia){
		FileOutputStream fos=null;
		int numRegistros=0,i;
		
		System.out.println("Inicia escritura a archivo de ganancias\n");
		try{
			fos=new FileOutputStream("Ganancias.dat");
			ObjectOutputStream salidaFile=new ObjectOutputStream(fos);
			numRegistros=LGanancia.size();
			salidaFile.writeInt(numRegistros);
			for(i=0;i<numRegistros;i++){
				salidaFile.writeObject(LGanancia.get(i));
			}
			salidaFile.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public int leerDeArchivo(List<Ganancia> LGananciaA){
		int numRegistros = 0, i;
		FileInputStream fis=null;
		Ganancia ganT;
		System.out.println("Inicia lectura del archivo de productos");
		
		try{
			fis=new FileInputStream("Ganancias.dat");
			ObjectInputStream entradaFile=new ObjectInputStream(fis);
			numRegistros=entradaFile.readInt();
			for(i=0;i<numRegistros;i++){
				ganT=new Ganancia();
				ganT=(Ganancia) entradaFile.readObject();
				insertarGanancia(LGananciaA, ganT);
			}
			entradaFile.close();
		}catch (ClassNotFoundException e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}catch (IOException e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}
		return numRegistros;
	}

}
