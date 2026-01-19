package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Usuario;
import servicios.MenuPrincipalImplementacion;
import servicios.SubMenuUsuarioImplementacion;
/**
 * 
 */
public class Inicio {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	public static int ultimoIdUsuario = 0;
	public static String sesion = "";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		MenuPrincipalImplementacion mpi = new MenuPrincipalImplementacion();
		SubMenuUsuarioImplementacion smui = new SubMenuUsuarioImplementacion();
		
		boolean esCerradoMenuPrincipal = false;
		byte opcionMenuPrincipal;
		
		do {
			
			mpi.mostrarMenu();
			opcionMenuPrincipal = mpi.seleccionarOpcionMenu();
			
			switch(opcionMenuPrincipal) {
			case 0:
				esCerradoMenuPrincipal = true;
				break;
			case 1:
				smui.accionarSubMenuUsuario();
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
