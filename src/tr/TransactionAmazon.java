package tr;

public class TransactionAmazon extends Transaction {
    private String numeroClient;
    private String categorieProduit;

    public TransactionAmazon(String idTransaction, double montant, String date, String numeroClient, String categorieProduit) {
        super(idTransaction, montant, date);
        this.numeroClient = numeroClient;
        this.categorieProduit = categorieProduit;
    }

    @Override
    public void afficher() {
        System.out.println("Transaction Amazon: ID = " + idTransaction + ", Montant = " + montant + ", Date = " + date +
                ", Numéro Client = " + numeroClient + ", Catégorie Produit = " + categorieProduit);
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    public String getCategorieProduit() {
        return categorieProduit;
    }
}

