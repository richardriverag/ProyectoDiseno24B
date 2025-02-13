package model.Usuarios;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoFactorAuth {
    private String secret;
    private String email;
    private boolean enabled;
    private static final Map<String, String> codigos2FA = new HashMap<>();
    
    public TwoFactorAuth(String secret, String email, boolean enabled) {
        this.secret = secret;
        this.email = email;
        this.enabled = enabled;
    }

    public String getSecret() {
        return secret;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static String generarCodigo(String correo) {
        Random random = new Random();
        String codigo = String.format("%06d", random.nextInt(1000000));
        codigos2FA.put(correo, codigo);
        return codigo;
    }

    public static boolean validarCodigo(String correo, String codigo) {
        return codigo.equals(codigos2FA.getOrDefault(correo, ""));
    }
}
