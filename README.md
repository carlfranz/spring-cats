
#Info
Create folder "~/h2/"

curl -X POST -d '{"name":"Bucky", "kind": "siamese"}' http://localhost:8080/cats -H "Content-Type:application/json"

curl -X GET http://localhost:8080/cats

curl -X POST -d '{"name":"Rob Wilco"}' http://localhost:8080/owners -H "Content-Type:application/json"

wiring:

curl -X PUT -d '{"name":"Rob Wilco", "cats": [{"id": 1}]}' http://localhost:8080/owners/1 -H "Content-Type:application/json"