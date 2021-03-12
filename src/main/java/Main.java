import models.Person;
import models.TestClass;
import utils.UniversalComparer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date();

        Date date2 = new Date(1212121212121L);
//        Person cheif = new Person(null,"chief","chief",date2);
//        Person cheif1 = new Person(null,"chief1","chief1",date2);
//        Person cheif2 = new Person(null,"chief2","chief2",date2);
//
//        Person person4=new Person(cheif,"ivan3","ivan24",date1);
//        Person person2=new Person(null,"ivan1","ivan",date1);
//        Person person3=new Person(null,"ivan","ivan",date1);
//        Person person=new Person(cheif2,"ivan3","ivan",date1);
//        Person person5=new Person(cheif1,"ivan1","ivan1",date1);
//
//        ArrayList<Person> arrayList=new ArrayList<Person>();
//        Collections.addAll(arrayList,person,person2,person3,person4,person5);
        ArrayList arrayList= new ArrayList();
        Collections.addAll(arrayList,new TestClass(2,"Andrey","Solovyev"),new TestClass(2,"Andrey","Solovyev"),new TestClass(5,"Andrey","Solovyev"),new TestClass(1,"Andrey","Solovyev"),new TestClass(8,"Andrey","Solovyev"));
        Collections.sort(arrayList, new UniversalComparer("id desc, name, lastName" ));

//        Collections.sort(arrayList, new UniversalComparer("chief.lastName, lastName, born" ));
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
