


INSERT INTO author (name,email,phone,birthdate) VALUES ( 'Luis Alfaro', 'lalfaro@gmail.com','12345678','2004-02-28T11:00');
INSERT INTO author (name,email,phone,birthdate) VALUES ('Carlos Ramos', 'cramos@gmail.com','34512398','1971-01-30T11:00');

INSERT INTO blog (name,description,url,status,author_id) VALUES ('El Blog de Carlos 1','El Blog de Luis','https://blogcarlos1.com','activo',2);
INSERT INTO blog (name,description,url,status,author_id) VALUES ('El Blog de Carlos 2','El Blog de Carlos','https://blogcarlos2.com','activo',2);

INSERT INTO post (title,date,status,content,blog_id) VALUES ('Hola Luis','2020-01-30T11:00','publicado','Hola mundo',1);
INSERT INTO post (title,date,status,content,blog_id) VALUES ('Hola Carlos','2020-01-30T11:00','publicado','Hola mundo',2);

INSERT INTO comment (date,name,estado,comment,post_id) VALUES ('2020-01-30T11:00','Pedro','publicado','Excelente post Luis',1);
INSERT INTO comment (date,name,estado,comment,post_id) VALUES ('2020-01-30T11:00','Pedro','publicado','Excelente post Carlos',2);



