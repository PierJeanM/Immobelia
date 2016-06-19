INSERT into adresses values (1, "44000", 12, "Rue du Hibou", "Nantes");
INSERT into adresses values (2, "44800", 5, "Rue du chocolat", "Saint-Herblain");
INSERT into adresses values (3, "44999", 3, "Rue du pin", "JavaCity");
INSERT into adresses values (4, "44800", 4, "Rue de la mort", "Beanville");
INSERT into adresses values (5, "44900", 56, "Rue de la rue", "EclipseHouse");
INSERT into adresses values (6, "44650", 0, "Boulevard des pintades", "PouleTown");
INSERT into adresses values (7, "44650", 0, "Boulevard des chevres", "PouleTown");
INSERT into adresses values (8, "44950", 0, "Boulevard des chameaux", "Nullepart");
INSERT into adresses values (9, "44000", 0, "Boulevard des dindons", "Nantes");
INSERT into adresses values (10, "44000", 0, "Boulevard des poules", "Nantes");


INSERT into conseillersimmobilier values (1, "Mouse", "Mickey", "0100000000", "1234", 1);
INSERT into conseillersimmobilier values (2, "Duck", "Donald", "0100000001", "2345", 2);

INSERT into clients values (1, "Jacky", "Michel", "0200000000", 3 , 1);
INSERT into clients values (2, "Rasta", "Philippe", "0200000001", 4 , 1);
INSERT into clients values (3, "Agile", "Frantz", "0200000002", 5 , 2);
INSERT into clients values (4, "Dupont", "Raoul", "0200000001", 6, 2);
 
 
INSERT into proprietaires values (1, "Fripouille", "Jacquouille", "0200000081", "0270000081", 7, 1);
INSERT into proprietaires values (2, "Montmirail", "Hubert", "0200980081", "0272300081", 8, 1);
INSERT into proprietaires values (3, "Rabbit", "Roger", "0265000081", "0270000081", 9, 2);
INSERT into proprietaires values (4, "Snow", "Jon", "0200009081", "0270500081", 10, 2);



INSERT into classes_standards values (1, 2, 100000, 40, "appartement", "achat");
INSERT into classes_standards values (2, 4, 300000, 70, "appartement", "achat");
INSERT into classes_standards values (3, 2, 100000, 40, "appartement", "location");
INSERT into classes_standards values (4, 4, 300000, 70, "appartement", "location");
INSERT into classes_standards values (5, 2, 100000, 40, "maison", "achat");
INSERT into classes_standards values (6, 4, 300000, 70, "maison", "achat");
INSERT into classes_standards values (7, 2, 100000, 40, "maison", "location");
INSERT into classes_standards values (8, 4, 300000, 70, "maison", "location");





INSERT into bienimmobiliers values("appartement", 1, '2016-01-01 00:00:00', '2015-12-23 00:00:00', 99000, 1200, true, 53, null, 0100000000, "habitation", null, null, false, null, null, null, 1, 1, 1, 1);

INSERT into aacheter values (1, 1, "correct");

INSERT into contrats values (1, '2016-02-01 00:00:00', 1, 1, 1);

INSERT into client_classestandard values (1,4);

INSERT into visites values (1, '2016-06-18 00:00:00', 1, 1, 1);