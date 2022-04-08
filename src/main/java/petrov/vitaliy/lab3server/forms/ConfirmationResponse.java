package petrov.vitaliy.lab3server.forms;

import lombok.Data;

@Data
public class ConfirmationResponse {
    private ResponseCode code;
    private String username;
}
