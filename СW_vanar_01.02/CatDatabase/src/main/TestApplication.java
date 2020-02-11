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

        FelineInterface cat = fr.get(22);
        cat.setName("Masya");

        FelineInterface cat2 = (fr.getByName("Шурсик"));
        System.out.println("getByName \"Шурсик\" method result: \n" + cat2 + "\n");

        FelineInterface cat3 = (fr.getByRace("Британская"));
        System.out.println("getByRace \"Британская\" method result \n" + cat3 + "\n");

        for (FelineInterface f : fr.all()) {
            System.out.println(f);
        }

    }
}
