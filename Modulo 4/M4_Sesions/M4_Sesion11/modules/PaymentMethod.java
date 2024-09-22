package M4_Sesion11.modules;

public class PaymentMethod {
    public enum TypeOfPayment {
        Cash,
        Credit,
        Debit
    }

    public static PayInterface getPaymentMethod(TypeOfPayment typeOfPayment) {
        return switch (typeOfPayment) {
            case Cash -> new Cash();
            case Credit -> new Credit();
            case Debit -> new Debit();
        };
    }
}
