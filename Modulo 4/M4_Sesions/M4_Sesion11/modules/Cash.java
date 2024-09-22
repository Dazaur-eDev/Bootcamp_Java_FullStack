package M4_Sesion11.modules;

public class Cash implements PayInterface{
    @Override
    public String payment() {
        return "Paid with cash";
    }
}
