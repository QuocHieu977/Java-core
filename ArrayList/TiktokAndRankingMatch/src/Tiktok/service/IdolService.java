
package Tiktok.service;

import Tiktok.entities.Follower;
import Tiktok.entities.Idol;

import java.util.ArrayList;
import java.util.Scanner;

public class IdolService {
    public Idol inputIdol(Scanner scanner) {
        System.out.print("Nhập tên Idol: ");
        String name = scanner.nextLine();
        System.out.print("Nhập id Idol: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập email Idol: ");
        String email = scanner.nextLine();
        FollowerService followerService = new FollowerService();
        ArrayList<Follower> followers = followerService.saveFollower(scanner);
        System.out.print("Nhập tên group: ");
        String group = scanner.nextLine();
        return new Idol(name, id, email, followers, group);
    }
}
