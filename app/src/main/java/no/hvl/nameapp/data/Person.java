package no.hvl.nameapp.data;


import android.graphics.drawable.Drawable;

/**
 * @author Torbjørn
 */

public class Person {
    private static long IDGEN = 0;
    private Integer picture;
    private String name;
    private long id;

    public Person() {
        this(null, "");
    }

    public Person(Integer picture, String name) {
        this.picture = picture;
        this.name = name;
        this.id = ++IDGEN;
    }

    public long getId() {
        return id;
    }

    public Integer getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
