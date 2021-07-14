package br.com.lojacar.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja"); //mostrar para jpa em qual banco irá se conectar
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager(); //cria objeto do tipo entity manager
	}
}
