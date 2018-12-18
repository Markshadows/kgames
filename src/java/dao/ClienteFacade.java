/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Miguel
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "kgamesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente login(String username, String password) {
        Cliente cl;
        Query query = em.createQuery("SELECT u FROM Cliente u WHERE u.username = :nombre and u.password = :contrasena");
        query.setParameter("nombre", username);
        query.setParameter("contrasena", password);
        if (query.getResultList().isEmpty()) {
            cl = null;
        } else {
            cl = (Cliente) query.getSingleResult();
        }
        
        return cl;
    }
    
}
