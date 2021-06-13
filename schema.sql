
CREATE USER 'catalogadmin'@'localhost' IDENTIFIED BY 'Password@1234';
ALTER USER 'catalogadmin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Password@1234';
create database catalog;
GRANT ALL PRIVILEGES ON catalog.* TO 'catalogadmin'@'localhost';


