package com.ibm.common.utils;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public abstract class UuidUtils {
	 
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
 
    public static String compressedUuid() {
        UUID uuid = UUID.randomUUID();
        return compressedUUID(uuid);
    }
 
    protected static String compressedUUID(UUID uuid) { 
    	byte[] byUuid = new byte[16];
    	long least = uuid.getLeastSignificantBits();
    	long most = uuid.getMostSignificantBits();
    	long2bytes(most, byUuid, 0);
    	long2bytes(least, byUuid, 8);
    	String compressUUID = Base64.encodeBase64URLSafeString(byUuid);
    	return compressUUID;}
 
    protected static void long2bytes(long value, byte[] bytes, int offset) {
        for (int i = 7; i > -1; i--) {
            bytes[offset++] = (byte) ((value >> 8 * i) & 0xFF);
        }
    }
 
    public static String compress(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        return compressedUUID(uuid);
    }
 
    public static String uncompress(String compressedUuid) {
        if (compressedUuid.length() != 22) {
            throw new IllegalArgumentException("Invalid uuid!");
        }
        byte[] byUuid = Base64.decodeBase64(compressedUuid + "==");
        long most = bytes2long(byUuid, 0);
        long least = bytes2long(byUuid, 8);
        UUID uuid = new UUID(most, least);
        return uuid.toString();}
 
    protected static long bytes2long(byte[] bytes, int offset) {
        long value = 0;
        for (int i = 7; i > -1; i--) {
            value |= (((long) bytes[offset++]) & 0xFF) << 8 * i;
        }
        return value;
    }
    
    
    public static String getUuid() {
        String s = UUID.randomUUID().toString();
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
    }
    
    public static void main(String[] args){
    	System.out.println(UuidUtils.uuid());
    	System.out.println(UuidUtils.getUuid());
    	System.out.println(UuidUtils.compressedUuid());  
    	
    }
}