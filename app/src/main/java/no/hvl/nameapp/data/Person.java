package no.hvl.nameapp.data;

import android.net.Uri;

/**
 * @author Torbjørn
 */

public class Person {
    private static long IDGEN = 0;
    private Uri imageURI;
    private String name;
    private long id;

    public Person() {
        this( null, "");
    }

    public Person(Uri imageURI, String name) {
        this.imageURI = imageURI;
        this.name = name;
        this.id = IDGEN++;
    }

    public long getId() {
        return id;
    }

    public Uri getImageURI() {
        return imageURI;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
