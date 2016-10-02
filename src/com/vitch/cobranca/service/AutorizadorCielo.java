package com.vitch.cobranca.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.vitch.cobranca.model.CartaoCredito;
import com.vitch.cobranca.model.Cliente;

public class AutorizadorCielo implements AutorizadorCartaoDeCredito {

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		try (PrintStream writer = new PrintStream(new FileOutputStream("debitos.txt", true))) {
			writer.println(cliente + " | " + cartaoCredito + " | R$" + valor);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Impossível salvar arquivo", e);
		}
	}

}
