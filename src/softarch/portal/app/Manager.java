package softarch.portal.app;

import softarch.portal.db.abs.DatabaseFacade;

/**
 * This class is an abstract superclass for all <i>managers</i>.
 * @author Niels Joncheere
 */
public abstract class Manager {
	protected DatabaseFacade dbFacade;
}
