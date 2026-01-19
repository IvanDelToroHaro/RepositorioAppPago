package servicios;

import controladores.Inicio;

/**
 * 
 */
public class MenuPrincipalImplementacion implements MenuInterfaz{

	@Override
	public void mostrarMenu() {
		
		System.out.println("----------");
		System.out.println("0. Cerrar aplicación");
		System.out.println("1. Menú usuario");
		System.out.println("2. Menú administrador");
		System.out.println("----------");
		
	}

	@Override
	public byte seleccionarOpcionMenu() {
		byte opcionUsuario;
		
		System.out.println("Seleccioner una opción: ");
		opcionUsuario = Inicio.sc.nextByte();
		
		return opcionUsuario;
	}

}
