package petrov.vitaliy.lab3server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import petrov.vitaliy.lab3server.forms.ConfirmationResponse;
import petrov.vitaliy.lab3server.forms.InputRequest;
import petrov.vitaliy.lab3server.forms.ResponseCode;
import petrov.vitaliy.lab3server.model.User;
import petrov.vitaliy.lab3server.service.AuthorizationService;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/auth")
    public ConfirmationResponse authorization(@RequestBody InputRequest authorizationRequest) {
        String username = authorizationRequest.getProducts().get(0).getUsername();

        User userCandidate = new User();
        userCandidate.setUsername(username);

        ConfirmationResponse response = new ConfirmationResponse();
        response.setUsername(username);

        if (!authorizationService.authorizeUser(userCandidate)) {
            if (authorizationService.addUser(userCandidate))
                response.setCode(ResponseCode.USER_ADDED);
            else
                response.setCode(ResponseCode.USER_NOT_ADDED);
        } else
            response.setCode(ResponseCode.USER_AUTHORIZED);

        return response;
    }
}
