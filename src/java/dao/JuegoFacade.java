/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Juego;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirtza Verdugo
 */
@Stateless
public class JuegoFacade extends AbstractFacade<Juego> {

    @PersistenceContext(unitName = "kgamesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuegoFacade() {
        super(Juego.class);
    }
    
}
