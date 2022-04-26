import java.io.*;   
import java.util.Random;
import java.util.Scanner;
 import java.util.UUID ;
 
public class Client{

    private int id;
    private String nom;
    private String tel;

    // NoArgConstructor
    public Client(){

    }

    //AllArgConstructor
    public Client(int id, String nom, String tel){
        this.id=id;
        this.nom=nom;
        this.tel=tel;
    }


    //getters

    public int getId(){return this.id;}
    public String getNom(){return this.nom;}
    public String getTel(){return this.tel;}


    //setters

    public void setId(int id){ this.id=id;}
    public void setNom(String nom){this.nom=nom;}
    public void setTel(String tel){this.tel=tel;}


    //Methods

    public static void enregistrerClient(Client clientObj){
        try {
           File client = new File("C:\\Users\\Dutervil Wadson\\Desktop\\ProjetJavaIntra\\client.txt");
            // if (client.createNewFile()) {
                System.out.println("Fichir créé: " + client.getName());

                // Enregistrement du client ici.
                String str = "Ce fichier vient d'etre initialisé";
                BufferedWriter writer = new BufferedWriter(new FileWriter(client.getName(),true));
                StringBuilder builder=new StringBuilder();
                builder.append(clientObj.getId()+";"+clientObj.getNom()+";"+clientObj.getTel());
                writer.write(builder.toString()); 
                writer.newLine() ;
                writer.close();

            // } else {
            //     System.out.println("Ce fichier existe deja");
            // }
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    }


 public static void ListerClient(){

        try{

       
         BufferedReader br = new BufferedReader(new FileReader("client.txt"));
          String line = null;
         System.out.println("       ID         NOM         PHONE");
         System.out.println("        ______________________________");
        while ((line = br.readLine()) != null) {
        String[] values = line.split(";");
         
             System.out.println("       "+values[0]+"       "+values[1]+"       "+values[2]);
         
        }
        br.close();
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
    }

    
public static Client  saisirCLient(){
        Client c=new Client();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir le nom du client !");
        String nom=scanner.nextLine();
        c.setNom(nom);
        System.out.println("Saisir le  du client !");
        String tel=scanner.nextLine();
        c.setTel(tel);
        Random r=new Random();
        c.setId(12);
        return c;
}
   public static void  clientMenu()
          {
             System.out.println("   1- Enregistrer");
             System.out.println("   2- Lister");
             System.out.println("   3- Rechercher");
             System.out.println("   4- Modifier");
             System.out.println("   5- Quitter");

             Scanner sc=new Scanner(System.in);
             

             switch(sc.nextInt()){
                 case 1:
                 Client newClient=Client.saisirCLient();
                 Client.enregistrerClient(newClient);
                 System.out.println(" Un nouveau client a ete enregistre "+newClient.getNom());
                 break;
                 case 2:
                 Client.ListerClient();
                 default:
                  System.out.println("Aucun Choix !");

             }
   }
    public static void main(String[] args){
        
        Client c=new Client();

             System.out.println("       A) GESTION CLIENTS");
             System.out.println("       B) GESTION FOURNISSEUR");
             System.out.println("       C) GESTION VOITURES");
             System.out.println("       D) GESTION CLIENTS");
             System.out.println("       E) RAPPORT VOITURES");
             System.out.println("       F) AIDE");
             

             Scanner sc=new Scanner(System.in);

             switch(sc.nextLine()){
                 case "A":
                 clientMenu();
                 break;
                 
                 default:
                 System.out.println("Il faut faire un choix !");
             }

         
        
    }
}