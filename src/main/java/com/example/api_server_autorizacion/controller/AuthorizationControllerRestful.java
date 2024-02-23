package com.example.api_server_autorizacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_server_autorizacion.security.JwtUtils;
import com.example.api_server_autorizacion.service.to.UsuarioTo;

@RestController
@RequestMapping("/autorizaciones")
@CrossOrigin
public class AuthorizationControllerRestful {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwt;

    @GetMapping("/jwt")
    public String obtenerToken(@RequestBody UsuarioTo usuarioTo){
        System.out.println(usuarioTo.getNombre() + "---------nombre");
        System.out.println(usuarioTo.getPassword() + "---------pass");
       
        this.autenticacion(usuarioTo.getNombre(), usuarioTo.getPassword());

        return this.jwt.builTokenJwt(usuarioTo.getNombre());
    }


    private void autenticacion(String usuario, String password){
        
        UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);
        Authentication autenticacion = this.authenticationManager.authenticate(usuarioToken);
        SecurityContextHolder.getContext().setAuthentication(autenticacion);
    }

}
