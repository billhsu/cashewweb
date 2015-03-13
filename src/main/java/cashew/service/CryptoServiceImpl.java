package cashew.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

/**
 * Created by Shipeng Xu on 13/3/15.
 */
@Service("cryptoService")
public class CryptoServiceImpl implements CryptoService {
    public String hashString(String input) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        md.update(input.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
