官方文档：
    https://dubbo.gitbooks.io/dubbo-user-book/content/

dubbo-admin

    docker run -d \
    -p 8888:8080 \
    -e dubbo.registry.address=zookeeper://172.17.0.2:2181 \
    -e dubbo.admin.root.password=root \
    -e dubbo.admin.guest.pas