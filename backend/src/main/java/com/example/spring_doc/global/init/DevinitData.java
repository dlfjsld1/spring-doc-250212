package com.example.spring_doc.global.init;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Configuration
public class DevinitData {

    @Bean
    public ApplicationRunner devApplicationRunner() {
        return args -> {
            System.out.println("dev application runner");
            String url = "http://localhost:8080/v3/api-docs/apiV1";
            genApiJsonFile(url, "apiV1.json");
        };
    }

    public void genApiJsonFile(String url, String filename) {
        // HttpClient 생성
        HttpClient client = HttpClient.newHttpClient();

        // HttpRequest 생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // HTTP 요청 보내기 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 상태 코드 확인
            if (response.statusCode() == 200) {
                // JSON 데이터를 파일로 저장
                Path filePath = Path.of(filename);
                Files.writeString(filePath, response.body(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
                System.out.println("JSON 데이터가 성공적으로 파일로 저장되었습니다: " + filePath.toAbsolutePath());
            } else {
                System.err.println("HTTP 요청 실패: 상태 코드 " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
