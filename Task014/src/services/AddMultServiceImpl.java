package services;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AddMultServiceImpl implements AddMultService {
    private static Logger logger = Logger.getLogger(DateServiceImpl.class.getName());

    @Override
    public Integer add(Integer num, Integer num1) {
        Integer result = num + num1;
        logger.info("Result of " + num + " and " + num1 + " addition is " + result);
        return result;
    }

    @Override
    public Integer mult(Integer num, Integer num1) {
        Integer result = num * num1;
        logger.info("Result of " + num + " and " + num1 + " multiplication is " + result);
        return result;
    }
}
