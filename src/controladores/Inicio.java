package controladores;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.Usuario;
import servicios.Menu;
import servicios.SubMenu;

/**
 * 
 */
public class Inicio {

	public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	public static int ultimoIdUsuario = 0;
	public static String sesion = "";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		SubMenu submenu = new SubMenu();
		
		boolean esCerradoMenuPrincipal = false;
		byte opcionMenu;
		
		do {
			
			opcionMenu = menu.mostrarMenuYElegirOpcion();
			
			switch(opcionMenu) {
			case 0:
				esCerradoMenuPrincipal = true;
				break;
			case 1:
				submenu.accionarSubMenuUsuario();
				break;
			case 2:
				
				break;
			default:
				System.out.println("No exite la opción elegida, vuelva a intetarlo.");
			}
			
		}while(!esCerradoMenuPrincipal);
		
		sc.close();
	}

}

