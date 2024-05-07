create table Customer
(
    customer_id            int auto_increment
        primary key,
    customer_name          varchar(255) not null,
    customer_status        ENUM('GOLD', 'SILVER', 'NONE') NOT NULL,
    total_customer_mileage int          not null
);

INSERT INTO Aerolines.Customer (customer_id, customer_name, customer_status, total_customer_mileage) VALUES (11, 'Pepe Riviera', '0', 115235);
