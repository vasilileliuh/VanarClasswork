package data;

public interface FelineInterface {

    void setName(String name);

    String getName();

    void setRace(String race);

    String getRace();

    void setYear(int year);

    int getYear();

    void setId(Integer id);

    Integer getId();

    FelineInterface clone() throws CloneNotSupportedException;


}

