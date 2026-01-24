package org.example;

import java.util.ArrayList;
import java.util.List;

public class ResourceGroup {
    private List<User> members;
    private String ipAdress;

    public ResourceGroup(List<User> members, String ipAdress) {
        this.members = new ArrayList<>();
        this.ipAdress = ipAdress;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return members;
    }

    public void removeMember(User user) {
        members.remove(user);
    }

    public String getIpAdress() {
        return ipAdress;
    }
}
