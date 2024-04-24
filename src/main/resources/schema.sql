CREATE SCHEMA IF NOT EXISTS alert;

USE alert;
CREATE TABLE IF NOT EXISTS alert (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    message VARCHAR(250) NOT NULL
);

INSERT INTO alert (employee_id, message) VALUES (1, 'Hi John!'), (1, 'How are you!'), (2, 'Hi J.Smith');

