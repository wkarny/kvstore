package io.grpc.examples;

import java.util.Scanner;

public class KvRunServer {
	public static void main(String []args) throws Exception {
		KvRunner store = new KvRunner();
		System.out.println("Enter any number to terminate the server");
		Scanner scan = new Scanner(System.in);
	    store.startServer(55662);
	    int n = scan.nextInt();
	    store.stopServer();
	}
}
