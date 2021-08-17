cd UserManagmetnSystemBE
mvn package

docker build -t lengarski/usermanagment:latest .

cd ..


cd UserManagmetnSystemFE

docker build -t  lengarski/usermanagment-web:latest .

cd ..
