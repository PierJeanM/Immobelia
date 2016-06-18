package fr.adaming.ManagedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
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
public class ScheduleView {
 
	private ScheduleModel eventModel;
 
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	@Autowired
	private VisiteService visiteService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private BienImmobilierService bienImmobilierService;
	
	private Visite visite;
	
	private List<Client> listeClients;
	
	private List<BienImmobilier> listeBiens;
 
	public Visite getVisite() {
		return visite;
	}

	public void setVisite(Visite visite) {
		this.visite = visite;
	}

	public List<Client> getListeClients() {
		if (listeClients == null) {
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
			listeClients = clientService.getClientByIdConseiller(conseillerMB.getConseillerImmobilier().getId_personne());
		}
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

	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel(); // Nouveau schedule
		visite = new Visite();
		
		List<Visite> listVisites = visiteService.getAll(); // Recup des visites presentes dans la BDD
		listeBiens = bienImmobilierService.getAll();
		
		// Ajout des visites au schedule
		for (Visite v : listVisites) {
			Date dateVisite = v.getDateVisite();
			eventModel.addEvent(new DefaultScheduleEvent(v.getClient().getPrenom()+" "+v.getClient().getNom(), dateVisite, finVisite(dateVisite)));
		}
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
	 
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	 
	public ScheduleEvent getEvent() {
		return event;
	}
 
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	 
	public void addEvent(ActionEvent actionEvent) {
		System.out.println("ICICICICICICICI\n\n\n*********");
		if(event.getId() == null) {
			Date dateVisite = visite.getDateVisite();
			event = new DefaultScheduleEvent(visite.getClient().getPrenom()+ " "+visite.getClient().getNom(), dateVisite, finVisite(dateVisite));
			eventModel.addEvent(event);
		} else
			eventModel.updateEvent(event);
		 
		event = new DefaultScheduleEvent();
		visite = new Visite();
	}
	 
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}
	 
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}
	 
	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		 
		addMessage(message);
	}
	 
	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		 
		addMessage(message);
	}
	 
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}