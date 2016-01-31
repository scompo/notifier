package com.github.scompo.notifer.app.events.producers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.notifer.api.events.EventImpl;
import com.github.scompo.notifer.api.events.producers.AbstractEventProducer;

public class CommandLineEventProducer extends AbstractEventProducer implements Runnable {

	private ZonedDateTime readDate() {

		ZonedDateTime res = null;

		String str = readString("time: ");

		int hour = new Integer(str.split(":")[0]);
		int minute = new Integer(str.split(":")[1]);

		ZonedDateTime now = ZonedDateTime.now();

		res = now.withSecond(0).withHour(hour).withMinute(minute);

		return res;
	}

	private String readName() {

		String res = null;

		res = readString("name: ");

		return res;
	}

	private String readString(String string) {

		System.err.print(string);
		String readLine = null;
		try {
			readLine = new BufferedReader(new InputStreamReader(System.in)).readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return readLine;
	}

	@Override
	public void doStart() {
		
		run();
	}

	@Override
	public void run() {

		System.err.println("commands: exit, add");
		String command = readString("command: ");

		while (!"exit".equalsIgnoreCase(command)) {

			if ("add".equalsIgnoreCase(command)) {

				String readName = readName();
				ZonedDateTime readDate = readDate();

				Event eventFromCmd = new EventImpl(readName, readDate);

				notifyObservers(eventFromCmd);

			}
			command = readString("command: ");
		}		
	}

}
