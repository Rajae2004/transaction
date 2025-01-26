package tr;
import tr.Transaction;
import tr.AnalyseTransactions;
import tr.TransactionEbay;
import tr.TransactionAmazon;
import tr.AnalyseTransactions;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalyseTransactions analyse = new AnalyseTransactions();

        System.out.println("Bienvenue dans le système de gestion des transactions !");
        System.out.print("Êtes-vous une femme ? (oui/non) : ");
        String sexe = scanner.nextLine().equalsIgnoreCase("oui") ? "femme" : "homme";

        System.out.print("Combien de fois êtes-vous venu chez nous ? ");
        int visites = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        double reduction = 0;
        if (visites > 5) {
            reduction += 0.1; // Réduction de 10% pour les clients fidèles
        }
        if (sexe.equals("femme")) {
            reduction += 0.1; // Réduction de 10% pour les femmes
        }

        System.out.printf("Vous avez droit à une réduction totale de %.0f%% !%n", reduction * 100);

        while (true) {
            System.out.println("Veuillez choisir une option :");
            System.out.println("1. Ajouter une transaction Amazon");
            System.out.println("2. Ajouter une transaction eBay");
            System.out.println("3. Ajouter une transaction indépendante");
            System.out.println("4. Afficher toutes les transactions");
            System.out.println("5. Montant total des transactions");
            System.out.println("6. Montant moyen des transactions");
            System.out.println("7. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("ID de la transaction Amazon : ");
                    String idAmazon = scanner.nextLine();
                    System.out.print("Montant : ");
                    double montantAmazon = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Date : ");
                    String dateAmazon = scanner.nextLine();
                    System.out.print("Numéro Client : ");
                    String numeroClient = scanner.nextLine();
                    System.out.print("Catégorie Produit : ");
                    String categorieProduit = scanner.nextLine();
                    Transaction transactionAmazon = new TransactionAmazon(idAmazon, montantAmazon, dateAmazon, numeroClient, categorieProduit);
                    analyse.ajouterTransaction(transactionAmazon);
                    break;

                case 2:
                    System.out.print("ID de la transaction eBay : ");
                    String idEbay = scanner.nextLine();
                    System.out.print("Montant : ");
                    double montantEbay = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Date : ");
                    String dateEbay = scanner.nextLine();
                    System.out.print("Pseudo Vendeur : ");
                    String pseudoVendeur = scanner.nextLine();
                    System.out.print("Mode Livraison : ");
                    String modeLivraison = scanner.nextLine();
                    Transaction transactionEbay = new TransactionEbay(idEbay, montantEbay, dateEbay, pseudoVendeur, modeLivraison);
                    analyse.ajouterTransaction(transactionEbay);
                    break;

                case 3:
                    System.out.print("ID de la transaction indépendante : ");
                    String idIndependant = scanner.nextLine();
                    System.out.print("Montant : ");
                    double montantIndependant = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Date : ");
                    String dateIndependant = scanner.nextLine();
                    System.out.print("Localisation Vendeur : ");
                    String localisationVendeur = scanner.nextLine();
                    System.out.print("Moyen de Paiement : ");
                    String moyenPaiement = scanner.nextLine();
                    Transaction transactionIndependante = new TransactionIndependante(idIndependant, montantIndependant, dateIndependant, localisationVendeur, moyenPaiement);
                    analyse.ajouterTransaction(transactionIndependante);
                    break;

                case 4:
                    analyse.afficherTransactions();
                    break;

                case 5:
                    System.out.printf("Montant total des transactions : %.2f%n", analyse.obtenirSommeTotale());
                    break;

                case 6:
                    System.out.printf("Montant moyen des transactions : %.2f%n", analyse.obtenirMontantMoyen());
                    break;

                case 7:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }


            double montantTotalAvant = analyse.obtenirSommeTotale();
            double montantTotalApres = montantTotalAvant * (1 - reduction);
            System.out.printf("Montant total avant réduction : %.2f%n", montantTotalAvant);
            System.out.printf("Montant total après réduction : %.2f%n", montantTotalApres);
        }
    }
}





