import java.io.IOException;
import model.ImageStatistic;
import model.Request;
import service.ImageStatisticService;

public class Main {

    private static final ImageStatisticService service = new ImageStatisticService();

    public static void main(String[] args) throws IOException {
        Request request = new Request("D:/images/image.jpg", true, 10);
        ImageStatistic statistic = service.parse(request);
    }
}