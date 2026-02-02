package org.example;

public class ServerBuilder {
    private String ipAddress;
    private Location location;
    private User owner;
    private String hostname;
    private ServerStatus status = ServerStatus.UP;
    private Integer cpuCores;
    private Integer ramGb;
    private Integer storageGb;

    public ServerBuilder(String ipAddress, Location location, User owner) {
        this.ipAddress = ipAddress;
        this.location = location;
        this.owner = owner;
    }

    public ServerBuilder setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    public ServerBuilder setStatus(ServerStatus status) {
        if (status != null)
            this.status = status;

        return this;
    }

    public ServerBuilder setCpuCores(String cpuStr) {
        if (!cpuStr.isEmpty())
            this.cpuCores = Integer.parseInt(cpuStr);

        return this;
    }

    public ServerBuilder setRamGb(String ramStr) {
        if (!ramStr.isEmpty())
            this.ramGb = Integer.parseInt(ramStr);

        return this;
    }

    public ServerBuilder setStorageGb(String storageStr) {
        if (!storageStr.isEmpty())
            this.storageGb = Integer.parseInt(storageStr);

        return this;
    }

    public Server build() {
        Server server = new Server(ipAddress, location, owner, hostname, status);
        server.setCpuCores(this.cpuCores);
        server.setRamGb(this.ramGb);
        server.setStorageGb(this.storageGb);
        return server;
    }
}
