DROP DATABASE IF EXISTS unf_dev;
CREATE DATABASE IF NOT EXISTS unf_dev;
USE unf_dev;

DROP TABLE IF EXISTS users, authorities, news;

CREATE TABLE users (
  username         VARCHAR(40)  NOT NULL,
  email            VARCHAR(40)  NOT NULL,
  password         CHAR(60)     NOT NULL,
  enabled          BOOLEAN      NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE authorities (
  username         VARCHAR(50)  NOT NULL,
  authority        VARCHAR(50)  NOT NULL,
  CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username,authority);

CREATE TABLE news (
  news_id         BIGINT        NOT NULL AUTO_INCREMENT,
  username        VARCHAR(40)   NOT NULL,
  date            TIMESTAMP     NOT NULL,
  title           VARCHAR(40)   NOT NULL,
  description     VARCHAR(255)  NOT NULL,
  PRIMARY KEY(news_id),
  CONSTRAINT fk_news_users FOREIGN KEY (username) REFERENCES users(username)
);

# password is unf_dev hashed with bcrypt
insert into users(username, email, password, enabled) values ('unf_dev', 'unv_dev@unf.uni.wroc.pl','$2a$10$J04CRozmf2qYVWKb/h7oKe5Eb4h3IKZ2gQo.bCHmACJwyYnbXe7Oe', 1);
insert into authorities (username, authority) value ('unf_dev','ROLE_USER');
insert into authorities(username, authority) value('unf_dev', 'ROLE_MODERATOR');
insert into authorities(username, authority) value('unf_dev', 'ROLE_ADMIN');

insert into news(username, date, title, description) values ('unf_dev', TIMESTAMP('2015-08-08 08:00:00'),'Some event','Automatically scheduled event');