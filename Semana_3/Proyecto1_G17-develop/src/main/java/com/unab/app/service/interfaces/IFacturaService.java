package com.unab.app.service.interfaces;

import java.util.List;

import com.unab.app.models.Factura;

public interface IFacturaService {
	public void save(Factura factura);
	public Factura findFacturaById(Long id);
	public void deleteFactura(Long id);
	public List<Factura> fetchByIdClienteWithFactura(Long id);
	public void updateFactura(Long idFactura, Long idProducto);
}
