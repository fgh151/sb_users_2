docker network create -d bridge sb_db
docker run --name sb_db \
 -e POSTGRES_DB=users \
 -e POSTGRES_USER=db_user \
 -e POSTGRES_PASSWORD=superstrongpassword \
 -v /tmp/postgres-data:/var/lib/postgres/data \
 -v ${PWD}/docker/database.sql:/docker-entrypoint-initdb.d/database.sql \
 -p 5439:5432 \
 postgres:15
 docker network connect sb_db sb_db