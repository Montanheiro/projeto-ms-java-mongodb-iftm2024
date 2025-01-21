package lucashumberto.shopping_api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.montanha.dto.UserDTO;

import reactor.core.publisher.Mono;

@Service
public class UserService {

    private String userApiURL = "http://localhost:8080";
	public UserDTO getUserByCpf(String cpf, String key) {
		try {
			WebClient webClient = WebClient.builder()
					.baseUrl(userApiURL)
					.build();

			Mono<UserDTO> user = webClient.get()
					.uri("/user/" + cpf + "/cpf?key="+key)
					.retrieve()
					.bodyToMono(UserDTO.class);

			return user.block();
		} catch (Exception e) {
			throw new RuntimeException("User not found");
		}
	}
}
