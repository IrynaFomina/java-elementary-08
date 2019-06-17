package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.*;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */
public class BirdStore extends AbstractBirdStore {
    private static final BirdStore birdStore = new BirdStore();
    private Map<String, Bird> listNames;
    private Map<String, List<Bird>> listLivingAreas;

    private BirdStore() {
        listNames = new HashMap<>();
        listLivingAreas = new HashMap<>();
    }

    public static BirdStore of() {
        return birdStore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BirdStore{");
        sb.append("listNames=").append(listNames);
        sb.append(", listLivingAreas=").append(listLivingAreas);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public synchronized void addBird(Bird b) {
        if (!listNames.containsKey(b.getName())) {
            listNames.put(b.getName(), b);
        } else {
            System.out.println("Bird with name " + b.getName() + "is already exist");
            return;
        }
        List<Bird> list;
        if (listLivingAreas.containsKey(b.getLivingArea())) {
            list = listLivingAreas.get(b.getLivingArea());
            list.add(b);
        } else {
            list = new ArrayList<>();
            list.add(b);
            listLivingAreas.put(b.getLivingArea(), list);
        }
    }


    @Override
    public Bird searchByName(String nameToSearch) {
        if (listNames.containsKey(nameToSearch)) {
            return listNames.get(nameToSearch);
        }
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {
        if (listLivingAreas.containsKey(livingAreaToFind)) {
            return listLivingAreas.get(livingAreaToFind);
        }
        return null;
    }

    @Override
    public synchronized void deleteBird(Bird b) {
        if (!listNames.remove(b.getName(),b)) {
            System.out.println("Bird with name " + b.getLivingArea()+ "do not exist");
            return;
        }
        listLivingAreas.get(b.getLivingArea()).remove(b);
    }
}
