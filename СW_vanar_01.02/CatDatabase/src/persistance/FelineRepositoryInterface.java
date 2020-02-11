package persistance;

import data.FelineInterface;

import java.util.List;

public interface FelineRepositoryInterface {
    boolean save(FelineInterface feline);

    boolean delete(FelineInterface feline);

    boolean update(FelineInterface feline); // Сначала находим этот объект, потом перезаписываем

    List<FelineInterface> all(); // Будет возвращать Empty List, если объекта не найдено

    FelineInterface get(Integer id); // Будет возвращать null, если объекта не найдено

    FelineInterface getByName(String name);

    FelineInterface getByRace(String race);
}
