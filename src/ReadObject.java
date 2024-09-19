import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("people.bin");
            ObjectInput ois = new ObjectInputStream(fis);

            Person [] people = (Person[]) ois.readObject();

            System.out.println(Arrays.toString(people));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
