package com.unab.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.app.models.DetalleFactura;
import com.unab.app.models.Factura;
import com.unab.app.service.interfaces.IDetalleFacturaService;
import com.unab.app.service.interfaces.IFacturaService;

@RestController
@RequestMapping(value = "/detalleFactura")
public class DetalleFacturaController {
	@Autowired
	private IDetalleFacturaService detalleFacturaService;
	
	@Autowired
	private IFacturaService facturaService;

	@PostMapping("/save")
	public DetalleFactura save(@RequestBody DetalleFactura detalleFactura) {
		Factura factura=detalleFactura.getFactura();
		Long valor=detalleFactura.getCantidad()*detalleFactura.getProducto().getPrecio();
		factura.setValorTotal(valor);
		facturaService.save(factura);
		detalleFacturaService.save(detalleFactura);
		return detalleFactura;
	}

	@GetMapping("/getDetail/{idFactura}/{idProducto}")
	public List<DetalleFactura> findByIDFacturaAndByIdProducto(@PathVariable("idFactura") Long idFactura,
			@PathVariable("idProducto") Long idProducto) {
		return detalleFacturaService.findByIDFacturaAndByIdProducto(idFactura, idProducto);
	}

	@GetMapping("/getDetail/{idFactura}")
	public List<DetalleFactura> findByIDFactura(@PathVariable("idFactura") Long idFactura) {
		return detalleFacturaService.findByIDFactura(idFactura);
	}
}
