package chatting;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ListeningThread extends Thread { // 서버에서 보낸 메세지 읽는 Thread
	Socket socket = null;

	public ListeningThread(Socket socket) { // 생성자
		this.socket = socket; // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
	}
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(input);
				protocol t = (protocol) ois.readObject();
				if(t.getTypeofrequest() == 1){

				}
				else if(t.getTypeofrequest() == 2) {
				}
				else if(t.getTypeofrequest() == 4){
					System.out.println("방번호 : " + t.getRoomnumber());
					System.out.println("보낸사람 : " + t.getSender());
					System.out.println("메시지 : " + t.getMessege());
				}
				else{
					System.out.println("잘못된 요청입니다.");
				}
			}
		} catch (SocketException e){
			System.out.println("로그아웃 하였습니다.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}