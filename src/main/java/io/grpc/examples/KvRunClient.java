package io.grpc.examples;

import java.util.Scanner;

public class KvRunClient {
	public static void main(String []args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter IP address : ");
		String ip = scan.nextLine();
		for(int i = 1; i < 1000000; i*=10){
			KvRunner store = new KvRunner();
		    store.runClient(ip, 55662, i);
		}
	}
}
