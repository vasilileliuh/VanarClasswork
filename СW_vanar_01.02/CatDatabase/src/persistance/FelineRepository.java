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
        return false;
    }

    @Override
    public boolean delete(FelineInterface feline) {
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
    public List<FelineInterface> findAll() {
        ArrayList<FelineInterface> cloneFelines = new ArrayList<>();
        for (FelineInterface feline : felines) {
            Cat cat = (Cat) feline;
            cloneFelines.add(cat.clone());
        }
        return cloneFelines;
    }

    @Override
    public FelineInterface findById(Integer id) {
        for (FelineInterface feline : felines) {
            if (feline.getId().equals(id)) {
                Cat cat = (Cat) feline;
                return cat.clone();
            }
        }
        return null;
    }

    public FelineInterface findByName(String name) {
        for (FelineInterface feline : felines) {
            if (feline.getName().equals(name)) {
                Cat cat = (Cat) feline;
                return cat.clone();
            }
        }
        return null;
    }

    public FelineInterface findByRace(String race) {
        for (FelineInterface feline : felines) {
            if (feline.getRace().equals(race)) {
                Cat cat = (Cat) feline;
                return cat.clone();
            }
        }
        return null;
    }

    // For testing
    // Fill the list with data
    public void generate() {
        felines.add(new Cat(11, "Барсик", "Шотландская", 2019));
        felines.add(new Cat(22, "Мурзик", "Британская", 2017));
        felines.add(new Cat(33, "Шурсик", "Персидская", 2018));
    }
}
