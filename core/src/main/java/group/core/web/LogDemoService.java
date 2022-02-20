package group.core.web;

import group.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    //private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    public void logic(String testID) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + testID);
    }
}
