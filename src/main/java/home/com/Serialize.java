package home.com;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

public class Serialize {
    public static void main(String args[]) throws IOException{

        //Instantiating generated emp class
        emp e1=new emp();

        //Creating values according the schema
        e1.setName("omar");
        e1.setAge(21);
        e1.setSalary(30000);
        e1.setAddress("Hyderabad");
        e1.setId(001);

        emp e2=new emp();

        e2.setName("ram");
        e2.setAge(30);
        e2.setSalary(40000);
        e2.setAddress("Hyderabad");
        e2.setId(002);

        emp e3=new emp();

        e3.setName("robbin");
        e3.setAge(25);
        e3.setSalary(35000);
        e3.setAddress("Hyderabad");
        e3.setId(003);

        //Instantiate DatumWriter class
        DatumWriter<emp> empDatumWriter = new SpecificDatumWriter<emp>(emp.class);
        DataFileWriter<emp> empFileWriter = new DataFileWriter<emp>(empDatumWriter);

        empFileWriter.create(e1.getSchema(), new File("/Users/zaks/Downloads/emp.avro"));

        for(int i=0;i<333333;i++) {
            empFileWriter.append(e1); 
            empFileWriter.append(e2);
            empFileWriter.append(e3);
        }

        empFileWriter.close();

        System.out.println("data successfully serialized");
    }
}