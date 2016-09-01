// Copyright (c) 2015 D1SM.net

package net.fs.cap;


public class CapServer {
	
	CapServer(String testIP){
		CapEnv capEnv=null;
		try {
			capEnv=new CapEnv(testIP,false,true);
			capEnv.init(testIP);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
