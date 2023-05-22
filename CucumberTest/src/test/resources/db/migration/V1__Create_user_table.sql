-- src/main/resources/db/migration/V1__Create_user_table.sql
CREATE TABLE USER(
  ID INT PRIMARY KEY,
  USERNAME VARCHAR(255),
  PASSWORD VARCHAR(255)
);
