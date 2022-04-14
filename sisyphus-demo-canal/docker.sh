#mvn clean install -am -amd -Pdev -Dmaven.test.skip=true -Dsun.net.maxDatagramSockets=50
docker stop demo-canal
docker rm demo-canal
docker build -t demo-canal:0.0.1-SNAPSHOT .
#docker run -d --network sisyphus-master_default --name sisyphus-auth-authorize -p 8010:8080 sisyphus-auth-authorize
