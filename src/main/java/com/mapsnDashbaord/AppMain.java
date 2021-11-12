package com.mapsnDashbaord;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Commun;
import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.model.Region;
import com.mapsnDashbaord.service.ILocaliteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;

@SpringBootApplication
public class AppMain
        implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    private ILocaliteService iLocaliteService;
    private RepositoryRestConfiguration configuration;

    public AppMain(ILocaliteService iLocaliteService, RepositoryRestConfiguration configuration) {
        this.iLocaliteService = iLocaliteService;
        this.configuration = configuration;
    }

    @Override
    public void run(String... args) throws Exception {

        Region dakar = new Region("001", "DAKAR","dakar", 547, 3938358, 25.5, 55.6, "dakar detail", new ArrayList<>());
        Region thies = new Region("002", "THIES", "thies",6670, 2221097, 25.5, 55.6, "thies detail", new ArrayList<>());
        Region fatick = new Region("003", "FATICK","fatick", 6849, 932629, 25.5, 55.6, "fatick detail", new ArrayList<>());
        Region diourbel = new Region("004", "DIOURBEL","diourbel", 4824, 1919090, 25.5, 55.6, "diourbel detail", new ArrayList<>());
        Region Ziguinchor = new Region("005", "Ziguinchor ","ziguinchor", 7352, 706554, 25.5, 55.6, "Ziguinchor  detail",
                new ArrayList<>());
        Region kaolack = new Region("006", "KAOLOACK", "kaolack",5357, 1228746, 25.5, 55.6, "kaolack detail", new ArrayList<>());
        Region Kaffrine = new Region("007", "KAFFRINE ","kaffrine", 11262, 755172, 25.5, 55.6, "Kaffrine  detail", new ArrayList<>());
        Region Kedougou = new Region("008", "KEDOUGOU","kedougou",16800, 196991, 25.5, 55.6, "Kedougou  detail", new ArrayList<>());

        Region Tambacounda = new Region("009", "TAMBACOUNDA ","Tambacounda", 42364, 904032, 25.5, 55.6, "Tambacounda  detail",
                new ArrayList<>());
        Region Matam = new Region("0010", "MATAM", "matam",29445, 760588, 25.5, 55.6, "Matam detail", new ArrayList<>());
        Region Saint_Louis = new Region("0011", "ST LOUIS","St-Louis", 19241, 1120585, 25.5, 55.6, "Saint-Louis detail",
                new ArrayList<>());
        Region Sédhiou = new Region("0012", "SEDHIOU ","sedhiou", 7341, 591970, 25.5, 55.6, "Sédhiou  detail", new ArrayList<>());
        Region Louga = new Region("0013", "LOUGA ","louga", 24889, 1091268 , 25.5, 55.6, "Louga  detail", new ArrayList<>());
        Region Kolda = new Region("0014", "KOLDA ", "kolda",13771, 848348, 25.5, 55.6, "Kolda  detail", new ArrayList<>());
//Depatement
        // dakar department
        Departement dakardep = new Departement("001", "dakar", 10.2, 142, 25.5, 55.6, "dakar detail", dakar,
                new ArrayList<>());
        Departement Guédiawaye = new Departement("002", "Guédiawaye", 10.2, 142, 25.5, 55.6, "Guédiawaye detail", dakar,
                new ArrayList<>());
        Departement Pikine = new Departement("003", "dakar", 10.2, 142, 25.5, 55.6, "Pikine  detail", dakar,
                new ArrayList<>());
        Departement Rufisque = new Departement("004", "Rufisque", 10.2, 142, 25.5, 55.6, "Rufisque detail", dakar,
                new ArrayList<>());
        // Diourbel deapartment
        Departement diourbelDep = new Departement("005", "diourbel",10.2, 142, 25.5, 55.6, "diourbel detail", diourbel,
                new ArrayList<>());
        Departement Bambey = new Departement("006", "Bambey ",10.2, 142, 25.5, 55.6, "Bambey  detail", diourbel,
                new ArrayList<>());
        Departement Mbacké = new Departement("007", "Mbacké", 10.2, 142, 25.5, 55.6, "Mbacké detail", diourbel,
                new ArrayList<>());

        // fatick depatement
        Departement fatickdep = new Departement("008", "fatick", 10.2, 142, 25.5, 55.6, "fatick detail", fatick,
                new ArrayList<>());
        Departement Foundiougne = new Departement("009", "Foundiougne ", 10.2, 142, 25.5, 55.6, "Foundiougne  detail",
                fatick, new ArrayList<>());
        Departement Gossas = new Departement("0010", "Gossas ",10.2, 142, 25.5, 55.6, "Gossas  detail", fatick,
                new ArrayList<>());
// kaolack departement

        Departement kaolackdep = new Departement("0011", "Kaolack",10.2, 142, 25.5, 55.6, "Kaolack detail", kaolack,
                new ArrayList<>());
        Departement Guinguinéo = new Departement("0012", "Guinguinéo ", 10.2, 142, 25.5, 55.6, "Guinguinéo  detail",
                kaolack, new ArrayList<>());
        Departement Nioro_du_Rip = new Departement("0013", "Nioro du Rip ", 10.2, 142, 25.5, 55.6,
                "Nioro du Rip  detail", kaolack, new ArrayList<>());
        // kolda departement
        Departement koldadep = new Departement("0014", "Kolda",10.2, 142, 25.5, 55.6, "Kolda detail", Kolda,
                new ArrayList<>());
        Departement Vélingara = new Departement("0015", "Vélingara ",10.2, 142, 25.5, 55.6, "Vélingara  detail", Kolda,
                new ArrayList<>());
        Departement Médina_Yoro_Foulah = new Departement("0016", "Médina Yoro Foulah ", 10.2, 142, 25.5, 55.6,
                "Médina Yoro Foulah", Kolda, new ArrayList<>());

        // Louga departement
        Departement Lougadep = new Departement("0017", "Louga",10.2, 142, 25.5, 55.6, "Louga detail", Louga,
                new ArrayList<>());
        Departement Kébémer = new Departement("0018", "Kébémer ", 10.2, 142, 25.5, 55.6, "Kébémer  detail", Louga,
                new ArrayList<>());
        Departement Linguère = new Departement("0019", "Linguère  ", 10.2, 142, 25.5, 55.6, "Linguère", Louga,
                new ArrayList<>());

        // Matam departement
        Departement Matamdep = new Departement("0020", "Louga",10.2, 142, 25.5, 55.6, "Louga detail", Matam,
                new ArrayList<>());
        Departement Kanel = new Departement("0021", "Kanel ",10.2, 142, 25.5, 55.6, "Kanel  detail", Matam,
                new ArrayList<>());
        Departement Ranérou = new Departement("0022", "Ranérou  ", 10.2, 142, 25.5, 55.6, "Ranérou", Matam,
                new ArrayList<>());
        // Saint-Louis departement
        Departement Saint_Louisdep = new Departement("0023", "Saint-Louis", 10.2, 142, 25.5, 55.6, "Saint-Louis detail",
                Saint_Louis, new ArrayList<>());
        Departement Dagana = new Departement("0024", "Dagana ", 10.2, 142, 25.5, 55.6, "Dagana  detail", Saint_Louis,
                new ArrayList<>());
        Departement Podor = new Departement("0025", "Podor  ",10.2, 142, 25.5, 55.6, "Podor", Saint_Louis,
                new ArrayList<>());
//Tambacounda departement

        Departement Tambacoundadep = new Departement("0026", "Tambacounda", 10.2, 142, 25.5, 55.6, "Tambacounda detail",
                Tambacounda, new ArrayList<>());
        Departement Bakel = new Departement("0027", "Bakel ", 10.2, 142, 25.5, 55.6, "Bakel  detail", Tambacounda,
                new ArrayList<>());
        Departement Koumpentoum = new Departement("0028", "Koumpentoum  ",10.2, 142, 25.5, 55.6, "Koumpentoum",
                Tambacounda, new ArrayList<>());
        Departement Goudiry = new Departement("0029", "Goudiry  ", 10.2, 142, 25.5, 55.6, "Goudiry", Tambacounda,
                new ArrayList<>());
        // Thies departement

        Departement thiesdep = new Departement("0030", "thies",10.2, 142, 25.5, 55.6, "thies detail", thies,
                new ArrayList<>());
        Departement Mbour = new Departement("0031", "Mbour ",10.2, 142, 25.5, 55.6, "Mbour  detail", thies,
                new ArrayList<>());
        Departement Tivaouane = new Departement("0032", "Tivaouane  ", 10.2, 142, 25.5, 55.6, "Tivaouane", thies,
                new ArrayList<>());
        // Ziguinchor departement

        Departement Ziguinchordep = new Departement("0033", "Ziguinchor", 10.2, 142, 25.5, 55.6, "Ziguinchor detail",
                Ziguinchor, new ArrayList<>());
        Departement Bignogna = new Departement("0034", "Bignogna ", 10.2, 142, 25.5, 55.6, "Bignogna  detail",
                Ziguinchor, new ArrayList<>());
        Departement Oussouye = new Departement("0035", "Oussouye  ",10.2, 142, 25.5, 55.6, "Oussouye", Ziguinchor,
                new ArrayList<>());

        // Kaffrine departement

        Departement Kaffrinedep = new Departement("0036", "Kaffrine", 10.2, 142, 25.5, 55.6, "Kaffrine detail",
                Kaffrine, new ArrayList<>());
        Departement Birkilane = new Departement("0037", "Birkilane ",10.2, 142, 25.5, 55.6, "Birkilane  detail",
                Kaffrine, new ArrayList<>());
        Departement Malem_Hodar = new Departement("0038", "Malem-Hodar  ", 10.2, 142, 25.5, 55.6, "Malem-Hodar",
                Kaffrine, new ArrayList<>());
        Departement Kounghel = new Departement("0039", "Kounghel ", 10.2, 142, 25.5, 55.6, "Kounghel", Kaffrine,
                new ArrayList<>());

        // Kédougou departement

        Departement Kédougoudep = new Departement("0040", "Kédougou",10.2, 142, 25.5, 55.6, "Kédougou detail",
                Kedougou, new ArrayList<>());
        Departement Salemata = new Departement("0041", "Salemata ", 10.2, 142, 25.5, 55.6, "Salemata  detail", Kedougou,
                new ArrayList<>());
        Departement Saraya = new Departement("0042", "Saraya  ", 10.2, 142, 25.5, 55.6, "Saraya", Kedougou,
                new ArrayList<>());
//Sedhiou departement

        Departement Sedhioudep = new Departement("0043", "Sedhiou",10.2, 142, 25.5, 55.6, "Sedhiou detail", Sédhiou,
                new ArrayList<>());
        Departement Bounkiling = new Departement("0044", "Bounkiling ", 10.2, 142, 25.5, 55.6, "Bounkiling  detail",
                Sédhiou, new ArrayList<>());
        Departement Goudomp = new Departement("0045", "Goudomp  ",10.2, 142, 25.5, 55.6, "Goudomp", Sédhiou,
                new ArrayList<>());

        // Arrond Dakar
        Arrondissement DAKAR = new Arrondissement("001", "DAKAR",125.5, 25.6, 558.6, 554.5, "DAKAR detail", dakardep,
                new ArrayList<>());
        Arrondissement DAKAR_PLATEAU = new Arrondissement("002", "DAKAR-PLATEAU", 125.5, 25.6, 558.6, 554.5,
                "DAKAR-PLATEAU detail", dakardep, new ArrayList<>());
        Arrondissement GRAND_DAKAR = new Arrondissement("003", "GRAND DAKAR ",125.5, 25.6, 558.6, 554.5,
                "GRAND DAKAR  detail", dakardep, new ArrayList<>());
        Arrondissement ALMADIES = new Arrondissement("004", "ALMADIES",125.5, 25.6, 558.6, 554.5, "ALMADIES detail",
                dakardep, new ArrayList<>());
        Arrondissement PARCELLES_ASSAINIES = new Arrondissement("005", "PARCELLES ASSAINIES", 125.5, 25.6, 558.6, 554.5,
                "PARCELLES ASSAINIESdetail", dakardep, new ArrayList<>());
//
//		// Arrond Guédiawaye
        Arrondissement GuédiawayeAr = new Arrondissement("006", "Guédiawaye", 125.5, 25.6, 558.6, 554.5, "Guédiawaye detail", Guédiawaye,
                new ArrayList<>());
//				// Arrond Pikin
        Arrondissement PIKINE_DAGOUDANE  = new Arrondissement("007", "PIKINE DAGOUDANE ", 125.5, 25.6, 558.6, 554.5, "pikine detail", Pikine,
                new ArrayList<>());
//				//Thiaroy
        Arrondissement Thiaroy  = new Arrondissement("008", "Thiaroy ",125.5, 25.6, 558.6, 554.5, "Thiaroy detail", Pikine,
                new ArrayList<>());
//				//niaye
        Arrondissement Niaye  = new Arrondissement("009", "Niaye  ",125.5, 25.6, 558.6, 554.5, "Niaye detail", Pikine,
                new ArrayList<>());
//				// Arrond Rufisque
        Arrondissement RUFISQUE = new Arrondissement("0010", "RUFISQUE ", 125.5, 25.6, 558.6, 554.5, "RUFISQUE detail", Rufisque,
                new ArrayList<>());
        Arrondissement RUFISQUE_EST   = new Arrondissement("0011", "RUFISQUE - EST  ", 125.5, 25.6, 558.6, 554.5, "RUFISQUE - EST  detail", Rufisque,
                new ArrayList<>());
        Arrondissement BAMBYLOR  = new Arrondissement("0012", "BAMBYLOR  ", 125.5, 25.6, 558.6, 554.5, "BAMBYLOR detail", Rufisque,
                new ArrayList<>());

        // commune Dakar
        //commun de dakar
        Commun Ville_de_Dakar = new Commun("0013", " Ville de Dakar ",125.5, 25.6, 558.6, 554.5, " Ville de Dakar  detail", DAKAR
        );
        Commun Gorée = new Commun("0014", " Gorée", 125.5, 25.6, 558.6, 554.5, " Gorée detail", DAKAR);
        //commun des almadie
        Commun Mermoz_Sacre_Coeur = new Commun("0013", " Mermoz_Sacre_Coeur",125.5, 25.6, 558.6, 554.5, " Mermoz_Sacre_Coeur detail", ALMADIES
        );
        Commun Ngor = new Commun("0016", " Ngor", 125.5, 25.6, 558.6, 554.5, " Ngor detail", ALMADIES);
        Commun Ouakam = new Commun("0017", " Ouakam", 125.5, 25.6, 558.6, 554.5, " Ouakam detail", ALMADIES);
        Commun Yoff = new Commun("0018", " Yoff",125.5, 25.6, 558.6, 554.5, " Yoff detail", ALMADIES);
        //commun Dakar plateau
        Commun Îles_des_Madeleines = new Commun("0019", " Îles_des_Madeleines", 125.5, 25.6, 558.6, 554.5, " Îles_des_Madeleines detail", DAKAR_PLATEAU);
        Commun Fann_PointE_Amitie = new Commun("0020", " Fann_PointE_Amitie", 125.5, 25.6, 558.6, 554.5, " Fann_PointE_Amitie detail", DAKAR_PLATEAU);
        //Commun Gorée = new Commun("0019", " Gorée", 125.5, 25.6, 558.6, 554.5, " Gorée detail", DAKAR_PLATEAU);
        Commun GueleTapée_Fass_Colobane = new Commun("0021", " GueleTapée_Fass_Colobane", 125.5, 25.6, 558.6, 554.5, " GueleTapée_Fass_Colobane detail", DAKAR_PLATEAU);
        Commun Médina = new Commun("0022", " Médina", 125.5, 25.6, 558.6, 554.5, " Médina detail", DAKAR_PLATEAU);
        Commun Plateau = new Commun("0023", " Plateau", 125.5, 25.6, 558.6, 554.5, " Plateau detail", DAKAR_PLATEAU);
        //commun de grand dakar
        Commun Buscuterie = new Commun("0024", " Buscuterie", 125.5, 25.6, 558.6, 554.5, " Buscuterie detail", GRAND_DAKAR);
//	   //Commune d'arrondissement
//				CommunAr abcdef = new CommunAr("0024", " abcdef", 125.5, 25.6, 558.6, 554.5, " abcdef detail", Yoff,
//					new ArrayList<>());
//
//	 //Communauté rurales
//				CommunRu ghijkl = new CommunRu("0025", " ghijkl", 125.5, 25.6, 558.6, 554.5, " ghijkl detail", abcdef);
//
        // save Region
        iLocaliteService.saveRegion(dakar);
        iLocaliteService.saveRegion(thies);
        iLocaliteService.saveRegion(fatick);
        iLocaliteService.saveRegion(diourbel);
        iLocaliteService.saveRegion(Ziguinchor);
        iLocaliteService.saveRegion(kaolack);
        iLocaliteService.saveRegion(Kaffrine);
        iLocaliteService.saveRegion(Kedougou);
        iLocaliteService.saveRegion(Tambacounda);
        iLocaliteService.saveRegion(Matam);
        iLocaliteService.saveRegion(Saint_Louis);
        iLocaliteService.saveRegion(Sédhiou);
        iLocaliteService.saveRegion(Louga);
        iLocaliteService.saveRegion(Kolda);
        // save department

        // save dakar department
        iLocaliteService.saveDepartemnt(dakardep);
        iLocaliteService.saveDepartemnt(Guédiawaye);
        iLocaliteService.saveDepartemnt(Pikine);
        iLocaliteService.saveDepartemnt(Rufisque);

        // save Diourbel department
        iLocaliteService.saveDepartemnt(diourbelDep);
        iLocaliteService.saveDepartemnt(Bambey);
        iLocaliteService.saveDepartemnt(Mbacké);

        // save Diourbel department
        iLocaliteService.saveDepartemnt(diourbelDep);
        iLocaliteService.saveDepartemnt(Bambey);
        iLocaliteService.saveDepartemnt(Mbacké);

        // save Fatick department
        iLocaliteService.saveDepartemnt(fatickdep);
        iLocaliteService.saveDepartemnt(Foundiougne);
        iLocaliteService.saveDepartemnt(Gossas);

        // save Kaolack department
        iLocaliteService.saveDepartemnt(kaolackdep);
        iLocaliteService.saveDepartemnt(Guinguinéo);
        iLocaliteService.saveDepartemnt(Nioro_du_Rip);

        // save Kolda department
        iLocaliteService.saveDepartemnt(koldadep);
        iLocaliteService.saveDepartemnt(Vélingara);
        iLocaliteService.saveDepartemnt(Médina_Yoro_Foulah);

        // save Louga department
        iLocaliteService.saveDepartemnt(Lougadep);
        iLocaliteService.saveDepartemnt(Kébémer);
        iLocaliteService.saveDepartemnt(Linguère);

        // save Matam department
        iLocaliteService.saveDepartemnt(Matamdep);
        iLocaliteService.saveDepartemnt(Kanel);
        iLocaliteService.saveDepartemnt(Ranérou);

        // save Saint-Louis department
        iLocaliteService.saveDepartemnt(Saint_Louisdep);
        iLocaliteService.saveDepartemnt(Dagana);
        iLocaliteService.saveDepartemnt(Podor);

        // save Tambacounda department
        iLocaliteService.saveDepartemnt(Tambacoundadep);
        iLocaliteService.saveDepartemnt(Bakel);
        iLocaliteService.saveDepartemnt(Koumpentoum);
        iLocaliteService.saveDepartemnt(Goudiry);

        // save Thiès department
        iLocaliteService.saveDepartemnt(thiesdep);
        iLocaliteService.saveDepartemnt(Mbour);
        iLocaliteService.saveDepartemnt(Tivaouane);

        // save Ziguinchor department
        iLocaliteService.saveDepartemnt(Ziguinchordep);
        iLocaliteService.saveDepartemnt(Bignogna);
        iLocaliteService.saveDepartemnt(Oussouye);

        // save Kaffrine department
        iLocaliteService.saveDepartemnt(Kaffrinedep);
        iLocaliteService.saveDepartemnt(Birkilane);
        iLocaliteService.saveDepartemnt(Malem_Hodar);
        iLocaliteService.saveDepartemnt(Kounghel);

        // save Kédougou department
        iLocaliteService.saveDepartemnt(Kédougoudep);
        iLocaliteService.saveDepartemnt(Salemata);
        iLocaliteService.saveDepartemnt(Saraya);

        // save Sédhiou department
        iLocaliteService.saveDepartemnt(Sedhioudep);
        iLocaliteService.saveDepartemnt(Bounkiling);
        iLocaliteService.saveDepartemnt(Goudomp);
//Arrondissement
        //Dakar Arrondissement
        iLocaliteService.saveArrondissement(DAKAR);
        iLocaliteService.saveArrondissement(DAKAR_PLATEAU);
        iLocaliteService.saveArrondissement(GRAND_DAKAR);
        iLocaliteService.saveArrondissement(ALMADIES);
        iLocaliteService.saveArrondissement(PARCELLES_ASSAINIES);
        //Guediaway Arrondissement
        iLocaliteService.saveArrondissement(GuédiawayeAr);
        //Pikine Arrondissement
        iLocaliteService.saveArrondissement(PIKINE_DAGOUDANE);
        //Niaye
        iLocaliteService.saveArrondissement(Niaye);
        //Rufisque Arrondissement
        iLocaliteService.saveArrondissement(RUFISQUE);
        iLocaliteService.saveArrondissement(RUFISQUE_EST);
        iLocaliteService.saveArrondissement(BAMBYLOR);
        //commune
        //Save Dakar Commune
        iLocaliteService.saveCommun(Ville_de_Dakar);
        iLocaliteService.saveCommun(Gorée);
        //Save almadie Commune
//        iLocaliteService.saveCommun(Mermoz_Sacre_Coeur);
//        iLocaliteService.saveCommun(Ngor);
//        iLocaliteService.saveCommun(Ouakam);
//        iLocaliteService.saveCommun(Yoff);

        //Save plateau Commune
        iLocaliteService.saveCommun(Îles_des_Madeleines);
        iLocaliteService.saveCommun(Fann_PointE_Amitie);
        //iLocaliteService.saveCommun(Gorée);
        iLocaliteService.saveCommun(GueleTapée_Fass_Colobane);
        iLocaliteService.saveCommun(Médina);
        iLocaliteService.saveCommun(Plateau);

        iLocaliteService.saveCommun(Buscuterie);

//Commune d'arrondissement
        //Save Dakar Commune d'arrondissement
//	   iLocaliteService.saveCommunAr(abcdef);

//Commune d'arrondissement
        //Save Dakar Communauté rurales
//		   iLocaliteService.saveCommunRu(ghijkl);


    }
}




