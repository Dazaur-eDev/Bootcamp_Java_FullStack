package M4_Sesion11.modules;

public class Credit implements PayInterface{
    @Override
    public String payment() {
        return "Paid with credit card";
    }
}
