package tr;

import java.util.ArrayList;
import java.util.List;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class AnalyseTransactions {
    private List<Transaction> transactions;

    public AnalyseTransactions() {
        transactions = new ArrayList<>();
        chargerTransactions();
    }

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        sauvegarderTransactions();
    }

    public void afficherTransactions() {
        for (Transaction transaction : transactions) {
            transaction.afficher();
        }
    }

    public double obtenirSommeTotale() {
        double somme = 0;
        for (Transaction transaction : transactions) {
            somme += transaction.obtenirMontant();
        }
        return somme;
    }

    public double obtenirMontantMoyen() {
        if (transactions.isEmpty()) return 0;
        return obtenirSommeTotale() / transactions.size();
    }

    private void sauvegarderTransactions() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"))) {
            for (Transaction transaction : transactions) {
                writer.write(transactionToString(transaction));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des transactions : " + e.getMessage());
        }
    }

    private void chargerTransactions() {
        File file = new File("transactions.txt");
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Transaction transaction = stringToTransaction(line);
                if (transaction != null) {
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des transactions : " + e.getMessage());
        }
    }

    private String transactionToString(Transaction transaction) {
        if (transaction instanceof TransactionAmazon) {
            TransactionAmazon amazon = (TransactionAmazon) transaction;
            return "Amazon," + amazon.getIdTransaction() + "," + amazon.obtenirMontant() + "," + amazon.getDate() + ","
                    + amazon.getNumeroClient() + "," + amazon.getCategorieProduit();
        } else if (transaction instanceof TransactionEbay) {
            TransactionEbay ebay = (TransactionEbay) transaction;
            return "eBay," + ebay.getIdTransaction() + "," + ebay.obtenirMontant() + "," + ebay.getDate() + ","
                    + ebay.getPseudoVendeur() + "," + ebay.getModeLivraison();
        } else if (transaction instanceof TransactionIndependante) {
            TransactionIndependante independante = (TransactionIndependante) transaction;
            return "Independante," + independante.getIdTransaction() + "," + independante.obtenirMontant() + "," + independante.getDate() + ","
                    + independante.getLocalisationVendeur() + "," + independante.getMoyenPaiement();
        }
        return "";
    }

    private Transaction stringToTransaction(String line) {
        String[] parts = line.split(",");
        if (parts.length < 6) return null;

        String type = parts[0];
        String idTransaction = parts[1];
        double montant = Double.parseDouble(parts[2]);
        String date = parts[3];

        switch (type) {
            case "Amazon":
                String numeroClient = parts[4];
                String categorieProduit = parts[5];
                return new TransactionAmazon(idTransaction, montant, date, numeroClient, categorieProduit);
            case "eBay":
                String pseudoVendeur = parts[4];
                String modeLivraison = parts[5];
                return new TransactionEbay(idTransaction, montant, date, pseudoVendeur, modeLivraison);
            case "Independante":
                String localisationVendeur = parts[4];
                String moyenPaiement = parts[5];
                return new TransactionIndependante(idTransaction, montant, date, localisationVendeur, moyenPaiement);
            default:
                return null;
        }
    }
}


