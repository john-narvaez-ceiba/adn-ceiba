package com.ceiba.manejador;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface ManejadorComando<C> {

	@Transactional
	void ejecutar(C comando) throws IOException;
}