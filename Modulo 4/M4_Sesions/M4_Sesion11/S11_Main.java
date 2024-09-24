package M4_Sesion11;

import M4_Sesion11.modules.PayInterface;
import M4_Sesion11.modules.PaymentMethod;
import M4_Sesion11.modules.Movies;
import M4_Sesion11.modules.Owner;
import M4_Sesion11.utils.ReadConsole;

import java.util.ArrayList;
import java.util.List;

public class S11_Main {

    public static List<Movies> moviesList = new ArrayList<>();

    public static void S11() {

        moviesList.add(new Movies("Interestellar", 2014, false));
        moviesList.add(new Movies("Interestellar 2", 2024, false));

        int option = 0;
        while (option != 8) {
            menu();
            option = ReadConsole.dataInputInt();
            switch (option) {
                case 1:
                    showAllMovies();
                    break;
                case 2:
                    System.out.println("Title of the movie you want to add");
                    String name = ReadConsole.dataInputString();
                    System.out.println("Year of the movie you want to add");
                    int year = ReadConsole.dataInputInt();
                    System.out.println("By default its not rented");
                    boolean status = false;
                    addMovie(name, year, status);
                    break;
                case 3:
                    deleteMovie();
                    break;
                case 4:
                    modifyMovie();
                    break;
                case 5:
                    listOfAvailableMovies();
                    break;
                case 6:
                    rentMovie();
                    break;
                case 7:
                    returnMovie();
                    break;
                case 8:
                    System.out.println("Thanks for using the program, support me with a ristretto coffe");
                    break;
                case 9:
                    createOwner();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void menu() {
        System.out.println("_____________________________________");
        System.out.println("Welcome to Video Club Nostalgia");
        System.out.println("1. Show the list of all movies");
        System.out.println("2. Add a new movie");
        System.out.println("3. Delete a movie");
        System.out.println("4. Modify a movie");
        System.out.println("5. Show the list of movies availables");
        System.out.println("6. Rent a movie");
        System.out.println("7. Return a movie");
        System.out.println("8. Exit the program");
        System.out.println("9. Create owner of the store");
        System.out.println("_____________________________________");
    }

    public static void showAllMovies() {
        int index = 0;
        for (Movies movie : moviesList) {
            index++;
            System.out.println(index + " - " + movie);
        }
    }

    public static void addMovie(String title, int year, boolean rented) {
        try {
            moviesList.add(new Movies(title, year, rented));
            System.out.println(title + " - " + year + " have been added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMovie() {
        showAllMovies();
        System.out.println("Select the number of the movie you want to delete");
        int index = ReadConsole.dataInputInt();
        index = index - 1;
        if (index < moviesList.size() && index >= 0) {
            System.out.println("Are you sure you want to delete :" + moviesList.get(index).getTitle() + ", write yes or no");
            String affirmation = ReadConsole.dataInputString().toLowerCase();
            if (affirmation.equals("yes")) {
                try {
                    System.out.println(moviesList.get(index).getTitle() + " have been deleted successfully");
                    moviesList.remove(index);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (affirmation.equals("no")) {
                System.out.println("Delete process canceled");
            } else {
                System.out.println("Invalid option");
            }
        } else {
            System.out.println("No movie for the number selected");
        }
    }

    public static void modifyMovie() {
        showAllMovies();
        System.out.println("Select the number of the movie you want to modify");
        int index = ReadConsole.dataInputInt();
        index = index - 1;
        if (index < moviesList.size() && index >= 0) {
            System.out.println("You have selected : " + moviesList.get(index).getTitle() + " - " + moviesList.get(index).getYear() + " - Rented : " + moviesList.get(index).isRented());
            System.out.println("You want to modify the name, year or status : ");
            String data = ReadConsole.dataInputString().toLowerCase();
            String affirmation;
            switch (data) {
                case "name":
                    System.out.println("Are you sure you want to modify the name : " + moviesList.get(index).getTitle() + ", write yes or no");
                    affirmation = ReadConsole.dataInputString().toLowerCase();
                    if (affirmation.equals("yes")) {
                        try {
                            System.out.println("Write the new name...");
                            String newTitle = ReadConsole.dataInputString();
                            System.out.println(moviesList.get(index).getTitle() + " have change the name successfully for " + newTitle);
                            moviesList.get(index).setTitle(newTitle);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    } else if (affirmation.equals("no")) {
                        System.out.println("Modify name process canceled");
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                case "year":
                    System.out.println("Are you sure you want to modify the year of the movie : " + moviesList.get(index).getTitle() + " - " + moviesList.get(index).getYear() + ", write yes or no");
                    affirmation = ReadConsole.dataInputString().toLowerCase();
                    if (affirmation.equals("yes")) {
                        try {
                            System.out.println("Write the new year...");
                            int newYear = ReadConsole.dataInputInt();
                            System.out.println(moviesList.get(index).getYear() + " have change the year of the movie successfully for " + newYear);
                            moviesList.get(index).setYear(newYear);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (affirmation.equals("no")) {
                        System.out.println("Modify year process canceled");
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                case "status":
                    if (moviesList.get(index).isRented()) {
                        System.out.println("Are you sure you want to modify the status to AVAILABLE for : " + moviesList.get(index).getTitle() + ", write yes or no");
                        affirmation = ReadConsole.dataInputString().toLowerCase();
                        if (affirmation.equals("yes")) {
                            try {
                                System.out.println(moviesList.get(index).getTitle() + " is available");
                                moviesList.get(index).setRented(false);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (affirmation.equals("no")) {
                            System.out.println("Modify status process canceled");
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Are you sure you want to modify the status to RENTED for : " + moviesList.get(index).getTitle() + ", write yes or no");
                        affirmation = ReadConsole.dataInputString().toLowerCase();
                        if (affirmation.equals("yes")) {
                            try {
                                System.out.println(moviesList.get(index).getTitle() + " is rented");
                                moviesList.get(index).setRented(true);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (affirmation.equals("no")) {
                            System.out.println("Modify status process canceled");
                        } else {
                            System.out.println("Invalid option");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } else {
            System.out.println("No movie for the number selected");
        }
    }

    public static boolean listOfAvailableMovies() {
        int index = 0;
        int validate = 0;
        for (Movies movie : moviesList) {
            index++;
            if (!movie.isRented()) {
                System.out.println(index + " - " + movie);
                validate = 1;
            }
        }
        if (validate != 1) {
            System.out.println("There are no Movies Availables");
            return false;
        } else {
            return true;
        }
    }

    public static boolean listOfRentedMovies() {
        int index = 0;
        int validate = 0;
        for (Movies movie : moviesList) {
            index++;
            if (movie.isRented()) {
                System.out.println(index + " - " + movie);
                validate = 1;
            }
        }
        if (validate != 1) {
            System.out.println("There are no Movies Rented");
            return false;
        } else {
            return true;
        }
    }

    public static void rentMovie() {

        PayInterface cash = PaymentMethod.getPaymentMethod(PaymentMethod.TypeOfPayment.Cash);
        PayInterface credit = PaymentMethod.getPaymentMethod(PaymentMethod.TypeOfPayment.Credit);
        PayInterface debit = PaymentMethod.getPaymentMethod(PaymentMethod.TypeOfPayment.Debit);

        System.out.println("Select the number of the movie you want to rent: ");
        if (listOfAvailableMovies()) {
            int index = ReadConsole.dataInputInt();
            index = index - 1;
            if (index < moviesList.size() && index >= 0) {
                System.out.println("You have selected : " + moviesList.get(index).getTitle() + " - " + moviesList.get(index).getYear());
                System.out.println("Which is your payment method: ");
                System.out.println("1.- Cash");
                System.out.println("2.- Credit");
                System.out.println("3.- Debit");
                int paySelected = ReadConsole.dataInputInt();
                switch (paySelected) {
                    case 1:
                        System.out.println(cash.payment());
                        moviesList.get(index).setRented(true);
                        System.out.println("Rented: " + moviesList.get(index).getTitle());
                        break;
                    case 2:
                        System.out.println(credit.payment());
                        moviesList.get(index).setRented(true);
                        System.out.println("Rented: " + moviesList.get(index).getTitle());
                        break;
                    case 3:
                        System.out.println(debit.payment());
                        moviesList.get(index).setRented(true);
                        System.out.println("Rented: " + moviesList.get(index).getTitle());
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } else {
                System.out.println("No movie for the number selected");
            }
        } else {
            System.out.println("It is not possible to process this solicitude");
        }
    }

    public static void returnMovie() {
        System.out.println("Select the number of the movie to returned: ");
        if (listOfRentedMovies()) {
            int index = ReadConsole.dataInputInt();
            index = index - 1;
            if (index < moviesList.size() && index >= 0) {
                System.out.println("Are you sure you want to modify the status to AVAILABLE for : " + moviesList.get(index).getTitle() + ", write yes or no");
                String affirmation = ReadConsole.dataInputString().toLowerCase();
                if (affirmation.equals("yes")) {
                    try {
                        System.out.println(moviesList.get(index).getTitle() + " is available again");
                        moviesList.get(index).setRented(false);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (affirmation.equals("no")) {
                    System.out.println("Modify status process canceled");
                } else {
                    System.out.println("Invalid option");
                }
            } else {
                System.out.println("No movie for the number selected");
            }
        } else {
            System.out.println("It is not possible to process this solicitude");
        }
    }

    public static void createOwner() {
        System.out.println("Enter the name of the Owner of the store");
        Owner.getOwner(ReadConsole.dataInputString());
    }
}
