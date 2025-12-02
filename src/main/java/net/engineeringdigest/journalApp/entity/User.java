package net.engineeringdigest.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data//Lombok annotation which covers getters, setters, etc.
@NoArgsConstructor
public class User {

    @Id
    private ObjectId id;
    @Indexed(unique = true)//For searching quickly Plus same username wont be taken by anyone else.
    // For Mongo to auto index, @Indexed(unique = true) alone won't be enough. We have to add (spring.data.mongodb.auto-index-creation = true) in properties files.
    @NonNull//Must not be null
    private String userName;
    @NonNull
    private String password;

    @DBRef //This is for connecting with JournalEntry class.
    private List<JournalEntry> journalEntries = new ArrayList<>();

    private List<String> roles;


}
