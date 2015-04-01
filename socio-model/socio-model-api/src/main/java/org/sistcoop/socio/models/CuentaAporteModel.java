package org.sistcoop.socio.models;

import java.math.BigDecimal;
import org.sistcoop.socio.models.enums.EstadoCuentaAporte;

public interface CuentaAporteModel extends Model {

	Long getId();

	String getNumeroCuenta();

	BigDecimal getSaldo();

	void setSaldo(BigDecimal saldo);

	String getMoneda();

	void setMoneda();

	EstadoCuentaAporte getEstadoCuenta();

	void setEstadoCuenta(EstadoCuentaAporte estadoCuenta);

	SocioModel getSocio();

}
