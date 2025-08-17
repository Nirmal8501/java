package streams;

import java.util.List;

public class StreamsNested {
    public record Item(Integer itemId, String itemName, double price) {}

    public record Order(Integer orderId, List<Item> items) {}

    public record Customer(Integer customerId, String name, List<Order> orders) {}

    public static List<Customer> getCustomers() {
        return List.of(
                new Customer(1, "Alice", List.of(
                        new Order(101, List.of(
                                new Item(1001, "Laptop", 1200.0),
                                new Item(1002, "Mouse", 25.0)
                        )),
                        new Order(102, List.of(
                                new Item(1003, "Keyboard", 75.0)
                        ))
                )),
                new Customer(2, "Bob", List.of(
                        new Order(201, List.of(
                                new Item(1004, "Phone", 800.0),
                                new Item(1005, "Charger", 20.0)
                        )),
                        new Order(202, List.of(
                                new Item(1006, "Tablet", 400.0),
                                new Item(1007, "Stylus", 50.0)
                        ))
                )),
                new Customer(3, "Charlie", List.of(
                        new Order(301, List.of(
                                new Item(1008, "Monitor", 300.0)
                        ))
                )),
                new Customer(4, "MMK", List.of(
                        new Order(401, List.of(
                                new Item(1009, "Laptop", 300000.0)
                        ))
                )),
                new Customer(5, "NJ", List.of(
                        new Order(501, List.of(
                                new Item(1010, "Bottle", 270.0)
                        ))
                )),
                new Customer(6, "Unknown", List.of(
                        new Order(601, List.of(
                                new Item(1011, "IdkBro", 70000.0)
                        ))
                ))
        );
    }
}
