package org.example;

import java.util.HashSet;
import java.util.Set;

public class Database {
    private static Database instance;
    private Set<Server> servers;
    private Set<ResourceGroup> resourceGroups;

    private Database() {
        servers = new HashSet<>();
        resourceGroups = new HashSet<>();
    }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();

        return instance;
    }

    public Server findServerByIp(String ip) {
        for (Server s : servers)
            if (s.getIpAddress().equals(ip))
                return s;

        return null;
    }

    public ResourceGroup findGroup(String ipAddress) {
        for (ResourceGroup g : resourceGroups)
            if (g.getIpAddress().equals(ipAddress))
                return g;

        return null;
    }

    public void addResourceGroup(ResourceGroup group) {
        resourceGroups.add(group);
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public Set<Server> getServers() {
        return servers;
    }

    public void removeGroup(String ipAddress) {
        resourceGroups.removeIf(g -> g.getIpAddress().equals(ipAddress));
    }

    public void clear() {
        servers.clear();
        resourceGroups.clear();
    }
}