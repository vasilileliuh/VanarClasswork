package data;

import java.io.*;

public class Cat implements FelineInterface, Serializable {
    private String name;
    private String race;
    private int year;
    private Integer id;

    public Cat(Integer id, String name, String race, int year) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRace() {
        return race;
    }

    @Override
    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Cat clone() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = null;
        try {
            ous = new ObjectOutputStream(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //сохраняем состояние кота Васьки в поток и закрываем его(поток)
        try {
            ous.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //создаём кота для опытов и инициализируем его состояние Васькиным
        try {
            return (Cat) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "ID='" + id + '\'' +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", year=" + year +
                '}';
    }

}
