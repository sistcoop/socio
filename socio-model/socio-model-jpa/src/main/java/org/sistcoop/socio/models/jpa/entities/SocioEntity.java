package org.sistcoop.socio.models.jpa.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.sistcoop.socio.models.enums.TipoPersona;

@Entity
@Table(name = "SOCIO")
public class SocioEntity implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String id;

    private TipoPersona tipoPersona;
    private String tipoDocumento;
    private String numeroDocumento;

    /**
     * El representante legal siempre es una persona natural
     */
    private String tipoDocumentoRepresentanteLegal;
    private String numeroDocumentoRepresentanteLegal;

    private Date fechaInicio;
    private Date fechaFin;

    /**
     * Si el estado es false significa que el socio ya no es socio de la
     * institucion
     */
    private boolean estado;

    private CuentaAporteEntity cuentaAporte;

    private Set<CuentaPersonalEntity> cuentasPersonales = new HashSet<CuentaPersonalEntity>();

    private Timestamp version;

    public SocioEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public TipoPersona getTipoPersona() {
        return this.tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @NotNull
    @Size(min = 1, max = 20)
    @NotEmpty
    @NotBlank
    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @NotNull
    @Size(min = 1, max = 20)
    @NotBlank
    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Size(min = 1, max = 20)
    public String getTipoDocumentoRepresentanteLegal() {
        return this.tipoDocumentoRepresentanteLegal;
    }

    public void setTipoDocumentoRepresentanteLegal(String tipoDocumentoRepresentanteLegal) {
        this.tipoDocumentoRepresentanteLegal = tipoDocumentoRepresentanteLegal;
    }

    @Size(min = 1, max = 20)
    public String getNumeroDocumentoRepresentanteLegal() {
        return this.numeroDocumentoRepresentanteLegal;
    }

    public void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
        this.numeroDocumentoRepresentanteLegal = numeroDocumentoRepresentanteLegal;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "ESTADO")
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey)
    public CuentaAporteEntity getCuentaAporte() {
        return cuentaAporte;
    }

    public void setCuentaAporte(CuentaAporteEntity cuentaAporte) {
        this.cuentaAporte = cuentaAporte;
    }

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)
    public Set<CuentaPersonalEntity> getCuentasPersonales() {
        return cuentasPersonales;
    }

    public void setCuentasPersonales(Set<CuentaPersonalEntity> cuentasPersonales) {
        this.cuentasPersonales = cuentasPersonales;
    }

    @Version
    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
        result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
        result = prime * result + ((tipoPersona == null) ? 0 : tipoPersona.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SocioEntity))
            return false;
        SocioEntity other = (SocioEntity) obj;
        if (numeroDocumento == null) {
            if (other.numeroDocumento != null)
                return false;
        } else if (!numeroDocumento.equals(other.numeroDocumento))
            return false;
        if (tipoDocumento == null) {
            if (other.tipoDocumento != null)
                return false;
        } else if (!tipoDocumento.equals(other.tipoDocumento))
            return false;
        if (tipoPersona != other.tipoPersona)
            return false;
        return true;
    }

}