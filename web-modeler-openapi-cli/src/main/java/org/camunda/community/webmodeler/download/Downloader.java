package org.camunda.community.webmodeler.download;

import static org.camunda.community.webmodeler.download.Downloader.Mode.CANONICAL_PATH;
import static org.camunda.community.webmodeler.download.Downloader.Mode.SIMPLE_PATH;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.camunda.community.webmodeler.client.api.FilesApi;
import org.camunda.community.webmodeler.client.dto.FileDto;
import org.camunda.community.webmodeler.client.dto.FileMetadataDto;
import org.camunda.community.webmodeler.client.dto.PathElementDto;
import org.camunda.community.webmodeler.client.invoker.ApiException;

public class Downloader {

    private final FilesApi filesApi;
    private final File folder;

    public Downloader(FilesApi filesApi, File folder) {
        this.filesApi = Objects.requireNonNull(filesApi);
        this.folder = Objects.requireNonNull(folder);
    }

    public void downloadProject(UUID projectUUID, Mode mode) throws ApiException {
        List<FileMetadataDto> fileMetadataDto = filesApi.listFiles(projectUUID);

        Map<String, FileDto> idToFile = fileMetadataDto.stream()
                .map(this::getFile)
                .collect(Collectors.toMap(item -> item.getMetadata().getId(), item -> item));

        if (SIMPLE_PATH.equals(mode)) {
            writeFilesSimplePath(idToFile);
        } else if (CANONICAL_PATH.equals(mode)) {
            writeFilesCanonicalPath(idToFile);
        } else {
            throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    private void writeFilesSimplePath(Map<String, FileDto> idToFile) {
        idToFile.values().stream()
                .forEach(file -> writeFile(file.getContent(), file.getMetadata().getSimplePath()));
    }

    private void writeFilesCanonicalPath(Map<String, FileDto> idToFile) {
        idToFile.values().stream().forEach(file -> writeFile(file.getContent(), getCanonicalPath(file)));
    }

    private String getCanonicalPath(FileDto file) {
        List<PathElementDto> pathElements = file.getMetadata().getCanonicalPath();

        String folderPath = pathElements.stream()
                .map(pe -> String.format("%s[%s]", pe.getName(), pe.getId()))
                .collect(Collectors.joining("/", "", "/"));

        String fileName = String.format(
                "%s[%s].%s",
                file.getMetadata().getName(),
                file.getMetadata().getId(),
                toExtension(file.getMetadata().getType()));

        return folderPath + fileName;
    }

    private String toExtension(String type) {
        if ("CONNECTOR_TEMPLATE".equalsIgnoreCase(type)) {
            return "json";
        } else {
            return type.toLowerCase();
        }
    }

    private void writeFile(String content, String fileName) {
        System.out.println("Writing: " + fileName);
        File outputFile = new File(folder, fileName);

        try {
            FileUtils.write(outputFile, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FileDto getFile(FileMetadataDto fileMetadata) {
        try {
            return getFile(UUID.fromString(fileMetadata.getId()));
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public FileDto getFile(UUID fileUUID) throws ApiException {
        return filesApi.getFile(fileUUID);
    }

    public enum Mode {
        SIMPLE_PATH,
        CANONICAL_PATH
    }
}
