package com.documents.demo.init;

import com.documents.demo.domain.Document;
import com.documents.demo.domain.Role;
import com.documents.demo.domain.User;
import com.documents.demo.repos.DocumentRepository;
import com.documents.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Component
public class DocumentInit implements ApplicationRunner {

    @Autowired
    private final DocumentRepository documentRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private DocumentInit(DocumentRepository documentRepository, UserRepository userRepository){
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(documentRepository.count() == 0){
            Document document1 = new Document();
            document1.setCreationDate(LocalDate.parse("2020-09-30"));
            document1.setStatus("deprecated");
            document1.setAuthor("ivan");
            document1.setFile("ivan.txt");

            Document document2 = new Document();
            document2.setCreationDate(LocalDate.parse("2020-06-03"));
            document2.setStatus("new");
            document2.setAuthor("sasha");
            document2.setFile("sasha.txt");

            Document document3 = new Document();
            document3.setCreationDate(LocalDate.parse("2020-10-03"));
            document3.setStatus("need to fix");
            document3.setAuthor("petya");
            document3.setFile("petya.txt");

            Document document4 = new Document();
            document4.setCreationDate(LocalDate.parse("2020-10-07"));
            document4.setStatus("new");
            document4.setAuthor("zhora");
            document4.setFile("zhora.txt");

            documentRepository.save(document1);
            documentRepository.save(document2);
            documentRepository.save(document3);
            documentRepository.save(document4);
        }

        if(userRepository.count() == 0){

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setRoles(Collections.singleton(new Role("ROLE_ADMIN")));


            User user = new User();
            user.setUsername("user");
            user.setPassword("user");
            user.setRoles(Collections.singleton(new Role("ROLE_USER")));

            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}
