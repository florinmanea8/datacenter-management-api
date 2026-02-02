package org.example;

import java.util.ArrayList;
import java.util.List;

public class ResourceGroup {
    private List<User> members;
    private String ipAddress;

    public ResourceGroup(String ipAddress) {
        this.members = new ArrayList<>();
        this.ipAddress = ipAddress;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ResourceGroup group = (ResourceGroup) o;
        return ipAddress.equals(group.ipAddress);
    }

    public boolean hasMember(String name, String role) {
        for (User u : members)
            if (u.getName().equals(name) && u.getRole().equals(role))
                return true;

        return false;
    }

    public int hashCode() {
        return ipAddress.hashCode();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return members;
    }

    public boolean removeMember(String name, String role) {
        return members.removeIf(u -> u.getName().equals(name) && u.getRole().equals(role));
    }

    public String getIpAddress() {
        return ipAddress;
    }
}