import service.TextAnalyzeService;
import service.TextAnalyzeServiceImpl;

/**
 * Created by User on 31.03.16.
 */
public class Main {
    public static void main(String[] args) {
        TextAnalyzeService service = new TextAnalyzeServiceImpl();
        service.analyze("i'm happy. And you?", "characters amount");
    }
}
