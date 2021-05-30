INSERT INTO bandages(id, length, material,  width, name) VALUES
(1, 10, 'CLOTH',  20, 'BandageUA'),
(2, 15, 'SILK',  10, 'Tight Bandage'),
(3, 10, 'CLOTH',  20, 'Wide bandage'),
(4, 20, 'CLOTH',  30, 'Large Bandage');
INSERT INTO gloves(id, material,  name) VALUES
(1, 'RUBBER',  'Medical gloves'),
(2, 'LEATHER',  'Healthcare gloves'),
(3, 'CLOTH',  'Simple gloves');
INSERT INTO garrots(id, length, width, name) VALUES
(1, 10,  10, 'Medical garrot'),
(2, 30,  20, 'Simple garrot'),
(3, 30,  20, 'Big garrot');
INSERT INTO aidkits(id, name, bandage_id, garrot_id, gloves_id) VALUES
(1, 'Simple aidkit', 1, 1, 1),
(2, 'Proffesion aidkit', 2, 2, 2);
INSERT INTO roles(id, name) VALUES
(1, 'User'),
(2, 'Admin');
INSERT INTO users(id, email, name, password, surname, role_id) VALUES
(1, 'max2001zh@gmail.com', 'Maksym', 'qwe', 'Zhuk', 1),
(2, 'admin@gmail.com', 'Sebastian', 'qwe', 'Fors', 2);
