package com.app.ws.service;


import com.app.utils.Day;
import com.app.utils.Tools;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class TodoService {    
    
    JSONObject resultList   = new JSONObject();
    JSONObject taskObject   = new JSONObject();
    JSONArray taskList      = new JSONArray();
    
    public JSONObject viewAllTodoList(String todoId){
        Day day = new Day();
        day.setYearType('e');
        
        try{
            // FOR_EXAMPLE_VIEW_ALL_TASK
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
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }
        
        return resultList;
    }
    
    public JSONObject viewSingleTodoList(String todoId, String taskId){
        Day day = new Day();
        day.setYearType('e');
        
        try{
            // FOR_EXAMPLE_VIEW_SINGLE_TASK
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
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }
        
        return resultList;
    }
    
    public JSONObject addNewTaskList(JSONArray inputParam){
        Day day         = new Day();
        day.setYearType('e');
        
        try{
            // FOR_EXAMPLE_INSERT_NEW_TASK            
            for(int i=1;i<=3;i++){
                taskObject = new JSONObject();
                taskObject.put("taskId", i);
                taskObject.put("subject", "Assignment "+i);
                taskObject.put("status", i%2==0?"done":"pending");
                taskList.put(taskObject);
            }
            
            for(int i = 0; i < inputParam.length(); i++){
                JSONObject jsonObject = inputParam.getJSONObject(i);
                
                taskObject = new JSONObject();
                taskObject.put("taskId", (3+(i+1)));
                taskObject.put("subject", Tools.chkNull(jsonObject.getString("subject")).equals("")?+(3+(i+1)):jsonObject.getString("subject"));
                taskObject.put("status", Tools.chkNull(jsonObject.getString("status")).equals("pending")||
                                         Tools.chkNull(jsonObject.getString("status")).equals("done")?jsonObject.getString("status"):"pending");
                taskList.put(taskObject);
            }
            
            resultList.put("todoId", 1);
            resultList.put("owner", "kankawee");            
            resultList.put("createDate", day.toString());
            resultList.put("createBy", "kankawee");
            resultList.put("modifyDate", day.toString());
            resultList.put("modifyBy", "kankawee");
            resultList.put("list", taskList);  
            
            System.out.println("resultList: "+resultList);
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }
        
        return resultList;
    }
    
    public JSONObject editTaskList(JSONObject inputParam){
        Day day = new Day();
        day.setYearType('e');
        
        try{
            // FOR_EXAMPLE_EDIT_TASK
            for(int i=1;i<=3;i++){
                taskObject = new JSONObject();
                taskObject.put("taskId", i);
                taskObject.put("subject", "Assignment "+i);
                taskObject.put("status", i%2==0?"done":"pending");
                taskList.put(taskObject);
            }
            
            resultList.put("todoId", 1);
            resultList.put("owner", "kankawee");            
            resultList.put("createDate", day.toString());
            resultList.put("createBy", "kankawee");
            resultList.put("modifyDate", day.toString());
            resultList.put("modifyBy", "kankawee");
            resultList.put("list", taskList);    
            
            JSONObject childobject = inputParam.getJSONObject("XXXX");

            JSONObject modifiedJson = new JSONObject();
            modifiedJson.put("type",childobject.get("type"));
            modifiedJson.put("value","newvalue"); 
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }
        
        return resultList;
    }
}

    
