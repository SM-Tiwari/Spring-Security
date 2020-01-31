package com.gnv.vnm.selfcare.webapi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class OracleConnection {

public static void main(String[] args) throws Exception {
//connect to database


Class.forName("oracle.jdbc.driver.OracleDriver");
ArrayList<String> serverNames = new ArrayList<String>();
serverNames.add("172.29.5.166");

String portNumber = "1521";
String sid = "KMSJPDB";
String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)" ;
for (String serverName : serverNames) { 
url += "(ADDRESS=(PROTOCOL=tcp)(HOST="+serverName+")(PORT="+portNumber+"))";
}
url += ")(CONNECT_DATA=(SID="+sid+")))";
String username = "odp";
String password = "o#5678#dp#indo";
// System.out.println(url); // for debugging, if you want to see the url that was built
Connection conn = DriverManager.getConnection(url, username, password);
}
}
