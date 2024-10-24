INSERT INTO instructor (instructor_name, email)
VALUES ('panha', 'panha123@gmail.com');

INSERT INTO product (name, price, specifications, in_stock)
VALUES (
           'Smartphone and PC',
           799.99,
           '[
             {
                "brand": "Samsung", "model": "Galaxy S21", "ram": "8GB", "storage": "128GB", "features": ["5G", "wireless charging"]
             },
             {
               "brand": "Dell", "model": "Dell nice", "ram": "16GB", "storage": "512GB", "features": ["5G", "wireless charging"]
             },
             {
               "brand": "MSI", "model": "MSI 4", "ram": "16GB", "storage": "512GB", "features": ["5G", "wireless charging"]
             }
           ]'::jsonb,
           true
       );