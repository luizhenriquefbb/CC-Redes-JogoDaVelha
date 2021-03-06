package client.packet.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import client.Client;
import client.Command;
import client.packet.ClientPacket;

import common.Packet;
import common.Payload;

import exception.BadPacketException;
import exception.InvalidCommandParametersException;

/**
 * Packet sent to initiate a play request
 *
 * 
 *
 */
public class ChoosePlayerPacket extends ClientPacket {
    public static final String PACKET_FORMAT = "convidar,%d,%s,%s";
    public static final Pattern PACKET_PATTERN = Pattern.compile("^convidar,(\\d+),(\\w+),(\\w+)$");
    public static final String COMMAND = "convidar";
    public static final Pattern COMMAND_PATTERN = Pattern.compile("^convidar\\s+(\\w*+)$");
    public static final String CODE = "convidar";


    public static ChoosePlayerPacket fromCommand(Command command, Client handler) {
        Matcher m = COMMAND_PATTERN.matcher(command.content);
        if (m.matches()) {
            long packetId = Packet.nextId();
            String sender = handler.getCurrentUser().getUsername();
            String reciever = m.group(1);
            return new ChoosePlayerPacket(packetId, sender, reciever);
        } else {
            throw new InvalidCommandParametersException("Could not parse.");
        }
    }
    public static ChoosePlayerPacket fromPayload(Payload payload) {
        Matcher m = PACKET_PATTERN.matcher(payload.content);
        if (m.matches()) {
            int packetId = Integer.parseInt(m.group(1));
            String sender = m.group(2);
            String reciever = m.group(3);
            return new ChoosePlayerPacket(packetId, sender, reciever);
        } else {
            throw new BadPacketException("Could not parse.");
        }
    }
    private final long packetId;

    private final String sender;

    private final String reciever;

    public ChoosePlayerPacket(long packetId, String sender, String reciever) {
        this.packetId = packetId;
        this.sender = sender;
        this.reciever = reciever;
    }

    public ChoosePlayerPacket(String... params) {
        this(Integer.parseInt(params[1]), params[2], params[3]);
    }

    @Override
    public String getCommand() {
        return COMMAND;
    }


    @Override
    public Pattern getCommandPattern() {
        return COMMAND_PATTERN;
    }

    @Override
    public String getPacketFormat() {
        return PACKET_FORMAT;
    }

    @Override
    public long getPacketId() {
        return this.packetId;
    }

    @Override
    public Pattern getPacketPattern() {
        return PACKET_PATTERN;
    }

    @Override
    public Object[] getParameters() {
        return new Object[] { packetId, sender, reciever };
    }

    public String getReciever() {
        return this.reciever;
    }

    public String getSender() {
        return this.sender;
    }

    @Override
    public String getUsername() {
        return this.sender;
    }

}
