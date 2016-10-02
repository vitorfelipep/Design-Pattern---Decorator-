package com.vitch.cobranca.service;

import java.time.YearMonth;

import com.vitch.cobranca.exception.RiscoCreditoException;
import com.vitch.cobranca.model.CartaoCredito;
import com.vitch.cobranca.model.Cliente;

public class AnalisadorDeRiscoClearSale implements AutorizadorCartaoDeCredito {

	private AutorizadorCartaoDeCredito autorizador;

	public AnalisadorDeRiscoClearSale(AutorizadorCartaoDeCredito autorizador) {
		this.autorizador = autorizador;
	}

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		if(cliente.getCpf().startsWith("111") || cartaoCredito.getVencimento().isBefore(YearMonth.now())
				|| valor > 500) {
			throw new RiscoCreditoException("Possivel fraude, negando pagamento");
		}
		this.autorizador.autorizar(cliente, cartaoCredito, valor);
		
	}

}
