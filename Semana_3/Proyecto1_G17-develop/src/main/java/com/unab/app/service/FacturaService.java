package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.app.dao.IFacturaDAO;
import com.unab.app.models.DetalleFactura;
import com.unab.app.models.Factura;
import com.unab.app.models.Producto;
import com.unab.app.service.interfaces.IDetalleFacturaService;
import com.unab.app.service.interfaces.IFacturaService;
import com.unab.app.service.interfaces.IProductoService;

@Service
public class FacturaService implements IFacturaService {

	@Autowired
	private IFacturaDAO facturaDao;

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IDetalleFacturaService detalleFacturaService;

	@Override
	public void save(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(new Factura());
	}

	@Override
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	public List<Factura> fetchByIdClienteWithFactura(Long id) {
		return facturaDao.fetchByIdClienteWithFactura(id);
	}

	@Override
	public void updateFactura(Long idFactura, Long idProducto) {
		Producto producto = productoService.findProductoById(idProducto);
		List<DetalleFactura> listDetalleFactura = detalleFacturaService.findByIDFacturaAndByIdProducto(idFactura,
				idProducto);

		System.out.println("Producto a actualizar: " + producto.getNombre());

		Factura factura = facturaDao.findById(idFactura).orElse(new Factura());

		listDetalleFactura.forEach(t -> {
			t.setCantidad(10);
			Long precio = t.getProducto().getPrecio();
			Integer cantidad = t.getCantidad();

			Long newValor = precio * cantidad;

			factura.setValorTotal(newValor);
			facturaDao.save(factura);
		});

		for (DetalleFactura d : listDetalleFactura) {
			System.out.println("For 1: " + d);
		}

		for (int i = 0; i < listDetalleFactura.size(); i++) {
			System.out.println("For 2: " + listDetalleFactura.get(i));
		}
	}

}
