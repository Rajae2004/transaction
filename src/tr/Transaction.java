package tr;

public abstract class Transaction {
    protected String idTransaction;
    protected double montant;
    protected String date;

    public Transaction(String idTransaction, double montant, String date) {
        this.idTransaction = idTransaction;
        this.montant = montant;
        this.date = date;
    }

    public abstract void afficher();


    public double obtenirMontant() {
        return montant;
    }


    public String getIdTransaction() {
        return idTransaction;
    }


    public String getDate() {
        return date;
    }
}
