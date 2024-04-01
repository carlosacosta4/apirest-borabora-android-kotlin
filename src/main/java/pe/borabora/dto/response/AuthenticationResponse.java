package pe.borabora.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "status", "jwt"})
public record AuthenticationResponse(
        String username,
        String message,
        String jwt,
        Boolean status) {
}
