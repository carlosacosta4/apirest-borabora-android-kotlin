package pe.borabora.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "jwt", "status", "roles"})
public record AuthenticationResponse(
        String username,
        String message,
        String jwt,
        Boolean status,
        List<String> roles) {
}
