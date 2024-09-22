package M4_Sesion11.modules;

public class Debit implements PayInterface{
    @Override
    public String payment() {
        return "Paid with debit card";
    }
}
