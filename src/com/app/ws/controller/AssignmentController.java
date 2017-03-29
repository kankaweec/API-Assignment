package com.app.ws.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;


@Path("/")
public class AssignmentController {
    
    public AssignmentController() {
        super();
    }
    
    @GET
    @Path("Assignment/{todoId}")
    public JSONObject getData(@PathParam("todoId") String todoId) throws Exception{
        AssignmentProcess assignmentProcess = new AssignmentProcess();
        JSONObject jsonObject = assignmentProcess.queryTaskList(todoId, "");
        
        return jsonObject;
    }
    
    @GET
    @Path("Assignment/{todoId}/{taskId}")
    public JSONObject getData(@PathParam("todoId") String todoId, @PathParam("taskId") String taskId) throws Exception{
        AssignmentProcess assignmentProcess = new AssignmentProcess();
        JSONObject jsonObject = assignmentProcess.queryTaskList(todoId, taskId);
        
        return jsonObject;
    }
        
    @POST
    @Path("Assignment")
    @Produces({MediaType.APPLICATION_JSON}) 
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject insertData(JSONArray inputParam) throws Exception{
        AssignmentProcess assignmentProcess = new AssignmentProcess();
        JSONObject jsonObject = assignmentProcess.insertNewTask(inputParam);
        
        return jsonObject;
    }
    
    @PUT
    @Path("Assignment")
    @Produces({MediaType.APPLICATION_JSON}) 
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject updateData(JSONArray inputParam) throws Exception{
        JSONObject jsonObject = new JSONObject();
        AssignmentProcess assignmentProcess = new AssignmentProcess();
        assignmentProcess.updateTask(inputParam);
        
        return jsonObject;
    }
    
    @DELETE
    @Path("Assignment")
    @Produces({MediaType.APPLICATION_JSON}) 
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject deleteData(JSONArray inputParam) throws Exception{
        JSONObject jsonObject = new JSONObject();
        AssignmentProcess assignmentProcess = new AssignmentProcess();
        assignmentProcess.deleteTask(inputParam);
        
        return jsonObject;
    }
}
