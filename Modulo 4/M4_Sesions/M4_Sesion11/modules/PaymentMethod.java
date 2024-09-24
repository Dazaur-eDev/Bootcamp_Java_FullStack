package M4_Sesion11.modules;

public class PaymentMethod {
    public enum TypeOfPayment {
        Cash,
        Credit,
        Debit
    }

    public static PayInterface getPaymentMethod(TypeOfPayment typeOfPayment) {
        switch (typeOfPayment) {
            case Cash: return new Cash();
            case Credit: return new Credit();
            case Debit: return new Debit();
        }
        return null;
    }
}
