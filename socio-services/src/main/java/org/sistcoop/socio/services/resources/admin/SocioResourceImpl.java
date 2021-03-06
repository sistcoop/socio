package org.sistcoop.socio.services.resources.admin;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.sistcoop.socio.admin.client.resource.CuentasPersonalesResource;
import org.sistcoop.socio.admin.client.resource.SocioResource;
import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.CuentaAporteProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.representations.idm.CuentaAporteRepresentation;
import org.sistcoop.socio.representations.idm.SocioRepresentation;
import org.sistcoop.socio.services.managers.SocioManager;

@Stateless
public class SocioResourceImpl implements SocioResource {

    @PathParam("socio")
    private String socio;

    @Inject
    private SocioProvider socioProvider;

    @Inject
    private CuentaAporteProvider cuentaAporteProvider;

    @Inject
    private SocioManager socioManager;

    @Inject
    private CuentasPersonalesResource cuentasPersonalesResource;

    private SocioModel getSocioModel() {
        return socioProvider.findById(socio);
    }

    @Override
    public SocioRepresentation socio() {
        SocioRepresentation rep = ModelToRepresentation.toRepresentation(getSocioModel());
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void update(SocioRepresentation representation) {
        socioManager.update(getSocioModel(), representation);
    }

    @Override
    public void enable() {
        throw new NotFoundException();
    }

    @Override
    public void disable() {
        socioManager.disable(getSocioModel());
    }

    @Override
    public void remove() {
        throw new NotFoundException();
    }

    @Override
    public CuentaAporteRepresentation cuentaAporte() {
        CuentaAporteModel model = cuentaAporteProvider.findBySocio(getSocioModel());
        return ModelToRepresentation.toRepresentation(model);
    }

    @Override
    public CuentasPersonalesResource cuentasPersonales() {
        return cuentasPersonalesResource;
    }

}
