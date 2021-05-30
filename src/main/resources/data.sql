INSERT INTO bandages(id, length, material,  width, name) VALUES
(1, 1000, 'CLOTH',  8, 'BandageUA'),
(2, 1500, 'SILK',  13, 'Tight Bandage'),
(3, 750, 'CLOTH',  15, 'Wide bandage'),
(4, 1750, 'CLOTH',  18, 'Large Bandage');
INSERT INTO gloves(id, material,  name) VALUES
(1, 'RUBBER',  'Medical gloves'),
(2, 'LEATHER',  'Healthcare gloves'),
(3, 'CLOTH',  'Simple gloves');
INSERT INTO garrots(id, length, width, name) VALUES
(1, 560,  10, 'Medical garrot'),
(2, 1100,  15, 'Simple garrot'),
(3, 1600,  18, 'Big garrot');
INSERT INTO aidkits(id, name, bandage_id, garrot_id, gloves_id) VALUES
(1, 'Simple aidkit', 1, 1, 1),
(2, 'Proffesion aidkit', 2, 2, 2);
INSERT INTO roles(id, name) VALUES
(1, 'User'),
(2, 'Admin');
INSERT INTO users(id, email, name, password, surname, role_id) VALUES
(1, 'max2001zh@gmail.com', 'Maksym', 'qwe', 'Zhuk', 1),
(2, 'admin@gmail.com', 'Sebastian', 'qwe', 'Fors', 2);
