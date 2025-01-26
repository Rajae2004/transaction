package tr;

public class TransactionEbay extends Transaction {
    private String pseudoVendeur;
    private String modeLivraison;

    public TransactionEbay(String idTransaction, double montant, String date, String pseudoVendeur, String modeLivraison) {
        super(idTransaction, montant, date);
        this.pseudoVendeur = pseudoVendeur;
        this.modeLivraison = modeLivraison;
    }

    @Override
    public void afficher() {
        System.out.println("Transaction eBay: ID = " + idTransaction + ", Montant = " + montant + ", Date = " + date +
                ", Pseudo Vendeur = " + pseudoVendeur + ", Mode Livraison = " + modeLivraison);
    }

    public String getPseudoVendeur() {
        return pseudoVendeur;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }
}


