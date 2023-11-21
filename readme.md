# Users microservice

## HTTP methods:

 * POST /users - create user
 * GET /users/{id} - get user by id
 * PUT /users/{id} - update user by id
 * DELETE /users/{id} - delete user by id

POST and PUT param:

```json
{
  "firstName" : "Name",
  "lastName" : "Last",
  "fatherName" : "Father",
  "gender" : "male",
  "birthday" : "11-11-2000"
}
```
## Run

```shell
./gradlew bootRun
```
