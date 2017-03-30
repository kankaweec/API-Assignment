package com.app.ws.controller;


import com.app.utils.Tools;
import com.app.ws.service.TodoService;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class AssignmentProcess {
    private static final String I0000 = "Save successfully";
    private static final String I2000 = "Edit successfully";
    private static final String I4000 = "Delete successfully";
    
    
    private static final String E0000 = "Parameter is null";
    private static final String E1000 = "Data not found";
    private static final String E2000 = "Please specify Todo Id";
    private static final String E3000 = "Found error";
    
    private static final String E4000 = "Save failure";
    private static final String E5000 = "Edit failure";
    private static final String E6000 = "Delete failure";
        
    public AssignmentProcess() {
        super();
    }
    
    public JSONObject queryTaskList(String todoId, String taskId) {    
        TodoService todoService     = new TodoService();
        JSONObject jsonResult       = new JSONObject();
        
        try{
            if(!Tools.chkNull(todoId).equalsIgnoreCase("") && Tools.chkNull(taskId).equalsIgnoreCase("")){
                try{
                    jsonResult = todoService.viewAllTodoList(todoId);
                }
                catch( Exception err ){
                    err.printStackTrace();
                    jsonResult.put("responseCode","E3000");
                    jsonResult.put("responseMessage",E3000);   
                }
            }
            else if(!Tools.chkNull(todoId).equalsIgnoreCase("") && !Tools.chkNull(taskId).equalsIgnoreCase("")){
                try{
                    jsonResult = todoService.viewSingleTodoList(todoId, taskId);
                }
                catch( Exception err ){
                    err.printStackTrace();
                    jsonResult.put("responseCode","E3000");
                    jsonResult.put("responseMessage",E3000);   
                }
            }
            else if(Tools.chkNull(todoId).equalsIgnoreCase("")){
                jsonResult.put("responseCode", "E2000");
                jsonResult.put("responseMessage", E2000);
            }
            
            if( jsonResult.length()<=0 ){
                jsonResult.put("responseCode", "E1000");
                jsonResult.put("responseMessage", E1000);
            }
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }

        return jsonResult;
    } 
    
    public JSONObject insertNewTask(JSONArray inputParam) {    
        TodoService todoService     = new TodoService();
        JSONObject jsonResult       = new JSONObject();
        String executeStatus        = "";
        
        try{
            if (inputParam == null) {
                jsonResult.put("responseCode","E0000");
                jsonResult.put("responseMessage",E0000);    
            }
            else{
                try{
                    executeStatus = todoService.insertNewTask(inputParam);
                    
                    if( executeStatus.equals("success")){
                        jsonResult.put("responseCode","I0000");
                        jsonResult.put("responseMessage",I0000);    
                    }
                    else{
                        jsonResult.put("responseCode","E4000");
                        jsonResult.put("responseMessage",E4000);   
                    }
                }
                catch( Exception err ){
                    err.printStackTrace();
                    jsonResult.put("responseCode","E4000");
                    jsonResult.put("responseMessage",E4000);   
                }
            } 
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }

        return jsonResult;
    } 
    
    public JSONObject updateTask(JSONArray inputParam) {    
        TodoService todoService     = new TodoService();
        JSONObject jsonResult       = new JSONObject();
        String executeStatus        = "";
        
        try{
            if (inputParam == null) {
                jsonResult.put("responseCode","E0000");
                jsonResult.put("responseMessage",E0000);    
            }
            else{
                try{
                    executeStatus = todoService.updateTask(inputParam);
                    
                    if( executeStatus.equals("success")){
                        jsonResult.put("responseCode","I2000");
                        jsonResult.put("responseMessage",I2000);    
                    }
                    else{
                        jsonResult.put("responseCode","E5000");
                        jsonResult.put("responseMessage",E5000);   
                    }
                }
                catch( Exception err ){
                    err.printStackTrace();
                    jsonResult.put("responseCode","E5000");
                    jsonResult.put("responseMessage",E5000);   
                }
            } 
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }

        return jsonResult;
    } 
    
    public JSONObject deleteTask(JSONArray inputParam) {    
        TodoService todoService     = new TodoService();
        JSONObject jsonResult       = new JSONObject();
        String executeStatus        = "";
        
        try{
            if (inputParam == null) {
                jsonResult.put("responseCode","E0000");
                jsonResult.put("responseMessage",E0000);    
            }
            else{
                try{
                    executeStatus = todoService.deleteTask(inputParam);
                    
                    if( executeStatus.equals("success")){
                        jsonResult.put("responseCode","I4000");
                        jsonResult.put("responseMessage",I4000);    
                    }
                    else{
                        jsonResult.put("responseCode","E6000");
                        jsonResult.put("responseMessage",E6000);   
                    }
                }
                catch( Exception err ){
                    err.printStackTrace();
                    jsonResult.put("responseCode","E6000");
                    jsonResult.put("responseMessage",E6000);   
                }
            } 
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }

        return jsonResult;
    } 
}