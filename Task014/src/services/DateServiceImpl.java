package services;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class DateServiceImpl implements DateService {
    private static Logger logger = Logger.getLogger(DateServiceImpl.class.getName());

    @Override
    public Date getDate() {
        Date curr = new Date();
        logger.info("Current date is " + curr);
        return curr;
    }
}
