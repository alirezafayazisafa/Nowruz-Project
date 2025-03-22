package ddbb;

import Exeptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    public static int makeID = 40312000;

    private Database(){}

    public static void addEntity(Entity entity) {
        makeID++;
        entities.add(entity);
        entity.id = makeID;
    }

    public static Entity getEntity(int id) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.id == id) {
                return entity;
            }
        }
        throw new EntityNotFoundException("Entity with ID " + id + " not found.");
    }

    public static void deleteEntity(int id) throws EntityNotFoundException {
        for (Entity entity : entities) {
            if (entity.id == id) {
                entities.remove(entity);
                return; // Exit the method after removing the entity
            }
        }
        throw new EntityNotFoundException("Entity with ID " + id + " not found.");
    }


    public static void updateEntity(Entity e) throws EntityNotFoundException {
        for (int i = 0; i < Database.entities.size(); i++) {
            if (Database.entities.get(i).id == e.id) {
                Database.entities.set(i, e);
                return;
            }
        }
        throw new EntityNotFoundException("Entity with ID " + e.id + " not found.");
    }
}


