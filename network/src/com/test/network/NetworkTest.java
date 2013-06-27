package com.test.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InetAddress ip;
		try {
	 
			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
	 
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
	 
			byte[] mac = network.getHardwareAddress();
	 
			System.out.print("Raw MAC address : ");
			for (int i = 0; i < mac.length; i++) {
				System.out.print(mac[i]);		
			}			
			
			System.out.println();
			System.out.print("Current MAC address : ");
	 
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			System.out.println(sb.toString());
	 
		} catch (UnknownHostException e) {
	 
			e.printStackTrace();
	 
		} catch (SocketException e){
	 
			e.printStackTrace();
	 
		}
		
	 }// end of main

}
