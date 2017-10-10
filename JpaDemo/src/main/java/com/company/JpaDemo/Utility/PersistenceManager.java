package com.company.JpaDemo.Utility;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.fabric.xmlrpc.base.Data;

public class PersistenceManager {

	private final Logger LOGGER  = Logger.getLogger(PersistenceManager.class.getName());
	
	private static EntityManagerFactory EMF;
	
	private static final String PERSISTENCE_UNIT = "jpa-example";
	
	private static final PersistenceManager singleton  = new PersistenceManager();
	
	private PersistenceManager() {}
	
	public static PersistenceManager getInstance()
	{
		return singleton;
	}
	
	public EntityManagerFactory getEntityManagerFactory()
	{
		if(EMF==null)
		{
			EMF = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			LOGGER.info("EntityManagerFacoty instance was created on : "+new Data());
		}
		return EMF;
	}
	
	public void closeEMF()
	{
		if(EMF !=null || EMF.isOpen())
		{
			EMF.close();
			LOGGER.info("EntityManagerFactory was closed on : "+new Data());
		}
		EMF = null;
		
	}
}
