package com.unab.app.service.interfaces;

import java.util.List;

import com.unab.app.models.DetalleFactura;

public interface IDetalleFacturaService {
	public void save(DetalleFactura detalleFactura);

	public List<DetalleFactura> findByIDFacturaAndByIdProducto(Long id_factura, Long id_producto);
	
	public List<DetalleFactura> findByIDFactura(Long id_factura);
}
