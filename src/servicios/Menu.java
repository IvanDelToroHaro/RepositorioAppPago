package servicios;

import controladores.Inicio;

public class Menu implements InterfazMenu {

	@Override
	public byte mostrarMenuYElegirOpcion() {
		byte opcionMenuUsuario;

		System.out.println("######### MENÚ #########");
		System.out.println("## 0. Cerrar el menú. ##");
		System.out.println("## 1. Acceso Usuario. ##");
		System.out.println("## 2. Acceso Admin.   ##");
		System.out.println("########################");

		System.out.println("Por favor, elija una opción: ");
		opcionMenuUsuario = Inicio.sc.nextByte();

		return opcionMenuUsuario;

	}
}