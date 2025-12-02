package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.support.SimpleTriggerContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
//    @CsvSource({ //for csv content
//            "anuj","ram", "vipul"
//    })
    @ValueSource(  //if we want to give value content
            strings = {
            "anuj","ram", "vipul"
    })
    public void testAdd(String userName){

        assertNotNull(userRepository.findByUserName(userName),"Failed for" +  userName);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
             "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }

}
