package M4_Sesion11.modules;

public class Owner {
    private static Owner owner;
    private String name;

    private Owner(String name) {
        this.name = name;
    }

    public static Owner getOwner(String name) {
        if (owner == null) {
            owner = new Owner(name);
            System.out.println("Unique Owner Movie Shop created as: " + name);
        } else {
            System.out.println("Already exist a Owner Shop, it's not posible to create more");
        }
        return owner;
    }
}
