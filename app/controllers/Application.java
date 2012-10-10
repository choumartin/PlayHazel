package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.client.HazelcastClient;

import java.util.Map;
import java.util.Collection;


public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void hazelTest()
    {
    	HazelcastClient client = HazelcastClient.newHazelcastClient("dev", "dev-pass", "localhost", "localhost:9000");
        //All Cluster Operations that you can do with ordinary HazelcastInstance
        Map<Integer,String> mapPublishers = client.getMap("publishers");
        for(int i=0;i<1000;i++)
        	mapPublishers.put(i,"Kiran"+i);
        
        System.out.println("Mapping done");

    }
    
    public static void retrieve()
    {
    	HazelcastClient client = HazelcastClient.newHazelcastClient("dev", "dev-pass", "localhost", "localhost:9001");
        Map<Integer,String> mapPublishers = client.getMap("publishers");
        
        Iterator it = mapPublishers.entrySet().iterator();
        while (it.hasNext()) 
        {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove(); 
        }
        System.out.println(mapPublishers.get(45));
        
        System.out.println("Retrieve Complete");
    }
    
    

}
