import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

//        PhoneBook book = new PhoneBook();
//
//         PhoneBook book2 = new PhoneBook(book);

        try {
            Path filePath = Path.of("base.json");
            String content = Files.readString(filePath);
            PhoneBook book = new PhoneBook(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}