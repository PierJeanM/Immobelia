package fr.adaming.ManagedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Visite;
import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.personne.Client;
import fr.adaming.service.BienImmobilierService;
import fr.adaming.service.ClientService;
import fr.adaming.service.VisiteService;
 
@ManagedBean
@ViewScoped
@Component
public class GestionCalendrierMB {
 
	private ScheduleModel eventModel;
 
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	@Autowired
	private VisiteService visiteService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private BienImmobilierService bienImmobilierService;
	
	private Visite visite;
	
	private Integer idClient;
	private Integer idBien;
	private Date date;
	
	private List<Client> listeClients;
	private List<BienImmobilier> listeBiens;
	private List<Visite> listeVisites;
	
	
	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel(); // Nouveau schedule
		visite = new Visite();
	}

	
	public void chargementVisites(){
		listeVisites = visiteService.getAll(); // Recup des visites presentes dans la BDD
		listeBiens = bienImmobilierService.getAll();
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		listeClients = clientService.getClientByIdConseiller(conseillerMB.getConseillerImmobilier().getId_personne());
		
		// Ajout des visites au schedule
		for (Visite v : listeVisites) {
			Date dateVisite = v.getDateVisite();
			DefaultScheduleEvent eventVisite = new DefaultScheduleEvent(v.getClient().getPrenom()+" "+v.getClient().getNom(), dateVisite, finVisite(dateVisite), v.getIdVisite());
			
			if(!containsVisite(v))
				eventModel.addEvent(eventVisite);
		}
	}
	
	
	private boolean containsVisite(Visite v){
		for (ScheduleEvent e : eventModel.getEvents())
			if (((Integer) e.getData()).equals(v.getIdVisite()))
				return true;
		return false;
	}
	
	
	/**
	 * Retourne la date de fin de visite (on considere qu'une visite dure une heure)
	 * @param dateVisite date de debut de visite
	 * @return
	 */
	private Date finVisite(Date dateVisite){
		Calendar cal = Calendar.getInstance(); // creates calendar
	    cal.setTime(dateVisite); // sets calendar time/date
	    cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
	    return cal.getTime(); // returns new date object, one hour in the future
	}
	 
	 
	/**
	 * Ajout d'une visite
	 * @param actionEvent
	 */
	public void addEvent(ActionEvent actionEvent) {
		
		if(event.getId() == null) {
			Client c = clientService.getById(idClient);
			BienImmobilier b = bienImmobilierService.getById(idBien);
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
			date = event.getStartDate();
			visite = new Visite(date, c, b, conseillerMB.getConseillerImmobilier());
			// Nouvelle visite, nouvel event
			visiteService.add(visite);
			event = new DefaultScheduleEvent(c.getPrenom()+ " "+c.getNom()+",\n"+b.getClasseStandard().getTypeBien()+" "+b.getAdresse(), date, finVisite(date), visite.getIdVisite());
			eventModel.addEvent(event);
		} else {
			// mise a jour d'une visite existante
			visiteService.update(visite);
			eventModel.deleteEvent(event);
			event = new DefaultScheduleEvent(visite.getClient().getPrenom()+ " "+visite.getClient().getNom()+",\n"+visite.getBienImmobilier().getClasseStandard().getTypeBien()+" "+visite.getBienImmobilier().getAdresse(), visite.getDateVisite(), finVisite(visite.getDateVisite()), visite.getIdVisite());
			eventModel.addEvent(event);
		}
		event = new DefaultScheduleEvent();
		visite = new Visite();
		idBien = null;
		idClient = null;
	}
	
	public void removeEvent(ActionEvent actionEvent){
		eventModel.deleteEvent(event);
		visiteService.remove(visite);
		event = new DefaultScheduleEvent();
		visite = new Visite();
	}
	
	/**
	 * méthode appelée quand on clique sur une visite dans le calendrier
	 * @param selectEvent
	 */
	public void onEventSelect(SelectEvent selectEvent) {
		event = (DefaultScheduleEvent) selectEvent.getObject();
		visite = visiteService.getById((Integer) event.getData());
	}
	
	/**
	 * méthode appelée quand on clique sur une date vide dans le calendrier
	 * @param selectEvent
	 */
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}
	

	public Visite getVisite() {
		return visite;
	}

	public void setVisite(Visite visite) {
		this.visite = visite;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdBien() {
		return idBien;
	}

	public void setIdBien(Integer idBien) {
		this.idBien = idBien;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	 
	public ScheduleEvent getEvent() {
		return event;
	}
 
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	
	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public List<BienImmobilier> getListeBiens() {
		return listeBiens;
	}

	public void setListeBiens(List<BienImmobilier> listeBiens) {
		this.listeBiens = listeBiens;
	}


	public List<Visite> getListeVisites() {
		return listeVisites;
	}


	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}
}