package persistance;

import data.FelineInterface;

import java.util.List;

public interface FelineRepositoryInterface {
    boolean save(FelineInterface feline);

    boolean delete(FelineInterface feline);

    boolean update(FelineInterface feline); // Сначала находим этот объект, потом перезаписываем

    List<FelineInterface> findAll() throws CloneNotSupportedException; // Будет возвращать Empty List, если объекта не найдено

    FelineInterface findById(Integer id) throws CloneNotSupportedException; // Будет возвращать null, если объекта не найдено

    List<FelineInterface> findByName(String name) throws CloneNotSupportedException;

    List<FelineInterface> findByRace(String race) throws CloneNotSupportedException;
}
