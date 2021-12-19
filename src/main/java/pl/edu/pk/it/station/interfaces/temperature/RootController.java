package pl.edu.pk.it.station.interfaces.temperature;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pk.it.station.interfaces.temperature.dto.TemperatureListDto;

@RestController
@RequestMapping("/")
public class RootController {

    @Value("${BASE_URL:localhost:8080}")
    private String baseUrl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return baseUrl+"/oauth2/code/okta";
    }
}