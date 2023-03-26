package br.com.controle.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encode {

    private static final String SECRET_KEY = "com_br_controle"; // Chave secreta para criptografia

    public static String encode(Object obj, int expirationTime) throws Exception {
        byte[] serializedObj = serialize(obj);
        byte[] encryptedBytes = encrypt(serializedObj);
        byte[] timestampBytes = longToBytes(new Date().getTime() + expirationTime * 1000);
        byte[] encodedBytes = concatArrays(encryptedBytes, timestampBytes);
        return Base64.getEncoder().encodeToString(encodedBytes);
    }

    public static Object decode(String encodedString) throws Exception {
        byte[] encodedBytes = Base64.getDecoder().decode(encodedString);
        byte[] encryptedBytes = Arrays.copyOfRange(encodedBytes, 0, encodedBytes.length - 8);
        byte[] timestampBytes = Arrays.copyOfRange(encodedBytes, encodedBytes.length - 8, encodedBytes.length);
        long timestamp = bytesToLong(timestampBytes);
        if (timestamp < new Date().getTime()) {
            throw new Exception("Token expirado");
        }
        byte[] decryptedBytes = decrypt(encryptedBytes);
        return deserialize(decryptedBytes);
    }

    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close();
        return baos.toByteArray();
    }

    private static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    private static byte[] encrypt(byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
        return cipher.doFinal(input);
    }

    private static byte[] decrypt(byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
        return cipher.doFinal(input);
    }

    private static SecretKeySpec getSecretKey() throws Exception {
        return new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
    }

    private static byte[] concatArrays(byte[] a, byte[] b) {
        byte[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    private static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    private static long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bytes);
        buffer.flip(); // É necessário chamar o método flip() para ler o long a partir do início do buffer
        return buffer.getLong();
    }
}
