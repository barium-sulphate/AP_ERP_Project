package auth;

public class AuthResult {
    public final int userId;
    public final String role;

    public AuthResult(int userId, String role) {
        this.userId = userId;
        this.role = role;
    }
}
