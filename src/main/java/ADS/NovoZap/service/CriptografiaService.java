package ADS.NovoZap.service;

import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class CriptografiaService {
    
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    
    public String gerarChaveE2E() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar chave E2E", e);
        }
    }
    
    public String criptografar(String texto, String chave) {
        try {
            byte[] chaveBytes = Base64.getDecoder().decode(chave);
            SecretKeySpec secretKey = new SecretKeySpec(chaveBytes, ALGORITHM);
            
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
            return Base64.getEncoder().encodeToString(textoCriptografado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar", e);
        }
    }
    
    public String descriptografar(String textoCriptografado, String chave) {
        try {
            byte[] chaveBytes = Base64.getDecoder().decode(chave);
            SecretKeySpec secretKey = new SecretKeySpec(chaveBytes, ALGORITHM);
            
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            
            byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
            return new String(textoDescriptografado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar", e);
        }
    }
    
    public String gerarToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
    
    public String gerarFingerprint(String palavras) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(palavras.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar fingerprint", e);
        }
    }
}