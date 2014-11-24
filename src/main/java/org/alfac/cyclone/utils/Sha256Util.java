package org.alfac.cyclone.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Ivan
 */
public final class Sha256Util {

    private static final String ALGORITHM = "SHA-256";

    private static final String CHARSET = "UTF-8";

    private Sha256Util() {
    }

    public static String getSHA256Hex(String string) {
        MessageDigest messageDigest = getMessageDigestInstance();

        try {
            messageDigest.update(string.getBytes(CHARSET));
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Invalid Charset", e);
        }

        byte[] result = messageDigest.digest();

        return String.valueOf(Hex.encodeHex(result));
    }

    public static MessageDigest getMessageDigestInstance() {
        try {
            return MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new UnsupportedOperationException("Unable to create MessageDigest for  '" + ALGORITHM + "' ", e);
        }
    }
}
