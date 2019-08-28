INSERT INTO EMPLOYEE(email, fullname, arrival_date) VALUES ('jon.snow@gmail.com','Jon Snow', TO_DATE('17/12/2015', 'DD/MM/YYYY'))

INSERT INTO EMPLOYEE(email, fullname, arrival_date) VALUES ('tywin.lanister@gmail.com','Tywin Lannister', TO_DATE('17/07/2016', 'DD/MM/YYYY'))

INSERT INTO EMPLOYEE(email, fullname, arrival_date) VALUES ('daenerys.targaryen@gmail.com','Daenerys Targaryen', TO_DATE('19/05/2016', 'DD/MM/YYYY'))

INSERT INTO EMPLOYEE(email, fullname, arrival_date, manager_id) VALUES ('tyrion.lannister@gmail.com', 'Tyrion Lannister', TO_DATE('23/09/1992', 'DD/MM/YYYY'),SELECT id FROM EMPLOYEE WHERE fullname = 'Tywin Lannister')
INSERT INTO EMPLOYEE(email, fullname, arrival_date, manager_id) VALUES ('cersei.lannister@gmail.com','Cersei Lannister', TO_DATE('05/07/2018', 'DD/MM/YYYY'),SELECT id FROM EMPLOYEE WHERE fullname = 'Tywin Lannister')

INSERT INTO EMPLOYEE(email, fullname, arrival_date) VALUES ('walter.white@wanadoo.com','Walter White', TO_DATE('22/02/1974', 'DD/MM/YYYY'))
INSERT INTO EMPLOYEE(email, fullname, arrival_date) VALUES ('jesse.pinkman@hkbn.com','Jess Pinkman', TO_DATE('01/02/2019', 'DD/MM/YYYY'))
INSERT INTO EMPLOYEE(email, fullname, arrival_date) VALUES ('skyler.white@pizza.com','Skyler White', TO_DATE('17/12/2015', 'DD/MM/YYYY'))


INSERT INTO EMPLOYEE(email, fullname, arrival_date, manager_id) VALUES ('michael.scoffield@gmail.com', 'Michael Scoffield', TO_DATE('17/09/2012', 'DD/MM/YYYY'),SELECT id FROM EMPLOYEE WHERE fullname = 'Walter White')
INSERT INTO EMPLOYEE(email, fullname, arrival_date, manager_id) VALUES ('camille.lescalliez@gmail.com', 'Camille Lescalliez', TO_DATE('01/01/2019', 'DD/MM/YYYY'),SELECT id FROM EMPLOYEE WHERE fullname = 'Jon Snow')
