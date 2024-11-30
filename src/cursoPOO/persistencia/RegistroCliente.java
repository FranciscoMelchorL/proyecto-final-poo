package cursoPOO.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class RegistroCliente implements RegistroClienteInterfaz {
	
	public void insertar(List<Cliente> LCliente, Cliente cliente){
		if(cliente.getIdCliente()>0){
			if(cliente.getNombre()!=null){
				if(cliente.getDireccion()!=null){
					LCliente.add(cliente);
				}
			}
		}
	}
	
	public Cliente buscarCliente(List<Cliente> LCliente, int idCliente){
		for(Cliente clienTemp:LCliente){
			if(clienTemp.getIdCliente()==idCliente){
				return clienTemp;
			}
		}
		return null;
	}
	
	public void imprimirLista(List<Cliente> LCliente){
		System.out.println("\t Los clientes son ");
		System.out.println("idCliente		Nombre		Direccion");
		for(Cliente clienTemp:LCliente){
			System.out.println(clienTemp.getIdCliente() + "\t\t\t" + clienTemp.getNombre() + "\t\t" + clienTemp.getDireccion());
		}
	}
	
	public void eliminar(List<Cliente> LCliente, Cliente cliente){
		LCliente.remove(cliente);
	}
	
	public void eliminarCola(List<Cliente> LCliente){
		LCliente.remove(0);
	}
	
	public void escribirEnArchivo(List<Cliente> LCliente){
		FileOutputStream fos=null;
		int numRegistros=0,i;
		
		System.out.println("Se escribio el archivo\n");
		try{
			fos=new FileOutputStream("Clientes.dat");
			ObjectOutputStream salidaFile=new ObjectOutputStream(fos);
			numRegistros=LCliente.size();
			salidaFile.writeInt(numRegistros);
			for(i=0;i<numRegistros;i++){
				salidaFile.writeObject(LCliente.get(i));
			}
			salidaFile.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void leerDeArchivo(List<Cliente> LClienteA){
		int numRegistros, i;
		FileInputStream fis=null;
		Cliente clienT;
		System.out.println("Inicia lectura del archivo de clientes");
		
		try{
			fis=new FileInputStream("Clientes.dat");
			ObjectInputStream entradaFile=new ObjectInputStream(fis);
			numRegistros=entradaFile.readInt();
			for(i=0;i<numRegistros;i++){
				clienT=new Cliente();
				clienT=(Cliente) entradaFile.readObject();
				insertar(LClienteA, clienT);
			}
			entradaFile.close();
		}catch (ClassNotFoundException e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}catch (IOException e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}
	}


}
