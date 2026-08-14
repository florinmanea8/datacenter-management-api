# Datacenter Management API

## Overview
This project is a Java-based API built to manage system alerts and IT infrastructure. The application simulates a real-world datacenter monitoring system by processing command streams and routing system alerts to the correct monitoring teams. The core architecture connects infrastructure management, user groups, and event generation dynamically through server IP addresses.

## Core Features
- **Infrastructure Management:** Registers and tracks servers, managing details such as IP address, physical location, hardware specifications (CPU, RAM, Storage), and operational status (UP, DOWN, DEGRADED).
- **Role-Based Access Control (RBAC):** Manages different hierarchical user levels: standard Users, Operators (assigned to specific departments), and Admins (requiring specific clearance levels).
- **Resource Monitoring Groups:** Allows the creation of dedicated teams assigned to monitor specific servers based on their IP addresses.
- **Event-Driven Alert System:** When a server generates a new alert (Anomaly or Advisory) with varying severity levels (Low, Medium, High, Critical), the system automatically notifies the linked monitoring group so operators can handle the event promptly.
- **Robust Error Handling:** Implements custom exceptions to handle edge cases gracefully, such as *MissingIpAddressException*, *LocationException*, and *UserException*.

## Technical Architecture & Design Patterns
The application is strictly built upon Object-Oriented Programming principles, utilizing inheritance, polymorphism, and advanced error handling.

To ensure clean code, separation of concerns, and scalability, the architecture implements several Design Patterns:
- **Singleton Pattern:** Used for the central *Database* instance to prevent multiple instantiations and maintain a single source of truth for the in-memory collections of servers, resource groups, and alerts.
- **Command Pattern:** Encapsulates incoming requests as objects (e.g., *AddServerCommand*, *AddEventCommand*), executed via a *CommandInvoker*.
- **Factory Pattern:** Utilized (*UserFactory*) to abstract and centralize the creation logic for different types of users based on roles.
- **Builder Pattern:** Implemented (*ServerBuilder*) to handle the flexible construction of Server objects with multiple optional parameters (like hostname or storage).

## How It Works

The API acts as a processor for simulated batch commands, reading from CSV-like input files separated by the pipe | character. It processes infrastructure commands (*ADD SERVER*), group management commands (*ADD GROUP*, *ADD MEMBER*), and system events (*ADD EVENT*), logging the state changes and captured exceptions to designated output streams.