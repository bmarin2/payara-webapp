/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.payara.learn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author john
 */
@Path("/movies")
public class Restcall {
    
    @GET
    @Path("/{id}")
    public Response ping(@PathParam("id") int id){
        System.out.println("form console");
        return Response.ok("ping hello, the number is: " + id).build();
    }
    
}