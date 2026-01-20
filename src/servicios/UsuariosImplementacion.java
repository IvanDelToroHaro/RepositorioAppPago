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
		
		/*System.out.println("Escriba su alias (no puede tener espacios): ");
		nuevoUsuario.setAliasUsuario(Inicio.sc.next());
		
		System.out.println("Escriba su nombre: ");
		nuevoUsuario.setNombreUsuario(Inicio.sc.next());
		
		Inicio.sc.nextLine();
		System.out.println("Escriba sus apellidos: ");		
		nuevoUsuario.setApellidosUsuario(Inicio.sc.nextLine());
		
		//System.out.println("Escriba su teléfono: ");
		
		 int telefono;

	        do {
	            System.out.println("Introduce un numero de telefono (9 digitos): ");
	            telefono = Inicio.sc.nextInt();
	        } while (telefono < 100000000 || telefono > 999999999);

	        System.out.println("Telefono valido: +34 " + telefono);
			nuevoUsuario.setTelefonoUsuario(telefono);
		
			
			//email
		String email;
		boolean emailValido;

		do {
		    System.out.println("Escriba su email: ");
		    email = Inicio.sc.next();

		    if (validarEmail(email)) {
		        emailValido = true;
		    } else {
		        System.out.println("Email no válido. Debe contener @ y un punto después del @");
		        emailValido = false;
		    }

		} while (!emailValido);

		nuevoUsuario.setEmailUsuario(email);
		
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
		
		//Dividir fecha en año, meses y dias
		System.out.println("Escriba su fecha de nacimiento (dd-MM-yyyy): ");
		String fechaFormato = Inicio.sc.next();
		String[] fechaDividida = fechaFormato.split("-");
		nuevoUsuario.setFechaNacimientoUsuario(LocalDate.of(Integer.parseInt(fechaDividida[2]), Integer.parseInt(fechaDividida[1]), Integer.parseInt(fechaDividida[0])));
		*/
		//Validación del dni
		String dni;
        boolean valido= true;

        do {
            System.out.println("Introduce un DNI (8 numeros y 1 letra): ");
            dni = Inicio.sc.next().toUpperCase();
            // Comprobar formato
            if (!dni.matches("\\d{8}[A-Z]")) {
                valido = false;
                System.out.println("DNI Mal introducido");
            } else {
                int numero = Integer.parseInt(dni.substring(0, 8));
                char letraIntroducida = dni.charAt(8);
                char letraCorrecta = Inicio.LETRAS.charAt(numero % 23);

                if (letraIntroducida != letraCorrecta) {
                    valido = false;
                }
            }

        } while (!valido);

        System.out.println("DNI valido: " + dni);
        nuevoUsuario.setDniUsuario(dni);
	}
	
	public static boolean validarEmail(String email) {
	    return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
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
						break;
					}
				}
			}
		}
	}
}