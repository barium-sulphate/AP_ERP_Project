#!/bin/bash

# echo "Starting ERP Database Setup..."
# read -sp "Enter MySQL root password: " ROOTPASS
# echo ""

# mariadb -u root -p"$ROOTPASS" < ./src/main/resources/db/deploy.sql
# mariadb -u root -p"$ROOTPASS" < ./src/main/resources/db/auth_scheme.sql
# mariadb -u root -p"$ROOTPASS" < ./src/main/resources/db/erp_scheme.sql

# mvn compile
# mvn exec:java -Dexec.mainClass="ui.LoginUI"

echo "Starting ERP Database Setup..."

sudo mariadb < ./src/main/resources/db/deploy.sql
sudo mariadb < ./src/main/resources/db/auth_scheme.sql
sudo mariadb < ./src/main/resources/db/erp_scheme.sql

mvn clean compile
mvn exec:java



