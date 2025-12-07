package com.javaProject.AptitudeApp.service.Impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.javaProject.AptitudeApp.service.ISupabaseStorageService;
@Service
public class SupabaseStorageService implements ISupabaseStorageService{

    private final RestClient restClient;

    private final String SUPABASE_URL = "https://bqtnndxsxgqxnzflbtay.supabase.co";
    private final String SUPABASE_BUCKET = "data-api";
    private final String SUPABASE_API_KEY = "sb_secret_kLaivyU4JVlE2h31ibgcJA_gVfAXSRI";

    public SupabaseStorageService() {
        this.restClient = RestClient.builder()
                .baseUrl(SUPABASE_URL)
                .defaultHeader("apikey", SUPABASE_API_KEY)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + SUPABASE_API_KEY)
                .build();
    }

    @Override
    public String uploadImage(byte[] imageBytes, String fileNameWithExtension) {

        // 1) Upload the file
        String responseFromSupaBase = restClient
                .put()
                .uri("/storage/v1/object/{bucket}/{file}", SUPABASE_BUCKET, fileNameWithExtension)
                .contentType(MediaType.parseMediaType(detectMimeType(fileNameWithExtension)))
                .body(imageBytes)
                .retrieve()
                .body(String.class);
        System.out.println(responseFromSupaBase);

        // 2) Return the public URL
        return SUPABASE_URL +
                "/storage/v1/object/public/" +
                SUPABASE_BUCKET + "/" + fileNameWithExtension;
    }

    private String detectMimeType(String fileName) {
        if (fileName.endsWith(".png")) return "image/png";
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) return "image/jpeg";
        return "application/octet-stream"; //else it stores it as byte-array
    }
}
