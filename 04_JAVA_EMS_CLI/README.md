```sql
CREATE DATABASE user;
use user;

CREATE TABLE user_table (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (id));

desc user;
```