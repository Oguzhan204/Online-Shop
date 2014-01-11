package de.shop.bestellverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

/**
 * @author <a href="mailto:oguzhan.atmaca@web.de">Oguzhan Atmaca</a>
 */
@Log
public class BestellungServiceImpl implements BestellungService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -519454062519816252L;

	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@Inject
	@NeueBestellung
	private transient Event<Bestellung> event;
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
	
	/**
	 * {inheritDoc}
	 */
	@Override
	public Bestellung findBestellungById(Long id) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungById(id);
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public List<Bestellung> findBestellungenByKunde(Kunde kunde) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungenByKunde(kunde);
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public Bestellung createBestellung(Bestellung bestellung, Kunde kunde, Locale locale) {
		// TODO Datenbanzugriffsschicht statt Mock
		bestellung = Mock.createBestellung(bestellung, kunde);
		event.fire(bestellung);
		
		return bestellung;
	}
}