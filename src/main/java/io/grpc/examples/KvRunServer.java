package io.grpc.examples;

import java.util.Scanner;

public class KvRunServer {
	public static void main(String []args) throws Exception {
		KvRunner store = new KvRunner();
		Scanner scan = new Scanner(System.in);
	    store.startServer(55661);
	    int n = scan.nextInt();
	    store.stopServer();
	}
}
