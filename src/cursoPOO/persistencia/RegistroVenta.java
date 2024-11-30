package cursoPOO.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class RegistroVenta implements RegistroVentaInterfaz {
	
	int IdGanancia=0;
	
	public void insertarVenta(List<Venta> LVenta, Venta venta){
		if(venta.getIdVenta()>0){
			LVenta.add(venta);
		}
	}
	
	public void imprimirLista(List<Venta> LVenta){
		System.out.println("\t Las ventas son ");
		System.out.println("idCliente		Cliente		Fecha");
		for(Venta ventaTemp:LVenta){
			System.out.println(ventaTemp.getIdVenta() + "\t\t\t" + ventaTemp.getCliente() + "\t\t\t" + ventaTemp.getFecha());
		}
	}
	
	public void atender(List<Venta> LVenta, List<Ganancia> LGanancia){
		float ganancia=0, precioVenta=0, precioCompra=0;
		Venta ventaTmp=new Venta();
		ventaTmp=LVenta.get(0);
		List<Producto> LProductoTmp=ventaTmp.getCarritoProd();
		for(Producto prodTemp:LProductoTmp){
			precioVenta=prodTemp.getPrecioVenta();
			precioCompra=prodTemp.getPrecioCompra();
			ganancia=ganancia+(precioVenta-precioCompra);
		}
		LVenta.remove(0);
		IdGanancia++;
		Ganancia gananciaTotal=new Ganancia(IdGanancia,ventaTmp.getIdVenta(),ventaTmp.getFecha(),ganancia);
		if(gananciaTotal.getIdGanancia()>0){
			LGanancia.add(gananciaTotal);
		}
	}
	
	public void escribirArchivo(List<Venta> LVenta){
		FileOutputStream fos=null;
		int numRegistros=0,i;
		
		System.out.println("Inicia escritura a archivo de ventas\n");
		try{
			fos=new FileOutputStream("Ventas.dat");
			ObjectOutputStream salidaFile=new ObjectOutputStream(fos);
			numRegistros=LVenta.size();
			salidaFile.writeInt(numRegistros);
			for(i=0;i<numRegistros;i++){
				salidaFile.writeObject(LVenta.get(i));
			}
			salidaFile.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public int leerDeArchivo(List<Venta> LVenta){
		int numRegistros = 0, i;
		FileInputStream fis=null;
		Venta venT;
		System.out.println("Inicia lectura del archivo de productos");
		
		try{
			fis=new FileInputStream("Ventas.dat");
			ObjectInputStream entradaFile=new ObjectInputStream(fis);
			numRegistros=entradaFile.readInt();
			for(i=0;i<numRegistros;i++){
				venT=new Venta();
				venT=(Venta) entradaFile.readObject();
				insertarVenta(LVenta, venT);
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
