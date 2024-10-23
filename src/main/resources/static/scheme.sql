INSERT INTO instructor (instructor_name, email)
VALUES ('panha', 'panha123@gmail.com');

INSERT INTO product (name, price, specifications, in_stock)
VALUES (
           'Test Product',
           99.99,
           '[{"color": "red", "size": "large"}, {"material": "leather", "waterproof": true}]'::jsonb,
           true
       );