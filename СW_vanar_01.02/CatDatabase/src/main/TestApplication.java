package main;

import data.FelineInterface;
import persistance.FelineRepository;
import persistance.FelineRepositoryInterface;

public class TestApplication {
    public static void main(String[] args) {

        FelineRepositoryInterface fr = new FelineRepository();
        // Тип переменной | Название |

        ((FelineRepository) fr).generate();

//         System.out.println(fr.get(11));

        FelineInterface cat = fr.findById(22);
        cat.setName("Masya");

        FelineInterface cat2 = (fr.findByName("Шурсик"));
        cat2.setYear(2050);
        System.out.println("Шурсик-клон изобрёл машину времени \n" + cat2 + "\n");

        FelineInterface cat3 = (fr.findByRace("Британская"));
        cat3.setId(555);
        System.out.println("getByRace \"Британская\" method result(clone set wrong ID) \n" + cat3 + "\n");

        for (FelineInterface f : fr.findAll()) {
            System.out.println(f);
        }

    }
}
