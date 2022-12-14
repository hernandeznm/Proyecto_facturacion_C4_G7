package com.unab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.app.models.Factura;
import com.unab.app.service.interfaces.IFacturaService;

@RestController
@RequestMapping(value = "/factura")
public class FacturaController {
	@Autowired
	private IFacturaService facturaService;

	@PostMapping("/save")
	public Factura save(@RequestBody Factura factura) {
		facturaService.save(factura);
		return factura;
	}

	@GetMapping("/getFacturaId/{id}")
	public Factura findFacturaById(@PathVariable("id") Long id) {
		return facturaService.findFacturaById(id);
	}

	@GetMapping("/deleteFactura/{id}")
	public void deleteFactura(@PathVariable("id") Long id) {
		facturaService.deleteFactura(id);
	}

	@GetMapping("/deleteFactura/{idFactura}/{idProducto}")
	public void updateFactura(@PathVariable("idFactura") Long ididFactura,
			@PathVariable("idProducto") Long idProducto) {
		facturaService.updateFactura(ididFactura, idProducto);
	}

}
