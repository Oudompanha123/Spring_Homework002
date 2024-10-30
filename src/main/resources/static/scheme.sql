INSERT INTO instructor (instructor_name, email)
VALUES ('panha', 'panha123@gmail.com');

INSERT INTO product (name, price, specifications, in_stock)
VALUES (
           'Test Product',
           99.99,
           '[{"color": "red", "size": "large"}, {"material": "leather", "waterproof": true}]',
           true
       );

UPDATE public.product
SET specifications = '[{"additionalProp1": {"storage": "1TB", "graphics": "4K HDR", "processor": "Custom AMD CPU"}, "additionalProp2": {"controllerIncluded": true, "onlineSubscription": "Available", "backwardCompatibility": true}, "additionalProp3": {"brand": "GameSphere", "color": "Black", "releaseDate": "2023-11-15"}}]'
WHERE id = 18;

SELECT *
FROM product
WHERE specifications -> 'additionalProp1' ->> 'color' = 'blue';