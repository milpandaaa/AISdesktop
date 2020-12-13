import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.itmo.app.DatabaseConnection;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@ExtendWith(MockitoExtension.class)
public class SampleTest {

    @Test
    public void f() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String dump = databaseConnection.dump();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Assertions.assertEquals("mysqldump -u root -p1234 pp -r C:\\Users\\milpa\\IdeaProjects\\pract\\dump\\"+dtf.format(now)+".sql",dump);
    }
}
