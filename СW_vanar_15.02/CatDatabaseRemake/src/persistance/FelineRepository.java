package persistance;

import data.Cat;
import data.FelineInterface;

import java.util.ArrayList;
import java.util.List;

public class FelineRepository implements FelineRepositoryInterface {
    private List<FelineInterface> felines;

    public FelineRepository() {
        felines = new ArrayList<>();
    }

    @Override
    public boolean save(FelineInterface feline) {
        if (!update(feline))
            felines.add(feline);
        return true;
    }

    @Override
    public boolean delete(FelineInterface feline) {
        for (FelineInterface oneFeline : felines) {
            if (feline.getId().equals(oneFeline.getId())) {
                felines.remove(oneFeline);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(FelineInterface feline) {
        for (FelineInterface oneFeline : felines) {
            if (feline.getId().equals(oneFeline.getId())) {
                felines.set(felines.indexOf(oneFeline), feline);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<FelineInterface> findAll() throws CloneNotSupportedException {
        List<FelineInterface> cloneFelines = new ArrayList<>();
        for (FelineInterface feline : felines) {
            cloneFelines.add(feline.clone());
        }
        return cloneFelines;
    }

    @Override
    public FelineInterface findById(Integer id) throws CloneNotSupportedException {
        for (FelineInterface feline : felines) {
            if (feline.getId().equals(id)) {
                return feline.clone();
            }
        }
        return null;
    }

    public List<FelineInterface> findByName(String name) throws CloneNotSupportedException {
        List<FelineInterface> findByNameFelines = new ArrayList<>();
        for (FelineInterface feline : felines) {
            if (feline.getName().equals(name)) {
                findByNameFelines.add(feline.clone());
            }
        }
        return findByNameFelines;
    }

    public List<FelineInterface> findByRace(String race) throws CloneNotSupportedException {
        List<FelineInterface> findByRaceFelines = new ArrayList<>();
        for (FelineInterface feline : felines) {
            if (feline.getRace().equals(race)) {
                findByRaceFelines.add(feline.clone());
            }
        }
        return findByRaceFelines;
    }

    // For testing
    // Fill the list with data
    public void generate() {
        felines.add(new Cat(11, "Барсик", "Шотландская", 2019));
        felines.add(new Cat(22, "Мурзик", "Британская", 2017));
        felines.add(new Cat(33, "Шурсик", "Персидская", 2018));
        felines.add(new Cat(44, "Шурсик", "Дворовая", 2015));
    }
}

