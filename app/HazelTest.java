import java.util.Map;

import com.hazelcast.client.HazelcastClient;

public class HazelTest 
{
	public static void main(String args[])
	{
		System.out.println("Hello");
		hazelTest();
	}
	
	 public static void hazelTest()
	 {
	    	HazelcastClient client = HazelcastClient.newHazelcastClient("kiran", "kiran", "127.0.0.1", "127.0.0.1:9000");
		//All Cluster Operations that you can do with ordinary HazelcastInstance
		Map<Integer,String> mapPublishers = client.getMap("publishers");
		for(int i=0;i<10;i++)
			mapPublishers.put(i,"Kiran"+i);
		
		System.out.println("Mapping done");
	 }
}
