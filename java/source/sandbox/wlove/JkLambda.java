package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class JkLambda
{
    public static void main(String[] args)
    {
        new JkLambda().run();
    }

    private void run()
    {
        KmList<Person> v = newList();

        System.out.println();
        System.out.println("Select names with 'a'.");
        v.print();
        v.select(e -> e.name.contains("a")).print();

        System.out.println();
        System.out.println("Collect ages.");
        v.print();
        v.collect(e -> e.age).print();

        System.out.println();
        System.out.println("Foreach increment the age.");
        v.print();
        v.forEach(Person::incrementAge);
        v.print();

        System.out.println();
        System.out.println("A simple sort on a getter.");
        v.print();
        v.sortOn(Person::getAge);
        v.print();

        System.out.println();
        System.out.println("A simple sort on whatever.");
        v.print();
        v.sortOn(e -> e.name.length());
        v.print();
    }

    private KmList<Person> newList()
    {
        KmList<Person> v;
        v = new KmList<>();
        v.add(create("al", 15));
        v.add(create("bob", 25));
        v.add(create("cal", 10));
        v.add(create("dan", 23));
        v.add(create("erin", 21));
        return v;
    }

    private Person create(String aName, Integer anAge)
    {
        Person e;
        e = new Person();
        e.name = aName;
        e.age = anAge;
        return e;
    }

    //##################################################
    //# class
    //##################################################

    private static class Person
    {
        String  name;
        Integer age;

        public Integer getAge()
        {
            return age;
        }

        public void incrementAge()
        {
            age++;
        }

        @Override
        public String toString()
        {
            return Kmu.format("%s(%s)", name, age);
        }

    }
}
