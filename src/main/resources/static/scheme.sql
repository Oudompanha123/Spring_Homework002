INSERT INTO instructor (instructor_name, email)
VALUES ('panha', 'panha123@gmail.com');

INSERT INTO product (name, price, specifications, in_stock)
VALUES (
           'Gaming Laptop',
           1500.99,
           '{"brand": "Asus", "processor": "Intel i9", "ram": "32GB", "storage": "1TB SSD", "features": ["RGB keyboard", "VR ready"]}'::jsonb,
           true
       );
