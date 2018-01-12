package no.hvl.nameapp.data;

import java.util.ArrayList;
import no.hvl.nameapp.R;

/**
 * @author Torbjørn on 12.01.2018.
 */

public class PersonDB {

        private static PersonDB instance = null;
        private ArrayList<Person> list = new ArrayList<>();

        private PersonDB() {
            list.add(new Person(R.drawable.img1,"Mona"));
            list.add(new Person(R.drawable.img2,"Timmy"));
            list.add(new Person(R.drawable.img3,"Per"));
            list.add(new Person(R.drawable.img4,"Hans"));
            list.add(new Person(R.drawable.img5,"Ole"));
            list.add(new Person(R.drawable.img6,"Tine"));
            list.add(new Person(R.drawable.img7,"Tim"));
            list.add(new Person(R.drawable.img8,"Geir"));
            list.add(new Person(R.drawable.img9,"Tommy"));
            list.add(new Person(R.drawable.img10,"Stine"));
            list.add(new Person(R.drawable.img11,"Rupert"));
            list.add(new Person(R.drawable.img12,"Franz"));
        }
        public static PersonDB getInstance() {
            if(instance == null) {
                instance = new PersonDB();
            }
            return instance;
        }
        public int count() {
            return list.size();
        }
        public Person getPersonByIndex(int i) {
            return list.get(i);
        }
        public long getIdByIndex(int i) {
            return list.get(i).getId();
        }

        public ArrayList<Person> getAll() {
            return list;
        }
        public void addPerson(Person p) {
            list.add(p);
        }
        public Person getPersonById(long id) {
            for (Person p : list) {
                if (p.getId() == id)
                    return p;
            }
            return null;
        }

}
