package com.rafaelcosta.cursomc.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rafaelcosta.cursomc.domain.Cep;

@Service
public class CepService {
	public String obterCep(String cep) {
		
		String baseUrl = String.format("https://viacep.com.br/ws/%s/json/", cep) ;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> resp = restTemplate.getForEntity(baseUrl, Object.class);
		
		return String.format("Cep: %s", resp.getBody().toString());
	}
	
//public Cep obterCep(String cep) {
//		
//		String baseUrl = String.format("https://viacep.com.br/ws/%s/json/", cep) ;
//		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Cep> resp = restTemplate.getForEntity(baseUrl, Cep.class);
//		
//		return resp.getBody();
//	}

}
