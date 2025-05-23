# Java Formula Evaluator - Spring Boot Project

##  Problem 1: Evaluate Dependent Formulas from JSON

-This Spring Boot project takes a JSON array of calculation fields with formulas and evaluates them based on field dependencies.

### Sample Input
json
[
  {"calculateField":"customFloat1", "formula":"10+15"},
  {"calculateField":"customFloat2", "formula":"customFloat1*10"},
  {"calculateField":"customFloat3", "formula":"customFloat2-18"},
  {"calculateField":"customFloat4", "formula":"customFloat3+customFloat2"}
]
### Sample Output
[
  { "fieldName": "customFloat1", "value": 25.0 },
  { "fieldName": "customFloat2", "value": 250.0 },
  { "fieldName": "customFloat3", "value": 232.0 },
  { "fieldName": "customFloat4", "value": 482.0 }
]
# How to Run
-Prerequisites
-Java 17+

# Maven

-Steps
-bash
-Copy
-Edit
-mvn clean install
-mvn spring-boot:run
-Open Swagger UI
# Visit: http://localhost:8080/swagger-ui.html

# Problem 2: File-Folder Tree Rendering (0-N Levels)
-Use a tree structure where each node represents a file or folder.

-Recursive data structure with children field.

Example:

-json
-Copy
-Edit
{
  "name": "root",
  "type": "folder",
  "children": [
    { "name": "Resume.pdf", "type": "file" },
    {
      "name": "Projects", "type": "folder",
      "children": [{ "name": "report.docx", "type": "file" }]
    }
  ]
}

# Problem 3: Multi-Tenant Data Isolation
-Use a tenant_id in every record.

-Intercept every request (Spring Filter) to extract tenant info (e.g., from header).

-Filter data at the DB level using tenant_id.

-Prevents one tenant from accessing another’s data.

Author
Name: [Jyotiranjan Barik]

Email: [jyotiranjanbarik2020@gmail.com]

GitHub: https://github.com/jyotiranjanbarik2001
