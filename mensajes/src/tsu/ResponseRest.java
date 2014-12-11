package tsu;

public class ResponseRest {
	
	String id_transaccion;
	String tipo_transaccion;
	String idUsuario;
	String sistemaOrigen;
	String subsistema;
	String perfilOrigen;
	String filename;
	String registros;
	String Exception;
	String mensajeError;
	String mensajeTecnico;
	
	public String getId_transaccion() {
		return id_transaccion;
	}
	public void setId_transaccion(String id_transaccion) {
		this.id_transaccion = id_transaccion;
	}
	public String getTipo_transaccion() {
		return tipo_transaccion;
	}
	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getSistemaOrigen() {
		return sistemaOrigen;
	}
	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}
	public String getSubsistema() {
		return subsistema;
	}
	public void setSubsistema(String subsistema) {
		this.subsistema = subsistema;
	}
	public String getPerfilOrigen() {
		return perfilOrigen;
	}
	public void setPerfilOrigen(String perfilOrigen) {
		this.perfilOrigen = perfilOrigen;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRegistros() {
		return registros;
	}
	public void setRegistros(String registros) {
		this.registros = registros;
	}
	public String getException() {
		return Exception;
	}
	public void setException(String exception) {
		Exception = exception;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}
	
	

}
