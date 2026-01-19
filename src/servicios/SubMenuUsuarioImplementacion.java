package servicios;

import controladores.Inicio;

/**
 * 
 */
public class SubMenuUsuarioImplementacion implements MenuInterfaz {
	
	@Override
	public void mostrarMenu() {
		
		System.out.println("----------");
		System.out.println("0. Volver a menú principal");
		System.out.println("1. Registro de usuario");
		System.out.println("2. Login usuario");
		System.out.println("3. Baja de cuenta");
		System.out.println("4. Modificar contraseña");
		System.out.println("5. Mostrar todo");
		System.out.println("6. Mostrar administradores");
		System.out.println("7. Mostrar usuarios normales");
		System.out.println("----------");

	}

	@Override
	public byte seleccionarOpcionMenu() {
		byte opcionUsuario;
		
		System.out.println("Seleccioner una opción: ");
		opcionUsuario = Inicio.sc.nextByte();
		
		return opcionUsuario;
	}
	
	/**
	 * 
	 */
	public void accionarSubMenuUsuario() {
		
		UsuariosImplementacion ui = new UsuariosImplementacion();
		
		boolean esCerradoSubMenuUsuario = false;
		byte opcionSubMenuUsuario;
		
		do {
			
			mostrarMenu();
			opcionSubMenuUsuario = seleccionarOpcionMenu();
			
			switch(opcionSubMenuUsuario) {
			case 0:
				esCerradoSubMenuUsuario = true;
				break;
			case 1:
				ui.registroUsuario();
				break;
			case 2:
				ui.loginUsuario();
				break;
			case 3:
				ui.bajaUsuarioXAlias();
				break;
			case 4:
				ui.modificarUsuarioXAlias();
				break;
			case 5:
				ui.listarUsuarios();
				break;
			case 6:
				ui.listarUsuariosAdministradores();
				break;
			case 7:
				ui.listarUsuariosNormales();
				break;
			default:
				System.out.println("No exite la opción elegida, vuelva a intetarlo.");
			}
			
		}while(!esCerradoSubMenuUsuario);
	}

}
