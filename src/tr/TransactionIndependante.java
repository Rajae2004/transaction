package tr;

public class TransactionIndependante extends Transaction {
    private String localisationVendeur;
    private String moyenPaiement;

    public TransactionIndependante(String idTransaction, double montant, String date, String localisationVendeur, String moyenPaiement) {
        super(idTransaction, montant, date);
        this.localisationVendeur = localisationVendeur;
        this.moyenPaiement = moyenPaiement;
    }

    @Override
    public void afficher() {
        System.out.println("Transaction Indépendante: ID = " + idTransaction + ", Montant = " + montant + ", Date = " + date +
                ", Localisation Vendeur = " + localisationVendeur + ", Moyen de Paiement = " + moyenPaiement);
    }

    public String getLocalisationVendeur() {
        return localisationVendeur;
    }

    public String getMoyenPaiement() {
        return moyenPaiement;
    }
}

