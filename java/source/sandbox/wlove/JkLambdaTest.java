package sandbox.wlove;

import java.util.function.Function;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class JkLambdaTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkLambdaTest().run();
    }

    private void run()
    {
        test();
    }

    private void test()
    {
        testListSelect();
        testListCollect();
        testListForEach();
        testListSort();
        testListSort2();
        testListLambdaSort();

        testRunnable();
        testRunnable2();

        testFunction();
    }

    //##################################################
    //# runnables
    //##################################################

    private void testRunnable()
    {
        System.out.println();
        System.out.println("A simple runnable; no arguments, no return value.");
        Runnable f = this::handleHello;
        f.run();
    }

    private void testRunnable2()
    {
        System.out.println();
        System.out.println("Two method references.");

        doTwoRunnables(this::handleHello, this::handleWorld);
    }

    private void doTwoRunnables(Runnable a, Runnable b)
    {
        a.run();
        b.run();
    }

    private void handleHello()
    {
        System.out.println("hello");
    }

    private void handleWorld()
    {
        System.out.println("world");
    }

    //##################################################
    //# functions
    //##################################################

    private void testFunction()
    {
        System.out.println();
        System.out.println("Test a method with two functions.");

        Person p = new Person("bob", 3);
        doTwoFunctions(p, this::function1, this::function2);
        doVarArgFunctions(p, this::function1, this::function2);
    }

    private void doTwoFunctions(Person p, Function<Person,String> a, Function<Person,String> b)
    {
        System.out.printf("1. %s.%n", a.apply(p));
        System.out.printf("2. %s.%n", b.apply(p));
    }

    @SafeVarargs
    private final void doVarArgFunctions(Person p, Function<Person,String>... arr)
    {
        int i = 0;
        for ( Function<Person,String> f : arr )
            System.out.printf("%s. %s.%n", ++i, f.apply(p));
    }

    private String function1(Person e)
    {
        return e.getName().toUpperCase();
    }

    private String function2(Person e)
    {
        return e.toString();
    }

    //##################################################
    //# list
    //##################################################

    private KmList<Person> testListSelect()
    {
        System.out.println();
        System.out.println("Select names with 'a'.");

        KmList<Person> v;
        v = newList();
        v.print();
        v.select(e -> e.hasNameSubstring("a")).print();
        return v;
    }

    private KmList<Person> testListCollect()
    {
        System.out.println();
        System.out.println("Collect ages.");

        KmList<Person> v;
        v = newList();
        v.print();
        v.collect(e -> e.getAge()).print();
        return v;
    }

    private KmList<Person> testListForEach()
    {
        System.out.println();
        System.out.println("Foreach increment the age.");

        KmList<Person> v;
        v = newList();
        v.print();
        v.forEach(Person::incrementAge);
        v.print();
        return v;
    }

    private KmList<Person> testListSort()
    {
        System.out.println();
        System.out.println("A simple sort on a getter.");
        KmList<Person> v;
        v = newList();
        v.sortOn(Person::getName);
        v.print();
        return v;
    }

    private KmList<Person> testListSort2()
    {
        System.out.println();
        System.out.println("A composite sort on a getter.");
        KmList<Person> v;
        v = newList();
        v.sortOn(Person::getName, Person::getAge);
        v.print();
        return v;
    }

    private void testListLambdaSort()
    {
        System.out.println("A simple sort on whatever.");
        KmList<Person> v;
        v = newList();
        v.print();
        v.sortOn(e -> e.getName().length());
        v.print();
    }

    private KmList<Person> newList()
    {
        KmList<Person> v;
        v = new KmList<>();
        v.add(new Person("al", 15));
        v.add(new Person("bob", 25));
        v.add(new Person("cal", 23));
        v.add(new Person("dan", 23));
        v.add(new Person("erin", 21));
        return v;
    }

    //##################################################
    //# person class
    //##################################################

    private static class Person
    {
        private String  _name;
        private Integer _age;

        public Person(String name, Integer age)
        {
            _name = name;
            _age = age;
        }

        public String getName()
        {
            return _name;
        }

        public boolean hasNameSubstring(String s)
        {
            return getName().contains(s);
        }

        public Integer getAge()
        {
            return _age;
        }

        public void incrementAge()
        {
            _age++;
        }

        @Override
        public String toString()
        {
            return Kmu.format("%s(%s)", _name, _age);
        }

    }
}
