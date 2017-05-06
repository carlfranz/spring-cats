
#Info
Create folder "~/h2/"

#add cats

curl -X POST -d '{"name":"Bucky", "kind": "siamese"}' http://localhost:8080/cats -H "Content-Type:application/json"

curl -X POST -d '{"name":"Hobbes", "kind": "plush bengal tiger"}' http://localhost:8080/cats -H "Content-Type:application/json"

curl -X POST -d '{"name":"Mr. Bigglesworth", "kind": "persian cat"}' http://localhost:8080/cats -H "Content-Type:application/json"

#get all cats

curl -X GET http://localhost:8080/cats

#add owners

curl -X POST -d '{"name":"Rob Wilco"}' http://localhost:8080/owners -H "Content-Type:application/json"

curl -X POST -d '{"name":"Calvin"}' http://localhost:8080/owners -H "Content-Type:application/json"

curl -X POST -d '{"name":"Dr. Evil"}' http://localhost:8080/owners -H "Content-Type:application/json"


#wire entities:

curl -X PUT -d '{"name":"Rob Wilco", "cats": [{"id": 1}]}' http://localhost:8080/owners/1 -H "Content-Type:application/json"

curl -X PUT -d '{"name":"Calvin", "cats": [{"id": 65}]}' http://localhost:8080/owners/33 -H "Content-Type:application/json"