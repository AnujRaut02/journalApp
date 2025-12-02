package net.engineeringdigest.journalApp.service;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {

    //logs implementation without Slf4j annotation
    //private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            /*   Severity High to low (1 to 5)
            TRACE -> Level 1
            * DEBUG -> Level 2
            * INFO -> Level 3
            * WARN -> Level 4
            * ERROR -> Level 5
            * */

            /*start printing logs by logger without Slf4j annotation*/
            //logger.info("Error occurred for {}",user.getUserName(),e);
            // logger.error("error");
            // logger.warn("warn");
            // logger.debug("debug");
            // logger.trace("trace");


            /*start printing logs by log when using Slf4j annotation*/
            log.error("Error occurred for {}",user.getUserName());
            log.warn("warn occurred for {}",user.getUserName());
            log.info("info occurred for {}",user.getUserName());
            log.debug("debug occurred for {}",user.getUserName());
            log.trace("trace occurred for {}",user.getUserName());

            return false;
        }

    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId myId){
        return userRepository.findById(myId);
    }

    public void deleteById(ObjectId myId){
        userRepository.deleteById(myId);
    }


    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
