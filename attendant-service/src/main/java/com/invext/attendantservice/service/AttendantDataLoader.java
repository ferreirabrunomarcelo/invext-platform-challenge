package com.invext.attendantservice.service;

import com.invext.attendantservice.model.Attendant;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.invext.attendantservice.model.TeamEnum.*;

@Component
public class AttendantDataLoader implements ApplicationRunner {
    public final List<Attendant> attendantList = new ArrayList<>();

    public AttendantDataLoader() {
        attendantList.add(Attendant.builder().id(1L).name("John Doe").team(CARD).isAvailable(true).ongoingTickets(new ArrayList<>()).build());
        attendantList.add(Attendant.builder().id(2L).name("Jane Smith").team(LOAN).isAvailable(true).ongoingTickets(new ArrayList<>()).build());
        attendantList.add(Attendant.builder().id(3L).name("Peter Parker").team(OTHER).isAvailable(false).ongoingTickets(new ArrayList<>()).build());
        attendantList.add(Attendant.builder().id(4L).name("Bill Gates").team(OTHER).isAvailable(true).ongoingTickets(new ArrayList<>()).build());
        attendantList.add(Attendant.builder().id(5L).name("Casemiro Miguel").team(LOAN).isAvailable(true).ongoingTickets(new ArrayList<>()).build());
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Os seguintes atendentes foram criados: ");
        attendantList.forEach(attendant -> {
            System.out.println("---------------------------------------");
            System.out.println("ID: " + attendant.getId());
            System.out.println("Name: " + attendant.getName());
            System.out.println("Team: " + attendant.getTeam());
            System.out.println("Is Available: " + attendant.isAvailable());
            System.out.println("Ongoing Tickets: " + attendant.getOngoingTickets().size());
         });
    }
}
