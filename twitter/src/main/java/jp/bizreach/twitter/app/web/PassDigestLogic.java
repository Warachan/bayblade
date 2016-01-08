package jp.bizreach.twitter.app.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.BASE64Encoder;

/**
 * @author mayuko.sakaba
 * パスワードを不可逆暗号化
 */
public class PassDigestLogic {

    public static final List<String> bList;
    public static final Map<Long, String> winnerMap;

    static {
        bList = new ArrayList<String>();
        winnerMap = new HashMap<Long, String>();
        winnerMap.put(1L, "https://www.youtube.com/watch?v=TSMIPxBWh0s");
        winnerMap.put(2L, "https://www.youtube.com/watch?v=aDI0tRMwiFI");
    }

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

    public void put(String str) {
        bList.add(str);
    }

    public resultWebBean battle() {
        int size = bList.size();
        if (size < 2) {
            return new resultWebBean();
        }
        resultWebBean webBean = new resultWebBean();
        for (String string : bList) {
            System.out.println("リストサイズを示す  :" + string);
        }
        System.out.println("リストサイズを示す  :" + size);

        if (size % 2 == 0) {
            Long battle1 = Long.valueOf(bList.get(size - 1));
            Long battle2 = Long.valueOf(bList.get(size - 2));
            System.out.println("hirota " + battle1);
            System.out.println("hirota " + battle2);
            webBean.power = battle2;
            webBean.fightFlg = true;
            webBean.winnerUrl = winnerMap.get(battle1.compareTo(battle2) > 0 ? 1L : 2L);
        } else {
            webBean.power = Long.valueOf(bList.get(size - 1));
            webBean.fightFlg = false;
        }
        return webBean;
    }

    public class resultWebBean {
        Long power = 0L;
        boolean fightFlg = false;
        String winnerUrl;
    }

    public class Battle {
        String name;
        String actionCd;
    }

}
