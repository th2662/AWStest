package com.ifutsalu.util;

import com.ifutsalu.dto.response.gonggong.OuterRespDto;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Builder
public class WebClientUtil {
    public static OuterRespDto sendRequest(String url) {
        WebClient webClient = WebClient.builder().build();

        OuterRespDto result = webClient.get()
                .uri(url)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToMono(OuterRespDto.class).block();
        return result;
    }
}
