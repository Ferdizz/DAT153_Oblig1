package no.hvl.nameapp.data;

import android.graphics.Bitmap;

/**
 * @author Torbjørn
 */

public class Person {
    private static long IDGEN = 0;
    private Bitmap picture;
    private String name;
    private long id;

    public Person() {
        this( null, "");
    }

    public Person(Bitmap picture, String name) {
        this.picture = picture;
        this.name = name;
        this.id = IDGEN++;
    }

    public long getId() {
        return id;
    }

    public Bitmap getPicture() {
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
