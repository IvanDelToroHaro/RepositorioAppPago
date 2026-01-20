package servicios;

import controladores.Inicio;

public class SubMenu implements InterfazMenu {

	@Override
	public byte mostrarMenuYElegirOpcion() {
		byte opcionUsuario;

		System.out.println("############# MENÚ #############");
		System.out.println("## 0. Volver al menú.         ##");
		System.out.println("## 1. Registro Usuario.       ##");
		System.out.println("## 2. Login Usuario.          ##");
		System.out.println("## 3. Restablecer Contraseña. ##");
		System.out.println("################################");

		System.out.println("Por favor, elija una opción: ");
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
				
				opcionSubMenuUsuario = mostrarMenuYElegirOpcion();
				
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
				default:
					System.out.println("No exite la opción elegida, vuelva a intetarlo.");
				}
				
			}while(!esCerradoSubMenuUsuario);
		}

	}
