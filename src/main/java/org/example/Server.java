package org.example;

public class Server {
    private String ipAddress;
    private Location location;
    private User owner;
    private String hostname;
    private ServerStatus status;
    private Integer cpuCores;
    private Integer ramGb;
    private Integer storageGb;

    public Server(String ipAddress, Location location, User owner, String hostname, ServerStatus status) {
        this.ipAddress = ipAddress;
        this.location = location;
        this.owner = owner;
        this.hostname = hostname;
        this.status = status;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Server server = (Server) o;

        return ipAddress.equals(server.ipAddress);
    }

    public int hashCode() {
        return ipAddress.hashCode();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Location getLocation() {
        return location;
    }

    public User getOwner() {
        return owner;
    }

    public String getHostname() {
        return hostname;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public void setStatus(ServerStatus status) {
        this.status = status;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Integer getRamGb() {
        return ramGb;
    }

    public void setRamGb(Integer ramGb) {
        this.ramGb = ramGb;
    }

    public Integer getStorageGb() {
        return storageGb;
    }

    public void setStorageGb(Integer storageGb) {
        this.storageGb = storageGb;
    }

    public String toString() {
        return "Server " + ipAddress + " (" + status + ")";
    }
}