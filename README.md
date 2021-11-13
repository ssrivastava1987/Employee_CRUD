# Employee_CRUD

## Steps
#### Checkout
git checkout https://github.com/ssrivastava1987/Employee_CRUD.git

cd devnech

#### Clean and Run
mvn clean install

mvn spring-boot:run

#### Create Employee

curl -XPOST -H "Content-type: application/json" -d '{
	"name":"Clark",
	"department":"CEO",
	"age": 6,
	"phone": "12385799",
	"email":"abc@bcd.com",
	"city":"paris",
	"salary":2345454545
}' 'http://localhost:8081/v1/devnech/employees'

#### Get All Employee

curl -XGET -H "Content-type: application/json" 'http://localhost:8081/v1/devnech/employees'

#### Get employee by Id

curl -XGET -H "Content-type: application/json" 'http://localhost:8081/v1/devnech/employees/employee/<employeeId>'

#### Get employee by name
  
curl -XGET -H "Content-type: application/json" 'http://localhost:8081/v1/devnech/employees/employee?employeeName=<name>'
  
#### Update employee
  
curl -XPUT -H "Content-type: application/json" -d '{
  "id": "<employeeId>",
  "department": "CTO"
}' 'http://localhost:8081/v1/devnech/employees'
  
#### Delete employee
  
curl -v -XDELETE -H "Content-type: application/json" 'http://localhost:8081/v1/devnech/employees/<employeeId>'  


