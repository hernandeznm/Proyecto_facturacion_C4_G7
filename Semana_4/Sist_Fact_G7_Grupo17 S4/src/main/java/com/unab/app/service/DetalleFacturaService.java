package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.app.dao.IDetalleFacturaDAO;
import com.unab.app.models.DetalleFactura;
import com.unab.app.service.interfaces.IDetalleFacturaService;

@Service
public class DetalleFacturaService implements IDetalleFacturaService {

	@Autowired
	private IDetalleFacturaDAO detalleFacturaDao;

	@Override
	public void save(DetalleFactura detalleFactura) {
		detalleFacturaDao.save(detalleFactura);
	}

	@Override
	public List<DetalleFactura> findByIDFacturaAndByIdProducto(Long id_factura, Long id_producto) {
		return detalleFacturaDao.findByIDFacturaAndByIdProducto(id_factura, id_producto);
	}

	@Override
	public List<DetalleFactura> findByIDFactura(Long id_factura) {
		return detalleFacturaDao.findByIDFactura(id_factura);
	}

}
