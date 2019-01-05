package com.mx.sftpserverneoris.sftpserverneoris;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.mx.sftpserverneoris.sftp.SFTPBean;
import com.mx.sftpserverneoris.sftp.SFTPConnector;


import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp.LsEntry;

@SpringBootApplication
public class SftpserverneorisApplication {
	 private static final String USERNAME = "test";
    private static final String HOST = "localhost";
    private static final int PORT = 22;
    private static final String PASSWORD = "12341234";
	public static void main(String[] args) {
		SpringApplication.run(SftpserverneorisApplication.class, args);
//		try {
//            SFTPConnector sshConnector = new SFTPConnector();
//             
//             
//            sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
//            System.out.println("100========> sshConnector: "+sshConnector);
//            sshConnector.addFile("C:\\PABLO\\SFTP\\", "C:\\PABLO\\VTUTORIALES\\BOOTSTRAP\\BOOTSTRAP_CLASSES\\rounded.PNG",
//                "rounded.PNG");
//            sshConnector.disconnect();
//        } catch (JSchException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        } catch (SftpException ex) {
//            ex.printStackTrace();
//             
//            System.out.println(ex.getMessage());
//        }
		
//		try {
//	        JSch jsch = new JSch();
//	        Session session = jsch.getSession( "test", "127.0.0.1", 22 );
//	        session.setConfig( "PreferredAuthentications", "password" );
//	        session.setPassword( "12341234" );
//	        java.util.Properties config = new java.util.Properties(); 
//	        config.put("StrictHostKeyChecking", "no");//do not prefer this. demo only
//	        session.setConfig(config);
//	        session.connect( 1200 );
//	        Channel channel = session.openChannel( "sftp" );
//	        ChannelSftp sftp = ( ChannelSftp ) channel;
//	        sftp.connect( 60 * 1000 );
//	        channel = session.openChannel("sftp");
//	        channel.connect();
//	        try {
//	            File f = new File("C:/PABLO/TUTORIALES/BOOTSTRAP/BOOTSTRAP_CLASSES/rounded.PNG");
//	            sftp.put(new FileInputStream(f), f.getName());
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        channel.disconnect();
//	        sftp.disconnect();
//	    } catch (JSchException e) {
//	        e.printStackTrace();
//	    }
		try {
			
		
		SFTPBean sftpBean = new SFTPBean();

		boolean blResult = sftpBean.connect(HOST, 22, USERNAME, PASSWORD);

		if (blResult) {
			System.out.println("Connect successed");
			
			//now we will try to download file
//			sftpBean.uploadFile(strLocalFile, strSftpFile)
			blResult = sftpBean.uploadFile( "C:\\PABLO\\antea.PNG","/antea.PNG");
			if(blResult) {
				System.out.println("upload successed");
			}
			else {
				System.out.println("upload failed");
			}
			//now we will try to download file
			blResult = sftpBean.downloadFile( "/antea.PNG", "C:\\PABLO\\TEST.PNG");
			if(blResult) {
				System.out.println("download successed");
			}else {
				System.out.println("download fail");
			}
			
			
			
			
			
////			//in here i demo list file first.
			//checking again file that u have just uploaded file
			Vector<LsEntry> vtFiles = sftpBean.listFile("/");
			System.out.println("Object is : "+vtFiles);
			if (vtFiles != null) {
				vtFiles.stream().forEach(file->{
					System.out.println("File in Server: "+file.getFilename() + "\r\n");
				});
//				for (LsEntry lsEntry : vtFiles) {
//					System.out.println(lsEntry.getFilename() + "\r\n");
//				}
			}
			sftpBean.close();
		} else {
			System.out.println("Connect failed.");
		}
		} catch (Exception e) {
        	System.out.println("Error al crear canal de comunicacion SFTP:"
                    + e.getMessage());
        	System.out.println(e);
            
        
//        } catch (SftpException se) {
//        	System.out.println("Error al intentar subir el archivo por SFTP:"
//                    + se.getMessage());
//        	System.out.println(se);
//            throw new Exception("No fue posible subir el archivo al "
//                    + "servidor:[" + "127.0.0.1" + ":"
//                    +  22  + ", causa:" + se.getMessage());
        } finally {
            
        }
	}
	
	
	 public void connect(/*SFTPCallback callback*/) throws Exception {
	        Session session = null;
	        ChannelSftp channel = null;

//	        SFTPSession.setConexionCode(CODE_ERROR);
	        try {
//	            System.out.println("Se establece conexion SFTP dado: " + info);
	            final JSch jsch = new JSch();

	            /*
	             * Si se especifica se usara sobre el
	             * password.
	             */
//	            if (info.getpKeyFilePath() != null) {
//	            	System.out.println("Se coloca como archivo llave:|"+info
//	                        .getpKeyFilePath()+"|");
//	                jsch.addIdentity(info.getpKeyFilePath());
//	            }
//	            config.put("StrictHostKeyChecking", "no");//do not prefer this. demo only
	            session = jsch.getSession("test", "127.0.0.1", 22);

	            /*
	             *  Si es nulo se entiende que se usara
	             *  autenticacion por llave privada.
	             */
//	            if (info.getPassword() != null && info.getpKeyFilePath() == null) {
	                session.setPassword("12341234");
//	            }

	            Properties config = new Properties();
	            config.put("StrictHostKeyChecking", "no");
	            session.setConfig(config);
	            session.connect(10000);
//	            session.setUserInfo(new DefaultUserInfo());
	            channel = (ChannelSftp) session.openChannel("sftp");
	            channel.connect();

	            System.out.println("Delegando canal a callback");
//	            callback.doInSFTPSession(channel);
//	            SFTPSession.setConexionCode(CODE_EXITO);
	            System.out.println("Finaliza ejecucion de callback");
	        } catch (JSchException e) {
	        	System.out.println("Error al crear canal de comunicacion SFTP:"
	                    + e.getMessage());
	        	System.out.println(e);
	            throw new Exception("No fue posible crear canal de "
	                    + "comunicacion SFTP, servidor: " + "127.0.0.1"
	                    + ":" + 22 + ", causa:" + e.getMessage());
	        
//	        } catch (SftpException se) {
//	        	System.out.println("Error al intentar subir el archivo por SFTP:"
//	                    + se.getMessage());
//	        	System.out.println(se);
//	            throw new Exception("No fue posible subir el archivo al "
//	                    + "servidor:[" + "127.0.0.1" + ":"
//	                    +  22  + ", causa:" + se.getMessage());
	        } finally {
	            if (channel != null) {
	                channel.quit();
	            }

	            if (session != null) {
	                session.disconnect();
	            }
	        }
	    }

}

