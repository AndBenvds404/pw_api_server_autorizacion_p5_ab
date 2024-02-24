package com.example.api_server_autorizacion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.api_server_autorizacion.repository.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepository{

    @PersistenceContext 
    private EntityManager entityManager;

    @Override
    public Usuario consultarPorNomnbre(String nombre) {
        // TODO Auto-generated method stub
        //TypedQuery<Usuario> mTypedQuery = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:nombre" ,Usuario.class);
        //TypedQuery.setParameter("nombre", nombre);
        Usuario usua = new Usuario();
        usua.setId(1);
        usua.setNombre(nombre);
        usua.setPassword("$2a$12$KzajltJHXcMQKDRDjlkdSOlXH8odMhym0TGJRLBVlUrn7TmEKBusG");
        return usua;
    }
    
}
