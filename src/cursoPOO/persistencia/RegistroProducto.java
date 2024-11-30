package cursoPOO.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class RegistroProducto  implements RegistroProductoInterfaz {

	public void insertar(List<Producto> LProducto, Producto producto){
		if(producto.getIdProducto()>0){
			LProducto.add(producto);
		}
	}
	
	public Producto buscarProducto(List<Producto> LProducto, int idProducto){
		for(Producto prodTemp:LProducto){
			if(prodTemp.getIdProducto()==idProducto){
				return prodTemp;
			}
		}
		return null;
	}
	
	public void imprimirLista(List<Producto> LProducto){
		System.out.println("\t Productos en existencia ");
		System.out.println("idProducto		Nombre		Cantidad		PrecioCompra		PrecioVenta");
		for(Producto prodTemp:LProducto){
			System.out.println(prodTemp.getIdProducto() + "\t\t\t" + prodTemp.getNombre() + "\t\t" + prodTemp.getCantidad() + "\t\t\t" + prodTemp.getPrecioCompra() + "\t\t\t" + prodTemp.getPrecioVenta());
		}
	}
	
	public void eliminar(List<Producto> LProducto, Producto producto){
		LProducto.remove(producto);
	}
	
	public void escribirEnArchivo(List<Producto> LProducto){
		FileOutputStream fos=null;
		int numRegistros=0,i;
		
		System.out.println("Inicia escritura a archivo de productos\n");
		try{
			fos=new FileOutputStream("productos.dat");
			ObjectOutputStream salidaFile=new ObjectOutputStream(fos);
			numRegistros=LProducto.size();
			salidaFile.writeInt(numRegistros);
			for(i=0;i<numRegistros;i++){
				salidaFile.writeObject(LProducto.get(i));
			}
			salidaFile.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void leerDeArchivo(List<Producto> LProductoA){
		int numRegistros, i;
		FileInputStream fis=null;
		Producto prodT;
		System.out.println("Inicia lectura del archivo de productos");
		
		try{
			fis=new FileInputStream("Productos.dat");
			ObjectInputStream entradaFile=new ObjectInputStream(fis);
			numRegistros=entradaFile.readInt();
			for(i=0;i<numRegistros;i++){
				prodT=new Producto();
				prodT=(Producto) entradaFile.readObject();
				insertar(LProductoA, prodT);
			}
			entradaFile.close();
		}catch (ClassNotFoundException e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}catch (IOException e){
			System.out.println("Error: " + e.getLocalizedMessage());
		}
	}
}
