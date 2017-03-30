# Assignment
dotography  assignment


- URL

        AssignmentRestService/rest/Assignment

- Method

        GET
        
- URL Params

  Required:

        todoId=[String]

  Optional:

        taskId=[String]
        
 - Data Params
 
        AssignmentRestService/rest/Assignment/100/101
        
    Success Response:
  
        {
          "todoId": "100",
          "owner": "kankawee",
          "createDate": "2017-03-30 10:33:09.531",
          "createBy": "kankawee",
          "modifyDate": "2017-03-30 10:33:09.531",
          "modifyBy": "kankawee",
          "list": [
                    {
                      "taskId": "101",
                      "subject": "Assignment 101",
                      "status": "pending"
                    }
                  ]
        }
        
      Error Response:
      
        {
          "responseCode": "E2000",
          "responseMessage": "Please specify Todo Id"
        }
