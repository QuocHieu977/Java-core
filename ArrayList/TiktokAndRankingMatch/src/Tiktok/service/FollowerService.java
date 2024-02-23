package Tiktok.service;

import Tiktok.entities.Follower;

import java.util.ArrayList;
import java.util.Scanner;

public class FollowerService {
    public Follower inputFollower(Scanner scanner) {
        System.out.print("Nhập tên người theo dõi: ");
        String name = scanner.nextLine();
        System.out.print("Nhập id người theo dõi: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập email người theo dõi: ");
        String email = scanner.nextLine();
        System.out.print("Nhập số lượt like: ");
        int numberOfLike = Integer.parseInt(scanner.nextLine());
        return new Follower(name, id, email, numberOfLike);
    }

    public ArrayList<Follower> saveFollower(Scanner scanner) {
        ArrayList<Follower> followers = new ArrayList<>();
        String choose;
        do {
            followers.add(inputFollower(scanner));

            System.out.println("Do you want continue(Y/N): ");
            choose = scanner.nextLine();
        } while (!choose.equalsIgnoreCase("n"));
        return followers;
    }
}
