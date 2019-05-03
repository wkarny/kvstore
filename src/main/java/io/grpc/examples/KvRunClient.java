package io.grpc.examples;

import java.util.Scanner;

public class KvRunClient {
	public static void main(String []args) throws Exception {
		for(int i = 1; i < 1000000; i*=10){
			Scanner scan = new Scanner(System.in);
			String ip = scan.nextLine();
		    KvRunner store = new KvRunner();
		    store.runClient(ip, 55661, i);
		}
	}
}
