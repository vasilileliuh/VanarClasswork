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
        return false;
    }

    @Override
    public List<FelineInterface> all() {
        return felines;
    }

    @Override
    public FelineInterface get(Integer id) {
        for (FelineInterface f : felines) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    public FelineInterface getByName(String name) {
        for (FelineInterface feline : felines) {
            if (feline.getName().equals(name))
                return feline;
        }
        return null;
    }

    public FelineInterface getByRace(String race) {
        for (FelineInterface feline : felines) {
            if (feline.getRace().equals(race))
                return feline;
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
