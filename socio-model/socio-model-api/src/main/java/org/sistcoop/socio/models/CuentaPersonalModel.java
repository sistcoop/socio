package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;

public interface CuentaPersonalModel extends Model {

    String getId();

    TipoCuentaPersonal getTipoCuenta();

    String getNumeroCuenta();

    String getMoneda();

    Date getFechaApertura();

    Date getFechaCierre();

    void setFechaCierre(Date fechaCierre);

    BigDecimal getSaldo();

    void setSaldo(BigDecimal saldo);

    int getCantidadRetirantes();

    EstadoCuentaPersonal getEstado();

    void setEstado(EstadoCuentaPersonal estadoCuenta);

    SocioModel getSocio();

    List<TitularModel> getTitulares();

    List<AutorizadoModel> getAutorizados();

    List<BeneficiarioModel> getBeneficiarios();

    List<TasaCuentaPersonalModel> getTasas();

}
