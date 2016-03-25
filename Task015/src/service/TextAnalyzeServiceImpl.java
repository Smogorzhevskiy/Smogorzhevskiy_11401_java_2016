package service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TextAnalyzeServiceImpl implements TextAnalyzeService {
    private static Logger logger = Logger.getLogger(TextAnalyzeServiceImpl.class.getName());

    @Override
    public Integer analyze(String text, String analyzeParam) {
        Integer amount;
        switch (analyzeParam) {
            case "characters amount": {
                amount = text.length();
                logger.info("Number of characters is " + amount);
            }
            case "sentences amount": {
                String[] st = text.split("[!\\.\\?]");
                amount = st.length;
                logger.info("Number of sentences is " + amount);
            }
            case "paragraphs amount": {
                String[] p = text.split("\\n");
                amount = p.length;
                logger.info("Number of paragraphs is " + amount);
            }
            case "words amount": {
                String[] str = text.split(" ");
                amount = str.length;
                logger.info("Number of words is " + amount);
            }
            default:
                amount = 0;
        }
        return amount;
    }
}
