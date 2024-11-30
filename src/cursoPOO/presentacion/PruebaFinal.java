package cursoPOO.presentacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cursoPOO.persistencia.Cliente;
import cursoPOO.persistencia.Ganancia;
import cursoPOO.persistencia.Producto;
import cursoPOO.persistencia.RegistroCliente;
import cursoPOO.persistencia.RegistroGanancia;
import cursoPOO.persistencia.RegistroProducto;
import cursoPOO.persistencia.RegistroVenta;
import cursoPOO.persistencia.Venta;

public class PruebaFinal {

	public static void main(String[] args) {
		InputStreamReader entrada=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(entrada);
		
		List<Producto> LProductos=new ArrayList<Producto>();
		RegistroProducto prodAux=new RegistroProducto();
		Producto prodTemp=new Producto();
		Producto nuevoProd=new Producto();
		
		List<Cliente> LClientes=new ArrayList<Cliente>();
		List<Cliente> colaLClientes=new ArrayList<Cliente>();
		RegistroCliente cliAux=new RegistroCliente();
		RegistroCliente colaClientes=new RegistroCliente();
		Cliente cliTemp=new Cliente();
		Cliente nuevoCli=new Cliente();
		
		List<Venta> LVenta=new ArrayList<Venta>();
		RegistroVenta ventaAux=new RegistroVenta();
		Venta ventaTemp=new Venta();
		ArrayList<Producto> carritoProd=new ArrayList<Producto>();
		
		List<Ganancia> LGanancia=new ArrayList<Ganancia>();
		RegistroGanancia gananciaAux=new RegistroGanancia();
		Ganancia gananciaTemp=new Ganancia();
		
		int opcion=12,id=0, idVenta, idGanancia, idVent=0, cantTemp=0;
		Date Fecha = new Date();
		
		prodAux.leerDeArchivo(LProductos);
		cliAux.leerDeArchivo(LClientes);
		idVenta=ventaAux.leerDeArchivo(LVenta);
		idGanancia=gananciaAux.leerDeArchivo(LGanancia);
		do{
			do{
				System.out.println(" GESTION DE INVENTARIO DE PRODUCTOS ");
				System.out.println(" 1. Alta de productos");
				System.out.println(" 2. Listar productos");
				System.out.println(" 3. Eliminar un producto\n");
				System.out.println(" GESTION DE CARTERA DE CLIENTES");
				System.out.println(" 4. Alta de clientes");
				System.out.println(" 5. Listar clientes");
				System.out.println(" 6. Eliminar un cliente\n");
				System.out.println(" GESTION DE VENTAS(cola clientes)");
				System.out.println(" 7. Insertar cliente en la cola");
				System.out.println(" 8. Listar cola clientes");
				System.out.println(" 9. Atender clientes\n");
				System.out.println(" GESTION DE GANANCIAS");
				System.out.println(" 10. Listar ganancias");
				System.out.println(" 11. Consultar ganancia por id");
				System.out.println(" 12. Salir");
				System.out.println(" Selecciona tu opcion: \n");
				
				try{
					opcion=Integer.parseInt(in.readLine());
				} catch (Exception e){
					System.out.println("Teclea la opcion correcta");
				}
			}while(opcion<1 || opcion> 12);
			
			switch(opcion){
			case 1:
				try{
					System.out.println("Insertar los siguientes datos de un producto");
					System.out.println("idProducto (0 para terminar):");
					id=Integer.parseInt(in.readLine());
					if(id>0){
						prodTemp=prodAux.buscarProducto(LProductos, id);
						while(id>0 && prodTemp==null){
							nuevoProd=new Producto();
							nuevoProd.setIdProducto(id);
							System.out.println("nombre:");
							nuevoProd.setNombre(in.readLine());
							System.out.println("cantidad");
							nuevoProd.setCantidad(Integer.parseInt(in.readLine()));
							System.out.println("precio de compra");
							nuevoProd.setPrecioCompra(Float.parseFloat(in.readLine()));
							System.out.println("precio de venta");
							nuevoProd.setPrecioVenta(Float.parseFloat(in.readLine()));
							
							prodAux.insertar(LProductos, nuevoProd);
							System.out.println("idProducto (0 para terminar):");
							id=Integer.parseInt(in.readLine());
							if(id>0)
								prodTemp=prodAux.buscarProducto(LProductos, id);
						}
						if(prodTemp != null){
							System.out.println("El producto ya existe\n\n\n");
						}
					}
				} catch (Exception e){
					System.out.println("Error: " + e);
				}
				break;
			case 2:
				try{
					System.out.println("Se imprimira la lista de todos los productos existentes");
					prodAux.imprimirLista(LProductos);
					System.out.println("\n\n\n");
				} catch (Exception e){
					System.out.println("La lista de productos esta vacia\n\n\n");
				}
				break;
			case 3:
				try{
					System.out.println("Teclee la id del producto que desea eliminar");
					id=Integer.parseInt(in.readLine());
					prodTemp=prodAux.buscarProducto(LProductos, id);
					prodAux.eliminar(LProductos, prodTemp);
					System.out.println("El producto fue eliminado con exito\n\n\n");
				} catch (Exception e){
					System.out.println("El producto a eliminar no existe\n\n\n");
				}
				break;
			case 4:
				try{
					System.out.println("Insertar los siguientes datos de un cliente");
					System.out.println("idCliente (1< para terminar)");
					id=Integer.parseInt(in.readLine());
					if(id>0){
						cliTemp=cliAux.buscarCliente(LClientes, id);
						while(id>0 && cliTemp==null){
							nuevoCli=new Cliente();
							nuevoCli.setIdCliente(id);
							System.out.println("Nombre:");
							nuevoCli.setNombre(in.readLine());
							System.out.println("Direccion");
							nuevoCli.setDireccion(in.readLine());
							
							cliAux.insertar(LClientes, nuevoCli);
							System.out.println("idCliente (1< para terminar)");
							id=Integer.parseInt(in.readLine());
							if(id>0)
								cliTemp=cliAux.buscarCliente(LClientes, id);
						}
						if(cliTemp!=null){
							System.out.println("El cliente ya existe\n\n\n");
						}
					}
				} catch (Exception e){
					System.out.println("Error: " + e);
				}
				break;
			case 5:
				try{
					System.out.println("Se imprimira la lista de todos los clientes");
					cliAux.imprimirLista(LClientes);
					System.out.println("\n\n\n");
				} catch (Exception e){
					System.out.println("La lista de clientes esta vacia\n\n\n");
				}
				break;
			case 6:
				try{
					System.out.println("Teclee la id del cliente que desea eliminar");
					id=Integer.parseInt(in.readLine());
					cliTemp=cliAux.buscarCliente(LClientes, id);
					cliAux.eliminar(LClientes, cliTemp);
					System.out.println("El cliente fue eliminado con exito\n\n\n");
				} catch (Exception e){
					System.out.println("El cliente a eliminar no existe\n\n\n");
				}
				break;
			case 7:
				try{
					System.out.println("Teclee la id del cliente que desea añadir a la cola");
					id=Integer.parseInt(in.readLine());
					cliTemp=cliAux.buscarCliente(LClientes, id);
					colaClientes.insertar(colaLClientes, cliTemp);
					System.out.println("Cliente insertado con exito\n");
					cliAux.eliminar(LClientes, cliTemp);
				} catch (Exception e){
					System.out.println("La id del cliente que se quiere añadir a la cola no existe\n\n\n");
					break;
				}
				try{
					while(id>0){
						System.out.println("Teclee la id del producto que el cliente va a comprar(0 para terminar)\n");
						id=Integer.parseInt(in.readLine());
						if(id<1)
							break;
						prodTemp=prodAux.buscarProducto(LProductos, id);
						cantTemp=prodTemp.getCantidad()-1;
						if(cantTemp>-1){
							prodTemp.setCantidad(cantTemp);
							carritoProd.add(prodTemp);
							System.out.println("Producto añadido al carrito con exito\n");
						}
						else{
							System.out.println("Productos insuficientes para añadir al carrito");
						}
					}
					idVent++;
					Fecha=new Date();
					ventaTemp=new Venta(idVent,cliTemp,carritoProd,0,Fecha);
					ventaAux.insertarVenta(LVenta, ventaTemp);
					carritoProd=new ArrayList<Producto>();
					System.out.println("\n\n\n");
				} catch (Exception e){
					System.out.println("el producto no existe\n\n\n");
				}
				break;
			case 8:
				try{
					System.out.println("Se imprimira la cola de clientes\n");
					colaClientes.imprimirLista(colaLClientes);
					System.out.println("\n\n\n");
				} catch (Exception e){
					System.out.println("La cola de clientes esta vacia\n\n\n");
				}
				break;
			case 9:
				try{
					System.out.println("Se atendera al primer cliente en la cola\n");
					ventaAux.atender(LVenta, LGanancia);
					colaClientes.eliminarCola(colaLClientes);
					System.out.println("El cliente fue atendido\n\n\n");
				} catch (Exception e){
					System.out.println("No hay clientes en la cola\n\n\n");
				}
				break;
			case 10:
				try{
					System.out.println("Se imprimira la lista de todas las ganancias\n");
					gananciaAux.imprimirLista(LGanancia);
					System.out.println("\n\n\n");
				} catch (Exception e){
					System.out.println("La lista de ganancias esta vacia\n\n\n");
				}
				break;
			case 11:
				try{
					System.out.println("Teclee la id de la ganacia a consultar");
					id=Integer.parseInt(in.readLine());
					gananciaTemp=gananciaAux.consultarID(LGanancia, id);
					System.out.println(gananciaTemp);
					System.out.println("\n\n\n");
				} catch (Exception e){
					System.out.println("No existe esta ganancia con esta id\n\n\n");
				}
				break;
			case 12:
				prodAux.escribirEnArchivo(LProductos);
				cliAux.escribirEnArchivo(LClientes);
				cliAux.escribirEnArchivo(colaLClientes);
				gananciaAux.escribirArchivo(LGanancia);
				ventaAux.escribirArchivo(LVenta); 
				opcion=15;
			}
		}while(opcion>0 && opcion<13);
		System.out.println("Programa terminado con exito");
	}
}
