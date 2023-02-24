package com.example.databasestudy.service;

import com.example.databasestudy.domain.Users;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void save() {
        Users user = Users.of("성준", "01074724537");
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void generateData() {
        try{
            String fileName = "/Users/parksungjun/Desktop/db/study/MySQL_Study/users.csv";
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("user_id, "+
                    "user_name, "+
                    "phone_number");

            for (int i = 0; i < 10; i++) {
                Long user_id = Long.valueOf(i);
                String user_name = "성준" + i;
                String phone_number = "010" + i;
                printWriter.println(
                        user_id + "," + user_name + "," + phone_number
                );
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
