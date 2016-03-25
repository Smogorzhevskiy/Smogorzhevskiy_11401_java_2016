package services;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SearchServiceImpl implements SearchService {
    private static Logger logger = Logger.getLogger(SearchServiceImpl.class.getName());

    @Override
    public String getSearchAddress(String currAddress) {
        String searchAddress;
        switch (currAddress) {
            case "baidu.com":
                searchAddress = "www.baidu.com/s";
            case "bing.com":
                searchAddress = "www.bing.com/search";
            case "yahoo.com":
                searchAddress = "search.yahoo.com/search";
            case "aol.com":
                searchAddress = "search.aol.com/aol/search";
            default:
                searchAddress = "";
        }
        logger.info("You should search it on " + searchAddress);
        return searchAddress;
    }

    @Override
    public String getSearchParam(String currParam) {
        String searchParam;
        switch (currParam) {
            case "baidu.com":
                searchParam = "wd";
            case "bing.com":
                searchParam = "q";
            case "yahoo.com":
                searchParam = "p";
            case "aol.com":
                searchParam = "q";
            default:
                searchParam = "";
        }
        logger.info("You should search " + searchParam);
        return searchParam;
    }
}
