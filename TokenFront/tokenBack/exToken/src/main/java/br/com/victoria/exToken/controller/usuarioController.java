package br.com.victoria.exToken.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.victoria.exToken.model.Usuario;
import br.com.victoria.exToken.security.Autenticador;
import br.com.victoria.exToken.security.Token;

@RestController
@CrossOrigin("*")
public class usuarioController {
 @PostMapping("/login")
 public ResponseEntity<Token> autentica(@RequestBody Usuario usuario){
	 if(usuario.getEmail().equals("user@user.com")&& usuario.getSenha().equals("1234")) {
		 usuario.setId(1);
		 usuario.setNome("Victoria");
		 
		 String tk =  Autenticador.generateToken(usuario);
		 Token token = new Token();
		 token.setStrToken(tk);
		 return ResponseEntity.ok(token);
	 }
	 else {
		 return ResponseEntity.status(403).build();
	 }
 }
}
