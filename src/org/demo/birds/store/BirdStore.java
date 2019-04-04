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
    private Map listNames;
    private Map listLivingAreas;

    private BirdStore() {
        listNames = new HashMap();
        listLivingAreas = new HashMap<String,List<Bird>>();
    }

    public static BirdStore of() {
        return birdStore;
    }

    @Override
    public void addBird(Bird b) {
//        birds.add(b);
//TODO: проверка на уже добавленное
            listNames.put(b.getName(), b);
            List list;
            if (listLivingAreas.containsKey(b.getLivingArea())) {
                list = (List) listLivingAreas.get(b.getLivingArea());
                list.add(b);
            }
            else{
                list = new ArrayList();
                list.add(b);
                listLivingAreas.put(b.getLivingArea(),list);
            }
    }


    @Override
    public Bird searchByName(String nameToSearch) {
        if (listNames.containsKey(nameToSearch)) {
            return (Bird) listNames.get(nameToSearch);
        }
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {
        if(listLivingAreas.containsKey(livingAreaToFind)){
            return (List) listLivingAreas.get(livingAreaToFind);
        }
        return null;
    }
}
