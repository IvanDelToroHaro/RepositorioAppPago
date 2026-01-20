package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import controladores.Inicio;

/**
 * 
 */
public class Usuario {	
	
	public Usuario() {
		super();
		this.idUsuario = Inicio.ultimoIdUsuario + 1;
		Inicio.ultimoIdUsuario = this.idUsuario;
	}

	//Atributos
	private int idUsuario;
	private String aliasUsuario;
	private String nombreUsuario;
	private String apellidosUsuario;
	private String dniUsuario;
	private int telefonoUsuario;
	private String emailUsuario;
	private String claveUsuario;
	private boolean esAdministradorUsuario = false;
	private LocalDateTime fechaAltaUsuario = LocalDateTime.now();
	private LocalDate fechaNacimientoUsuario;
	
	//Getters y Setters
	
	public int getIdUsuario() {
		return idUsuario;
	}	

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getAliasUsuario() {
		return aliasUsuario;
	}
	public void setAliasUsuario(String aliasUsuario) {
		this.aliasUsuario = aliasUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	public String getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	public int getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(int telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getClaveUsuario() {
		return claveUsuario;
	}
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	public boolean isEsAdministradorUsuario() {
		return esAdministradorUsuario;
	}
	public void setEsAdministradorUsuario(boolean esAdministradorUsuario) {
		this.esAdministradorUsuario = esAdministradorUsuario;
	}
	public LocalDateTime getFechaAltaUsuario() {
		return fechaAltaUsuario;
	}
	public void setFechaAltaUsuario(LocalDateTime fechaAltaUsuario) {
		this.fechaAltaUsuario = fechaAltaUsuario;
	}
	public LocalDate getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}
	public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", aliasUsuario=" + aliasUsuario + ", nombreUsuario=" + nombreUsuario
				+ ", apellidosUsuario=" + apellidosUsuario + ", dniUsuario=" + dniUsuario + ", telefonoUsuario="
				+ telefonoUsuario + ", emailUsuario=" + emailUsuario + ", claveUsuario=" + claveUsuario
				+ ", esAdministradorUsuario=" + esAdministradorUsuario + ", fechaAltaUsuario=" + fechaAltaUsuario
				+ ", fechaNacimientoUsuario=" + fechaNacimientoUsuario + "]";
	}	
	
}
