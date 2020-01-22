package br.com.victoria.exToken.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.victoria.exToken.model.Produto;
import br.com.victoria.exToken.security.Autenticador;

@RestController
@CrossOrigin("*")
public class produtoController {

	@GetMapping("/produto/todos")
	public ResponseEntity<ArrayList<Produto>> getTodosProd(@RequestParam String token){
		if(Autenticador.isValid(token)) {
			ArrayList<Produto> lista = new ArrayList<Produto>();
			for(int i = 0; i <20;i++) {
				Produto p = new Produto();
				p.setCodigo((i+211)+125489);
				p.setTitulo("Produto muito bom");
				p.setPreco((i+2)+11.50f);
				p.setDetalhes("muitos detalhes bons desse produto que tem "+ i +" coisas muito legais");
				
				lista.add(p);
			}
			return ResponseEntity.ok(lista);
		}
		else {
			return ResponseEntity.status(403).build();
		}
	}
}
