/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sandalu.restpro;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.JAXB;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sandalu
 */
@Path("restpro")
public class RestProResource {

        String mname;
        String mprice;
        String mram;
        String msim;
        String mstatus;
        
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestProResource
     */
    public RestProResource() {
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("name")String name) {
        //TODO return proper representation object
       
        Mobile Xiomi=new Mobile("XiomiRedmi6","23,900","4GB","Dual","available");
        Mobile Oppo=new Mobile("OppoF5","39,900","4GB","Dual","available");
        Mobile Huawei=new Mobile("HuaweiY3","16,400","1GB","Dual","available");
        Mobile Samsung=new Mobile("SamsungGalaxyC8","41,900","3GB","Dual","available");
        Mobile Apple=new Mobile("AppleiPhone6sPlus","89,400","2GB","Dual","available");
        
        
        Mobile[] mobile=new Mobile[5];
        mobile[0]=Xiomi;
        mobile[1]=Oppo;
        mobile[2]=Huawei;
        mobile[3]=Samsung;
        mobile[4]=Apple;
        
        for(Mobile m:mobile){
            if(m.name.equals(name)){
                mname=m.name;
                mprice=m.price;
                mram=m.ram;
                msim=m.sim;
                mstatus=m.status;
              
            }
        }
//        switch(name){
//            case "XiomiRedmi6":
//                mprice="23,900";
//                break;
//            default:
//                mprice="10,000";
//                break;
//        }
        
                
        String message="Model     :   "+mname+"\nPrice      :   "+ mprice+"\nRAM       :   "+mram+"\nSIM         :   "+msim+"\nStatus    :   "+mstatus;
        StringWriter writer=new StringWriter();
       JAXB.marshal(message, writer);
        
//        JAXB.marshal(mprice, writer);
//        JAXB.marshal(mram, writer);
//        JAXB.marshal(msim, writer);
//        JAXB.marshal(mstatus, writer);
        
        return writer.toString();
    }

    /**
     * PUT method for updating or creating an instance of RestProResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
