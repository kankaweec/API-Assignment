package com.app.ws.controller;


import com.app.utils.Tools;
import com.app.ws.service.TodoService;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class AssignmentProcess {
    private static final String I0000 = "Save successfully";
    
    private static final String E0000 = "Parameter is null";
    private static final String E1000 = "Data not found";
    private static final String E2000 = "Please specify Todo Id";
    private static final String E3000 = "Please specify Subject";
        
    public AssignmentProcess() {
        super();
    }
    
    public String callImportDeclaration(JSONObject inputParam) {
            
        JSONObject jsonImportDeclarationResult = new JSONObject(); 
            
        try {
            jsonImportDeclarationResult.put("responseCode","");
                
            if (inputParam == null) {
                jsonImportDeclarationResult.put("responseCode","E2000");
                jsonImportDeclarationResult.put("responseMessage",E2000+", inputParam is null");    
            } else {
                String inboxId_from = inputParam.getString("inboxId_from");
                String inboxId_to   = inputParam.getString("inboxId_to");
                String where        = inputParam.getString("where");
                String order_by     = inputParam.getString("order_by");
                
//                jsonImportDeclarationResult = queryImportDeclaration(inboxId_from, inboxId_to, where, order_by);
            } 
                
        } catch (Exception e) {
            try {
                jsonImportDeclarationResult.put("responseCode","E1000");
//                jsonImportDeclarationResult.put("responseMessage",E1000+", "+"Exception Error : Classname = "+className+" : MethodName = "+methodName+" : Error = "+e.getMessage());  
            } catch (Exception je){
                je.printStackTrace();    
            }
        }
            
        return jsonImportDeclarationResult.toString();
    }
    
    public JSONObject queryTaskList(String todoId, String taskId) {    
        TodoService todoService     = new TodoService();
        JSONObject result           = new JSONObject();
        
        try{
            if(!Tools.chkNull(todoId).equalsIgnoreCase("") && Tools.chkNull(taskId).equalsIgnoreCase("")){
                result = todoService.viewAllTodoList(todoId);
            }
            else if(!Tools.chkNull(todoId).equalsIgnoreCase("") && !Tools.chkNull(taskId).equalsIgnoreCase("")){
                result = todoService.viewSingleTodoList(todoId, taskId);
            }
            else if(Tools.chkNull(todoId).equalsIgnoreCase("")){
                result.put("responseCode", "E2000");
                result.put("responseMessage", E2000);
            }
            
            if( result.length()<=0 ){
                result.put("responseCode", "E1000");
                result.put("responseMessage", E1000);
            }
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }

        return result;
    } 
    
    public JSONObject insertNewTask(JSONArray inputParam) {    
        TodoService todoService     = new TodoService();
        JSONObject result           = new JSONObject();
        
        try{
            if (inputParam == null) {
                result.put("responseCode","E0000");
                result.put("responseMessage",E0000);    
            }
            else{
                result = todoService.addNewTaskList(inputParam);
            } 
        }
        catch( JSONException jsonErr ){
            jsonErr.printStackTrace();
        }

        return result;
    } 
}