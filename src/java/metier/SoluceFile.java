package metier;

import DAO.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import model.*;
/**
 *
 * @author Victor
 */
public class SoluceFile {

    private final JPADAOFactory jpaDaoFactory;
    private final DAOBox typeBoxDao;
    private final DAOInstanceBox boxAcheteDao;
    private final DAOCommande commandeDao;
    private final DAOProduit produitDao;
    private final DAOProduitBaked produitBakedDao;
    private final DAOCommandeDetails produitCommandeDao;
    private String nameFile;
    private Double eval;
    
    
    public SoluceFile() {
        jpaDaoFactory = (JPADAOFactory) DAOFactory.getDaoFactory(DAOFactory.PersistType.JPA);
        typeBoxDao = jpaDaoFactory.getBoxDao();
        boxAcheteDao = jpaDaoFactory.getInstanceBoxDao();
        commandeDao = jpaDaoFactory.getCommandeDao();
        produitDao = jpaDaoFactory.getProduitDao();
        produitBakedDao = jpaDaoFactory.getProduitBaked();
        produitCommandeDao = jpaDaoFactory.getCommandeDetailDao();

    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile.replace(".txt", ".sol");
    }
    
  public File generate() throws IOException{

        List<String> temp = new ArrayList();
        
        eval = 0.00;
        System.out.println("\n\n\n\n DEBUT : ");
        System.out.println("DEBUT EVAL");
        System.out.println("\n\n\n\n");
        
        typeBoxDao.findAll().stream().forEach((Bbox) -> {
            eval = eval + Bbox.getPrixBox()*boxAcheteDao.compteurDeBox(Bbox);
            });
        System.out.println("\n\n\n\n PREMIER : ");
        System.out.println(eval);
        System.out.println("FIN PREMIER \n\n\n\n");
        commandeDao.findAll().stream().forEach((commande) -> {
          if (commande.getDEnvoi()!=null && commande.getDEnvoiPrevue()!=null && commande.getPenalite()!=null){
              double diff= commande.getDEnvoi()- commande.getDEnvoiPrevue();
              if (diff<0){
                  diff=-diff;
              }
              eval = eval + commande.getPenalite()*(diff);
          }    
        });
         
        temp.add(Double.toString(eval));
//        System.out.println("\n\n\n\n Le eval est : ");
//        System.out.println(ev);
//        System.out.println("\n\n\n\n");
        //temp.add(Double.toString(eval));
        temp.add("\n");
        
        System.out.println("\n\n\n\n");
        System.out.println(temp);
        System.out.println("\n\n\n\n");
        
        // son identiﬁant id(b),
        // le nombre nbBoxAchetes(b) de box achetés
        for(Box bt : typeBoxDao.findAll()){
            temp.add(bt.getId()+" "+boxAcheteDao.compteurDeBox(bt)+" ");
        }
        temp.add("\n");

        //son identiﬁant id(c),
        // la date dEnvoi à laquelle on a vidé tous les box où se trouvaient ses unités
        for(Commande cd : commandeDao.findAllOrderByDEnvoi()){
            temp.add(cd.getId()+" "+ cd.getDEnvoi()+" ");
        }
        temp.add("\n");
         
        //l’identiﬁant id(c)de sa commande
        //l’identiﬁant id(t)desontype
        //lenumérodelaligneoùelleaétéproduite(entiercompris entre 1 et nbLignes)
        //sa date de début de production (∈ N)
        //l’identiﬁant id(b) du type de box dans lequel elle a été stockée
        //et le numéro de ce box (entier compris entre 1 et nbBoxAchetes(b))
        for(ProduitBaked p : produitBakedDao.findAll()){
                  //InstanceBox inst = new InstanceBox();
                  for(InstanceBox inst : boxAcheteDao.findBoxByProduitBaked(p)){
                      //if (inst.getIdBox()!=null && inst.getNumBox()!=null){
                            temp.add(p.getIdCommandeDetails().getIdCommande().getId()+" "+ 
                            p.getIdCommandeDetails().getIdProduit().getId()+" "+
                            p.getNbLigne().getNbLignes()+" "+
                            p.getDateDebutProd()+" "+
                            inst.getIdBox().getId()+" "+
                            inst.getNumBox()+" "+
                            // help
                            // help
                            " ");
                      //}
                  }
        } 
        temp.add("\n");
        
        String Fichiernm = "Soluc";
        Path file = Paths.get(Fichiernm);
        Files.write(file, temp, Charset.forName("UTF-8"));
        
        return file.toFile();
    }
  
  
    
}
