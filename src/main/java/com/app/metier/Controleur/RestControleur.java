package com.app.metier.Controleur;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.metier.Service.RestService;
import com.app.metier.entities.Connexion;
import com.app.metier.entities.Dates;
import com.app.metier.entities.Majournee;
import com.app.metier.entities.Position;
import com.app.metier.entities.SoldeDebuterJournee;
import com.app.metier.entities.Transaction;
import com.app.metier.entities.Utilisateur;
import com.app.metier.entities.history;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class RestControleur {
    @Autowired
    private RestService service;
    
    //GET ALL ELEMENTS ok
    public static final  String ALL_USERS = "/utilisateurs";
    public static final  String ALL_DATES = "/dates";
    public static final  String ALL_SOLDE_DEBUTER_JOURNEES = "/soldeDebuterJournees";
    public static final  String ALL_TRANSACTIONS = "/transactions";
    
    //GET ONE ELEMENT ok
    public static final  String GET_USER_ID = "/utilisateurs/{id}";
    public static final  String GET_SOLDE_DEBUTER_JOURNEE_ID = "/soldeDebuterJournees/{id}";
    public static final  String GET_TRANSACTION_ID = "/transactions/{id}";
    
    //MODIFIED ONE ELEMENT ok
    public static final  String PUT_USER_ID = "/utilisateurs/modifier/{id}";
    public static final  String PUT_SOLDE_DEBUTER_JOURNEE_ID = "/soldeDebuterJournees/modifier/{id}";
    public static final  String PUT_TRANSACTION_ID = "/transactions/modifier/{id}";
    
    //DELETED ONE ELEMENT ok
    public static final  String DELETE_USER_ID = "/utilisateurs/modifier/{id}";
    public static final  String DELETE_SOLDE_DEBUTER_JOURNEE_ID = "/soldeDebuterJournees/modifier/{id}";
    public static final  String DELETE_TRANSACTION_ID = "/transactions/modifier/{id}";
    
    //ADD ONE ELEMENT ok
    public static final  String ADD_USER = "/utilisateurs/ajouter";
    public static final  String ADD_SOLDE_DEBUTER_JOURNEE = "/soldeDebuterJournees/ajouter";
    public static final  String ADD_TRANSACTION = "/transactions/ajouter";
    
    //TASKS MANAGER
    public static final  String GET_SOLDE_DEBUTER_JOURNEE_TOTAL_DEC_CAISSIER_ID = "/soldeDebuterJournees/totalDecaissement/caissier/{idU}";
    public static final  String GET_SOLDE_DEBUTER_JOURNEE_CAISSIER_ID = "/soldeDebuterJournees/caissier/{idU}";
    public static final  String GET_SOLDE_DEBUTER_JOURNEE_TOTAL_ENC_CAISSIER_ID = "/soldeDebuterJournees/totalEncaissement/caissier/{idU}";
    public static final  String GET_SOLDE_DEBUTER_JOURNEE_TOTAL_FRAIS_CAISSIER_ID = "/soldeDebuterJournees/totalFrais/caissier/{idU}";
    public static final  String GET_MA_JOURNEE_CAISSIER_ID = "/maJournee/caissier/{idU}";

   //LA PARTIE TRAITEMENT DES DONNEES
    public static final  String DO_AUTHENTIFICATION = "/authentification";
    public static final  String DO_CLOTURER = "/cloturer/{id}/{somme}";
    public static final  String GET_SOMME_FINALE_CAISSIER_ID = "/sommeFinale/{id}";
    public static final  String GET_TOTAL_SORTIE_CAISSIER_ID = "/totalSortie/{id}";
    public static final  String GET_TOTAL_ENTREE_CAISSIER_ID = "/totalEntree/{id}";
    public static final  String GET_SOMME_INITIALE_CAISSIER_ID = "/sommeInitiale/{id}";
    public static final  String GET_TOTAL_DEC_CAISSIER_ID = "/totalDecaissement/{id}";
    public static final  String GET_TOTAL_ENC_CAISSIER_ID = "/totalEncaissement/{id}";
    public static final  String GET_TOTAL_COMMISSION_CAISSIER_ID = "/totalCommission/{id}";
    public static final  String GET_TOTAL_FRAIS_CAISSIER_ID = "/totalFrais/{id}";
    public static final  String GET_POSITION_CAISSIER_STATUS = "/position/status/{status}";
    public static final  String GET_POSITION_CAISSIER_ID = "/position/id/{id}";
    public static final  String GET_POSITION_CAISSIER_ID_STATUS = "/position/{id}/{status}";
    public static final  String GET_ALL_TRANSACTIONS_CAISSIER_ID = "/transactions/caissier/{id_caissier}";
    public static final  String GET_HISTORIQUE_TRANSACTIONS_CAISSIER_ID = "/transactions/caissier/historiques";
    public static final  String DO_TRIER_ID_OPERATEUR = "/trier/caissier/{id}/{operateur}";
    public static final  String DO_SEARCH_CAISSIER_ID_RECHERCHE_SENS = "/transactions/caissier/{id}/recherche/sens/{sens}";
    public static final  String DO_SEARCH_CAISSIER_ID_RECHERCHE_OPERATEUR ="/transactions/caissier/{id}/recherche/operateur/{operateur}";
    public static final  String DO_SEARCH_CAISSIER_ID_RECHERCHE_OPERATEUR_SENS ="/transactions/caissier/{id}/recherche/operateur/{operateur}/sens/{sens}";
   
   
	@GetMapping(ALL_DATES)
    public List<Dates> listeDate() {
		return service.getAllDates();
	}
                     
	   //LA PARTIE CRUD DE UTILISATEUR    
    
    @GetMapping("/utilisateurs")
    public List<Utilisateur> listeUtilisateurs() {
        return service.getAllUsers();
    }
    @GetMapping(GET_USER_ID)
    public Utilisateur getUsersById(@PathVariable(value = "id") int userId) {   
        return service.getUsersById(userId);
    }
    
    @PostMapping(ADD_USER)
    public Utilisateur createUser( @RequestBody Utilisateur user) {
        return service.createUser(user);
    }
    
    @PutMapping(PUT_USER_ID)
    public Utilisateur updateUser( @PathVariable(value = "id") int userId, @RequestBody Utilisateur userDetails) {
        return service.updateUser(userId, userDetails);
    }
    @DeleteMapping(DELETE_USER_ID)
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId) {
        return service.deleteUser(userId);
    }
    
    //LA PARTIE CRUD DE SOLDEDEBUTERJOURNEE  
    @GetMapping(GET_SOLDE_DEBUTER_JOURNEE_CAISSIER_ID)
    public List<SoldeDebuterJournee> getSoldeDebuterJournees(@PathVariable(value = "idU") int userId) {
        return service.getSoldeDebuterJournees(userId);
    }

    @GetMapping(GET_SOLDE_DEBUTER_JOURNEE_TOTAL_ENC_CAISSIER_ID)
    public SoldeDebuterJournee gettotalEncaissement(@PathVariable(value = "idU") int userId) {
        return service.getTotalEncaissementOperateur(userId);
    }
    @GetMapping(GET_SOLDE_DEBUTER_JOURNEE_TOTAL_DEC_CAISSIER_ID)
    public SoldeDebuterJournee gettotaldecaissement(@PathVariable(value = "idU") int userId) {
        return service.getTotalDecaissementOperateur(userId);
    }
    @GetMapping(GET_SOLDE_DEBUTER_JOURNEE_TOTAL_FRAIS_CAISSIER_ID)
    public SoldeDebuterJournee gettotalfrais(@PathVariable(value = "idU") int userId) {
        return service.getTotalFraisOperateur(userId);
    }
    @GetMapping(ALL_SOLDE_DEBUTER_JOURNEES)
    public List<SoldeDebuterJournee>getAllSoldeDebuterJournees() {
        return service.getAllSoldeDebuterJournees();
    }
    @GetMapping(GET_SOLDE_DEBUTER_JOURNEE_ID)
    public SoldeDebuterJournee getSoldeDebuterJourneesById(@PathVariable(value = "id") int userId) {
        return service.getSoldeDebuterJourneesById(userId);
    }
    
    @GetMapping(GET_MA_JOURNEE_CAISSIER_ID)
    public List<Majournee> getMJourneesById(@PathVariable(value = "idU") int userId) {
        return service.getMajourneesById(userId);
    }
    
    @PostMapping(ADD_SOLDE_DEBUTER_JOURNEE)
    public SoldeDebuterJournee createSoldeDebuterJournee( @RequestBody SoldeDebuterJournee user) {
        return service.createSoldeDebuterJournee(user);
    }
    
    @PutMapping(PUT_SOLDE_DEBUTER_JOURNEE_ID)
    public SoldeDebuterJournee updateSoldeDebuterJournee(@PathVariable(value = "id") int userId,  @RequestBody SoldeDebuterJournee ad){
    	service.updateMajournee(userId,ad);
    	return service.updateSoldeDebuterJournee(userId, ad);
    }
    @DeleteMapping(DELETE_SOLDE_DEBUTER_JOURNEE_ID)
    public Map<String, Boolean> deleteSoldeDebuterJournee(@PathVariable(value = "id") int userId) {
    	
        return service.deleteSoldeDebuterJournee(userId);
    }
    
  //LA PARTIE CRUD DE TRANSACTION  
    @GetMapping(ALL_TRANSACTIONS)
    public List<Transaction>getAllTransactions() {
        return service.getAllTransactions();
    }
    @GetMapping(GET_TRANSACTION_ID)
    public Transaction getTransactionById(@PathVariable(value = "id") int userId){
        return service.getTransactionById(userId);
    }
    
    @PostMapping(ADD_TRANSACTION)
    public void createTransactions( @RequestBody Transaction user) {
    	service.createTransactions(user);
    }
    
    @PutMapping(PUT_TRANSACTION_ID)
    public Transaction updateTransactions(@PathVariable(value = "id") int userId,  @RequestBody Transaction ad){   
        return service.updateTransactions(userId, ad);
    }
    @DeleteMapping(DELETE_TRANSACTION_ID)
    public Map<String, Boolean> deleteTransactions(@PathVariable(value = "id") int userId) throws Exception { 	
        return service.deleteTransactions(userId);
    }
    
    
    //LA PARTIE TRAITEMENT DES DONNEES
    @PostMapping(DO_AUTHENTIFICATION)
    public Utilisateur seConnecter( @RequestBody Connexion con){	
    	return service.seConnecter(con) ;
     }
    @PostMapping(DO_CLOTURER)
    public double cloturer( @PathVariable(value="id") int id, @PathVariable(value="somme") double con){	
    	return service.cloturer(id, con);
     }
    @GetMapping(GET_SOMME_FINALE_CAISSIER_ID)
    public double sommeFinale(@PathVariable(value="id") int id){
    	return service.sommeFinale(id) ;
     }
    @GetMapping(GET_TOTAL_SORTIE_CAISSIER_ID)
    public double totalSortie(@PathVariable(value="id") int id){
    	return service.totalSortie(id);
     }
    @GetMapping(GET_TOTAL_ENTREE_CAISSIER_ID)
    public double totalEntree(@PathVariable(value="id") int id){
    	return service.totalEntree(id);
     }

    @GetMapping(GET_SOMME_INITIALE_CAISSIER_ID)
    public double sommeInitiale(@PathVariable(value="id") int id){
    	return service.sommeInitiale(id);
     }
    @GetMapping(GET_TOTAL_DEC_CAISSIER_ID)
    public double totalDecaissement(@PathVariable(value="id") int id){
    	return service.totalDecaissement(id);
     }
    @GetMapping(GET_TOTAL_ENC_CAISSIER_ID)
    public double totalEncaissement(@PathVariable(value="id") int id){
    	return service.totalEncaissement(id);
     }
    @GetMapping(GET_POSITION_CAISSIER_ID_STATUS)
    public  List<Position> position(@PathVariable(value="id") int id,@PathVariable(value="status") boolean status){
    	return service.getPositionByIdUAndStatus(id, status);
     }
    @GetMapping(GET_POSITION_CAISSIER_ID)
    public  List<Position> position(@PathVariable(value="id") int id){
    	return service.getPositionByIdU(id);
     }
    @GetMapping(GET_POSITION_CAISSIER_STATUS)
    public List<Position> position(@PathVariable(value="status") boolean status){
    	return service.getPositionsByStatus(status);
     }
    @GetMapping(GET_TOTAL_FRAIS_CAISSIER_ID)
    public double totalFrais(@PathVariable(value="id1") int id1){
    	return service.totalFrais(id1);
     }
    @GetMapping(DO_TRIER_ID_OPERATEUR)
    public List<Transaction>listeTriParOperateur(@PathVariable(value="id") int id,@PathVariable( "operateur") String operateur){
    	return service.listeTriParOperateur(id, operateur);
    }
    @GetMapping(GET_ALL_TRANSACTIONS_CAISSIER_ID)
    public List<Transaction>listeTansactionParCassier(@PathVariable(value = "id_caissier") int id_caissier){
    	return service.listeTansactionParCassier(id_caissier);
    }
    @PostMapping(GET_HISTORIQUE_TRANSACTIONS_CAISSIER_ID)
    public List<Transaction>listeHistorique( @RequestBody history user){
    	return service.listeHistorique(user);
    }
    @GetMapping(DO_SEARCH_CAISSIER_ID_RECHERCHE_SENS)
    public List<Transaction>listeRehercherParSens(@PathVariable(value = "id") int id_caissier,@PathVariable("sens") String sens){
    	return service.listeRehercherParSens(id_caissier, sens);
    }
    @GetMapping(DO_SEARCH_CAISSIER_ID_RECHERCHE_OPERATEUR)
    public List<Transaction>listeRehercherParOperateur(@PathVariable(value = "id") int id_caissier,@PathVariable("operateur") String operation){
    	return service.listeRehercherParOperateur(id_caissier, operation);
    }
    @GetMapping(DO_SEARCH_CAISSIER_ID_RECHERCHE_OPERATEUR_SENS)
    public List<Transaction>listeRehercherParOperation(@PathVariable(value = "id") int id_caissier,@PathVariable("operateur") String operateur,@PathVariable("sens") String sens){
    	
    	return service.listeRehercherParSensOperateur(operateur,id_caissier,sens);
    }
    public void actionPlafonnementDeplafonnement(SoldeDebuterJournee solde,double ancienMontant,String nomOp) {
    	service.actionPlafonnementDeplafonnement(solde, ancienMontant, nomOp); 
    	
    }
    public void calculeActualiser(SoldeDebuterJournee solde,double ancienMontant,String nomOp) {
		service.calculeActualiser(solde, ancienMontant, nomOp);
		}	
    
    
}
