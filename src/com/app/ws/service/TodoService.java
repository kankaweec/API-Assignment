package com.app.ws.service;


import com.app.utils.Day;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class TodoService{    
    
    JSONObject resultList   = new JSONObject();
    JSONObject taskObject   = new JSONObject();
    JSONArray taskList      = new JSONArray();
    
    public JSONObject viewAllTodoList(String todoId)throws Exception, JSONException{
        Day day = new Day();
        day.setYearType('e');
        
        // SELECT_WHERE_WITH_CRITERIA
        
        // FOR_EXAMPLE_GET_VALUE
        for(int i=1;i<=3;i++){
            taskObject = new JSONObject();
            taskObject.put("taskId", i);
            taskObject.put("subject", "Assignment "+i);
            taskObject.put("status", i%2==0?"done":"pending");
            taskList.put(taskObject);
        }
        
        resultList.put("todoId", todoId);
        resultList.put("owner", "kankawee");            
        resultList.put("createDate", day.toString());
        resultList.put("createBy", "kankawee");
        resultList.put("modifyDate", day.toString());
        resultList.put("modifyBy", "kankawee");
        resultList.put("list", taskList);    
        
        return resultList;
    }
    
    public JSONObject viewSingleTodoList(String todoId, String taskId)throws Exception, JSONException{
        Day day = new Day();
        day.setYearType('e');
            
        // SELECT_WHERE_WITH_CRITERIA
        
        // FOR_EXAMPLE_GET_VALUE
        taskObject = new JSONObject();
        taskObject.put("taskId", taskId);
        taskObject.put("subject", "Assignment "+taskId);
        taskObject.put("status", "pending");
        taskList.put(taskObject);
        
        resultList.put("todoId", todoId);
        resultList.put("owner", "kankawee");            
        resultList.put("createDate", day.toString());
        resultList.put("createBy", "kankawee");
        resultList.put("modifyDate", day.toString());
        resultList.put("modifyBy", "kankawee");
        resultList.put("list", taskList);    
        
        return resultList;
    }
    
    public String insertNewTask(JSONArray inputParam)throws Exception, JSONException{
        for(int i = 0; i < inputParam.length(); i++){
            JSONObject jsonObject = inputParam.getJSONObject(i);
            
            // INSERT_NEW_TASK
            
        }
        
        return "success";
//        return "fail";
    }
    
    public String updateTask(JSONArray inputParam)throws Exception, JSONException{
        for(int i = 0; i < inputParam.length(); i++){
            JSONObject jsonObject = inputParam.getJSONObject(i);
            
            // EDIT_TASK_WHERE_WITH_CRITERIA
            
        }
        
        return "success";
//        return "fail";
    }
    
    public String deleteTask(JSONArray inputParam)throws Exception, JSONException{
        for(int i = 0; i < inputParam.length(); i++){
            JSONObject jsonObject = inputParam.getJSONObject(i);
            
            // DELETE_TASK_WHERE_WITH_CRITERIA
            
        }
        
        return "success";
//        return "fail";
    }
}

    
