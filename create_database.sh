#! /bin/bash

docker exec -i instituto mysql -u root -pfederica < jdbc/src/main/resources/database.sql

