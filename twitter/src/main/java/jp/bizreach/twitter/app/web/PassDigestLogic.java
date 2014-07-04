package jp.bizreach.twitter.app.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @author mayuko.sakaba
 * パスワードを不可逆暗号化
 */
public class PassDigestLogic {
    public String build(String password) throws NoSuchAlgorithmException {
        String passDigest = null;
        if (password != null && 0 < password.length()) {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] digest = md.digest();

            BASE64Encoder encoder = new BASE64Encoder();
            String b64digest = encoder.encodeBuffer(digest);
            passDigest = b64digest.trim();
        }
        return passDigest;
    }
}
