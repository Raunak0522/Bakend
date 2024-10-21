package com.example.basicsofspring;

import com.example.basicsofspring.couple.Animal;
import com.example.basicsofspring.couple.Dog;
import com.example.basicsofspring.couple.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicsofSpringApplication {

    public static void main(String[] args) {
       Animal animal=new Dog();
        Person person=new Person(animal);
        person.playAnimal();
        ApplicationContext context= SpringApplication.run(BasicsofSpringApplication.class, args);
        Person personBean=context.getBean(Person.class);
        personBean.playAnimal();
    }

}
