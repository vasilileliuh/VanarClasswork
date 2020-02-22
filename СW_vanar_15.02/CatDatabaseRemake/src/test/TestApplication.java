package test;

import data.Cat;
import data.FelineInterface;
import persistance.FelineRepository;

import java.util.List;

public class TestApplication {
    public static void main(String[] args) throws CloneNotSupportedException {
        FelineInterface cat = new Cat(1, "Murzik", "British", 2018);
        FelineInterface cloned = cat.clone();

        FelineRepository repository = new FelineRepository();
        repository.generate();

        FelineInterface findByID = repository.findById(22);
        findByID.setName("Обречённый");
        repository.delete(findByID);

//        FelineInterface findByID = repository.findById(22);
//        findByID.setYear(1900);
////        findByID.setId(10000);
//        repository.update(findByID);

        System.out.println(repository.findAll());


//        List<FelineInterface> findByName = repository.findByName("Шурсик");
//        System.out.println(findByName.toString() + "\n");
//
//        List<FelineInterface> findByRace = repository.findByRace("Британская");
//        System.out.println(findByRace.toString() + "\n");
//
//        List<FelineInterface> findByRace2 = repository.findByRace("К");
//        System.out.println(findByRace2.toString() + "\n");

    }
}
