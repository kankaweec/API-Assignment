# Assignment
dotography  assignment



        
-------------------------------------------------------------------------------------------------------------------

(View all item in the list / View a single task in the list)

- URL

        AssignmentRestService/rest/Assignment/{todoId}
        
        OR
        
        AssignmentRestService/rest/Assignment/{todoId}/{taskId}

- Method

        GET
        
- URL Params

  Required:

        todoId=[String]

  Optional:

        taskId=[String]
        
 - Data Params
 
        AssignmentRestService/rest/Assignment/100
        
    Success Response:
  
        {
          "todoId": "100",
          "owner": "kankawee",
          "createDate": "2017-03-30 11:29:25.097",
          "createBy": "kankawee",
          "modifyDate": "2017-03-30 11:29:25.097",
          "modifyBy": "kankawee",
          "list": [
            {
              "taskId": 1,
              "subject": "Assignment 1",
              "status": "pending"
            },
            {
              "taskId": 2,
              "subject": "Assignment 2",
              "status": "done"
            },
            {
              "taskId": 3,
              "subject": "Assignment 3",
              "status": "pending"
            }
          ]
        }
        
 - Data Params
 
        AssignmentRestService/rest/Assignment/100/2
        
    Success Response:
  
        {
          "todoId": "100",
          "owner": "kankawee",
          "createDate": "2017-03-30 11:30:15.108",
          "createBy": "kankawee",
          "modifyDate": "2017-03-30 11:30:15.108",
          "modifyBy": "kankawee",
          "list": [
            {
              "taskId": "2",
              "subject": "Assignment 2",
              "status": "done"
            }
          ]
        }
        
    Error Response:
      
        {
          "responseCode": "E2000",
          "responseMessage": "Please specify Todo Id"
        }
        
        ----------------------------------------------------------
        
        {
          "responseCode": "E1000",
          "responseMessage": "Data not found"
        }
        


-------------------------------------------------------------------------------------------------------------------

(Add a task to the list)

- URL

        AssignmentRestService/rest/Assignment

- Method

        POST
        
- URL Params

  Required:

        subject=[String]
        status=[String]

  Optional:

        Do not define
        
 - Data Params
 
        [
                {
                  "subject": "TEST1",
                  "status": "pending"
                },
                {
                  "subject": "TEST2",
                  "status": "done"
                },
                {
                  "subject": "TEST3",
                  "status": "pending"
                },
                {
                  "subject": "TEST4",
                  "status": "done"
                }
        ]
        
      Success Response:
  
        {
          "responseCode": "I0000",
          "responseMessage": "Save successfully"
        }
        
      Error Response:
      
        {
          "responseCode": "E4000",
          "responseMessage": "Save failure"
        }
        
        
        
 -------------------------------------------------------------------------------------------------------------------
 
 (Edit existing task / Set the task status)
 
 - URL

        AssignmentRestService/rest/Assignment

- Method

        PUT
        
- URL Params

  Required:

        todoId=[String]
        taskId=[String]

  Optional:

        subject=[String]
        status=[String]
        
 - Data Params
 
        {
          "todoId": "100",          
          "list": [
                    {
                      "taskId": "1",
                      "subject": "Assignment TEST",
                      "status": "done"
                    }
                  ]
        }
        
     Success Response:
  
        {
          "responseCode": "I2000",
          "responseMessage": "Edit successfully"
        }
        
      Error Response:
      
        {
          "responseCode": "E5000",
          "responseMessage": "Edit failure"
        }
        
        
        
-------------------------------------------------------------------------------------------------------------------

(Delete a task from list)

- URL

        AssignmentRestService/rest/Assignment

- Method

        DELETE
        
- URL Params

  Required:

        todoId=[String]
        taskId=[String]

  Optional:

        Do not define
        
 - Data Params
 
        {
          "todoId": "100",          
          "list": [
                    {
                      "taskId": "3",
                    }
                  ]
        }
        
     Success Response:
  
        {
          "responseCode": "I4000",
          "responseMessage": "Delete successfully"
        }
        
      Error Response:
      
        {
          "responseCode": "E6000",
          "responseMessage": "Delete failure"
        }
