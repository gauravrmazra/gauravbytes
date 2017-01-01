package com.gauravbytes;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.apache.avro.util.Utf8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gauravbytes.avro.EmailMessage;
import com.gauravbytes.avro.EmailSender;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class EmailClientServer {
	private static final Logger logger = LoggerFactory.getLogger(EmailClientServer.class);

	public static class EmailSenderImpl implements EmailSender {
		@Override
		public CharSequence send(EmailMessage email) throws AvroRemoteException {
			return email.toString();
		}
	}

	private static Server server;

	private static void startServer() throws IOException {
		server = new NettyServer(new SpecificResponder(EmailSender.class, new EmailSenderImpl()),
				new InetSocketAddress(65333));
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 3) {
			System.out.println("Usage: <to> <from> <body>");
			System.exit(1);
		}

		logger.info("Starting Server");
		// usually this would be another app, but for simplicity
		startServer();
		logger.info("Server started");

		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(65333));
		// client code - attach to the server and send a message
		EmailSender proxy = SpecificRequestor.getClient(EmailSender.class, client);
		logger.info("Client built, got proxy");

		// fill in the Message record and send it
		EmailMessage message = new EmailMessage();
		message.setTo(new Utf8(args[0]));
		message.setFrom(new Utf8(args[1]));
		message.setBody(new Utf8(args[2]));
		logger.info("Calling proxy.send with message: {} ", message.toString());
		logger.info("Result: {}", proxy.send(message));
		// cleanup
		client.close();
		server.close();
	}
}
