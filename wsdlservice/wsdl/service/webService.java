package wsdl.service;

import service.UserServiceImpl;

import javax.xml.ws.Endpoint;

public class webService {

    public static void main(String args[]){

        Endpoint.publish("http://localhost:8081/ws/user", new UserServiceImpl());

    }
}
