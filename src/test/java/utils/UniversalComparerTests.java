package utils;

import models.Person;
import models.TestClass;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.*;

public class UniversalComparerTests {
    @Test
    public void testPersonChief() {
        Date date1 = new Date();

        Date date2 = new Date(1212121212121L);
        Person cheif = new Person(null,"chief","chief",date1);
        Person cheif1 = new Person(null,"chief1","chief1",date1);
        Person cheif2 = new Person(null,"chief2","chief2",date1);

        Person person4=new Person(cheif,"ivan3","ivan24",date1);
        Person person2=new Person(null,"ivan1","ivan",date1);
        Person person3=new Person(null,"ivan","ivan",date1);
        Person person=new Person(cheif2,"ivan3","ivan",date1);
        Person person5=new Person(cheif1,"ivan1","ivan1",date1);

        ArrayList<Person> arrayList=new ArrayList<Person>();
        Collections.addAll(arrayList,person,person2,person3,person4,person5);
        Collections.sort(arrayList, new UniversalComparer("chief.lastName, firstName, lastName , born",true ));
        ArrayList<Person> arrayListResult = new ArrayList<Person>();
        Collections.addAll(arrayListResult,person2,person3,person4,person5,person);
        Assert.assertEquals(arrayList.toArray(),arrayListResult.toArray());
    }

    @Test
    public void testPersonLastName() {
        Date date1 = new Date();
        Person person=new Person(null,"ivan3","ivan",date1);
        Person person2=new Person(null,"ivan1","ivan",date1);
        Person person3=new Person(null,"ivan","ivan",date1);
        Person person4=new Person(null,"ivan3","ivan24",date1);
        Person person5=new Person(null,"ivan1","ivan1",date1);

        ArrayList<Person> arrayList=new ArrayList<Person>();
        Collections.addAll(arrayList,person,person2,person3,person4,person5);
        Collections.sort(arrayList, new UniversalComparer("lastName, firstName, born" ));
        ArrayList<Person> arrayListResult = new ArrayList<Person>();
        Collections.addAll(arrayListResult,person3,person2,person,person5,person4);
        Assert.assertEquals(arrayList.toArray(),arrayListResult.toArray());
    }
    @Test
    public void testPersonBorn() {
        Date date1 = new Date();
        Date date2 = new Date(1212121217070L);
        Date date3 = new Date(1212121218080L);
        Date date4 = new Date(1212121219090L);
        Date date5 = new Date(1212121219999L);

        Person person=new Person(null,"ivan1","ivan",date1);
        Person person2=new Person(null,"ivan2","ivan",date5);
        Person person3=new Person(null,"ivan3","ivan",date3);
        Person person4=new Person(null,"ivan4","ivan24",date4);
        Person person5=new Person(null,"ivan5","ivan1",date2);

        ArrayList<Person> arrayList=new ArrayList<Person>();
        Collections.addAll(arrayList,person,person2,person3,person4,person5);
        Collections.sort(arrayList, new UniversalComparer("born, lastName, firstName" ));
        ArrayList<Person> arrayListResult = new ArrayList<Person>();
        Collections.addAll(arrayListResult,person5,person3,person4,person2,person);
        Assert.assertEquals(arrayList.toArray(),arrayListResult.toArray());
    }
    @Test
    public void testTestClassById() {
        ArrayList arrayList= new ArrayList();
        TestClass testClass = new TestClass(2,"Andrey","Solovyev");
        TestClass testClass1 = new TestClass(7,"Andrey","Solovyev");
        TestClass testClass2 = new TestClass(1,"Andrey","Solovyev");
        TestClass testClass3 = new TestClass(12,"Andrey","Solovyev");
        TestClass testClass4 = new TestClass(8,"Andrey","Solovyev");
        TestClass testClass5 = new TestClass(3,"Andrey","Solovyev");

        Collections.addAll(arrayList,testClass,testClass1,testClass2,testClass3,testClass4,testClass5);
        Collections.sort(arrayList, new UniversalComparer("id desc, name, lastName" ));
        ArrayList<TestClass> arrayListResult=new ArrayList<TestClass>();
        Collections.addAll(arrayListResult,testClass3,testClass4,testClass1,testClass5,testClass,testClass2);
        Assert.assertEquals(arrayList.toArray(),arrayListResult.toArray());
    }

    @Test
    public void testTestClassBySMT() {
        ArrayList arrayList= new ArrayList();
        TestClass testClass = new TestClass(2,"Andrey","A");
        TestClass testClass1 = new TestClass(7,"Ivan","B");
        TestClass testClass2 = new TestClass(1,"Petty","C");
        TestClass testClass3 = new TestClass(12,"Marina","D");
        TestClass testClass4 = new TestClass(8,"Ivan","E");
        TestClass testClass5 = new TestClass(3,"Svetlana","F");

        Collections.addAll(arrayList,testClass,testClass1,testClass2,testClass3,testClass4,testClass5);
        Collections.sort(arrayList, new UniversalComparer("name desc, lastName asc" ));
        ArrayList<TestClass> arrayListResult=new ArrayList<TestClass>();
        Collections.addAll(arrayListResult,testClass5,testClass2,testClass3,testClass1,testClass4,testClass);
        Assert.assertEquals(arrayList.toArray(),arrayListResult.toArray());
    }
}