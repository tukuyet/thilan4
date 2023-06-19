CREATE DATABASE phone;

USE phone;

CREATE TABLE phones (
  id INT NOT NULL AUTO_INCREMENT,
  phoneName VARCHAR(255) NOT NULL,
  brand VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO phones VALUES('iPhone 12', 'Apple', 799, '6.1-inch Super Retina XDR display, A14 Bionic chip')


INSERT INTO phones VALUES('Samsung Galaxy S21', 'Samsung', 799, '6.2-inch Dynamic AMOLED 2X display, Snapdragon 888')


INSERT INTO phones VALUES('Nokia G21', 'Nokia', 200, '6.5-inch IPS LCD HD+ display, Unisoc T606')