import Exeptions.EntityNotFoundException;
import example.Human;
import ddbb.Database;


public class Main {
    public static void main(String[] args) throws EntityNotFoundException {
        Human[] humans = {
                new Human("Gholi"),
                new Human("Jamshid"),
                new Human("Akbar"),
        };

        System.out.println("#### Test add method ####");

        for (Human h : humans) {
            System.out.println("Adding " + h.name + " to the database.");
            Database.addEntity(h);
        }

        for (Human h : humans) {
            System.out.println("Id of \"" + h.name + "\" is " + h.id + ".");
        }

        System.out.println();
        System.out.println("#### Test get method ####");

        int gholiId = humans[0].id;
        Human gholi = (Human) Database.getEntity(gholiId);

        System.out.println("successfully got " + gholi.name + " from the database.");

        System.out.println();
        System.out.println("#### Test update method ####");

        gholi.name = "Gholi Mohammadi";
        Database.updateEntity(gholi);

        Human gholiAgain = (Human) Database.getEntity(gholiId);
        System.out.println("Updated name: \"" + gholiAgain.name + "\".");

        System.out.println();
        System.out.println("#### Test delete method ####");

        int jamshidId = humans[1].id;
        Database.deleteEntity(jamshidId);

        try {
            Human jamshid = (Human) Database.getEntity(jamshidId);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}