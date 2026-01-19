package servicios;

import java.time.LocalDate;

import controladores.Inicio;
import entidades.Usuario;

/**
 * 
 */
public class UsuariosImplementacion {
	
	public void registroUsuario () {
		
		Usuario nuevoUsuario = new Usuario();
		
		System.out.println("Escriba su alias (no puede tener espacios): ");
		nuevoUsuario.setAliasUsuario(Inicio.sc.next());
		
		System.out.println("Escriba su nombre: ");
		nuevoUsuario.setNombreUsuario(Inicio.sc.next());
		
		Inicio.sc.nextLine();
		System.out.println("Escriba sus apellidos: ");		
		nuevoUsuario.setApellidosUsuario(Inicio.sc.nextLine());
		
		System.out.println("Escriba su dni: ");
		nuevoUsuario.setDniUsuario(Inicio.sc.next());
		
		System.out.println("Escriba su teléfono: ");
		nuevoUsuario.setTelefonoUsuario(Inicio.sc.nextInt());
		
		System.out.println("Escriba su email: ");
		nuevoUsuario.setEmailUsuario(Inicio.sc.next());
		
		//Solicitud de clave
		boolean solicitarClave;		
		do {
			System.out.println("Escriba su contraseña: ");
			String clave1 = Inicio.sc.next();			
			System.out.println("Confirme su contraseña: ");
			String clave2 = Inicio.sc.next();
			if(clave1.equals(clave2)) {
				nuevoUsuario.setClaveUsuario(clave2);
				solicitarClave = false;
			}else {
				System.out.println("Las contraseñas no coinciden: ");
				solicitarClave = true;
			}
		}while(solicitarClave);
		
		System.out.println("Escriba su fecha de nacimiento (dd-MM-yyyy): ");
		String fechaFormato = Inicio.sc.next();
		String[] fechaDividida = fechaFormato.split("-");
		nuevoUsuario.setFechaNacimientoUsuario(LocalDate.of(Integer.parseInt(fechaDividida[2]), Integer.parseInt(fechaDividida[1]), Integer.parseInt(fechaDividida[0])));
				
		Inicio.listaUsuarios.add(nuevoUsuario);
		System.out.println("El usuario se ha dado de alta correctamente.");
	}
	
	public void loginUsuario() {
		
		System.out.println("Alias usuario: ");
		String alias = Inicio.sc.next();
		System.out.println("Clave usuario: ");
		String clave = Inicio.sc.next();
		
		Usuario uAuxiliar = new Usuario();
		
		for(Usuario u : Inicio.listaUsuarios) {
			if(u.getAliasUsuario().equals(alias)) {
				uAuxiliar = u;
				break;
			}
		}
		
		if(uAuxiliar.getAliasUsuario() != null) {
			if(uAuxiliar.getClaveUsuario().equals(clave)) {
				Inicio.sesion = uAuxiliar.getAliasUsuario();
				System.out.println("El usuario ha accedido correctamente.");
			}else {
				System.out.println("Los datos de acceso son incorrectos.");
			}
		}else {
			System.out.println("Los datos de acceso son incorrectos.");
		}		
		
	}
	
	public void bajaUsuarioXAlias() {
		
		if(Inicio.sesion.isBlank()) {
			System.out.println("Debe haber iniciado sesión para poder dar de baja la cuenta.");
		}else {
			System.out.println("Escriba su alias para confirmar que quiere dar de baja la cuenta: ");
			String alias = Inicio.sc.next();
			if(Inicio.sesion.equals(alias)) {
				for(Usuario u : Inicio.listaUsuarios) {
					if(u.getAliasUsuario().equals(alias)) {
						Inicio.listaUsuarios.remove(u);
						Inicio.sesion = "";
						System.out.println("La baja del usuario se ha hecho correctamente.");
						break;
					}
				}
			}else {
				System.out.println("No puede realizarse la baja de un usuario no logado.");
			}
		}		
		
	}
	
	public void modificarUsuarioXAlias() {
		
		if(Inicio.sesion.isBlank()) {
			System.out.println("Debe haber iniciado sesión para poder modificar su contraseña.");
		}else {			
			Usuario uAuxiliar = new Usuario();
			for(Usuario u : Inicio.listaUsuarios) {
				if(u.getAliasUsuario().equals(Inicio.sesion)) {
					uAuxiliar = u;
					break;
				}
			}
			System.out.println("Informe su contraseña anterior.");
			String contraseniaActual = Inicio.sc.next();
			if(uAuxiliar.getClaveUsuario().equals(contraseniaActual)) {
				System.out.println("Informe la nueva contraseña.");
				String contraseniaNueva = Inicio.sc.next();
				uAuxiliar.setClaveUsuario(contraseniaNueva);
				System.out.println("La contraseña se ha modificado correctamente.");
			}else {
				System.out.println("La contraseña actual no es correcta.");
			}

		}		
		
	}
	
	public void listarUsuarios() {
		
		for(Usuario u : Inicio.listaUsuarios) {
			System.out.println(u.toString());
		}
		
	}
	
	public void listarUsuariosAdministradores() {
		
		for(Usuario u : Inicio.listaUsuarios) {
			if(u.isEsAdministradorUsuario()) {
				System.out.println(u.toString());
			}
		}
		
	}
	
	public void listarUsuariosNormales() {
		
		for(Usuario u : Inicio.listaUsuarios) {
			if(!u.isEsAdministradorUsuario()) {
				System.out.println(u.toString());
			}
		}
		
	}

}
