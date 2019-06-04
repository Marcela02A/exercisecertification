
import Entities.Address;
import Entities.Employee;
import Entities.MyClass;
import business.OrderFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import javax.naming.directory.BasicAttribute;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlos.martinez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        orderPDFFile("C:\\Users\\Marcela\\Documents\\");
    }

    public static void UnaryOperator() {
        final String str1 = "Java";
        StringBuffer strBuf = new StringBuffer("Cource");
        UnaryOperator<String> u = (str2) -> str1.concat(str2);
        UnaryOperator<String> c = (str3) -> str3.toLowerCase();
        //Error conversion de tipos
        System.out.println(u.apply(c.apply(strBuf.toString())));
    }

    public static void hasMap() {
        Map<Integer, String> unsortMap = new HashMap<>();
        unsortMap.put(10, "z");
        unsortMap.put(5, "b");
        unsortMap.put(1, "d");
        unsortMap.put(7, "e");
        unsortMap.put(50, "j");

        Map<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t, Integer t1) {
                return t1.compareTo(t);
            }
        });

        treeMap.putAll(unsortMap);

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }

    }

    public static void optionalExam() {

        Address address = new Address();
        Optional<Address> addrsl = Optional.ofNullable(address);
        Employee employee = new Employee(addrsl);
        String eAddress = (addrsl.isPresent()) ? addrsl.get().getCity() : "City not available";
        System.out.println(eAddress);

    }

    public static void ZoneHora() {
        ZoneId zone = ZoneId.of("America/New_York");
        ZonedDateTime dt = ZonedDateTime.of(LocalDate.of(2015, 3, 8), LocalTime.of(1, 0), zone);

        ZonedDateTime dt2 = dt.plusHours(2);
        //Horario de verano 
        System.out.println(DateTimeFormatter.ofPattern("H:mm - ").format(dt2));
        System.out.println("difference: " + ChronoUnit.HOURS.between(dt, dt2));
    }

    public static void LecturaArchivos() {

        try {
            Stream<Path> files = Files.walk(Paths.get(System.getProperty("user.home")));

            files.forEach(fName -> {
                try {
                    Path aPath = fName.toAbsolutePath();
                    System.out.println(fName + ":"
                            + Files.readAttributes(aPath, BasicFileAttributes.class).creationTime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void Txt() throws FileNotFoundException, IOException {
        int i;
        char c;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\carlos.martinez\\Desktop\\course.txt");
                InputStreamReader isr = new InputStreamReader(fis);) {
            while (isr.ready()) {
                isr.skip(2);
                i = isr.read();
                c = (char) i;
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void orderPDFFile(String route){
    OrderFile orderRute = new OrderFile();
    orderRute.execute(route);
    }
}
