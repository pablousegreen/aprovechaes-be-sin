package com.mx.sftpserverneoris.sftpserverneoris;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class newput {
	
    
//    try {
//    	JSch jsch = new JSch();
//    	Session session = null;
//       session = jsch.getSession("admin", "127.0.0.1", 22);
//        session.setConfig("StrictHostKeyChecking", "no");
//        session.setPassword("pass");
//        session.connect();
//        
//        Channel channel = session.openChannel("sftp");
//        channel.connect();
//        ChannelSftp sftpChannel = (ChannelSftp) channel;
//        sftpChannel.get("/tmpremote/testDownload.txt", "/tmplocal/testDownload.txt");  
//        sftpChannel.exit();
//        session.disconnect();
//    } catch (JSchException f) {
//        f.printStackTrace();  
//    } catch (SftpException t) {
//        t.printStackTrace();
//    }
//}

}
