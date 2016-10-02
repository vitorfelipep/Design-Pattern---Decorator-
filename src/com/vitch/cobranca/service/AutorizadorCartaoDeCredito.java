package com.vitch.cobranca.service;

import com.vitch.cobranca.model.CartaoCredito;
import com.vitch.cobranca.model.Cliente;

public interface AutorizadorCartaoDeCredito {
	
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor);
}
