package M4_Sesion11.modules;

public class Movies {
    private String title;
    private int year;
    private boolean rented;

    public Movies(String title, int year, boolean rented) {
        this.title = title;
        this.year = year;
        this.rented = rented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Title='" + title + '\'' +
                ", Year=" + year +
                ", Rented=" + rented;
    }
}
